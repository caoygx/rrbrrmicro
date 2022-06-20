package com.rrbrr.word.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.no.global.entity.QueryBean;
import com.rrbrr.word.entity.FamilyMember;
import org.apache.poi.ss.formula.functions.T;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-06-29
 */
public interface IBaseService<T> extends IService<T> {
    public IPage<T> selectPage(QueryBean queryBean,T entiy,Integer size);


    }
