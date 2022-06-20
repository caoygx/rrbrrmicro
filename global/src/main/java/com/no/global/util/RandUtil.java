package com.no.global.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandUtil {
    public static String randomFileNameByTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = simpleDateFormat.format(date);
        return fileName;
    }
}
