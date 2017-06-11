package edu.iss.sa44team8laps.model;

public class Role {
	private int RoleId;
	private String RoleName;
	private String RoleDescription;
	
	public Role(int roleId, String roleName, String roleDescription) {
		super();
		RoleId = roleId;
		RoleName = roleName;
		RoleDescription = roleDescription;
	}
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public String getRoleDescription() {
		return RoleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		RoleDescription = roleDescription;
	}
	
}
