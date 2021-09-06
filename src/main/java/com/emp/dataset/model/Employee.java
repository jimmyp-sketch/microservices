package com.emp.dataset.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -6276895429382738674L;
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Integer id;
	    @Column(name = "name")
	    private String name;
	    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Department.class)
	    @JoinColumn(name = "dept_id", insertable = false, updatable = false)
	    private Department department;
	    public Employee() {
	    	
	    }
		public Employee(Integer id, String name, Department department) {
			super();
			this.id = id;
			this.name = name;
			this.department = department;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Department getDepartment() {
			return department;
		}
		public void setDepartment(Department department) {
			this.department = department;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
		}
		
	    
}
