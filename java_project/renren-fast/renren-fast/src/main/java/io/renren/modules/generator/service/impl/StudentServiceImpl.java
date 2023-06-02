package io.renren.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.StudentDao;
import io.renren.modules.generator.entity.StudentEntity;
import io.renren.modules.generator.service.StudentService;


@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentEntity> page = this.page(
                new Query<StudentEntity>().getPage(params),
                new QueryWrapper<StudentEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Cacheable(value = "student",key="#id")
    public StudentEntity getById(Serializable id) {
        return super.getById(id);
    }

    @CacheEvict(value = "student",key="#id")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @CacheEvict(value = "student",allEntries = true)
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return super.removeByIds(idList);
    }

    @CacheEvict(value = "student",allEntries = true)
    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return super.removeByMap(columnMap);
    }

    @CacheEvict(value = "student",allEntries = true)
    @Override
    public boolean remove(Wrapper<StudentEntity> wrapper) {
        return super.remove(wrapper);
    }

    @CacheEvict(value = "student",allEntries = true)
    @Override
    public boolean update(StudentEntity entity, Wrapper<StudentEntity> updateWrapper) {
        return super.update(entity, updateWrapper);
    }
    @CacheEvict(value = "student",key = "#entity.id")
    @Override
    public boolean updateById(StudentEntity entity) {
        return super.updateById(entity);
    }
}