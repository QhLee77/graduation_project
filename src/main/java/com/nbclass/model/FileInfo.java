package com.nbclass.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "file_info")
public class FileInfo {
    /**
     * 主键id
     */
    @Id
    private String id;

    /**
     * 文件编号id,从1000 开始自动增长
     */
    @Column(name = "file_number")
    private Integer fileNumber;

    /**
     * 文件名字
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * 文件md5
     */
    private String md5;

    /**
     * 文件类别id
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 文件类别名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 空间id
     */
    @Column(name = "space_id")
    private String spaceId;

    /**
     * 空间名称
     */
    @Column(name = "space_name")
    private String spaceName;

    /**
     * 上传者id
     */
    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     * 上传者名称
     */
    @Column(name = "creator_name")
    private String creatorName;

    /**
     * 关键字
     */
    @Column(name = "file_keys")
    private String fileKeys;

    /**
     * 文件类型
     */
    @Column(name = "contentType")
    private String contenttype;

    /**
     * 文件大小
     */
    private Integer size;

    /**
     * 物理路径
     */
    private String path;

    private String url;

    private Integer status;

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "updateTime")
    private Date updatetime;

    /**
     * 详细说明
     */
    private String detail;

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
     * 获取文件编号id,从1000 开始自动增长
     *
     * @return file_number - 文件编号id,从1000 开始自动增长
     */
    public Integer getFileNumber() {
        return fileNumber;
    }

    /**
     * 设置文件编号id,从1000 开始自动增长
     *
     * @param fileNumber 文件编号id,从1000 开始自动增长
     */
    public void setFileNumber(Integer fileNumber) {
        this.fileNumber = fileNumber;
    }

    /**
     * 获取文件名字
     *
     * @return file_name - 文件名字
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 获取文件简短名字，为了显示方便
     *
     * @return file_name - 文件名字
     */
    public String getSimpleFileName() {
        if (this.getFileName() != null && this.getFileName().length() > 25) {
            String fileName = this.getFileName();
            return fileName.substring(0, 10) + "......" + fileName.substring(fileName.length() - 9);
        } else {
            return this.getFileName();
        }
    }
    /**
     * 设置文件名字
     *
     * @param fileName 文件名字
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取文件md5
     *
     * @return md5 - 文件md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * 设置文件md5
     *
     * @param md5 文件md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * 获取文件类别id
     *
     * @return category_id - 文件类别id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置文件类别id
     *
     * @param categoryId 文件类别id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取文件类别名称
     *
     * @return category_name - 文件类别名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置文件类别名称
     *
     * @param categoryName 文件类别名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取空间id
     *
     * @return space_id - 空间id
     */
    public String getSpaceId() {
        return spaceId;
    }

    /**
     * 设置空间id
     *
     * @param spaceId 空间id
     */
    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    /**
     * 获取空间名称
     *
     * @return space_name - 空间名称
     */
    public String getSpaceName() {
        return spaceName;
    }

    /**
     * 设置空间名称
     *
     * @param spaceName 空间名称
     */
    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    /**
     * 获取上传者id
     *
     * @return creator_id - 上传者id
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置上传者id
     *
     * @param creatorId 上传者id
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取上传者名称
     *
     * @return creator_name - 上传者名称
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 设置上传者名称
     *
     * @param creatorName 上传者名称
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * 获取关键字
     *
     * @return file_keys - 关键字
     */
    public String getFileKeys() {
        return fileKeys;
    }

    /**
     * 设置关键字
     *
     * @param fileKeys 关键字
     */
    public void setFileKeys(String fileKeys) {
        this.fileKeys = fileKeys;
    }

    /**
     * 获取文件类型
     *
     * @return contentType - 文件类型
     */
    public String getContenttype() {
        return contenttype;
    }

    /**
     * 设置文件类型
     *
     * @param contenttype 文件类型
     */
    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
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
     * 获取物理路径
     *
     * @return path - 物理路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置物理路径
     *
     * @param path 物理路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取详细说明
     *
     * @return detail - 详细说明
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置详细说明
     *
     * @param detail 详细说明
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Transient
    private String fileIcon;

    public String getFileIcon() {
        return fileIcon;
    }

    public FileInfo setFileIcon(String fileIcon) {
        this.fileIcon = fileIcon;
        return this;
    }
}
