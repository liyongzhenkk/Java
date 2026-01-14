package demo1;

public class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void Eat() {
        System.out.println(this.name +" eat cat foods");
    }
}
