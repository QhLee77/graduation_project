package com.nbclass.controller;

import com.github.pagehelper.PageInfo;
import com.nbclass.config.FileInfoConfig;
import com.nbclass.model.Download;
import com.nbclass.model.FileInfo;
import com.nbclass.service.DownloadService;
import com.nbclass.service.FileInfoService;
import com.nbclass.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/download")
public class DownloadController {
    @Autowired
    private DownloadService downloadService;

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    FileInfoConfig fileInfoConfig;

    /* 申请下载 */
    @PostMapping("/download/apply")
    @ResponseBody
    public Object addDownload(@RequestBody Map<String,Object> map){
        String applicationRemark = (String) map.get("applicationRemark");
        String[] fids = ((ArrayList<String>) map.get("ids")).toArray(new String[]{});
        return ResultUtil.success("ok",downloadService.addDownload(applicationRemark,fids));
    }

    /* 展示我的下载  */
    @GetMapping("/download/list-my")
    @ResponseBody
    public Object listMyDownload(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1") int pageNo){
        PageInfo<Download> pageInfo  = downloadService.findMydownloads(TokenUtils.currentUser(),pageNo, limit);
        return ResultUtil.table(pageInfo.getList(),pageInfo.getTotal());
    }

    /**
     * 下载审核通过后，下载文件过程的第一步，生成压缩包
     * @param id
     * @return
     */
    @GetMapping("/download/check_yes")
    @ResponseBody
    public Object download(String id){
        Download download = downloadService.findDownloadById(id);
        if(download.getStatus()==1){
            if(download.getZipFile()==null || !(new File(fileInfoConfig.getTemDir(),download.getZipFile()).exists()) ){
                String firstFileName=download.getFileInfoList().get(0).getFileName().trim();
                String zipFileNme = download.getDownloadNumber()+"-"
                        +(firstFileName.contains(".")?firstFileName.substring(0,firstFileName.lastIndexOf(".")):firstFileName)
                        +"(" +download.getFileInfoList().size()+ ").zip";
                File zip = this.createZipFile(download.getFileInfoList(),zipFileNme,download.getZipPassword());
                download.setZipFile("/"+zip.getName());
                download.setUpdateTime(new Date());
                downloadService.updateDownloadById(download);
            }
            return ResultUtil.success("OK",download.getZipFile());
        }else{
            return ResultUtil.error("download unchecked" );
        }
    }

    /**
     * 直接下载，下载文件过程的第一步，拷贝文件或生成压缩包
     * @param fids
     * @return
     */
    @PostMapping("/download/immediately")
    @ResponseBody
    public Object downloadImmediately(@RequestBody String[] fids){
        List<FileInfo> fileInfoList = fileInfoService.findFileInfoByIds(fids);
        String resultPath = null;
        if(fileInfoList!=null && fileInfoList.size()>1){
            String firstFileName=fileInfoList.get(0).getFileName().trim();
            String zipFileNme = (firstFileName.contains(".")?firstFileName.substring(0,firstFileName.lastIndexOf(".")):firstFileName) +"(" +fileInfoList.size()+ "个文件).zip";
            resultPath = this.createZipFile(fileInfoList,zipFileNme,null).getName();
        }else{
            FileInfo fileInfo = fileInfoList.get(0);
            FileUtil.copyFile(fileInfoConfig.getFileDir()+"/"+fileInfo.getPath(),fileInfoConfig.getTemDir()+"/"+fileInfo.getFileName());
            resultPath = fileInfo.getFileName();
        }
        return  ResultUtil.success("OK","/"+resultPath);
    }

    /**
     * 直接下载我的文件，为了更好控制权限，重新写url，功能和直接下载一样
     * @param fids
     * @return
     */
    @PostMapping("/download/download_my")
    @ResponseBody
    public Object downloadImmediatelyMy(@RequestBody String[] fids){
        return downloadImmediately(fids);
    }

    /**
     * 下载文件过程的第二步，下载压缩包
     * @param path
     * @return
     */
    @PostMapping("/download/{path}")
    public void outputDownload(@PathVariable("path") String path , HttpServletRequest request, HttpServletResponse response){
        File file = new File(fileInfoConfig.getTemDir(),path);
        DownLoadUtil.outputDownload(file,file.getName(),request,response);
        try{
            file.delete();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 提取出来的私有化方法:生成压缩文件
     * @param fileInfoList
     * @param zipFileName
     * @param zipPassword
     * @return
     */
    private File createZipFile(List<FileInfo> fileInfoList, String zipFileName,String zipPassword) {
        ArrayList<File> newFileList = new ArrayList<>();
        for (FileInfo fileInfo : fileInfoList) {
            File oldFile = new File(fileInfoConfig.getFileDir(), fileInfo.getPath());
            File newFile = new File(fileInfoConfig.getTemDir(), fileInfo.getFileName());
            FileUtil.copyFile(oldFile.getAbsolutePath(), newFile.getAbsolutePath());
            newFileList.add(newFile);
        }
        File zipFile = new File(fileInfoConfig.getTemDir(), zipFileName);
        FileUtil.zipFiles(zipFile, newFileList, zipPassword);
        for (File file : newFileList) {
            file.delete();
        }
        return zipFile;
    }

    @PutMapping("/download/check")
    @ResponseBody
    public Object downloadCheck(@RequestBody Download download){
        return ResultUtil.success("OK",downloadService.updateDownloadById(download));
    }


    /* 展示我的下载  */
    @GetMapping("/download/list-check")
    @ResponseBody
    public Object listCheck(@RequestParam(defaultValue = "0") int status,@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1") int pageNo){
        PageInfo<Download> pageInfo  = downloadService.findDownloadsByStauts(status,pageNo, limit);
        return ResultUtil.table(pageInfo.getList(),pageInfo.getTotal());
    }

}
