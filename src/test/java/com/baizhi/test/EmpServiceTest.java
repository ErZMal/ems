package com.baizhi.test;

import com.baizhi.EmsApplication;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = EmsApplication.class)
@RunWith(SpringRunner.class)
public class EmpServiceTest {

    @Autowired
    private EmpService empService;

    /**
     * 如果出现以下错误：
     *      java.sql.SQLNonTransientConnectionException: CLIENT_PLUGIN_AUTH is required
     *  需要在pom/xml的mysql驱动中指定5.x版本驱动
     */

    @Test
    public void testSave(){
        Emp emp = new Emp();
        emp.setName("百知").setAge(24).setSalary(14234f).setAvatar(null);
        empService.save(emp);
    }

    @Test
    public void testFindAll(){
        List<Emp> emps = empService.findAll();
        emps.forEach((emp)-> System.out.println("emp:"+ emp));
    }
}
