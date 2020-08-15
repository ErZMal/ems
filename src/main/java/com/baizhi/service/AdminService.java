package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {

    Admin login(String username);

    void regist(Admin admin);

}
