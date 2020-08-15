package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao {

    Admin findByUserName(String username);

    void regist(Admin admin);

}
