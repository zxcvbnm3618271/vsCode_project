package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.StudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-09-29 21:06:02
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {
	
}
