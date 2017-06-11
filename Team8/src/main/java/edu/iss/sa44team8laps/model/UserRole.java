package edu.iss.sa44team8laps.model;

public class UserRole {
	private int UserRoleId;
	private int UserId;
	private int RoleId;
	
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
