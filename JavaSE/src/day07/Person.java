package day07;


public class Person {
    String name;
    public void speak(String name){
        System.out.println(this+"...............");
        System.out.println(this.name+"您好,我是"+name);
    }
}

class Test01 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person+"...");
        person.name = "哪吒";
        person.speak("李靖");

        System.out.println("================");
        Person person2 = new Person();
        System.out.println(person2+"...");
        person2.name = "沉香";
        person2.speak("刘彦昌");
    }
}
