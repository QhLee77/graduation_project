package com.nbclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version V1.0
 * @date 2020年8月13日
 * @author hkx
 */
@Controller
public class RenderController {

    /*工作台*/
    @GetMapping("/workdest")
    public String workdest(){
        return "index/workdest";
    }

    /**用户列表入口*/
    @GetMapping("/users")
    public String userList(){
        return "user/list";
    }

    /*角色列表入口*/
    @GetMapping("/roles")
    public String roleList() {
        return "role/list";
    }

    /*权限列表入口*/
    @GetMapping("/permissions")
    public String permissionList(){
        return "permission/list";
    }

    /*在线用户入口*/
    @GetMapping("/online/users")
    public String onlineUsers(){return "onlineUsers/list";}

    /* 文件分类管理*/
    @GetMapping("/categorys")
    public String categorys(){return "files/list-categorys";}


    /*浏览所有文件*/
    @GetMapping("/files")
    public String files(){return "files/fileInfo-list";}

    /*我上传的文件*/
    @GetMapping("/myuploads")
    public String myuploads(){return "files/list-my-uploads";}

    /*我申请下载的文件*/
    @GetMapping("/mydownloads")
    public String mydownloads(){return "files/list-my-downloads";}



    /*未审核的下载申请*/
    @GetMapping("/downloads-uncheck")
    public String downloadsUncheck(){return "files/list-uncheck-downloads";}


    /*已通过的下载申请*/
    @GetMapping("/downloads-passed")
    public String downloadsPassed(){return "files/list-passed-downloads";}

    /*已拒绝的下载申请*/
    @GetMapping("/downloads-refuse")
    public String downloadsRefuse(){return "files/list-refuse-downloads";}


}
