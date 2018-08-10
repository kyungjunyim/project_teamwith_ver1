package com.teamwith.vo;

import java.sql.Timestamp;

public class ApplicantSimpleVO {
	private String teamId;
	private String applicationId;
	private String memberId;
	private String memberName;
	private String memberPic;
	private Timestamp applicationDate;
	private int applicationStatus;
	private String applicationFreewriting;
	private String roleId;
	public ApplicantSimpleVO() {
		super();
	}
	public ApplicantSimpleVO(String teamId, String applicationId, String memberId, String memberName, String memberPic,
			Timestamp applicationDate, int applicationStatus, String applicationFreewriting, String roleId) {
		super();
		this.teamId = teamId;
		this.applicationId = applicationId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPic = memberPic;
		this.applicationDate = applicationDate;
		this.applicationStatus = applicationStatus;
		this.applicationFreewriting = applicationFreewriting;
		this.roleId = roleId;
	}
	public String getTeamId() {
		return teamId;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getMemberPic() {
		return memberPic;
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
	public String getRoleId() {
		return roleId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
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
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String toString() {
		return "ApplicantSimpleVO [teamId=" + teamId + ", applicationId=" + applicationId + ", memberId=" + memberId
				+ ", memberName=" + memberName + ", memberPic=" + memberPic + ", applicationDate=" + applicationDate
				+ ", applicationStatus=" + applicationStatus + ", applicationFreewriting=" + applicationFreewriting
				+ ", roleId=" + roleId + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationDate == null) ? 0 : applicationDate.hashCode());
		result = prime * result + ((applicationFreewriting == null) ? 0 : applicationFreewriting.hashCode());
		result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
		result = prime * result + applicationStatus;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberPic == null) ? 0 : memberPic.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicantSimpleVO other = (ApplicantSimpleVO) obj;
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
		if (applicationId == null) {
			if (other.applicationId != null)
				return false;
		} else if (!applicationId.equals(other.applicationId))
			return false;
		if (applicationStatus != other.applicationStatus)
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberPic == null) {
			if (other.memberPic != null)
				return false;
		} else if (!memberPic.equals(other.memberPic))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
	
}
