package io.bruce.ultron.manage.controller;

import com.github.pagehelper.PageInfo;
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
    protected BaseService<T, PK> baseService;

    @GetMapping("{id}")
    public BaseResponse<T> getById(@PathVariable("id") PK id) {
        try {
            T entity = baseService.getById(id);
            return BaseResponse.success(entity);
        } catch (Exception e) {
            log.error("getById error", e);
            return BaseResponse.error(null);
        }
    }

    @PostMapping
    public BaseResponse save(@RequestBody T entity) {
        try {
            baseService.save(entity);
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
            baseService.updateById(entity);
            return BaseResponse.success();
        } catch (Exception e) {
            log.error("updateById error", e);
            return BaseResponse.error();
        }
    }

    @DeleteMapping("{id}")
    public BaseResponse deleteById(@PathVariable("id") PK id) {
        try {
            baseService.deleteById(id);
            return BaseResponse.success();
        } catch (Exception e) {
            log.error("deleteById error", e);
            return BaseResponse.error();
        }
    }

    @GetMapping("list/{pageNum}/{pageSize}")
    public BaseResponse<PageInfo<T>> getByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        try {
            PageInfo<T> page = baseService.getByPage(pageNum, pageSize);
            return BaseResponse.success(page);
        } catch (Exception e) {
            log.error("getByPage error, pageNum = {}, pageSize = {}", pageNum, pageSize, e);
            return BaseResponse.error();
        }
    }

}
