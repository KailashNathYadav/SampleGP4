package com.glearning.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.dao.EmployeeRepository;
import com.glearning.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getAllEmployeeByFirstName(String firstName) {
		return employeeRepository.findEmployeeByFirstNameContainingIgnoreCase(firstName);
	}

	@Override
	public List<Employee> getAllEmployeesSorted(String dir) {
		List<Employee> employees = employeeRepository.findAll();
		if (dir.equals("asc"))
			Collections.sort(employees, Comparator.comparing(Employee::getFirstName));
		else
			Collections.sort(employees, Comparator.comparing(Employee::getFirstName, Collections.reverseOrder()));
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

}
