package edu.iss.sa44team8laps.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "Userid")
	private Set<Application> application;
	@ManyToOne
	private Role role;
	
	public User(){}
	
	public User(int userId, String userPassword, int employeeId, String userName, Integer roleid) {
		super();
		UserId = userId;
		UserPassword = userPassword;
		EmployeeId = employeeId;
		UserName = userName;
		this.roleid=roleid;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
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

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Set<Application> getApplication() {
		return application;
	}

	public void setApplication(Set<Application> application) {
		this.application = application;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
	
	
}
