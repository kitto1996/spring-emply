package com.kitto.dao;

import com.kitto.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kitto
 * @create 2022-04-07-19:00
 */
//部门表
    @Repository
public class DepartDao {
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();//创建一个部门
        departments.put(101, new Department(101, "蒙德"));
        departments.put(102, new Department(102, "璃月"));
        departments.put(103, new Department(103, "稻妻"));
        departments.put(104, new Department(104, "须弥"));
        departments.put(105, new Department(105, "枫丹"));
    }

    //获取所有部门信息
    public Collection<Department> getDepart() {
        return departments.values();
    }
    //通过id获取部门信息
    public Department getDepartById(Integer id){
        return departments.get(id);
    }
}
