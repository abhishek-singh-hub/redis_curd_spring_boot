package com.spring.rediscurd.dao;

import java.util.Map;

import com.spring.rediscurd.modal.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee emp);
    Employee getOneEmployee(Integer id);
    void updateEmployee(Employee emp);
    Map<Integer, Employee> getAllEmployees();
    void deleteEmployee(Integer id);
    void saveAllEmployees(Map<Integer, Employee> map);
}
