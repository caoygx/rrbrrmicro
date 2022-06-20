package com.no.global.entity;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Sort<T> {
    Boolean isAsc;
    String column;

/*    public Consumer<T> getColumn() {
        Supplier<Downfile> supplier = Downfile::getId;
        return supplier;
    }

    public KiteFunction<LocalDateTime,String,String>  getColumn(){
        //return  Downfile::getId;
        return FunctionTest::DateFormat;
    }
*/
    public SFunction<Downfile,?> getColumn(){

        /*try {
            Class<?> aClass = Class.forName("com.no.global.entity.Downfile");
            //Method[] methods = aClass.getMethods();
            Method getId = aClass.getMethod("getId");
            return getId;
            //System.out.println(methods);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        if("id".equals(column)){
            return  Downfile::getId;
        }else if("productName".equals(column)){
            return  Downfile::getProductName;
        }else if("ext".equals(column)){
            return  Downfile::getExt;
        }else if("dataUpTo".equals(column)){
            return  Downfile::getDataUpTo;
        }else if("uploadedTime".equals(column)){
            return  Downfile::getUploadedTime;
        }else{
            return  Downfile::getId;
        }
        //return FunctionTest::DateFormat;
    }




}

class FunctionTest {
    public static String DateFormat(LocalDateTime dateTime, String partten) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(partten);
        return dateTime.format(dateTimeFormatter);
    }
}

//@FunctionalInterface
//interface FunctionalInter{}

/*@FunctionalInterface
interface SFunction<T, R> extends Function<T, R>, Serializable {
}*/

@FunctionalInterface
interface Get<R> {
    R run();
}

@FunctionalInterface
interface KiteFunction<T, R, S> {

    /**
     * 定义一个双参数的方法
     * @param t
     * @param s
     * @return
     */
    R run(T t, S s);
}

