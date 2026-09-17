package com.atguigu.test01;

public enum State {
    WEIFUKUAN("未付款"),
    YIFUKUAN("已付款"),
    DAIFAHUO("待收货"),
    YISHOUHUO("已收货");

    private String name;
    State(String name){
        this.name = name;
    }
    String Getname(){
        return name;
    }
}
