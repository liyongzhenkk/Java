package com.atguigu.test04;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Biginteger {
    public static void main(String[] args) {
//        BigInteger b1 = new BigInteger("12121212121212121212121212121212121");
//        BigInteger b2 = new BigInteger("12121212121212121212121212121212121");
//        BigInteger add = b1.add(b2);
//        System.out.println("add = " + add);
//        BigInteger subtract = b1.subtract(b2);
//        System.out.println("subtract = " + subtract);
//        BigInteger multiply = b1.multiply(b2);
//        System.out.println("multiply = " + multiply);
//        BigInteger divide = b1.divide(b2);
//        System.out.println("divide = " + divide);
//
//        int num = b1.intValue();
//        System.out.println("num = " + num);
        Date date = new Date();
        System.out.println(date);

        LocalDate local1 = LocalDate.now();
        System.out.println(local1);

        LocalDateTime local2 = LocalDateTime.now();
        System.out.println(local2);

    }
}
