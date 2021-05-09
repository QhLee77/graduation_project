package com.nbclass.model;

import java.util.Date;
import javax.persistence.*;

public class Category {
    @Id
    private String id;

    /**
     * 父级类别id
     */
    @Column(name = "parent_id")
    private String parentId;
    /**
    父级类别名称
     */
    @Column(name = "parent_name")
    private String parentName;



    /**
     * 类别名称
     */
    private String name;

    /**
     * 类别描述
     */
    private String description;

    /**
     * 创建者id
     */
    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     *  空间id
     */
    @Column(name = "space_id")

    private Integer spaceId;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 图标
     */
    private String icon;

    /**
     * 状态：1有效；2删除
     */
    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 预留字段
     */
    private String cols;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取父级类别id
     *
     * @return parent_id - 父级类别id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级类别id
     *
     * @param parentId 父级类别id
     */
    public void setParentId(String parentId) {
      //  if(parentId!=null && parentId.trim().length()>0){
            this.parentId = parentId;
        //}
    }

    /**
     * 获取类别名称
     *
     * @return name - 类别名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类别名称
     *
     * @param name 类别名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类别描述
     *
     * @return description - 类别描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置类别描述
     *
     * @param description 类别描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取创建者id
     *
     * @return creator_id - 创建者id
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建者id
     *
     * @param creatorId 创建者id
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取空间id
     *
     * @return spaceId 空间id  1：类别目录
     */
    public Integer getSpaceId() {
        return spaceId;
    }

    /**
     * 设置空间id
     *
     * @param spaceId 空间id
     */
    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    /**
     * 获取排序
     *
     * @return order_num - 排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置排序
     *
     * @param orderNum 排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取状态：1有效；2删除
     *
     * @return status - 状态：1有效；2删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：1有效；2删除
     *
     * @param status 状态：1有效；2删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    /**
     * 获取预留字段
     *
     * @return cols - 预留字段
     */
    public String getCols() {
        return cols;
    }

    /**
     * 设置预留字段
     *
     * @param cols 预留字段
     */
    public void setCols(String cols) {
        this.cols = cols;
    }

    public String getParentName() {
        return parentName;
    }

    public Category setParentName(String parentName) {
        this.parentName = parentName;
        return this;
    }
}
