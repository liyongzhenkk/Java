package com.atguigu.test02;

import java.util.Objects;



public class Student {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }
}
