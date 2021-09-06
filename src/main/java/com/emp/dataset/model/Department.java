package com.emp.dataset.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Department")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4027352304927458232L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",insertable = false,nullable = true)
    private Integer id;
    @Column(name = "dept_name")
    private String deptName;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Employee> employees;
    public Department() {
    	
    }
	public Department(Integer id, String deptName, List<Employee> employees) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.employees = employees;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", employees=" + employees + "]";
	}

    
}
