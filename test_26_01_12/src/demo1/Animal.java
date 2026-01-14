package demo1;

public class Animal {
    protected String name;
    protected int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void Eat() {
        System.out.println(this.name + "eat");
    }

}
