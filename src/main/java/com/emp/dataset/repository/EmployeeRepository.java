package com.emp.dataset.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emp.dataset.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
