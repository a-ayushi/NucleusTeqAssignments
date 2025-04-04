package com.HR.portal.model;

import jakarta.persistence.*;

//the table Emp_details contains details of all employees
@Entity
@Table(name="Emp_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String dept;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private double salary;

    //default constructor
    public Employee(){}

    //parameterized constructor
    public Employee(String name, String dept, String email, double salary){
        this.name=name;
        this.dept=dept;
        this.email=email;
        this.salary=salary;
    }

    //getters and setters

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
