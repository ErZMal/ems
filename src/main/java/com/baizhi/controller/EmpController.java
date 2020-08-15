package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Value("${upload.dir}")
    private String uploadPath;

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Emp> emps = empService.findAll();
        model.addAttribute("emps",emps);
        return "emplist";
    }

    @RequestMapping("save")
    public String save(Emp emp, MultipartFile photo) throws IOException {
        //对avatar进行处理
        log.info("得到头像的地址："+uploadPath);

        if (photo == null){
            emp.setAvatar("2.jpg");
        }else {

            //整理头像上传的文件
            File dir = new File(uploadPath);

            if (!dir.exists()) dir.mkdirs();

            //整理照片的名字
            String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
            String fileName = UUID.randomUUID().toString() + "." + extension;
            log.info("文件要存入数据库的名字:" + fileName);

            photo.transferTo(new File(dir,fileName));
            emp.setAvatar(fileName);
        }

        empService.save(emp);
        return "redirect:/emp/findAll";
    }

    @RequestMapping("delete")
    public String delete(Integer id){
        empService.delete(id);
        return "redirect:/emp/findAll";
    }


    @RequestMapping("findById")
    public String findById(Integer id, HttpServletRequest request){
        Emp emp = empService.findById(id);
        request.setAttribute("emp", emp);

        return "updateEmp";
    }

    @RequestMapping("update")
    public String update(Emp emp,MultipartFile photo) throws IOException {
        log.info("更改后的信息为"+emp);

        if (photo == null){

        }else {

            //整理头像上传的文件
            File dir = new File(uploadPath);

            if (!dir.exists()) dir.mkdirs();

            //整理照片的名字
            String extension = FilenameUtils.getExtension(photo.getOriginalFilename());
            String fileName = UUID.randomUUID().toString() + "." + extension;
            log.info("文件要存入数据库的名字:" + fileName);

            photo.transferTo(new File(dir,fileName));
            emp.setAvatar(fileName);
        }
        empService.update(emp);
        return "redirect:/emp/findAll";
    }

}
