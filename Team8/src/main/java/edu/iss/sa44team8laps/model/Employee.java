package edu.iss.sa44team8laps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	
	@Column(name="id")
	private Integer Id;
	@Column(name = "employee_id")
	private Integer EmployeeId;
	@Column(name="manager_id")
	private Integer ManagerId;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, int employeeId, int managerId) {
		super();
		Id=id;
		EmployeeId = employeeId;
		ManagerId = managerId;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		EmployeeId = employeeId;
	}
	public Integer getManagerId() {
		return ManagerId;
	}
	public void setManagerId(Integer managerId) {
		ManagerId = managerId;
	}

 
}
