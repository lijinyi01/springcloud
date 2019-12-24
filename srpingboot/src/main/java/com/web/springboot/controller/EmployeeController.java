package com.web.springboot.controller;

import com.web.springboot.dao.DepartmentDao;
import com.web.springboot.dao.EmployeeDao;
import com.web.springboot.entities.Department;
import com.web.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao DepartmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }

    @GetMapping("/emp")
    public String addEmployee(Model model){
        Collection<Department> collection = DepartmentDao.getDepartments();
        model.addAttribute("depts",collection);
        return "/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return  "redirect:/emps";

    }
    @GetMapping("/emp/{id}")
    public String edipage(@PathVariable("id") Integer id,
                          Model model
                          ){
        Employee employees = employeeDao.get(id);
        model.addAttribute("employee",employees);
        Collection<Department> collection = DepartmentDao.getDepartments();
        model.addAttribute("depts",collection);

        return "add";



    }

}
