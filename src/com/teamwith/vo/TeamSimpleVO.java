package com.teamwith.vo;

import java.sql.Timestamp;

public class TeamSimpleVO {
	private String teamId;
	private String teamName;
	private String teamProjectName;
	private String teamPic;
	private String projectCategoryId;
	private Timestamp teamUpdateDate;
	private String memberName;
	private String memberId;
	public TeamSimpleVO() {
		super();
	}
	public TeamSimpleVO(String teamId, String teamName, String teamProjectName, String teamPic,
			String projectCategoryId, Timestamp teamUpdateDate, String memberName, String memberId) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamProjectName = teamProjectName;
		this.teamPic = teamPic;
		this.projectCategoryId = projectCategoryId;
		this.teamUpdateDate = teamUpdateDate;
		this.memberName = memberName;
		this.memberId = memberId;
	}
	public String getTeamId() {
		return teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public String getTeamProjectName() {
		return teamProjectName;
	}
	public String getTeamPic() {
		return teamPic;
	}
	public String getProjectCategoryId() {
		return projectCategoryId;
	}
	public Timestamp getTeamUpdateDate() {
		return teamUpdateDate;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setTeamProjectName(String teamProjectName) {
		this.teamProjectName = teamProjectName;
	}
	public void setTeamPic(String teamPic) {
		this.teamPic = teamPic;
	}
	public void setProjectCategoryId(String projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}
	public void setTeamUpdateDate(Timestamp teamUpdateDate) {
		this.teamUpdateDate = teamUpdateDate;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String toString() {
		return "TeamSimpleVO [teamId=" + teamId + ", teamName=" + teamName + ", teamProjectName=" + teamProjectName
				+ ", teamPic=" + teamPic + ", projectCategoryId=" + projectCategoryId + ", teamUpdateDate="
				+ teamUpdateDate + ", memberName=" + memberName + ", memberId=" + memberId + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((projectCategoryId == null) ? 0 : projectCategoryId.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		result = prime * result + ((teamPic == null) ? 0 : teamPic.hashCode());
		result = prime * result + ((teamProjectName == null) ? 0 : teamProjectName.hashCode());
		result = prime * result + ((teamUpdateDate == null) ? 0 : teamUpdateDate.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamSimpleVO other = (TeamSimpleVO) obj;
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
		if (projectCategoryId == null) {
			if (other.projectCategoryId != null)
				return false;
		} else if (!projectCategoryId.equals(other.projectCategoryId))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
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
		if (teamProjectName == null) {
			if (other.teamProjectName != null)
				return false;
		} else if (!teamProjectName.equals(other.teamProjectName))
			return false;
		if (teamUpdateDate == null) {
			if (other.teamUpdateDate != null)
				return false;
		} else if (!teamUpdateDate.equals(other.teamUpdateDate))
			return false;
		return true;
	}
	

}
