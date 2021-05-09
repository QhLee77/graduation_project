package com.nbclass.service;

import com.github.pagehelper.PageInfo;
import com.nbclass.model.Download;
import com.nbclass.model.User;
import com.nbclass.vo.base.PageResultVo;

import java.io.Serializable;

public interface DownloadService {
    Object addDownload(String applicationRemark,String... ids);

    PageInfo<Download> findMydownloads(User currentUser, int pageNo, int limit);

    Download findDownloadById(Serializable id);

    int updateDownloadById(Download download);

    PageInfo<Download> findDownloadsByStauts(int status, int pageNo, int limit);
}
