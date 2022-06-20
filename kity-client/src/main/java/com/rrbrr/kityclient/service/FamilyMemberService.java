package com.rrbrr.kityclient.service;

import com.alibaba.fastjson.JSONObject;
import com.no.global.entity.QueryBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "kity-provider", value = "kity-provider", fallbackFactory = FamilyMemberFallbackFactory.class,
        contextId = "familyMember"
)
public interface FamilyMemberService {

    //当前GetMapping是获取另一个微服务的具体控制器
    @GetMapping("/familyMember/test")
    String test(@SpringQueryMap QueryBean queryBean);

    //当前GetMapping是获取另一个微服务的具体控制器
    @GetMapping("/familyMember/save")
    String save(@SpringQueryMap QueryBean queryBean);

    @GetMapping("/familyMember/kitySave")
    String kitySave(@RequestBody JSONObject queryBean);
}
