package edu.iss.sa44team8laps.javabeans;

import java.util.Date;

public class LeaveHistory {
	private Integer applicationId;
	private String leaveType;
	private Date startDate;
	private Integer days;
	private String status;
	private String reason;
	private String comment;
	
	public LeaveHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveHistory(Integer applicationId, String leaveType, Date startDate, Integer days, 
			String status, String reason, String comment) {
		super();
		this.applicationId = applicationId;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.days = days;
		this.status = status;
		this.reason = reason;
		this.comment = comment;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
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
