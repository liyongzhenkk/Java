package demo1;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Cat("mimi",2);
        Animal animal2 = new Dog("wangwang",1);

        animal.Eat();
        animal2.Eat();
    }
}
