package com.springdemo.CRUDdemo.service;

import com.springdemo.CRUDdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findByID(int theID);

    public Employee save(Employee theEmployee);

    public void delete(int ID);
}
