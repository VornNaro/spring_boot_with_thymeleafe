package com.kshrd.thymeleaf_testing03.service;

import com.kshrd.thymeleaf_testing03.model.Employee;
import com.kshrd.thymeleaf_testing03.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public void deleteById(Integer empId) {
        employeeRepository.remove(empId);
    }

    @Override
    public void saveEmp(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
      employeeRepository.edit(employee);
    }
}
