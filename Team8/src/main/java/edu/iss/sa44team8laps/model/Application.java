package edu.iss.sa44team8laps.model;

import java.util.Date;

public class Application {
	private int ApplicationId;
	private int UserId;
	private int LeaveId;
	private Date LeaveDate;
	private int LeavePeriod;
	private String status;
	private String reason;
	private String comment;
	public int getApplicationId() {
		return ApplicationId;
	}
	public void setApplicationId(int applicationId) {
		ApplicationId = applicationId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getLeaveId() {
		return LeaveId;
	}
	public void setLeaveId(int leaveId) {
		LeaveId = leaveId;
	}
	public Date getLeaveDate() {
		return LeaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		LeaveDate = leaveDate;
	}
	public int getLeavePeriod() {
		return LeavePeriod;
	}
	public void setLeavePeriod(int leavePeriod) {
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
	
}
