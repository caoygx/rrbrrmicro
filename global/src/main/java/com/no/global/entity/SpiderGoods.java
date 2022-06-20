package com.no.global.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SpiderGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    private String categoryName;

    private String asin;

    private String brand;

    /**
     * 排名
     */
    private String rank;

    /**
     * 增长数
     */
    private String addNum;

    /**
     * 增长率
     */
    private String addRate;

    /**
     * 价格
     */
    private String price;

    /**
     * 毛利率
     */
    private String grossRate;

    /**
     * 运费
     */
    private String freight;

    /**
     * 评论数
     */
    private String review;

    /**
     * 评论率
     */
    private String reviewRate;

    /**
     * 评分
     */
    private String rating;

    /**
     * 月新增
     */
    private String addMonth;

    /**
     * 月销量
     */
    private String salesVolume;

    /**
     * 月增长率
     */
    private String monthRate;

    /**
     * 销量
     */
    private String sales;

    /**
     * 上架时间
     */
    private String startDate;

    /**
     * 配送
     */
    private String expressCompany;

    /**
     * 站点id
     */
    private String marketId;

    /**
     * 月份
     */
    private String month;

    private Integer total;


}
