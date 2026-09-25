package com.atguigu.test01;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DemoHashmap {
    @Test
    public void test01(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("大郎","金莲");
        map.put("岩朔","王婆");
        map.put("硕鑫","雨姐");
//        Set<String> keys = map.keySet();
//        for (String key : keys) {
//            System.out.printf(map.get(key));
//        }

        Set<Map.Entry<String,String>> entries = map.entrySet();
        for(Map.Entry<String,String> entry:entries){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }


    ///需求:用Map集合统计字符串中每一个字符出现的次数
    /// 步骤:
    ///   1.指定一个字符串
    ///   2.创建一个map集合,key指定为String代表字符,value为Integer代表字符个数
    ///   3.遍历字符串,用每一个字符去判断,Map中是否包含字符
    ///   4.如果不包含,将字符和1存到map中
    ///   5.如果包含,根据字符将对应的value获取出来,让其+1,并重新存入
    ///   6.输出map
    @Test
    public void test02(){
        countNum("abcde");
    }

    public static void countNum(String str1){
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char c = str1.charAt(i);
            stringIntegerHashMap.compute(c+" ",(k, num) -> num == null ? 1 : num + 1);
        }
        for(Map.Entry<String,Integer> entry:stringIntegerHashMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

}
