package edu.iss.sa44team8laps.javabeans;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;

import edu.iss.sa44team8laps.model.Application;

public class employeeLeave {
	
	private Integer ApplicationId;

	private Integer UserId;

	private Integer LeaveId;

	private Date LeaveDate;

	private Integer LeavePeriod;

	private String status;
	private String reason;
	private String comment;
	private String leavetype;
	public employeeLeave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employeeLeave(Integer applicationId, Integer userId, Integer leaveId, Date leaveDate, Integer leavePeriod,
			String status, String reason, String comment, String leavetype) {
		super();
		ApplicationId = applicationId;
		UserId = userId;
		LeaveId = leaveId;
		LeaveDate = leaveDate;
		LeavePeriod = leavePeriod;
		this.status = status;
		this.reason = reason;
		this.comment = comment;
		this.leavetype = leavetype;
	}
	public Integer getApplicationId() {
		return ApplicationId;
	}
	public void setApplicationId(Integer applicationId) {
		ApplicationId = applicationId;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public Integer getLeaveId() {
		return LeaveId;
	}
	public void setLeaveId(Integer leaveId) {
		LeaveId = leaveId;
	}
	public Date getLeaveDate() {
		return LeaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		LeaveDate = leaveDate;
	}
	public Integer getLeavePeriod() {
		return LeavePeriod;
	}
	public void setLeavePeriod(Integer leavePeriod) {
		LeavePeriod = leavePeriod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getLeavetype() {
		return leavetype;
	}
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	
	

}
