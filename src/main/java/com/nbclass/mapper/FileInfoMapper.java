package com.nbclass.mapper;

import com.nbclass.model.FileInfo;
import com.nbclass.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface FileInfoMapper extends MyMapper<FileInfo> {
    List<FileInfo> selectFileInfoByDownloadId(@Param("downloadId") Serializable downloadId);
}
