package com.atguigu.test03;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class demo03 {
    public static void main(String[] args) throws FileNotFoundException {
//        int result = method();
//        System.out.println(result);
        String s = "abc.tt";
        try {
            Insert(s);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            e.printStackTrace();
//            e.printStackTrace();
        }finally {

        }

        System.out.println("hehhehe");
        //method();

        //编译时期异常
//        FileOutputStream fos = new FileOutputStream("/Users/liyongzhen/Desktop/daily/JavaCoding/JavaSE/day04/src/main/java/com/atguigu/test03/1.txt");

        //运行时期异常
//        int[] arr = new int[10];
//        System.out.println(arr[100]);
    }

    public static int method() {
        try {
//            String s = null;
//            System.out.println(s.length());//空指针异常
            return 2;
        } catch (Exception e) {
            return 1;
            //System.out.println("哈哈哈哈");
        } finally {
            System.out.println("我一定要执行");
            //return 3;
        }
    }

    public static void Insert(String s) throws FileNotFoundException {
        if(!s.endsWith(".txt")){
            throw new FileNotFoundException("file not found");
        }

        System.out.println("haha!");
    }

}
