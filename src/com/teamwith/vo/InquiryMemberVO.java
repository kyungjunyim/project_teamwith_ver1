package com.teamwith.vo;

import java.sql.Timestamp;

public class InquiryMemberVO {
	private String inquiryId;
	private String inquiryContent;
	private Timestamp inquiryUpdateDate;
	private String teamId;
	private String memberId;
	private String memberName;
	private String memberPic;
	public InquiryMemberVO() {
		super();
	}
	public InquiryMemberVO(String inquiryId, String inquiryContent, Timestamp inquiryUpdateDate, String teamId,
			String memberId, String memberName, String memberPic) {
		super();
		this.inquiryId = inquiryId;
		this.inquiryContent = inquiryContent;
		this.inquiryUpdateDate = inquiryUpdateDate;
		this.teamId = teamId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPic = memberPic;
	}
	public String getInquiryId() {
		return inquiryId;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	public Timestamp getInquiryUpdateDate() {
		return inquiryUpdateDate;
	}
	public String getTeamId() {
		return teamId;
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
	public void setInquiryId(String inquiryId) {
		this.inquiryId = inquiryId;
	}
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public void setInquiryUpdateDate(Timestamp inquiryUpdateDate) {
		this.inquiryUpdateDate = inquiryUpdateDate;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
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
	public String toString() {
		return "InquiryMemberVO [inquiryId=" + inquiryId + ", inquiryContent=" + inquiryContent + ", inquiryUpdateDate="
				+ inquiryUpdateDate + ", teamId=" + teamId + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", memberPic=" + memberPic + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inquiryContent == null) ? 0 : inquiryContent.hashCode());
		result = prime * result + ((inquiryId == null) ? 0 : inquiryId.hashCode());
		result = prime * result + ((inquiryUpdateDate == null) ? 0 : inquiryUpdateDate.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberPic == null) ? 0 : memberPic.hashCode());
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
		InquiryMemberVO other = (InquiryMemberVO) obj;
		if (inquiryContent == null) {
			if (other.inquiryContent != null)
				return false;
		} else if (!inquiryContent.equals(other.inquiryContent))
			return false;
		if (inquiryId == null) {
			if (other.inquiryId != null)
				return false;
		} else if (!inquiryId.equals(other.inquiryId))
			return false;
		if (inquiryUpdateDate == null) {
			if (other.inquiryUpdateDate != null)
				return false;
		} else if (!inquiryUpdateDate.equals(other.inquiryUpdateDate))
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
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
	
}
