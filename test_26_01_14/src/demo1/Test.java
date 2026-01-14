package demo1;

import java.util.Comparator;

class AgeComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age-o2.age;
    }
}
class Student implements Comparable<Student> {
    protected String name;
    protected int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Student o) {
        if(this.age < o.age) return -1;
        else if(this.age > o.age) return 1;
        else return 0;
    }
}

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("zs",22);
        Student student2 = new Student("ls",20);

        //System.out.println(student1 > student2);
        //System.out.println(student1.compareTo(student2));
        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1, student2));
    }
}
