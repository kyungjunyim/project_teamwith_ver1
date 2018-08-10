package com.teamwith.vo;

import java.sql.Timestamp;

public class ApplicationSimpleVO {
	private String memberId;
	private String teamPic;
	private String teamName;
	private String roleId;
	private Timestamp applicationDate;
	private int applicationStatus;
	private String applicationFreewriting;
	public ApplicationSimpleVO() {
		super();
	}
	public ApplicationSimpleVO(String memberId, String teamPic, String teamName, String roleId,
			Timestamp applicationDate, int applicationStatus, String applicationFreewriting) {
		super();
		this.memberId = memberId;
		this.teamPic = teamPic;
		this.teamName = teamName;
		this.roleId = roleId;
		this.applicationDate = applicationDate;
		this.applicationStatus = applicationStatus;
		this.applicationFreewriting = applicationFreewriting;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getTeamPic() {
		return teamPic;
	}
	public String getTeamName() {
		return teamName;
	}
	public String getRoleId() {
		return roleId;
	}
	public Timestamp getApplicationDate() {
		return applicationDate;
	}
	public int getApplicationStatus() {
		return applicationStatus;
	}
	public String getApplicationFreewriting() {
		return applicationFreewriting;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setTeamPic(String teamPic) {
		this.teamPic = teamPic;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public void setApplicationDate(Timestamp applicationDate) {
		this.applicationDate = applicationDate;
	}
	public void setApplicationStatus(int applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public void setApplicationFreewriting(String applicationFreewriting) {
		this.applicationFreewriting = applicationFreewriting;
	}
	public String toString() {
		return "ApplicationSimpleVO [memberId=" + memberId + ", teamPic=" + teamPic + ", teamName=" + teamName
				+ ", roleId=" + roleId + ", applicationDate=" + applicationDate + ", applicationStatus="
				+ applicationStatus + ", applicationFreewriting=" + applicationFreewriting + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationDate == null) ? 0 : applicationDate.hashCode());
		result = prime * result + ((applicationFreewriting == null) ? 0 : applicationFreewriting.hashCode());
		result = prime * result + applicationStatus;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		result = prime * result + ((teamPic == null) ? 0 : teamPic.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationSimpleVO other = (ApplicationSimpleVO) obj;
		if (applicationDate == null) {
			if (other.applicationDate != null)
				return false;
		} else if (!applicationDate.equals(other.applicationDate))
			return false;
		if (applicationFreewriting == null) {
			if (other.applicationFreewriting != null)
				return false;
		} else if (!applicationFreewriting.equals(other.applicationFreewriting))
			return false;
		if (applicationStatus != other.applicationStatus)
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		if (teamPic == null) {
			if (other.teamPic != null)
				return false;
		} else if (!teamPic.equals(other.teamPic))
			return false;
		return true;
	}
	

	
}
