package com.rrbrr.kityclient.service;

import com.no.global.entity.QueryBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "datafile-provider", value = "datafile-provider", fallbackFactory = DownfileFallbackFactory.class,
        contextId = "downfile"
)
public interface DownfileService {

    //当前GetMapping是获取另一个微服务的具体控制器
    @GetMapping("/downfile/lists")
    String lists(@SpringQueryMap QueryBean queryBean);
    //String lists(@RequestParam("page") String page);

    @GetMapping("/downfile/batchDownload")
    String batchDownload(@SpringQueryMap QueryBean queryBean);
}
