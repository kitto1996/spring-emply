package com.kitto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author kitto
 * @create 2022-04-07-18:46
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String empName;
    private String email;
    private Integer gender;//0->女 1->男
    private Department department;
    private Date date;

    public Employee(Integer id, String empName, String email, Integer gender, Department department) {
        this.id = id;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认日期
        this.date = new Date();
    }

}
