package com.teamwith.vo;

public class BestMemberVO {
	private String memberId;
	private String memberName;
	private String memberPic;
	private int praiseTotalCount;
	public BestMemberVO() {
		super();
	}
	public BestMemberVO(String memberId, String memberName, String memberPic, int praiseTotalCount) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPic = memberPic;
		this.praiseTotalCount = praiseTotalCount;
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
	public int getPraiseTotalCount() {
		return praiseTotalCount;
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
	public void setPraiseTotalCount(int praiseTotalCount) {
		this.praiseTotalCount = praiseTotalCount;
	}
	public String toString() {
		return "BestMemberVO [memberId=" + memberId + ", memberName=" + memberName + ", memberPic=" + memberPic
				+ ", praiseTotalCount=" + praiseTotalCount + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberPic == null) ? 0 : memberPic.hashCode());
		result = prime * result + praiseTotalCount;
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BestMemberVO other = (BestMemberVO) obj;
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
		if (praiseTotalCount != other.praiseTotalCount)
			return false;
		return true;
	}
	
}
