package day02_1.a_abstract;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("cat eat");
    }

    @Override
    public void drink() {
        System.out.println("cat drink");
    }
}
