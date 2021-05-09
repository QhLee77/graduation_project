package com.nbclass.controller;

import com.github.pagehelper.PageInfo;
import com.nbclass.model.FileInfo;
import com.nbclass.service.FileInfoService;
import com.nbclass.util.ResultUtil;
import com.nbclass.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileInfo")
public class FileInfoController {

    @Autowired
    private FileInfoService fileInfoService;

    @GetMapping("/list")
    @ResponseBody
    public Object list(FileInfo example,@RequestParam(defaultValue = "false") boolean diGui,
                       @RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1") int pageNo){
        PageInfo<FileInfo> fileInfo = fileInfoService.findFileInfo(limit, pageNo, example,diGui);
        return ResultUtil.table(fileInfo.getList(),fileInfo.getTotal());
    }

    @GetMapping("/list-myupload")
    @ResponseBody
    public Object listMyupload(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1") int pageNo){
        PageInfo<FileInfo> fileInfo = fileInfoService.findMyUploadFileInfo(TokenUtils.currentUser(),limit, pageNo);
        return ResultUtil.table(fileInfo.getList(),fileInfo.getTotal());
    }


    @GetMapping("/layer/upload")
    public String layUpload(){
        return "files/layer-upload";
    }

    @PostMapping("/submitUpload")
    @ResponseBody
    public Object submitUpload( String categoryId,String categoryName, @RequestParam("file") MultipartFile multipartFile){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setCategoryId(categoryId);
        fileInfo.setCategoryName(categoryName);
        fileInfo.setCreatorId(TokenUtils.currentUser().getId());
        fileInfo.setCreatorName(TokenUtils.currentUser().getRealName());
        return ResultUtil.success("OK",fileInfoService.saveFile(fileInfo,multipartFile));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Object selectFileInfoById(@PathVariable("id") String id){
        return ResultUtil.success("OK",fileInfoService.findFileInfoById(id));
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Object deleteFileInfoById(@RequestBody FileInfo fileInfo){
        return ResultUtil.success("OK",fileInfoService.deleteFileInfo(fileInfo.getId()));
    }

    @DeleteMapping("/delete-myfileinfo")
    @ResponseBody
    public Object deleteMyFileInfoById(@RequestBody FileInfo fileInfo){
        int hour = 12;
        if(((System.currentTimeMillis() - fileInfoService.findFileInfoById(fileInfo.getId()).getUpdatetime().getTime())/1000)>(3600*hour)){
            return ResultUtil.error("文件上传超过" +hour+ "小时，不能删除");
        }
        return ResultUtil.success("OK",fileInfoService.deleteFileInfo(fileInfo.getId()));
    }

    @GetMapping("/edit")
    public String edit(String id, ModelMap modelMap){
        FileInfo fileInfo = fileInfoService.findFileInfoById(id);
        modelMap.put("fileInfo",fileInfo);
        return "files/fileInfo-formForEdit";
    }

    @GetMapping("/edit_my")
    public String editMy(String id, ModelMap modelMap){
        FileInfo fileInfo = fileInfoService.findFileInfoById(id);
        modelMap.put("fileInfo",fileInfo);
        return "files/fileInfo-formForEdit";
    }


    @PostMapping("/edit_submit")
    @ResponseBody
    public Object editSubmit(FileInfo fileInfo, @RequestParam("file") MultipartFile multipartFile){
        FileInfo f =  fileInfoService.updateFile(fileInfo,multipartFile);
        return ResultUtil.success("ok",f);
    }

    @PostMapping("/edit_submit_my")
    @ResponseBody
    public Object editSubmitMy(FileInfo fileInfo, @RequestParam("file") MultipartFile multipartFile){
        FileInfo f =  fileInfoService.updateFile(fileInfo,multipartFile);
        return ResultUtil.success("ok",f);
    }



}
