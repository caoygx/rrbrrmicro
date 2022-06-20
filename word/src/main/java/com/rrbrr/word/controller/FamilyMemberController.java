package com.rrbrr.word.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.no.global.entity.QueryBean;

import com.no.global.util.CommonPage;
import com.no.global.util.ReturnModel;
import com.rrbrr.word.entity.FamilyMember;
import com.rrbrr.word.service.IFamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    IFamilyMemberService familyMemberService;

    @RequestMapping(value = "/test", method = {RequestMethod.POST})
    public String test(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        return "test";
    }

    public void curd(QueryBean queryBean,FamilyMember familyMember,HttpServletResponse response, HttpServletRequest request)  throws IOException {
        IPage<FamilyMember> familyMemberIPage = familyMemberService.selectPage(queryBean, familyMember, 1);
        List<FamilyMember> records = familyMemberIPage.getRecords();
        System.out.println(records);
        new ReturnModel(CommonPage.restPage(familyMemberIPage)).renderJSON(response);
    }


    @RequestMapping("index")
    public void index(QueryBean queryBean,FamilyMember familyMember,HttpServletResponse response, HttpServletRequest request) throws IOException {

        curd( queryBean, familyMember, response,  request);


    }



}
