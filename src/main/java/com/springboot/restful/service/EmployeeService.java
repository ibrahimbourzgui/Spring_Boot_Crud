package com.springboot.restful.service;

import java.util.List;

import com.springboot.restful.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee emp);
	List<Employee> getAllEmp();
	Employee getEmpById(long id);
	Employee updateEmp(Employee emp,long id);
	void deleEmp(long id);

}
