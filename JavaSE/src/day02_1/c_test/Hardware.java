package day02_1.c_test;

public class Hardware extends Maintainer {
    public Hardware(int id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println("员工号为" + getId() + "的 " + getName() + "员工，正在修复电脑主板");
    }
}
