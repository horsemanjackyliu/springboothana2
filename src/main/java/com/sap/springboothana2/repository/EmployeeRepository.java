package com.sap.springboothana2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sap.springboothana2.model.Employee;
@Repository

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
    
}
