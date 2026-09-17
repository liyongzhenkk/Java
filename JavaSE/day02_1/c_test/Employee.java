package day02_1.c_test;

public abstract class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // 所有员工都要工作，具体工作内容由工程师子类实现。
    public abstract void work();
}
