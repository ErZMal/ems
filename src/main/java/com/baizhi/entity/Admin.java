package com.baizhi.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Admin implements Serializable {
    private int id;
    private String username;
    private String name;
    private String password;
    private String sex;
}
