package com.sap.springboothana2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.springboothana2.model.Employee;
import com.sap.springboothana2.repository.EmployeeRepository;

@Service

public class EmployeeService {


    @Autowired
private EmployeeRepository employeeRepository;
    public long getCount(){
        return employeeRepository.count();
    }
    public Employee  getById(long id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee != null){
            return employee;
        }else{return null;}
    }
    public List<Employee> getAll(){
        List<Employee> employees = new ArrayList<>();

        employeeRepository.findAll().forEach(employees::add);
        return employees;

    }
    public boolean insertEmployee(Employee employee){
        try{employeeRepository.save(employee);return true;}catch(Exception ex){return false;}

    }

    public boolean deleteEmployee(long id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee != null){
            employeeRepository.delete(employee);return true;
        }else{
            return false;
        }
    }
}
