package com.no.global.util;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class GzipUtil {

    /**
     *
     * @Title: pack
     * @Description: 将一组文件打成tar包
     * @param sources
     *            要打包的原文件数组
     * @param target
     *            打包后的文件
     * @return File 返回打包后的文件
     * @throws
     */
    public static File pack(List<String> sources, File target) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(target);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        TarArchiveOutputStream os = new TarArchiveOutputStream(out);
        for(int i = 0; i < sources.size(); i++){

            File file = new File(sources.get(i));
            InputStream inputStream = null;
            try {
                os.putArchiveEntry(new TarArchiveEntry(file,file.getName()));//打包的时候只是包含文件，不带路径
                //os.putArchiveEntry(new TarArchiveEntry(file));  //打包的时候带路径
                inputStream = new FileInputStream(file);
                IOUtils.copy(inputStream, os);
                os.closeArchiveEntry();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(inputStream!=null){
                inputStream.close();
            }
        }
        if (os != null) {
            try {
                os.flush();
                os.close();
                System.out.println("打包后文件为：" + target);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return target;
    }


    /**
     * tar打包压缩
     * @param source  需要压缩的文件
     * @param FilePath  压缩后的文件全文件名(.tar)
     * @return  返回压缩后的文件
     */
    public static File compress(File source,String FilePath) {
        File target = new File(FilePath);
        FileInputStream in = null;
        GZIPOutputStream out = null;
        try {
            in = new FileInputStream(source);
            out = new GZIPOutputStream(new FileOutputStream(target));
            byte[] array = new byte[1024];
            int number;
            while ((number = in.read(array, 0, array.length)) != -1) {
                out.write(array, 0, number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (in != null) {
                try {
                    in.close();
                    source.delete();//解压成功后，删除tar文件
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            if (out != null) {
                try {
                    out.close();
                    System.out.println("打包后文件为：" + target);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return target;
    }

    //spublic static String createGzipFile(ArrayList<String> fileList, String zipFileName)

    public static String createZipFile(ArrayList<String> fileList, String zipFileName) {
/*
        if(fileList == null || fileList.size() == 0 || StringUtils.isEmpty(zipFileName)){
            return null;
        }

        //构建压缩文件File
        File zipFile = new File(zipFileName);
        //初期化ZIP流
        GZIPOutputStream out = null;

        try{
            //构建ZIP流对象
            out = new GZIPOutputStream(new FileOutputStream(zipFile));
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
*/

        return zipFileName;

    }


    /**
     * GZIP方式 对文件进行压缩
     *
     * zipFile("D:\\4.json", "D:\\test\\4.zip");
     * @param source 源文件
     * @param target 目标文件
     * @throws IOException
     */
    public static void zipFile(String source, String target) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fin = null;
        FileOutputStream fout = null;
        GZIPOutputStream gzout = null;
        try {
            fin = new FileInputStream(source);
            fout = new FileOutputStream(target);
            gzout = new GZIPOutputStream(fout);
            byte[] buf = new byte[1024];
            int num;
            while ((num = fin.read(buf)) != -1) {
                gzout.write(buf, 0, num);
            }
        } finally {
            if (gzout != null)
                gzout.close();
            if (fout != null)
                fout.close();
            if (fin != null)
                fin.close();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
