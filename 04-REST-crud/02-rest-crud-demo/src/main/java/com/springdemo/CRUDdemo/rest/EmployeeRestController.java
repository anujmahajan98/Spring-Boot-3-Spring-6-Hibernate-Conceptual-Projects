package com.springdemo.CRUDdemo.rest;

import com.springdemo.CRUDdemo.dao.EmployeeDAO;
import com.springdemo.CRUDdemo.entity.Employee;
import com.springdemo.CRUDdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID){
        Employee theEmployee = employeeService.findByID(employeeID);
        if(theEmployee == null){
            throw new RuntimeException("Employee not found - " + employeeID);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{ID}")
    public String deleteEmployee(@PathVariable int ID){
        Employee theEmployee = employeeService.findByID(ID);
        if(theEmployee == null){
            throw new RuntimeException("Employee not found - " + ID);
        }
        employeeService.delete(ID);
        return "Deleted Employee ID is : " + ID;
    }
}
