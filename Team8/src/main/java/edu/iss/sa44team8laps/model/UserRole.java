package edu.iss.sa44team8laps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer UserRoleId;
	@Column(name="user_id")
	private Integer UserId;
	@Column(name="role_id")
	private Integer RoleId;
	
	public UserRole(int userRoleId, int userId, int roleId) {
		super();
		UserRoleId = userRoleId;
		UserId = userId;
		RoleId = roleId;
	}
	public int getUserRoleId() {
		return UserRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		UserRoleId = userRoleId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	
}
