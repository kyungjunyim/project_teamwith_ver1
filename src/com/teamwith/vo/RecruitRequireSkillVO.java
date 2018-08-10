package com.teamwith.vo;

public class RecruitRequireSkillVO {
	private String teamId;
	private String recruitId;
	private String skillId;
	public RecruitRequireSkillVO() {
		super();
	}
	public RecruitRequireSkillVO(String teamId, String recruitId, String skillId) {
		super();
		this.teamId = teamId;
		this.recruitId = recruitId;
		this.skillId = skillId;
	}
	public String getTeamId() {
		return teamId;
	}
	public String getRecruitId() {
		return recruitId;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public void setRecruitId(String recruitId) {
		this.recruitId = recruitId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public String toString() {
		return "RecruitRequireSkillVO [teamId=" + teamId + ", recruitId=" + recruitId + ", skillId=" + skillId + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recruitId == null) ? 0 : recruitId.hashCode());
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
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
		RecruitRequireSkillVO other = (RecruitRequireSkillVO) obj;
		if (recruitId == null) {
			if (other.recruitId != null)
				return false;
		} else if (!recruitId.equals(other.recruitId))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
	
}
