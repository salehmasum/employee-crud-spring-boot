package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //Create
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    //Read
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    //Delete
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    public Employee updateEmployee(Long empId, Employee employee) {
        Employee employee1 = employeeRepository.findById(empId).get();
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmailId(employee.getEmailId());
        return employeeRepository.save(employee1);
    }


}
