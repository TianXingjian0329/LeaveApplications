package edu.iss.sa44team8laps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leave_type")
public class LeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leave_id")
	private Integer LeaveId;
	@Column(name="leave_type")
	private String LeaveName;
	@Column(name="leave_desc")
	private String LeaveDescription;
	
	public LeaveType(int leaveId, String leaveName, String leaveDescription) {
		super();
		LeaveId = leaveId;
		LeaveName = leaveName;
		LeaveDescription = leaveDescription;
	}
	public int getLeaveId() {
		return LeaveId;
	}
	public void setLeaveId(int leaveId) {
		LeaveId = leaveId;
	}
	public String getLeaveName() {
		return LeaveName;
	}
	public void setLeaveName(String leaveName) {
		LeaveName = leaveName;
	}
	public String getLeaveDescription() {
		return LeaveDescription;
	}
	public void setLeaveDescription(String leaveDescription) {
		LeaveDescription = leaveDescription;
	}
	
}
