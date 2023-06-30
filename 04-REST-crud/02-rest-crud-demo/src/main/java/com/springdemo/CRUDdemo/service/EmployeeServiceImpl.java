package com.springdemo.CRUDdemo.service;

import com.springdemo.CRUDdemo.dao.EmployeeDAO;
import com.springdemo.CRUDdemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findALL();
    }

    @Override
    public Employee findByID(int theID) {
        return employeeDAO.findByID(theID);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void delete(int ID) {
        employeeDAO.delete(ID);
    }
}
