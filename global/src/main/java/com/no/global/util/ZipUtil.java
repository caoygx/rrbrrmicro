package com.no.global.util;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public static String createZipFile(ArrayList<String> fileList, String zipFileName) {

        if(fileList == null || fileList.size() == 0 || StringUtils.isEmpty(zipFileName)){
            return null;
        }

        //构建压缩文件File
        File zipFile = new File(zipFileName);
        //初期化ZIP流
        ZipOutputStream out = null;

        try{
            //构建ZIP流对象
            out = new ZipOutputStream(new FileOutputStream(zipFile));
            //循环处理传过来的集合
            for(int i = 0; i < fileList.size(); i++){
                //获取目标文件
                File inFile = new File(fileList.get(i));
                if(inFile.exists()){
                    //定义ZipEntry对象
                    ZipEntry entry = new ZipEntry(inFile.getName());
                    //赋予ZIP流对象属性
                    out.putNextEntry(entry);
                    int len = 0 ;
                    //缓冲
                    byte[] buffer = new byte[1024];
                    //构建FileInputStream流对象
                    FileInputStream fis;
                    fis = new FileInputStream(inFile);
                    while ((len = fis.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                        out.flush();
                    }
                    //关闭closeEntry
                    out.closeEntry();
                    //关闭FileInputStream
                    fis.close();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                //最后关闭ZIP流
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return zipFileName;

    }
}
