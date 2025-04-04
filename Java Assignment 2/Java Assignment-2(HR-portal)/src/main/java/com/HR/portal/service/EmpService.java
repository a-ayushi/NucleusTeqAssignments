package com.HR.portal.service;

import com.HR.portal.exception.EmployeeNotFoundException;
import com.HR.portal.exception.InvalidSalaryException;
import com.HR.portal.model.Employee;
import com.HR.portal.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;

    //fetch all employees
    public List<Employee> getAllEmp(){
        //returns a list of all employees
        return empRepository.findAll();
    }

    //add an employee
    public Employee addEmployee(Employee employee){
        if (employee.getSalary() <= 0) {
            throw new InvalidSalaryException(HttpStatus.BAD_REQUEST,"Salary must be greater than zero");
        }

        //call repository method to save employee to db
        return empRepository.save(employee);
    }

    //update an employee details
    public Employee updateEmployee(Long emp_id,Employee updatedEmployee){
        Employee existingEmp=empRepository.findById(emp_id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee not found"));//retrieve employee

        //updating emp details
        existingEmp.setName(updatedEmployee.getName());
        existingEmp.setDept(updatedEmployee.getDept());
        existingEmp.setEmail(updatedEmployee.getEmail());


        if (updatedEmployee.getSalary() <= 0) {
            throw new InvalidSalaryException(HttpStatus.BAD_REQUEST, "Salary must be greater than zero");
        }
        existingEmp.setSalary(updatedEmployee.getSalary());

        //save updated employee details in db
        return empRepository.save(existingEmp);

    }

    //delete employee
    public void deleteEmployee(Long emp_id){
        if(!empRepository.existsById(emp_id)){
            throw new EmployeeNotFoundException("Employee not found");
        }
        empRepository.deleteById(emp_id);
    }
}
