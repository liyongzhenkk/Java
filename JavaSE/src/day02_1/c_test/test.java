package day02_1.c_test;


//某IT公司有多名员工，按照员工负责的工作不同，进行了部门的划分（研发部、维护部）。
//研发部(Developer)根据所需研发的内容不同，又分为 JavaEE工程师 、Android工程师 ；
//维护部(Maintainer)根据所需维护的内容不同，又分为 网络维护工程师(Network) 、硬件维护工程师(Hardware) 。
//
//公司的每名员工都有他们自己的员工编号、姓名，并要做他们所负责的工作。
//
//工作内容:
//        - JavaEE工程师： 员工号为xxx的 xxx员工，正在研发电商网站
//- Android工程师：员工号为xxx的 xxx员工，正在研发电商的手机客户端软件
//- 网络维护工程师：员工号为xxx的 xxx员工，正在检查网络是否畅通
//- 硬件维护工程师：员工号为xxx的 xxx员工，正在修复电脑主板
//
//请根据描述，完成员工体系中所有类的定义，并指定类之间的继承关系。进行XX工程师类的对象创建，完成工作方法的调用。

public class test {
    public static void main(String[] args) {
        JavaEE javaEE = new JavaEE(1, "张三");
        Android android = new Android(2, "李四");
        Network network = new Network(3, "王五");
        Hardware hardware = new Hardware(4, "赵六");

        javaEE.work();
        android.work();
        network.work();
        hardware.work();
    }
}
