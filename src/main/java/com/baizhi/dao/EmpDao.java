package com.baizhi.dao;

import com.baizhi.entity.Emp;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface EmpDao {

    List<Emp> findAll();

    void save(Emp emp);

    void update(Emp emp);

    void delete(Integer id);

    Emp findById(Integer id);
}
