package com.imooc.utils;

import java.util.Random;

/**
 * @author Donqiuxote
 * @data 2018/2/5 14:25
 */
public class KeyUtil {
    public static synchronized String genUniqueKey(){
        //主键生成：当前毫秒数+6位随机数
        Random random=new Random();
        Integer a = random.nextInt(900000) + 100000;
        return  System.currentTimeMillis()+String.valueOf(a);
    }
}
