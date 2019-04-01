package info.chen.smallcrud.controller;

import info.chen.smallcrud.dao.DepartmentDao;
import info.chen.smallcrud.dao.EmployeeDao;
import info.chen.smallcrud.model.Department;
import info.chen.smallcrud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String show(Map<String, Object> map) {

        Collection<Employee> employees = employeeDao.getAll();

        map.put("emps", employees);
        return "emp/list";
    }

    @GetMapping("emp")
    public String addHome(Map<String, Object> map) {

        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);
        return "emp/add";
    }

    @PostMapping("emp")
    public String addEmployee(Employee employee) {

        System.out.println(employee);

        return "emp/list";
    }
}
