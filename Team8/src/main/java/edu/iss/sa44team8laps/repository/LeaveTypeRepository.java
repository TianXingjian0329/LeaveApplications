package edu.iss.sa44team8laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import edu.iss.sa44team8laps.model.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer> {

	@Query("SELECT u FROM Leave_Type u WHERE u.leave_type=:un")
	LeaveType findLeaveTypeByName(@Param("un") String uname);
}
