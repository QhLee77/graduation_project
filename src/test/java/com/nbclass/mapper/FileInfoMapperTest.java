package com.nbclass.mapper;

import com.alibaba.fastjson.JSON;
import com.nbclass.model.Category;
import com.nbclass.model.FileInfo;
import com.nbclass.util.UUIDUtil;
import com.nbclass.utils.PrintUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class FileInfoMapperTest {
   /* @Autowired
    FileInfoMapper fileInfoMapper;

    @Test
    public void testAdd() {
        for (int i = 0; i <105 ; i++) {
            FileInfo fileInfo =  new FileInfo();
            fileInfo.setFileName("文件名字-"+i);
            fileInfo.setId(UUIDUtil.getUniqueIdByUUId());
            fileInfo.setCategoryId("1002");
            fileInfo.setCategoryName("北京分公司");
            fileInfo.setMd5(UUIDUtil.uuid());
            fileInfo.setCreatetime(new Date());
            fileInfo.setUpdatetime(new Date());
            fileInfo.setContenttype(UUIDUtil.generateShortUuid());
            fileInfo.setDetail("详情.........");
            fileInfo.setFileKeys("关键字");
            fileInfo.setStatus(0);
            fileInfoMapper.insert(fileInfo);
        }
    }
*/



}
