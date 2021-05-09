package com.nbclass.shiro;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * js调用 thymeleaf 实现按钮权限
 * @version V1.0
 * @date 2020年8月11日
 * @author hkx
 */
@Component("perms")
public class PermsService
{
    public boolean hasPerm(String permission)
    {
        return SecurityUtils.getSubject().isPermitted(permission);
    }
}
