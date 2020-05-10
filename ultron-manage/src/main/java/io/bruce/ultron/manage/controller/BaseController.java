package io.bruce.ultron.manage.controller;

import io.bruce.ultron.manage.service.BaseService;
import io.bruce.ultron.manage.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public abstract class BaseController<T, PK extends Serializable> {

    @Autowired
    protected BaseService<T, PK> abstractService;

    @GetMapping("{id}")
    public BaseResponse<T> getById(@PathVariable("id") PK id) {
        try {
            T entity = abstractService.getById(id);
            return BaseResponse.success(entity);
        } catch (Exception e) {
            return BaseResponse.error(null);
        }
    }

    @PostMapping
    public BaseResponse save(T entity) {
        try {
            abstractService.save(entity);
            return BaseResponse.success();
        } catch (Exception e) {
            return BaseResponse.error();
        }
    }

    @PutMapping
    public BaseResponse updateById(T entity) {
        abstractService.updateById(entity);
        return BaseResponse.success();
    }

    @DeleteMapping
    public BaseResponse deleteById(PK id) {
        abstractService.deleteById(id);
        return BaseResponse.success();
    }

}
