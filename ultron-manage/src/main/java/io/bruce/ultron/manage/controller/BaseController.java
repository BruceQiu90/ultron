package io.bruce.ultron.manage.controller;

import io.bruce.ultron.manage.bean.BaseEntity;
import io.bruce.ultron.manage.service.BaseService;
import io.bruce.ultron.manage.web.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@Slf4j
public abstract class BaseController<T extends BaseEntity<PK>, PK extends Serializable> {

    @Autowired
    protected BaseService<T, PK> abstractService;

    @GetMapping("{id}")
    public BaseResponse<T> getById(@PathVariable("id") PK id) {
        try {
            T entity = abstractService.getById(id);
            return BaseResponse.success(entity);
        } catch (Exception e) {
            log.error("getById error", e);
            return BaseResponse.error(null);
        }
    }

    @PostMapping
    public BaseResponse save(@RequestBody T entity) {
        try {
            abstractService.save(entity);
            return BaseResponse.success();
        } catch (Exception e) {
            log.error("save one error", e);
            return BaseResponse.error();
        }
    }

    @PutMapping("{id}")
    public BaseResponse updateById(@PathVariable("id") PK id, @RequestBody T entity) {
        try {
            entity.setId(id);
            abstractService.updateById(entity);
            return BaseResponse.success();
        } catch (Exception e) {
            log.error("updateById error", e);
            return BaseResponse.error();
        }
    }

    @DeleteMapping("{id}")
    public BaseResponse deleteById(@PathVariable("id") PK id) {
        try {
            abstractService.deleteById(id);
            return BaseResponse.success();
        } catch (Exception e) {
            log.error("deleteById error", e);
            return BaseResponse.error();
        }
    }

}
