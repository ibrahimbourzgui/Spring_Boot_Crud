package com.springboot.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restful.model.Employee;

public interface EmployeRepo extends JpaRepository<Employee, Long> {

}
