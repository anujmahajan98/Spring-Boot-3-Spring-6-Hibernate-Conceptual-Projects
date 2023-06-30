package com.springdemo.CRUDdemo.dao;

import com.springdemo.CRUDdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findALL() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findByID(int theID) {
        Employee theEmployee = entityManager.find(Employee.class, theID);
        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge((theEmployee));
        return dbEmployee;
    }

    @Override
    public void delete(int ID) {
        Employee theEmployee = entityManager.find(Employee.class, ID);
        entityManager.remove(theEmployee);
    }
}
