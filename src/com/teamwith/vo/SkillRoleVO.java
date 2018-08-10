package com.teamwith.vo;

public class SkillRoleVO {
	private String skillId;
	private String skillName;
	private String roleId;
	public SkillRoleVO(){
		super();
	}
	public SkillRoleVO(String skillId, String skillName, String roleId) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.roleId = roleId;
	}
	public String getSkillId() {
		return skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String toString() {
		return "SkillRoleVO [skillId=" + skillId + ", skillName=" + skillName + ", roleId=" + roleId + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillRoleVO other = (SkillRoleVO) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		return true;
	}
	
}
