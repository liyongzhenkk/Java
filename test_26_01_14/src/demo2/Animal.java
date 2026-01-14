package demo2;

abstract class Animal {
    protected String name;
    protected int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    abstract void eat();

}

class Dog extends Animal implements IRun {
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    void eat() {
        System.out.println(this.name + "dog eat!!!!");
    }

    @Override
    public void Run() {
        System.out.println(this.name + "dog run!!!!");
    }
}

class Bird extends Animal implements IRun, IFly {
    public Bird(String name, int age) {
        super(name, age);
    }
    @Override
    void eat() {
        System.out.println(this.name + "bird eat!!!!");
    }

    @Override
    public void Run() {
        System.out.println(this.name + "bird run!!!!");
    }

    @Override
    public void fly() {
        System.out.println(this.name + "bird fly!!!!");
    }
}

