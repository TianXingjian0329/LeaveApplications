package edu.iss.sa44team8laps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Integer UserId;
	@Column(name="employee_id")
	private String UserPassword;
	@Column(name="pass_word")
	private int EmployeeId;
	@Column(name="name")
	private String UserName;
	@Column(name="role_id")
	private Integer roleid;
	
	public User(int userId, String userPassword, int employeeId, String userName, Integer roleid) {
		super();
		UserId = userId;
		UserPassword = userPassword;
		EmployeeId = employeeId;
		UserName = userName;
		this.roleid=roleid;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
}
