package edu.iss.sa44team8laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.sa44team8laps.model.Role;
import edu.iss.sa44team8laps.model.User;
import edu.iss.sa44team8laps.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository; 
	
	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<User> ul=(ArrayList<User>)userRepository.findAll();
		return ul;
	}

	@Override
	@Transactional
	public User findUser(int userId) {
		// TODO Auto-generated method stub
		User ul=(User)userRepository.findUserById(userId);
		return ul;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public User changeUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}

//	@Override
//	@Transactional
//	public ArrayList<Role> findRolesForUser(int userId) {
//		// TODO Auto-generated method stub
//		
//		return null;
//	}
//
//	@Override
//	@Transactional
//	public ArrayList<String> findRoleNamesForUser(int userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	@Transactional
//	public ArrayList<String> findManagerNameByUID(int userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	@Transactional
	public User authenticate(int uname, String pwd) {
		// TODO Auto-generated method stub
		User us= userRepository.findUserByNamePwd(uname, pwd);
		return us;
	}

}
