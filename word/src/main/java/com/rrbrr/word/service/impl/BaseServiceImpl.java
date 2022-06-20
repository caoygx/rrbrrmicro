package com.rrbrr.word.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.no.global.entity.QueryBean;
import com.rrbrr.word.entity.FamilyMember;
import com.rrbrr.word.service.IBaseService;
import com.rrbrr.word.util.Camelback;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-06-29
 */

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {

    @Autowired
    protected M mapper;

    public IPage<T> selectPage(QueryBean queryBean, T familyMember,  Integer size) {


        //FamilyMember familyMember = new FamilyMember();
        QueryWrapper<T> wrapper = new QueryWrapper<>();
//        QueryWrapper<FamilyMember> wrapper = new QueryWrapper<>();
        Class<?> clazz = familyMember.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            //属性名
            String fieldName = field.getName();
            if("serialVersionUID".equals(fieldName)) continue;

            /*MyAnnotation.MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyAnnotation.MyFieldAnnotation.class);
            if(myFieldAnnotation == null) continue;
            System.out.println(myFieldAnnotation.desc() + "+" + myFieldAnnotation.uri());*/

            //对应值
            try {
                Object value = field.get(familyMember);
                System.out.println(value);
                String name = field.getType().getName();
                System.out.println(name);
                if (value != null) {
                    fieldName = Camelback.humpToLine(fieldName);
                    wrapper.eq(fieldName, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }



        IPage<T> pageList = new Page<>(queryBean.getPage(), size);//参数一是当前页，参数二是每页个数
        pageList = mapper.selectPage(pageList, wrapper);
        return pageList;
    }



}


