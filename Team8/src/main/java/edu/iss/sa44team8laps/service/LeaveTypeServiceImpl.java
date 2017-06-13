package edu.iss.sa44team8laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.iss.sa44team8laps.model.LeaveType;
import edu.iss.sa44team8laps.repository.LeaveTypeRepository;
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

	@Resource
	private LeaveTypeRepository ltRepository;
	@Override
	public ArrayList<LeaveType> findAllLeaveType() {
		// TODO Auto-generated method stub
		ArrayList<LeaveType> ltlist= (ArrayList<LeaveType>)ltRepository.findAll();
		return ltlist;
	}

	@Override
	public LeaveType findById(Integer id) {
		// TODO Auto-generated method stub
		LeaveType lt=ltRepository.findOne(id);
		return lt;
	}

	@Override
	public LeaveType findByName(String name) {
		// TODO Auto-generated method stub
		return ltRepository.findLeaveTypeByName(name);
	}

	@Override
	public LeaveType createLeaveType(LeaveType lt) {
		// TODO Auto-generated method stub
		return ltRepository.saveAndFlush(lt);
	}

	@Override
	public LeaveType updateLeaveType(LeaveType lt) {
		// TODO Auto-generated method stub
		return ltRepository.saveAndFlush(lt);
	}

	@Override
	public void deleteLeaveType(LeaveType lt) {
		// TODO Auto-generated method stub
		ltRepository.delete(lt);
	}

	@Override
	public ArrayList<LeaveType> findLeaveTypesByRoleName(String name) {
		// TODO Auto-generated method stub
		ArrayList<LeaveType> ltlist= ltRepository.findLeaveTypeByRole(name);
		return ltlist;
	}

}
