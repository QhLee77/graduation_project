package com.nbclass.model;

import javax.persistence.*;

@Table(name = "download_fileInfo")
public class DownloadFileInfo {
    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 下载记录id
     */
    @Column(name = "download_id")
    private String downloadId;

    /**
     * 文件id
     */
    @Column(name = "fileInfo_id")
    private String fileinfoId;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取下载记录id
     *
     * @return download_id - 下载记录id
     */
    public String getDownloadId() {
        return downloadId;
    }

    /**
     * 设置下载记录id
     *
     * @param downloadId 下载记录id
     */
    public void setDownloadId(String downloadId) {
        this.downloadId = downloadId;
    }

    /**
     * 获取文件id
     *
     * @return fileInfo_id - 文件id
     */
    public String getFileinfoId() {
        return fileinfoId;
    }

    /**
     * 设置文件id
     *
     * @param fileinfoId 文件id
     */
    public void setFileinfoId(String fileinfoId) {
        this.fileinfoId = fileinfoId;
    }
}