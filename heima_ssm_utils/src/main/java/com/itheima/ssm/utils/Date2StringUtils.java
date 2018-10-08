package com.itheima.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2StringUtils {
    //提供将Date类型转换为String类型的方法
    public static String date2String(Date date,String pattern){
        String format = new SimpleDateFormat(pattern).format(date);
        return format;
    }
}
