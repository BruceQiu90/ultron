package io.bruce.ultron.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.bruce.ultron.manage.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class BaseService<T, PK extends Serializable> {

    @Autowired
    private BaseMapper<T> baseMapper;

    public T getById(PK id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void save(T entity) {
        baseMapper.insertSelective(entity);
    }

    @Transactional
    public void updateById(T entity) {
        baseMapper.updateByPrimaryKeySelective(entity);
    }

    @Transactional
    public void deleteById(PK id) {
        baseMapper.deleteByPrimaryKey(id);
    }

    public List<T> getAll() {
        return baseMapper.selectAll();
    }

    public PageInfo<T> getByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = baseMapper.selectAll();
        return new PageInfo<T>(list);
    }
}
