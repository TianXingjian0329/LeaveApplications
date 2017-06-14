package edu.iss.sa44team8laps.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name = "role_id")
	private Integer RoleId;
	@Column(name="role_name")
	private String RoleName;
	@Column(name="role_desc")
	private String RoleDescription;
	@OneToMany 
	private Set<User> users; 

	
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int roleId, String roleName, String roleDescription) {
		super();
		RoleId = roleId;
		RoleName = roleName;
		RoleDescription = roleDescription;
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

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Integer getRoleId() {
		return RoleId;
	}
	
}
