package com.springboot.restful.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.restful.exception.RessourceNotFoundException;
import com.springboot.restful.model.Employee;
import com.springboot.restful.repository.EmployeRepo;
import com.springboot.restful.service.EmployeeService;

@Service
public class EmployeeServiceIpml implements EmployeeService{
	
	private EmployeRepo employeeRepo;
	
	public EmployeeServiceIpml(EmployeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmp() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmpById(long id) {
		
//		Optional<Employee> emp = employeeRepo.findById(id);
//		if(emp.isPresent())
//		{
//			return emp.get();
//		}
//		else
//		{
//			throw new RessourceNotFoundException("Employé", "ID", id);
//		}
		return employeeRepo.findById(id).orElseThrow(() -> 
		    new RessourceNotFoundException("Employé", "ID", id));
	}

	@Override
	public Employee updateEmp(Employee emp, long id) {
//		Employee existEmp= employeeRepo.findById(id).orElseThrow(() ->
//		new RessourceNotFoundException("Employé", "ID", id));
//		
		Employee exEmp=getEmpById(id);
		exEmp.setEmail(emp.getEmail());
		exEmp.setFirstName(emp.getFirstName());
		exEmp.setLastName(emp.getLastName());
		//enregistrer l'employé
		employeeRepo.save(exEmp);
		return exEmp;
	}

	@Override
	public void deleEmp(long id) {
		Employee exiEmp=getEmpById(id);
		employeeRepo.deleteById(exiEmp.getId());
	}

	

}
