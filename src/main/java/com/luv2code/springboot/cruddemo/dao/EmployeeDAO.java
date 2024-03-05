package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    void delete(Integer id);
}
