package edu.iss.sa44team8laps.javabeans;

public class empList {
	private Integer empId;
	private String empName;
	private String managerName;
	private String roleName;
	public empList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public empList(Integer empId, String empName, String managerName, String roleName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.managerName = managerName;
		this.roleName = roleName;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
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
	
}
