package com.nbclass.util;
/**
 * @version V1.0
 * @date 2020年8月11日
 * @author hkx
 */
public class PageUtil {
    public static Integer getPageNo(Integer limit,Integer offset){
        return offset==0 ? 1 : offset / limit + 1;
    }
}
