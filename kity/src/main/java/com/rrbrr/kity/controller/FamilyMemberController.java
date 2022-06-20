package com.rrbrr.kity.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.no.global.entity.QueryBean;
import com.rrbrr.kity.entity.FamilyMember;
import com.rrbrr.kity.service.IFamilyMemberService;
import com.rrbrr.kity.service.impl.FamilyMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    FamilyMemberServiceImpl familyMemberService;

    @RequestMapping(value = "/test", method = {RequestMethod.POST})
    public String test(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        return "test";
    }

    @RequestMapping("save")
    @ResponseBody
    public String batchDownload(QueryBean queryBean) {

       return "";
    }

    @RequestMapping(value = "/kitySave", method = {RequestMethod.POST})
    @ResponseBody
    public String kitySave(@RequestBody JSONObject jsonObject) {

        System.out.println(jsonObject);
        JSONObject root = jsonObject.getJSONObject("root");
        root.getJSONObject("data"); //节点



        return "收到";
    }

    public void save(FamilyMember familyMember){
        familyMemberService.save(familyMember);
    }


    @RequestMapping("test")
    public void test(){
        String json = "{\"root\":{\"data\":{\"id\":\"cdfryz77uwao\",\"created\":1628592816150,\"text\":\"导入\"},\"children\":[{\"data\":{\"id\":\"cdgn01y2gutc\",\"created\":1628680354899,\"text\":\"csv2x1x\"},\"children\":[]},{\"data\":{\"id\":\"cdh84jktqt4w\",\"created\":1628739950045,\"text\":\"csvx2x2\"},\"children\":[]},{\"data\":{\"id\":\"cecogmmbquio\",\"created\":1631934393451,\"text\":\"csxv313\"},\"children\":[]},{\"data\":{\"id\":\"cecoh358exhc\",\"created\":1631934429423,\"text\":\"gz\"},\"children\":[]},{\"data\":{\"id\":\"cecohs2i7vnk\",\"created\":1631934483678,\"text\":\"zip\"},\"children\":[]}]},\"template\":\"default\",\"theme\":\"fresh-blue\",\"version\":\"1.4.43\"}";
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject root = jsonObject.getJSONObject("root");

        parseJson(root);
        //parseJson(root);


    }


    public void parseJson(JSONObject root){

        //处理当前节点数据
        FamilyMember familyMember = new FamilyMember();
        familyMember.setName(root.getString("text"));
        save(familyMember);

        //处理子节点数据
        JSONArray children = root.getJSONArray("children");
        if(children.size()>0){
            //递归
            for(int i=0; i<children.size(); i++){
                Object o = children.get(i);
                parseJson((JSONObject) o);
            }

        }

    }

    @RequestMapping("index")
    public String index(){
        QueryBean queryBean = new QueryBean();
        queryBean.setPage(1);
        FamilyMember familyMember = new FamilyMember();
        familyMember.setStatus(1);
        IPage<FamilyMember> familyMemberIPage = familyMemberService.selectPage(queryBean, familyMember, 1);
        System.out.println(familyMemberIPage);


        return "x";
    }

}
