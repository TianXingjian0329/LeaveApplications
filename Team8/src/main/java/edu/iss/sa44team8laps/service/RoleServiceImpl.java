package edu.iss.sa44team8laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.sa44team8laps.model.Role;
import edu.iss.sa44team8laps.repository.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleRepository roleRepository;
	@Override
	@Transactional
	public Role createRole(Role r) {
		// TODO Auto-generated method stub
		return roleRepository.saveAndFlush(r);
	}

	@Override
	@Transactional
	public Role updateRole(Role r) {
		// TODO Auto-generated method stub
		return roleRepository.saveAndFlush(r);
	}

	@Override
	@Transactional
	public void deleteRole(Role r) {
		// TODO Auto-generated method stub
		roleRepository.delete(r);
	}

	@Override
	@Transactional
	public ArrayList<Role> findAllRole() {
		// TODO Auto-generated method stub
		ArrayList<Role> list=(ArrayList<Role>)roleRepository.findAll();
		return list;
	}

	@Override
	@Transactional
	public Role findRoleById(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findOne(id);
	}

	@Override
	public Role findRoleByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findRoleByRoleName(name);
	}

}
