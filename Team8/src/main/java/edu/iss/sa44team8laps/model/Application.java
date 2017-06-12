package edu.iss.sa44team8laps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Application")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="application_id")
	private Integer ApplicationId;
	@Column(name="user_id")
	private Integer UserId;
	@Column(name="leave_id")
	private Integer LeaveId;
	@Column(name="date_of_application")
	private Date LeaveDate;
	@Column(name="period")
	private Integer LeavePeriod;
	@Column(name="status")
	private String status;
	@Column(name="reason")
	private String reason;
	@Column(name="manager_comments")
	private String comment;
	
	public Application(int applicationId, int userId, int leaveId, Date leaveDate, int leavePeriod, String status,
			String reason, String comment) {
		super();
		ApplicationId = applicationId;
		UserId = userId;
		LeaveId = leaveId;
		LeaveDate = leaveDate;
		LeavePeriod = leavePeriod;
		this.status = status;
		this.reason = reason;
		this.comment = comment;
	}
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
