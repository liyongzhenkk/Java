package com.atguigu.test02;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("lisi",19));
        students.add(new Student("zhangsan",18));

        System.out.println(students);

//        Collections.sort(students,(Student o1, Student o2)-> o1.age - o2.age);
        Collections.sort(students);

        System.out.println(students);


    }


    @org.junit.Test
    public void test01(){
        HashSet<String> strings = new HashSet<>();
        strings.add("lisi");
        strings.add("zhangsan");
        strings.add("lisi");

        for (String string : strings) {
            System.out.println(string);
        }

    }

    @org.junit.Test
    public void test02(){
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add("lisi");
        strings.add("zhangsan");

        for (String string : strings) {
            System.out.println(string);
        }

    }
}
