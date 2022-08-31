package com.spring.rediscurd.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.spring.rediscurd.dao.EmployeeDao;
import com.spring.rediscurd.modal.Employee;

@RestController
@RequestMapping("/redis/vi/api")
public class RedisCurdController {
	
	@Autowired
	private EmployeeDao empDao;
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployee(@PathVariable Integer empId) {
		
		return empDao.getOneEmployee(empId);
	}
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee emp) {
		 empDao.saveEmployee(emp);
		return empDao.getOneEmployee(emp.getEmpId());
		
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		
		empDao.updateEmployee(emp);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId) {
		
		empDao.deleteEmployee(empId);
		return new ResponseEntity<String>("Employe with id "+empId+" is deleted", HttpStatus.OK);
	}

}
