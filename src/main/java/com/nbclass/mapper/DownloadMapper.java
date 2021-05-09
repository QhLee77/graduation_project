package com.nbclass.mapper;

import com.nbclass.model.Download;
import com.nbclass.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DownloadMapper extends MyMapper<Download> {
    /**
     *  查找我的下载
     * @param applicantId  申请人的id
     * @return
     */
    List<Download> selectMydownloads(@Param("applicantId") Serializable applicantId);
    List<Download> selectDownloadsByStatus(@Param("status") int status);
    Download selectDownloadById(@Param("id") Serializable id);

}
