package com.teamwith.vo;

public class PraiseVO {
	private String targetMemberId;
	private String praiseId;
	private int praiseCount;
	public PraiseVO() {
		super();
	}
	public PraiseVO(String targetMemberId, String praiseId, int praiseCount) {
		super();
		this.targetMemberId = targetMemberId;
		this.praiseId = praiseId;
		this.praiseCount = praiseCount;
	}
	public String getTargetMemberId() {
		return targetMemberId;
	}
	public String getPraiseId() {
		return praiseId;
	}
	public int getPraiseCount() {
		return praiseCount;
	}
	public void setTargetMemberId(String targetMemberId) {
		this.targetMemberId = targetMemberId;
	}
	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}
	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}
	public String toString() {
		return "PraiseVO [targetMemberId=" + targetMemberId + ", praiseId=" + praiseId + ", praiseCount=" + praiseCount
				+ "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + praiseCount;
		result = prime * result + ((praiseId == null) ? 0 : praiseId.hashCode());
		result = prime * result + ((targetMemberId == null) ? 0 : targetMemberId.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PraiseVO other = (PraiseVO) obj;
		if (praiseCount != other.praiseCount)
			return false;
		if (praiseId == null) {
			if (other.praiseId != null)
				return false;
		} else if (!praiseId.equals(other.praiseId))
			return false;
		if (targetMemberId == null) {
			if (other.targetMemberId != null)
				return false;
		} else if (!targetMemberId.equals(other.targetMemberId))
			return false;
		return true;
	}
	
}
