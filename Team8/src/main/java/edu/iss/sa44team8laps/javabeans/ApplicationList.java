package edu.iss.sa44team8laps.javabeans;

import java.util.Date;


public class ApplicationList {
	private int appId;
	private String userName;
	private Date date;
	private int period;
	private String status;
	private String reason;
	private String leaveName;
	private String comment;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getLeaveName() {
		return leaveName;
	}
	public void setLeaveName(String leaveType2) {
		this.leaveName = leaveType2;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
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
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public ApplicationList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
