package com.spring.rediscurd.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.spring.rediscurd.modal.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private final String hashReference= "Employee";
	
	//'redisTemplate' is defined as a Bean in AppConfig.java
	@Resource(name = "redisTemplate")
	private HashOperations<String, Integer, Employee> hasOperations;
	
	@Override 
	public void saveEmployee(Employee emp) {
		hasOperations.putIfAbsent(hashReference, emp.getEmpId(), emp);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return hasOperations.get(hashReference, id);
	}

	@Override
	public void updateEmployee(Employee emp) {
		hasOperations.put(hashReference, emp.getEmpId(), emp);
	}

	@Override
	public Map<Integer, Employee> getAllEmployees() {
		return hasOperations.entries(hashReference);
	}

	@Override
	public void deleteEmployee(Integer id) {
		hasOperations.delete(hashReference, id);
	}

	@Override
	public void saveAllEmployees(Map<Integer, Employee> map) {
		hasOperations.putAll(hashReference, map);
	}

}
