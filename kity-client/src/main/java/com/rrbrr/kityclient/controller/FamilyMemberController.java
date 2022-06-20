package com.rrbrr.kityclient.controller;


import com.alibaba.fastjson.JSONObject;
import com.no.global.entity.QueryBean;
import com.rrbrr.kityclient.service.DownfileService;
import com.rrbrr.kityclient.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-23
 */
@RestController
@RequestMapping("/familyMember")
public class FamilyMemberController {

    @Autowired
    FamilyMemberService service;

    @RequestMapping(value = "/test", method = {RequestMethod.POST})
    public String test(@RequestBody JSONObject jsonObject) {
        //String result = service.test(queryBean);
        System.out.println(jsonObject);
        return "";
        //return result;
    }

    @RequestMapping("save")
    @ResponseBody
    public String save(QueryBean queryBean) {

        String result = service.save(queryBean);
        System.out.println(result);
        return result;
    }

    @RequestMapping("kitySave")
    @ResponseBody
    public String kitySave(@RequestBody JSONObject jsonObject) {
        String result = service.kitySave(jsonObject);
        System.out.println(result);
        return result;
    }

    public void parseJson(){

    }

}
