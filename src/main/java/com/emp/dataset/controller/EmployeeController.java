package com.emp.dataset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dataset.model.Department;
import com.emp.dataset.model.Employee;
import com.emp.dataset.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value = "/empdata")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;
	 @GetMapping("/get-employees")
	    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
	        Iterable<Employee> employees = employeeService.getAllEmployees();
	        return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
	    }
	@PostMapping(value = "/save",consumes = "application/json",produces = "application/json")
	@ResponseBody
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		System.out.println(emp);
		Employee deptSaveData=employeeService.saveDeptData(emp);
		return new ResponseEntity<Employee>(deptSaveData,HttpStatus.OK);
	}
	
	  @PutMapping("/employee")
	    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
	        Employee emp = employeeService.editEmployees(employee);
	        return new ResponseEntity<>(emp, HttpStatus.OK);
	    }
	    @DeleteMapping("/employee")
	    public ResponseEntity<String> deleteEmployee(@RequestParam(name = "employeeId") Integer employeeId) {
	        employeeService.deleteEmployees(employeeId);
	        return new ResponseEntity<>("Employee with ID :" + employeeId + " deleted successfully", HttpStatus.OK);
	    }
}
