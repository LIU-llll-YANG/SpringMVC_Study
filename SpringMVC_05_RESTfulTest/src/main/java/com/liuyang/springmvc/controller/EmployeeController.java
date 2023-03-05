package com.liuyang.springmvc.controller;

import com.liuyang.springmvc.dao.EmployeeDao;
import com.liuyang.springmvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String showEmployeePage(HttpServletRequest request){
        //1. 获取所有的员工
        Collection<Employee> employees = employeeDao.getAll();
        //2.将员工信息保存到请求域中共享
        request.setAttribute("employees",employees);
        return "employee";
    }


    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
