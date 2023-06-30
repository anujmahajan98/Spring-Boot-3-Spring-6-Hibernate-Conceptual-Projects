package com.springdemo.CRUDdemo.dao;

import com.springdemo.CRUDdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findALL();

    public Employee findByID(int theID);

    public Employee save(Employee theEmployee);

    public void delete(int ID);
}
