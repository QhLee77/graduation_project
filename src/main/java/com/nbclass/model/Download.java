package com.nbclass.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

public class Download {
    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 下载编号id,从1000 开始自动增长
     */
    @Column(name = "download_number")
    private Integer downloadNumber;

    /**
     * 申请人id
     */
    @Column(name = "applicant_id")
    private Integer applicantId;

    /**
     * 申请人名字
     */
    @Column(name = "application_name")
    private String applicationName;

    /**
     * 申请时间
     */
    @Column(name = "application_time")
    private Date applicationTime;


    /**
     * 申请的备注说明
     */
    @Column(name = "application_remark")
    private String applicationRemark;

    /**
     * 审核人id
     */
    @Column(name = "checker_id")
    private Integer checkerId;

    /**
     * 审核人名字
     */
    @Column(name = "checker_name")
    private String checkerName;

    /**
     * 审核时间
     */
    @Column(name = "check_time")
    private Date checkTime;


    /**
     * 审核的备注说明
     */
    @Column(name = "check_remark")
    private String checkRemark;
    /**
     * -1 无需审核，默认通过  0 未审核  1 通过  2 不通过
     */
    private Integer status;

    /**
     * 解压密码
     */
    @Column(name = "zip_password")
    private String zipPassword;


    /**
     * 压缩包文件
     */
    @Column(name = "zip_file")
    private String zipFile;
    /**
     * 文件大小
     */
    private Integer size;

    /**
     * 最后一次下载时间
     */
    @Column(name = "last_download_time")
    private Date lastDownloadTime;

    /**
     * 下载次数
     */
    @Column(name = "download_count")
    private Integer downloadCount;

    @Column(name = "update_time")
    private Date updateTime;


    private List<FileInfo> fileInfoList;

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
     * 获取申请人id
     *
     * @return applicant_id - 申请人id
     */
    public Integer getApplicantId() {
        return applicantId;
    }

    /**
     * 设置申请人id
     *
     * @param applicantId 申请人id
     */
    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    /**
     * 获取申请人名字
     *
     * @return application_name - 申请人名字
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * 设置申请人名字
     *
     * @param applicationName 申请人名字
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * 获取申请时间
     *
     * @return application_time - 申请时间
     */
    public Date getApplicationTime() {
        return applicationTime;
    }

    /**
     * 设置申请时间
     *
     * @param applicationTime 申请时间
     */
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    /**
     * 获取审核人id
     *
     * @return checker_id - 审核人id
     */
    public Integer getCheckerId() {
        return checkerId;
    }

    /**
     * 设置审核人id
     *
     * @param checkerId 审核人id
     */
    public void setCheckerId(Integer checkerId) {
        this.checkerId = checkerId;
    }

    /**
     * 获取审核人名字
     *
     * @return checker_name - 审核人名字
     */
    public String getCheckerName() {
        return checkerName;
    }

    /**
     * 设置审核人名字
     *
     * @param checkerName 审核人名字
     */
    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    /**
     * 获取审核时间
     *
     * @return check_time - 审核时间
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * 设置审核时间
     *
     * @param checkTime 审核时间
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * 获取-1 无需审核，默认通过  0 未审核  1 通过  2 不通过
     *
     * @return status - -1 无需审核，默认通过  0 未审核  1 通过  2 不通过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置-1 无需审核，默认通过  0 未审核  1 通过  2 不通过
     *
     * @param status -1 无需审核，默认通过  0 未审核  1 通过  2 不通过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取解压密码
     *
     * @return zip_password - 解压密码
     */
    public String getZipPassword() {
        return zipPassword;
    }

    /**
     * 设置解压密码
     *
     * @param zipPassword 解压密码
     */
    public void setZipPassword(String zipPassword) {
        this.zipPassword = zipPassword;
    }

    /**
     * 获取文件大小
     *
     * @return size - 文件大小
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 设置文件大小
     *
     * @param size 文件大小
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 获取最后一次下载时间
     *
     * @return last_download_time - 最后一次下载时间
     */
    public Date getLastDownloadTime() {
        return lastDownloadTime;
    }

    /**
     * 设置最后一次下载时间
     *
     * @param lastDownloadTime 最后一次下载时间
     */
    public void setLastDownloadTime(Date lastDownloadTime) {
        this.lastDownloadTime = lastDownloadTime;
    }

    /**
     * 获取下载次数
     *
     * @return download_count - 下载次数
     */
    public Integer getDownloadCount() {
        return downloadCount;
    }

    /**
     * 设置下载次数
     *
     * @param downloadCount 下载次数
     */
    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getApplicationRemark() {
        return applicationRemark;
    }

    public Download setApplicationRemark(String applicationRemark) {
        this.applicationRemark = applicationRemark;
        return this;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public Download setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
        return this;
    }

    public List<FileInfo> getFileInfoList() {
        return fileInfoList;
    }

    public Download setFileInfoList(List<FileInfo> fileInfoList) {
        this.fileInfoList = fileInfoList;
        return this;
    }

    public Integer getDownloadNumber() {
        return downloadNumber;
    }

    public Download setDownloadNumber(Integer downloadNumber) {
        this.downloadNumber = downloadNumber;
        return this;
    }

    public String getZipFile() {
        return zipFile;
    }

    public Download setZipFile(String zipFile) {
        this.zipFile = zipFile;
        return this;
    }
}
