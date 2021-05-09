package com.nbclass.service;

import com.nbclass.config.FileInfoConfig;
import com.nbclass.model.Download;
import com.nbclass.model.FileInfo;
import com.nbclass.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class DownloadServiceTest {
  /*  @Autowired
    FileInfoConfig fileInfoConfig;
    @Autowired
    DownloadService downloadService;

    @Test
    public void test1(){
        downloadService.addDownload("1000000057343064","1000000168403703");
    }

    */
  /*
     * 测试下载中生成压缩包的过程
     */
  /*
    @Test
    public void test2(){
        // "1000002036221908"
        long l = System.currentTimeMillis();
        Download download = downloadService.findDownloadById("1000000820888446");
        try {
            List<FileInfo> fileInfoList = download.getFileInfoList();
            ArrayList<File> newFileList = new ArrayList<>();
            for (FileInfo fileInfo : fileInfoList) {
                File old = new File(fileInfoConfig.getFileDir(),fileInfo.getPath());
                File newFile = new File(fileInfoConfig.getTemDir(),fileInfo.getFileName());
                FileUtil.copyFile(old.getAbsolutePath(),newFile.getAbsolutePath());
                newFileList.add(newFile);
            }
            System.out.println(System.currentTimeMillis() - l);
            String zipName = fileInfoList.get(0).getFileName()+"-"+fileInfoList.size()+ LocalDate.now() +".zip";
            File zipFile = new File(fileInfoConfig.getTemDir(),zipName);
            FileUtil.zipFiles(zipFile,newFileList,"12233");
            for (File file : newFileList) {
                file.delete();
            }
            System.out.println(System.currentTimeMillis() - l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

*/

}
