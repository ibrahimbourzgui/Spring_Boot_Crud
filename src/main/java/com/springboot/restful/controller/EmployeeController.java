package com.springboot.restful.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restful.model.Employee;
import com.springboot.restful.service.EmployeeService;

@RestController
@RequestMapping("/api/employe")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	//Création d'un employé REST API
	//@RequestBody /*permet de récupérer la requête et faire la conversion automatiquement vers un objet java*/
	@PostMapping //insertion
	public ResponseEntity<Employee> saveEmployee( @RequestBody Employee emp)
	{
	return new ResponseEntity<Employee>(employeeService.saveEmployee(emp), HttpStatus.CREATED);
	}
	
	//sélection de touts les employés
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmp();
	}
	
	//employé par ID
	//http://localhost:8080/api/employe/3
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") long id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmpById(id), HttpStatus.OK);
	}
	
	//Modifier
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp,@PathVariable("id") long id)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmp(emp, id), HttpStatus.OK);
	}
	
	//Supprimer
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") long id)
	{
		employeeService.deleEmp(id);
		return new ResponseEntity<String>("Employé supprimé", HttpStatus.OK);
	}
}
