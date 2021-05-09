package com.nbclass.controller;

import com.nbclass.model.User;
import com.nbclass.util.TokenUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class HelloController {
    @GetMapping("/hhhh")
    @ResponseBody
    public Object hello(){
        return TokenUtils.currentUser();
    }
}
