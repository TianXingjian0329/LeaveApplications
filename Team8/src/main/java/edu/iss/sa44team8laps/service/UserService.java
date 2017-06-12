package edu.iss.sa44team8laps.service;

import java.util.ArrayList;

import edu.iss.sa44team8laps.model.Role;
import edu.iss.sa44team8laps.model.User;

public interface UserService {
	ArrayList<User> findAllUsers();
	
	User findUserById(Integer userId);
	
	User findUserByName(String name);

	User createUser(User user);

	User changeUser(User user);

	void removeUser(User user);
//
//	ArrayList<Role> findRolesForUser(int userId);
//
//	ArrayList<String> findRoleNamesForUser(int userId);
//
//	ArrayList<String> findManagerNameByUID(int userId);
	
	User authenticate(Integer uname, String pwd);
}
