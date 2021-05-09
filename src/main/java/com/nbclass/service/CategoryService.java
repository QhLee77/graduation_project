package com.nbclass.service;

import com.nbclass.model.Category;

import java.io.Serializable;
import java.util.List;

public interface CategoryService {
    /**
     *  根据类别id 查找
     */
    public Category findById(Serializable id);

    /**
     * 根据空间 id 查找
     */
     public List<Category> findCategorysBySpaceId(Serializable spaceId);

    /**
     * 根据父级id 查找
     */

    public List<Category> findCategorysByParentId(Serializable parentId);


    /**
     * 添加类别
     */
    public void addCategory(Category category);

    /**
     * 修改类别
     */
    public void updateCategory(Category category);

    /**
     *
     * @param id
     */
    public void deleteCategoryByIds(String...  id);
}
