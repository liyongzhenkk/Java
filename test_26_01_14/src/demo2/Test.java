package demo2;

public class Test {
    public static void Running(IRun run) {
        run.Run();
    }

    public static void Swimming(ISwim swim) {
        swim.swim();
    }

    public static void Flying(IFly fly) {
        fly.fly();
    }

    public static void main(String[] args) {
        Animal animal1 = new Dog("www ",1);
        Dog dog1 = new Dog("qqq ",12);
        Animal animal2 = new Bird("eee ",2);

        animal1.eat();
        animal2.eat();

        Running(dog1);


    }
}
