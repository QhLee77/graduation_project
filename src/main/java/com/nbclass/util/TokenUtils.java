package com.nbclass.util;

import com.nbclass.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;

public class TokenUtils {
    public static User currentUser(){
        Object principal = SecurityUtils.getSubject().getPrincipal();
        if(principal == null){
            throw new AuthorizationException("未认证登录");
        }
        return  (User) principal;
    }
}
