package com.baizhi.test;

import com.baizhi.entity.User;

import java.util.Date;

public class UserTest {
    public static void main(String[] args) {
        User user = new User();
        /*user.setName("zhangsan");
        user.setAge(23);
        user.setId("1");
        user.setBir(new Date());*/
        user.setId("1").setName("lsii").setAge(23).setBir(new Date());
        System.out.println(user);
    }
}
