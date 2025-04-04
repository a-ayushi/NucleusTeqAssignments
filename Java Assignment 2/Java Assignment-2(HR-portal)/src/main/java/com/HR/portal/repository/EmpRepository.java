package com.HR.portal.repository;


import com.HR.portal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee,Long> {
    boolean existsByEmail(String email);
}
