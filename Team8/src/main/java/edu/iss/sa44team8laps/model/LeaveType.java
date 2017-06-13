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
	@Column(name="role_name")
	private String RoleName;
	@Column(name="leave_days")
	private Integer days;
	@OneToMany(mappedBy="leaveType")
	private Set<Application> application;
	
	
	
	public LeaveType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeaveType(int leaveId, String leaveName, String rolename, int days) {
		super();
		LeaveId = leaveId;
		LeaveName = leaveName;
		RoleName = rolename;
		this.days=days;
	}
	public String getLeaveName() {
		return LeaveName;
	}
	public void setLeaveName(String leaveName) {
		LeaveName = leaveName;
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
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	
}
