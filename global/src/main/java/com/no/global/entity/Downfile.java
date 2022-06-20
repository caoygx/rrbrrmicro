package com.no.global.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Downfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String type;
    private String title;
    private String productName;
    private String oldpath;

    private String filename;

    private String uploadedTime;

    private String path;

    private String ext;

    private Long size;
    private Long newSize;
    private Integer synchronizationStatus;

    private String downloadCount;

    private String wrappedDatasource;

    private String dataUpTo;

    private String productFrequency;

    private String displayFlag;

    private String downloadType;

    private String createTime;

    private String fullname;

    private String period;


}
