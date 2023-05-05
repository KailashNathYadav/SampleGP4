package com.glearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.entities.Employee;
import com.glearning.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	//Get all employee -
	@GetMapping("/employees")
	public List<Employee>	fetchAllEmployees(){
		return this.employeeService.getAllEmployees();
	}
	
	//Get employee by id -
	@GetMapping("/employees/{id}")
	public Employee fetchEmployeeById(@PathVariable int id) {
		return this.employeeService.getEmployeeById(id);
	}
	
	//Save employee -
	@PostMapping("/employees")
	@PreAuthorize("hasAuthorithy('ADMIN')")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	//Update employee by id -
	@PutMapping("/employees/{id}")
	public void updateEmployeeById(@PathVariable int id,@RequestBody Employee updatedEmployee) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setFirstName(updatedEmployee.getFirstName());
		existingEmployee.setLastName(updatedEmployee.getLastName());
		existingEmployee.setEmail(updatedEmployee.getEmail());
		saveEmployee(existingEmployee);
	}
	
	//Delete employee by id -
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeById(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
	}
	
	//Get all employees by firstName -
	@GetMapping("/employees/search/{firstName}")
	public List<Employee> getAllEmployeesByFirstName(@PathVariable String firstName){
		return this.employeeService.getAllEmployeeByFirstName(firstName);
	}
	
	//Get all employees sorted by their firstName -
	@GetMapping("/employees/sort")
	public List<Employee> getAllEmployeesInSortedWay(@RequestParam(name = "order" , defaultValue = "asc", required = false) String sort ){
		return this.employeeService.getAllEmployeesSorted(sort);
	}
	
}

