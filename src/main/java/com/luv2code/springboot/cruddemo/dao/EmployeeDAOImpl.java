package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public void save(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public void delete(Integer id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
