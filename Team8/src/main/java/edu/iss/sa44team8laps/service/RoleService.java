package edu.iss.sa44team8laps.service;

import java.util.ArrayList;

import edu.iss.sa44team8laps.model.Role;

public interface RoleService {
	
	Role createRole(Role r);
	
	Role updateRole(Role r);
	
	Role deleteRole(int id);
	
	ArrayList<Role> findAllRole();
	
	Role findRoleById(int id);
}
