package com.nbclass.service;

import com.nbclass.model.Category;
import com.nbclass.util.UUIDUtil;
import com.nbclass.utils.PrintUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class CategoryServiceImplTest {
  /*  @Autowired
    CategoryService categoryService;

    @Test
    public void findById() {
        Category category = categoryService.findById("1003");
        PrintUtil.printlnJSON(category);
    }

    @Test
    public void findCategorysBySpaceId() {
        List<Category> categorys = categoryService.findCategorysBySpaceId(1);
        categorys.forEach(c->PrintUtil.printlnJSON(c));
    }

    @Test
    public void findCategorysByParentId() {
        List<Category> categorys = categoryService.findCategorysByParentId("1003");
        categorys.forEach(c->PrintUtil.printlnJSON(c));
    }

    @Test
    public void addCategory() {
        Category category = new Category();
        category.setParentId("1000");
        category.setName("重庆分公司");
        category.setId(UUIDUtil.generateShortUuid());


        Category category1 = new Category();
        category1.setId(UUIDUtil.generateShortUuid());
        category1.setName("解放碑分公司");
        category1.setParentId(category.getId());
        categoryService.addCategory(category);
        categoryService.addCategory(category1);

    }

    @Test
    public void updateCategory() {
        Category category = categoryService.findById("7hMvn1mV");
        category.setName("成都分公司");
        categoryService.updateCategory(category);
    }

    @Test
    public void deleteCategoryByIds() {
        categoryService.deleteCategoryByIds("ekzdxJHI");
    }*/
}
