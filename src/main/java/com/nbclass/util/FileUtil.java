package com.nbclass.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 文件工具类
 *
 * @author 小威老师 xiaoweijiagou@163.com
 */
public class FileUtil {

    public static String saveFile(MultipartFile file, String pathname) {
        try {
            File targetFile = new File(pathname);
            if (targetFile.exists()) {
                return pathname;
            }

            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            file.transferTo(targetFile);

            return pathname;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*public static boolean deleteFile(String pathname) {
        File file = new File(pathname);
        if (file.exists()) {
            boolean flag = file.delete();

            if (flag) {
                File[] files = file.getParentFile().listFiles();
                if (files == null || files.length == 0) {
                    file.getParentFile().delete();
                }
            }
            return flag;
        }
        return false;
    }*/

    public static String fileMd5(InputStream inputStream) {
        try {
            return DigestUtils.md5Hex(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getNowDatePath() {
        return LocalDate.now().toString().replace("-", "");
    }

    /**
     * 将文本写入文件
     *
     * @param value
     * @param path
     */
    public static void saveTextFile(String value, String path) {
        FileWriter writer = null;
        try {
            File file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            writer = new FileWriter(file);
            writer.write(value);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getText(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }

        try {
            return getText(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getText(InputStream inputStream) {
        InputStreamReader isr = null;
        BufferedReader bufferedReader = null;
        try {
            isr = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(isr);
            StringBuilder builder = new StringBuilder();
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                string = string + "\n";
                builder.append(string);
            }

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static String fileMd5(MultipartFile multipartFile) {
        try {
            return fileMd5(multipartFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 压缩多个文件
     * @param zipFile 压缩后的文件
     * @param addFiles 需要压缩的多个文件
     * @param password 密码，不传密码则压缩不加密
     */
    public static void zipFiles(File zipFile, ArrayList<File> addFiles, String... password) {
        try {
            //创建压缩文件
            ZipFile respFile = new ZipFile(zipFile);
            //设置压缩文件参数
            ZipParameters parameters = new ZipParameters();
            //设置压缩方法
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            if(password!=null && password.length>0 && password[0]!=null){
                //设置压缩文件加密
                parameters.setEncryptFiles(true);
                //设置加密方式
                parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
                //设置密码
                parameters.setPassword(password[0].toCharArray());
            }
            //添加文件到压缩文件
            respFile.addFiles(addFiles, parameters);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }



    /**
     * 移动 文件或者文件夹
     * @param oldPath
     * @param newPath
     * @throws IOException
     */
    public static void moveTo(String oldPath,String newPath) {
        copyFile(oldPath,newPath);
        deleteFile(oldPath);
    }

    /**
     * 删除 文件或者文件夹
     * @param filePath
     */
    public static void deleteFile(String filePath){
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (File f : list) {
                deleteFile(f.getAbsolutePath()) ;
            }
        }
        file.delete();
    }

    /**
     * 复制 文件或者文件夹
     * @param oldPath
     * @param newPath
     * @throws IOException
     */
    public static void  copyFile(String oldPath ,String newPath ) {
        try {
            File oldFile = new File(oldPath) ;
            if  (oldFile.exists())  {
                if(oldFile.isDirectory()){ // 如果是文件夹
                    File newPathDir = new File(newPath);
                    newPathDir.mkdirs();
                    File[] lists = oldFile.listFiles() ;
                    if(lists != null && lists.length > 0 ){
                        for (File file : lists) {
                            copyFile(file.getAbsolutePath(), newPath.endsWith(File.separator) ? newPath + file.getName() : newPath + File.separator + file.getName()) ;
                        }
                    }
                }else {
                    InputStream  inStream  =  new BufferedInputStream(new  FileInputStream(oldFile));  //读入原文件
                    OutputStream  outputStream  = new BufferedOutputStream(new  FileOutputStream(newPath)) ;
                    transferInOut(inStream ,outputStream) ;

                    inStream.close();
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 重命名文件
     * @param file
     * @param name
     * @return
     */
    public static File renameFile(File file , String name ){
        String fileName = file.getParent()  + File.separator + name ;
        File dest = new File(fileName);
        file.renameTo(dest) ;
        return dest ;
    }


    /**
     * 对接输入流和输出流，不关闭流
     * @param input
     * @param out
     * @param bufferSize 缓冲字节大小
     */
    public static void transferInOut(InputStream input , OutputStream out,int... bufferSize)  {
        try {
            if(bufferSize.length==0){
                bufferSize = new int[]{8192};
            }
            byte[] b = new byte[bufferSize[0]];
            int c = 0 ;
            while ( (c = input.read(b)) != -1 ) {
                out.write(b,0,c);
                out.flush();
            }
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	public static void main(String[] args) {
        /*ArrayList<File> list = new ArrayList<>(Arrays.asList(new File("/Users/huangkexiang/ant-design-pro-vue-master.zip"), new File("/Users/huangkexiang/项目工场介绍PPT.pptx")));
        FileUtil.zipFiles(new File("/Users/huangkexiang/uuuu.zip"),list,"1233");*/

        File dir = new File("/Users/huangkexiang/01ProjectFileTemDir");
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(new java.util.Date(file.lastModified()));
        }
    }

}
