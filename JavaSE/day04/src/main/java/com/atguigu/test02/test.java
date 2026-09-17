package com.atguigu.test02;

public class test {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));

    }
}
