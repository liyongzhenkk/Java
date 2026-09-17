package day03.test1;

public class Person {
    Person(){
        System.out.println("构造方法");
    }

    {
        System.out.println("构造代码块");
    }

    static{
        System.out.println("static 构造代码块");
    }
}
