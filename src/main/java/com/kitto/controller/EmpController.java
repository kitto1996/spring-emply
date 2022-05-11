package com.kitto.controller;

import com.kitto.dao.DepartDao;
import com.kitto.dao.EmpDao;
import com.kitto.pojo.Department;
import com.kitto.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author kitto
 * 员工管理
 * @create 2022-04-10-9:18
 */
@Controller
public class EmpController {
    @Autowired
     EmpDao empDao;
    @Autowired
    DepartDao departDao;
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = empDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有部门信息
        Collection<Department> departments = departDao.getDepart();
        model.addAttribute("departments",departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加的操作
        empDao.add(employee);
        return "redirect:/emps";
    }

    //去修改员工信息页面
    @GetMapping ("/emp/{id}")//连接形式请求用getMapping
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //先查员工数据
        Employee employee = empDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //查部门信息
        Collection<Department> departments = departDao.getDepart();
        model.addAttribute("departments",departments);
        return "emp/update";
    }
    //在修改页面修改员工信息
    @PostMapping  ("/updateEmp")
    public String updateEmp(Employee employee){
        //修改过后保存员工信息
        empDao.add(employee);
        return "redirect:/emps";
    }
//删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        empDao.delete(id);
        return "redirect:/emps";
    }
}
