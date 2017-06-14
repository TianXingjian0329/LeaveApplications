package edu.iss.sa44team8laps.javabeans;

import java.util.ArrayList;

public class CreateEmployee {
	
	private Integer employeeId;
	private String empName;
	private String managerName;
	private String roleName;
	private String passWord;
	public CreateEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateEmployee(Integer employeeId, String empName, String managerName, String roleName,
			String passWord) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
		this.managerName = managerName;
		this.roleName = roleName;
		this.passWord = passWord;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
}
