package day07.pojo;

public class test {
    public static void main(String[] args) {
        Student.room = "VIP1";
        Student student1 = new Student("zs",18);
        student1.room = "vip2";
        System.out.println(student1);

        Student student2 = new Student("ls",20);
        System.out.println(student2);


    }
}
