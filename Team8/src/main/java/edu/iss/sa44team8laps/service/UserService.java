package edu.iss.sa44team8laps.service;

import java.util.ArrayList;

import edu.iss.sa44team8laps.model.Role;
import edu.iss.sa44team8laps.model.User;

public interface UserService {
	ArrayList<User> findAllUsers();
	
	User findUser(String userId);

	User createUser(User user);

	User changeUser(User user);

	void removeUser(User user);

	ArrayList<Role> findRolesForUser(String userId);

	ArrayList<String> findRoleNamesForUser(String userId);

	ArrayList<String> findManagerNameByUID(String userId);
	
	User authenticate(String uname, String pwd);
}
