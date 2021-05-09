package com.nbclass.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nbclass.mapper.DownloadFileInfoMapper;
import com.nbclass.mapper.DownloadMapper;
import com.nbclass.model.Download;
import com.nbclass.model.DownloadFileInfo;
import com.nbclass.model.User;
import com.nbclass.service.DownloadService;
import com.nbclass.util.TokenUtils;
import com.nbclass.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service
public class DownloadServiceImpl implements DownloadService {
    @Autowired
    DownloadMapper downloadMapper;
    @Autowired
    DownloadFileInfoMapper downloadFileInfoMapper;

    @Override
    @Transactional
    public Object addDownload(String applicationRemark,String... ids) {
        if (ids.length > 0) {
            Download download = new Download();
            download.setId(UUIDUtil.getUniqueIdByUUId());
            download.setZipPassword(UUIDUtil.uuid().trim().toLowerCase().substring(3,7));
            for (String id : ids) {
                DownloadFileInfo downloadFileInfo = new DownloadFileInfo();
                downloadFileInfo.setId(UUIDUtil.getUniqueIdByUUId());
                downloadFileInfo.setDownloadId(download.getId());
                downloadFileInfo.setFileinfoId(id);
                downloadFileInfoMapper.insert(downloadFileInfo);
            }
            download.setApplicantId(TokenUtils.currentUser().getId());
            download.setApplicationName(TokenUtils.currentUser().getRealName());
            download.setApplicationRemark(applicationRemark);
            download.setApplicationTime(new Date());
            download.setStatus(0);
            download.setUpdateTime(new Date());
            return downloadMapper.insert(download);
        }
        return null;

    }

    @Override
    public PageInfo<Download> findMydownloads(User currentUser, int pageNo,int limit ) {
        PageHelper.startPage(pageNo,limit);
        List<Download> downloadList = downloadMapper.selectMydownloads(currentUser.getId());
        PageInfo<Download> downloadPageInfo = new PageInfo<>(downloadList);
        PageHelper.clearPage();
        return downloadPageInfo;
    }

    @Override
    public Download findDownloadById(Serializable id) {
        return downloadMapper.selectDownloadById(id);
    }

    @Override
    public int updateDownloadById(Download download) {
        download.setCheckerId(TokenUtils.currentUser().getId());
        download.setCheckerName(TokenUtils.currentUser().getRealName());
        download.setCheckTime(new Date());
        download.setUpdateTime(new Date());//
        return downloadMapper.updateByPrimaryKeySelective(download);
    }

    @Override
    public PageInfo<Download> findDownloadsByStauts(int status, int pageNo, int limit) {
        PageHelper.startPage(pageNo,limit);
        List<Download> downloadList = downloadMapper.selectDownloadsByStatus(status);
        PageInfo<Download> downloadPageInfo = new PageInfo<>(downloadList);
        PageHelper.clearPage();
        return downloadPageInfo;
    }
}
