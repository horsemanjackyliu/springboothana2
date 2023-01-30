package com.sap.springboothana2.contoller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sap.springboothana2.model.Employee;
import com.sap.springboothana2.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
 @RequestMapping(path = "/count",method = RequestMethod.GET)
    public long getCunt(){
        return employeeService.getCount();
    }
 @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public Employee getById(@PathParam("id") long id){
   return employeeService.getById(id);
    }
    @PostMapping(path = "/add")
  public boolean addEmployee(@RequestBody Employee employee){
return employeeService.insertEmployee(employee);
  } 
  @DeleteMapping(path = "{id}") 
  public boolean deleteEmployee(@PathParam("id") long id){
    
       return employeeService.deleteEmployee(id);

    
  }
}
