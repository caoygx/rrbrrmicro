package com.rrbrr.kity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.no.global.entity.QueryBean;
import com.rrbrr.kity.service.IBaseService;
import com.rrbrr.kity.util.Camelback;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

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
    public IPage<T> selectPage(QueryBean queryBean, Integer size){

        QueryWrapper<T> wrapper = new QueryWrapper<>();

        String keywords = queryBean.getKeyword();
        if(!StringUtils.isEmpty(keywords)){
            wrapper.like("table_name",keywords)
                    .or().like("project_name",keywords)
                    .or().like("description",keywords)
                    .or().like("definition",keywords);
        }

        IPage<T> pageList = new Page<>(queryBean.getPage(), size);//参数一是当前页，参数二是每页个数
        pageList = mapper.selectPage(pageList, wrapper);
        return  pageList;
    }


    public IPage<T> selectPage(QueryBean queryBean, T entity, Integer size) {


        QueryWrapper<T> wrapper = new QueryWrapper<>();
        Class<?> clazz = entity.getClass();
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
                Object value = field.get(entity);
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
//        return null;
    }

    public Class<T> getTClass()
    {
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }



}


