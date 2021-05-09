package com.nbclass.mapper;

import com.github.pagehelper.PageHelper;
import com.nbclass.model.Download;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class DownloadMapperTest {
   /* @Autowired
    DownloadMapper downloadMapper;

    @Test
    public void test1() {
        PageHelper.startPage(1,10);
        *//*Example example = new Example(Download.class);
        example.createCriteria().andEqualTo("applicantId",1);*//*

        List<Download> downloadList = downloadMapper.selectMydownloads(1);
        System.out.println(downloadList.get(0).getFileInfoList().size() +"  !!!!! ");
    }

    @Test
    public void test2() {
       downloadMapper.selectDownloadById("1000002036221908").getFileInfoList().forEach(e->{
           System.out.println(e.getFileName());
       });
    }*/









}
