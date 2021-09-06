package com.emp.dataset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dataset.model.Department;
import com.emp.dataset.model.Employee;
import com.emp.dataset.repository.DepartmentRepository;
import com.emp.dataset.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
	@Override
	public Employee saveDeptData(Employee employee) {
        Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
        if (null == dept) {
            dept = new Department();
        }
        dept.setId(employee.getDepartment().getId());
        dept.setDeptName(employee.getDepartment().getDeptName());
        employee.setDepartment(dept);
        return employeeRepository.save(employee);
    }
	public Employee editEmployees(Employee entity) {
        return employeeRepository.save(entity);
    }
    public void deleteEmployees(Integer id) {
        employeeRepository.deleteById(id);
    }
	
}
