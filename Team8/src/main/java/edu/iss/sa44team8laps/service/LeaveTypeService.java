package edu.iss.sa44team8laps.service;
import java.util.ArrayList;

import edu.iss.sa44team8laps.model.*;

public interface LeaveTypeService {
	ArrayList<LeaveType> findAllLeaveType();
	LeaveType findById(Integer id);
	LeaveType findByName(String name);
	ArrayList<LeaveType> findLeaveTypesByRoleName(String name);
	LeaveType createLeaveType(LeaveType lt);
	LeaveType updateLeaveType(LeaveType lt);
	void deleteLeaveType(LeaveType lt);
}
