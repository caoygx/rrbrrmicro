package com.rrbrr.kityclient.service;

public class ProductService {
/*
    public byte[] getPackage(String packageName){
        byte[] bag  = null;
        try{
            ImageFile m = productMapper.getPackage(packageName);
            if(m!=null){
                bag = m.getPicture();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return bag;
    }



    public List<String> getPackageNamesByFamilyAndType(Map<String, String> params) {
        List<String> packageNames = productMapper.getPackageNamesByFamilyAndType(params);

        return packageNames;
    }


    public void downloadBatchByFile(HttpServletResponse response, Map<String, byte[]> files, String zipName){
        try{
            response.setContentType("application/x-msdownload");
            response.setHeader("content-disposition", "attachment;filename="+ URLEncoder.encode(zipName, "utf-8"));

            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
            BufferedOutputStream bos = new BufferedOutputStream(zos);

            for(Map.Entry<String, byte[]> entry : files.entrySet()){
                String fileName = entry.getKey();            //每个zip文件名
                byte[]    file = entry.getValue();            //这个zip文件的字节

                BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(file));
                zos.putNextEntry(new ZipEntry(fileName));

                int len = 0;
                byte[] buf = new byte[10 * 1024];
                while( (len=bis.read(buf, 0, buf.length)) != -1){
                    bos.write(buf, 0, len);
                }
                bis.close();
                bos.flush();
            }
            bos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
}
