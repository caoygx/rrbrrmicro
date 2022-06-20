package com.rrbrr.kityclient.controller;



import com.no.global.entity.QueryBean;
import com.rrbrr.kityclient.service.DownfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName MemberController
 * @Description TODO
 * @Author ZhangSan_Plus
 * @Date 2020/5/18 16:51
 * @Version 1.0
 **/
@Controller
@RequestMapping("downfile")
public class DownfileController {

    @Autowired
    DownfileService downfileService;

    @GetMapping("/lists")
    @ResponseBody
    public String getList(QueryBean queryBean) {

        String result = downfileService.lists(queryBean);
        System.out.println(result);
        return result;
    }

    /**
     * 根据产品族、产品类型下载照片包
     * @return
     */
    @RequestMapping("/batchDownload")
    @ResponseBody
    //public String batchDownload(@RequestBody QueryBean queryBean){
    public String batchDownload( QueryBean queryBean){

        String result = downfileService.batchDownload(queryBean);
        return result;


        //http://localhost:8080/MySSM/downloadwBatch?productFamily=接入网&productType=OLT
        /*try {
            productFamily = new String(productFamily.getBytes("iso-8859-1"), "utf-8");
            productType = new String(productType.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //获取要下载的照片包名
        Map<String, String> params = new HashMap<String, String>();
        params.put("productFamily", productFamily);
        params.put("productType", productType);
        //List<String> packageNames = productService.getPackageNamesByFamilyAndType(params);

        List<String> packageNames = new ArrayList<>();
        packageNames.add("c:\\1.txt");
        packageNames.add("c:\\2.txt");
        packageNames.add("c:\\3.txt");

        //根据包名获取待下载的文件    文件名-字节数组的形式
        Map<String, byte[]> files = new HashMap<String, byte[]>();
        for(String packageName : packageNames){
            byte[] f = productService.getPackage(packageName);
            if(f!=null){
                files.put(packageName, f);
            }
        }

        //设置下载的压缩包名
        String zipName = productFamily + "_"+ productType + ".zip";

        //根据文件，进行压缩，批量下载
        if(files.size() > 0){
            productService.downloadBatchByFile(response, files, zipName);
        }*/

    }


}
