package com.rrbrr.kity.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FamilyMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别,1:男,0:女
     */
    private Integer sex;

    /**
     * 第几代
     */
    private Integer level;

    /**
     * 排行,男女分别排行
     */
    private Integer order;

    /**
     * 爸爸ID
     */
    private Integer fid;

    /**
     * 妈妈ID
     */
    private Integer mid;

    /**
     * 配偶id 
     */
    private Integer spouse;

    /**
     * 生日
     */
    private String birth;

    /**
     * 卒日
     */
    private String death;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 所属家族id
     */
    private Integer familyId;

    /**
     * 简单描述
     */
    private String description;

    /**
     * 字辈
     */
    private String generational;

    /**
     * 成员照片
     */
    private String thumb;

    /**
     * 娘家家谱id
     */
    private Integer foreignFamilyId;

    private Integer status;

    /**
     * 纪念馆ID
     */
    private Integer memorialId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
