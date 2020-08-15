package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
@Log4j2
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(Admin admin, HttpServletRequest request){
        Admin login = adminService.login(admin.getUsername());
        if (login.getPassword().equals(admin.getPassword())){
            request.getSession().setAttribute("adminLogin",admin);
            return "redirect:/emp/findAll";
        }else{
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("regist")
    public String regist(Admin admin){
        log.info("接收到的参数为："+admin);
        adminService.regist(admin);
        return "redirect:/login.jsp";
    }

    @RequestMapping("zhuxiao")
    public String zhuxiao(HttpServletRequest request){
        request.getSession().setAttribute("adminLogin","");
        return "/login";
    }

}
