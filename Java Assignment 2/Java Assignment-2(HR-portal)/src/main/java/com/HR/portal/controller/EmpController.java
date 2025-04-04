package com.HR.portal.controller;

//here apis for add,view,update and delete are made

import com.HR.portal.exception.EmployeeNotFoundException;
import com.HR.portal.exception.InvalidSalaryException;
import com.HR.portal.model.Employee;
import com.HR.portal.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    //1. get emp details
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmp(){
        //call service layer method to get list of all employees
        return ResponseEntity.ok(empService.getAllEmp());
    }

    //2. API to Add employee details
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        //call service level method to add the employee in db
        Employee addedEmp=empService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEmp);//send back the saved employee
    }

    //3. API to update the employee details
    @PutMapping(value="/{emp_id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable Long emp_id, @ModelAttribute Employee updatedEmployee){
        Employee updatedEmp = empService.updateEmployee(emp_id, updatedEmployee);
        return ResponseEntity.ok(updatedEmp);
    }
    
    //4. Delete employee
    @DeleteMapping("/{emp_id}")
    public ResponseEntity<String> deleteEmp(@PathVariable Long emp_id){
        empService.deleteEmployee(emp_id);
        return ResponseEntity.ok("Employee is deleted successfully");
    }


    //  Handle EmployeeNotFoundException
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //  Handle InvalidSalaryException
    @ExceptionHandler(InvalidSalaryException.class)
    public ResponseEntity<String> handleInvalidSalaryException(InvalidSalaryException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
