package com.nbclass.component;

import com.nbclass.config.FileInfoConfig;
import com.nbclass.service.FileInfoService;
import com.nbclass.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

//@Component
public class StartApplicationRunner implements ApplicationRunner {
    @Autowired
    FileInfoConfig fileInfoConfig;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] sourceArgs = args.getSourceArgs();
        for (String arg : sourceArgs) {
        }
//        System.out.println("启动就开始干活！！！！");
//        fileInfoService.findFileInfoById("1000000889158090");
//        开发阶段，每次启动清空临时文件夹

        FileUtil.deleteFile(fileInfoConfig.getTemDir());
        new File(fileInfoConfig.getTemDir()).mkdir();
        System.out.println("开发阶段，每次启动清空临时文件夹");
    }
}
