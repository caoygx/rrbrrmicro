package com.rrbrr.kityclient.service;

import com.alibaba.fastjson.JSONObject;
import com.no.global.entity.QueryBean;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DownfileFallbackFactory implements FallbackFactory<DownfileService> {

    @Override
    public DownfileService create(Throwable cause) {
        return new DownfileService() {

            @Override
            public String lists(QueryBean queryBean) {
                JSONObject json = new JSONObject();
                //json.put("id", id);
                json.put("description", "服务异常演习专用！");
                json.put("msg", cause.getMessage());
                return json.toJSONString();
            }

            @Override
            public String batchDownload(QueryBean queryBean) {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("description","下载失败");
                jsonObject.put("msg",cause.getMessage());
                return jsonObject.toJSONString();
            }


        };
    }

}
