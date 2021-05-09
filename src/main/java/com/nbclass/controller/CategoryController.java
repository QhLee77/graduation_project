package com.nbclass.controller;

import com.nbclass.model.Category;
import com.nbclass.model.FileInfo;
import com.nbclass.service.CategoryService;
import com.nbclass.service.FileInfoService;
import com.nbclass.util.ResultUtil;
import com.nbclass.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private FileInfoService fileInfoService;


    @PostMapping("/list")
    @ResponseBody
    public Object listAll4Tree(){
        return categoryService.findCategorysBySpaceId(1);
    }

    @PostMapping("/add")
    @ResponseBody
    public Object addCategroy(Category category){
        category.setCreatorId(TokenUtils.currentUser().getId());
        categoryService.addCategory(category);
        return   ResultUtil.success("Successful") ;
    }

    @GetMapping("/edit")
    @ResponseBody
    public Object edit4show(String id){
        return ResultUtil.success("ok",categoryService.findById(id));
    }

    @PostMapping("/edit")
    @ResponseBody
    public Object editSubmit(Category category){
        categoryService.updateCategory(category);
        return ResultUtil.success("Successful");
    }



    @PostMapping("/delete")
    @ResponseBody
    public Object deleteCategroy(String id){
        List<Category> categoryList = categoryService.findCategorysByParentId(id);
        List<String> categoryIdsList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryIdsList.add(category.getId());
        }
        String[] categoryIdsArray = categoryIdsList.toArray(new String[]{});
        List<FileInfo> fileInfoList = fileInfoService.findFileInfoByCategoryIds(categoryIdsArray);
        if(fileInfoList.size()>0){
            return ResultUtil.error("删除 failed，分类下存在"+fileInfoList.size()+"个文件");
        }else {
            categoryService.deleteCategoryByIds(categoryIdsArray);
        }
        return  ResultUtil.success("Successful") ;
    }
}
