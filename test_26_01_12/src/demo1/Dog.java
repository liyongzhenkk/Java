package demo1;

public class Dog extends Animal{

    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void Eat() {
        System.out.println(this.name +" eat dog foods");
    }
}
