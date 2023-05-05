package com.glearning.service;

import java.util.List;

import com.glearning.entities.Employee;

public interface EmployeeService {
	List<Employee>  getAllEmployees();
	List<Employee>  getAllEmployeeByFirstName(String firstName);
	List<Employee>  getAllEmployeesSorted(String sort);
	Employee getEmployeeById(int id);
	
	void addEmployee(Employee employee);
	void deleteEmployeeById(int id);
}
