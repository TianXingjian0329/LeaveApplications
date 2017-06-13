package edu.iss.sa44team8laps.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(name="leave_days")
	private Integer days;
	@OneToMany(mappedBy="leaveType")
	private Set<Application> application;
	
	public LeaveType(int leaveId, String leaveName, String leaveDescription, int days) {
		super();
		LeaveId = leaveId;
		LeaveName = leaveName;
		LeaveDescription = leaveDescription;
		this.days=days;
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
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public void setLeaveId(Integer leaveId) {
		LeaveId = leaveId;
	}
	public Set<Application> getApplication() {
		return application;
	}
	public void setApplication(Set<Application> application) {
		this.application = application;
	}
	public Integer getLeaveId() {
		return LeaveId;
	}
	
}
