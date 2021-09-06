package com.emp.dataset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.dataset.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
