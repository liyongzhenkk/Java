package day02_1.c_test;

public class Android extends Developer {
    public Android(int id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println("员工号为" + getId() + "的 " + getName() + "员工，正在研发电商的手机客户端软件");
    }
}
