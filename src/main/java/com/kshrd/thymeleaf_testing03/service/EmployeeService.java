package com.kshrd.thymeleaf_testing03.service;

import com.kshrd.thymeleaf_testing03.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmp();
    Employee getById(Integer empId);

    void deleteById(Integer empId);
    void saveEmp(Employee employee);
    void update(Employee employee);

}
