package com.atguigu.test01;

import org.junit.Test;

public class test {

    @Test
    public void test01(){
//        State weifukuan = State.WEIFUKUAN;
//        System.out.println(weifukuan.Getname());
//

        State[] values = State.values();
        for (State value : values) {
            System.out.println(value.Getname());
        }
    }

}
