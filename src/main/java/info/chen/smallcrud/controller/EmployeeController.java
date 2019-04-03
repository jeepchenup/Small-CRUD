package info.chen.smallcrud.controller;

import info.chen.smallcrud.dao.DepartmentDao;
import info.chen.smallcrud.dao.EmployeeDao;
import info.chen.smallcrud.exception.UserNotFoundException;
import info.chen.smallcrud.model.Department;
import info.chen.smallcrud.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String listHome(Map<String, Object> map) {

        Collection<Employee> employees = employeeDao.getAll();

        map.put("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String addHome(Map<String, Object> map) {

        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        logger.info("save employee: {}", employee);
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @GetMapping("/emp/{empID}")
    public String updateHome(@PathVariable("empID") Integer empID, Map<String, Object> map) {

        if(empID == 111) {
            throw new UserNotFoundException(empID + " not found.");
        }
        Employee employee = employeeDao.get(empID);
        map.put("employee", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);

        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee, Integer empID) {

        employee.setId(empID);
        employeeDao.save(employee);

        logger.info("Update employee: {}" , employee);

        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{empID}")
    public String deleteEmployee(@PathVariable("empID") Integer empID) {

        employeeDao.delete(empID);
        logger.info("Delete employee : {}", empID);
        return "redirect:/emps";
    }
}
