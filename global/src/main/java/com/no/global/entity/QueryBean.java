package com.no.global.entity;

import lombok.Data;

@Data
public class QueryBean {

    private String id;
    private String ids;
    private String sort;
    private String keyword;
    private Integer parseStatus;
    private Integer page;
    private Integer rowSize;
    private String name;
    private String title;
    private String productName;
    private Integer status;
    private String type;
    private Integer goodsId;
    private String openid;
    private String phone;
    private Integer userType;
    private String startDate;
    private String endDate;
    private String userName;

//    public QueryBean() {
//        this.page = Integer.valueOf(1);
//        this.rowSize = Integer.valueOf(10);
//    }
}