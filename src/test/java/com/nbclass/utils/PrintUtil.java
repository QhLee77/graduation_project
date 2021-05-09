package com.nbclass.utils;

import com.alibaba.fastjson.JSON;

public class PrintUtil {
    public  static void printlnJSON(Object object){
        System.out.println(JSON.toJSONString(object));
    }
}
