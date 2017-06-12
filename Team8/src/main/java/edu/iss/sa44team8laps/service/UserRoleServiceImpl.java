package edu.iss.sa44team8laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.sa44team8laps.model.Role;
import edu.iss.sa44team8laps.model.User;
import edu.iss.sa44team8laps.model.UserRole;
import edu.iss.sa44team8laps.repository.UserRoleRepository;
@Service
public class UserRoleServiceImpl implements UserRoleService {

	
	@Resource
	private UserRoleRepository userRoleRepository;
	@Override
	@Transactional
	public ArrayList<UserRole> listAllUserRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Role findRoleByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User findUserByRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

}
