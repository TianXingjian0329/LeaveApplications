package edu.iss.sa44team8laps.model;

public class Employee {
	private int EmployeeId;
	private int ManagerId;
	
	public Employee(int employeeId, int managerId) {
		super();
		EmployeeId = employeeId;
		ManagerId = managerId;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public int getManagerId() {
		return ManagerId;
	}
	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}
 
}
