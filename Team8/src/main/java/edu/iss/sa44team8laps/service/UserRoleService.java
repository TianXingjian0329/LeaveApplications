package edu.iss.sa44team8laps.service;
import java.util.ArrayList;

import edu.iss.sa44team8laps.model.*;
public interface UserRoleService {
	ArrayList<UserRole> listAllUserRole();
	Role findRoleByUser(User user);
	User findUserByRole(Role role);
}
