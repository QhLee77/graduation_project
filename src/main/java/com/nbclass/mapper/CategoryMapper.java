package com.nbclass.mapper;

import com.nbclass.model.Category;
import com.nbclass.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface CategoryMapper extends MyMapper<Category> {
    public List<Category> selectCategorysByParentId(@Param("parentId") Serializable parentId);
}
