package com.baizhi.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Emp implements Serializable {
    private int id;
    private String name;
    private String avatar;
    private float salary;
    private int age;
}
