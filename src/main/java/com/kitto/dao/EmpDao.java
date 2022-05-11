package com.kitto.dao;

import com.kitto.pojo.Department;
import com.kitto.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kitto
 * @create 2022-04-09-9:05
 */
@Repository
public class EmpDao {
    //员工表
    private static Map<Integer, Employee>employeeMap=null;
    @Autowired
    private DepartDao departDao;
    static {
        employeeMap=new HashMap<Integer,Employee>();
        employeeMap.put(1001,new Employee(1001,"巴巴托斯","10744581@qq.com",1,new Department(101,"蒙德")));
        employeeMap.put(1002,new Employee(1002,"摩拉克斯","10744582@qq.com",0,new Department(102,"璃月")));
        employeeMap.put(1003,new Employee(1003,"雷电将军","10744583@qq.com",0,new Department(103,"稻妻")));
        employeeMap.put(1004,new Employee(1004,"kitto","10744584@qq.com",1,new Department(104,"须弥")));
        employeeMap.put(1005,new Employee(1005,"小王","10744585@qq.com",1,new Department(105,"枫丹")));
    }
    //员工主键自增
    private static Integer InitId=1006;
    //增加员工
    public void add(Employee employee){
        //如果id为空，则设置id自增
        if(employee.getId()==null){
            employee.setId(InitId++);
        }
        employee.setDepartment(departDao.getDepartById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
    //查询所有员工信息
    public Collection<Employee> getAll(){
        return employeeMap.values();
    }
    //根据id查询员工所有信息
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }
    //通过id删除员工
    public void delete(Integer id){
        employeeMap.remove(id);
    }
}
