package com.nbclass.util;

import com.nbclass.model.Download;
import com.nbclass.model.FileInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DownLoadUtil {
    /**
     *  封装的下载的方法
     * @param file
     * @param zipFileNme
     * @param request
     * @param response
     */
    public static void outputDownload(File file, String zipFileNme, HttpServletRequest request, HttpServletResponse response)  {
        FileInputStream fis =null;
        try {
//            下载文件名乱码处理
            String userAgent = request.getHeader("User-Agent");
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                //IE浏览器处理
                zipFileNme = java.net.URLEncoder.encode(zipFileNme, "UTF-8");
            } else {
                // 非IE浏览器的处理：
                zipFileNme = new String(zipFileNme.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + zipFileNme);
            response.setContentLength((int) file.length());
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            int count = 0;
            while ((count = fis.read(buffer)) > 0) {
                response.getOutputStream().write(buffer, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { response.getOutputStream().flush(); } catch (IOException e) { e.printStackTrace(); }
            try { response.getOutputStream().close(); } catch (IOException e) { e.printStackTrace(); }
            try { if (fis!=null)fis.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }

}

