package com.nbclass.service.impl;

import com.nbclass.mapper.CategoryMapper;
import com.nbclass.mapper.FileInfoMapper;
import com.nbclass.model.Category;
import com.nbclass.model.FileInfo;
import com.nbclass.service.CategoryService;
import com.nbclass.util.TokenUtils;
import com.nbclass.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private FileInfoMapper  fileInfoMapper;

    /**
     * 根据类别id 查找
     *
     * @param id
     */
    @Override
    public Category findById(Serializable id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据空间 id 查找
     *
     * @param spaceId
     */
    @Override
    public List<Category> findCategorysBySpaceId(Serializable spaceId) {
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("spaceId",spaceId).andEqualTo("status",1);
        example.orderBy("orderNum");
        return categoryMapper.selectByExample(example);
    }

    /**
     * 根据父级id 查找
     *
     * @param parentId
     */
    @Override
    public List<Category> findCategorysByParentId(Serializable parentId) {
        return categoryMapper.selectCategorysByParentId(parentId);
    }

    /**
     * 添加类别
     *
     * @param category
     */
    @Override
    public void addCategory(Category category) {
        category.setId(UUIDUtil.generateShortUuid());
        category.setCreateTime(new Date());
        categoryMapper.insertSelective(category);
    }

    /**
     * 修改类别
     *
     * @param category
     */
    @Override
    public void updateCategory(Category category) {
        category.setUpdateTime(new Date());
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    /**
     * @param id
     */
    @Override
    public void deleteCategoryByIds(String... id) {
//        删除类别
        Example example = new Example(Category.class);
        example.createCriteria().andIn("id", Arrays.asList(id));
        Category category = new Category();
        category.setStatus(0);
        categoryMapper.updateByExampleSelective(category,example);

//      清空该类别下所有文件的类别字段
      /*  Example exampleFileInfo = new Example(FileInfo.class);
        exampleFileInfo.createCriteria().andIn("categoryId", Arrays.asList(id));
        FileInfo fileInfo = new FileInfo();
        fileInfo.setCategoryId("");
        fileInfoMapper.updateByExampleSelective(fileInfo,exampleFileInfo);*/
    }
}
