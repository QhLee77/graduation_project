package com.nbclass.mapper;

import com.alibaba.fastjson.JSON;
import com.nbclass.model.Category;
import com.nbclass.utils.PrintUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class CategoryMapperTest {
    /*@Autowired
    CategoryMapper categoryMapper;

    @Test
    public void test1() {
        List<Category> categories = categoryMapper.selectAll();
        for (Category category : categories) {
            System.out.println(JSON.toJSONString(category));
        }
    }


    @Test
    public void test2() {
        Category category = categoryMapper.selectByPrimaryKey("1001");
        PrintUtil.printlnJSON(category);
    }


    @Test
    public void test3() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria().andIn("id", Arrays.asList(new String[]{"1001"}));
        List<Category> categories = categoryMapper.selectByExample(example);
        for (Category category : categories) {
            System.out.println(JSON.toJSONString(category));
        }
    }

    @Test
    public void test4() {
        List<Category> categories = categoryMapper.selectCategorysByParentId("1013");
        categories.forEach(category -> PrintUtil.printlnJSON(category));
    }


*/



}
