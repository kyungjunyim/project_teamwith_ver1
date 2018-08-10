package com.teamwith.vo;

import java.sql.Timestamp;

public class ReplySimpleVO {
	private String replyId;
	private String replyContent;
	private Timestamp replyUpdateDate;
	private String inquiryId;
	private String memberId;
	private String memberName;
	private String memberPic;
	public ReplySimpleVO() {
		super();
	}
	public ReplySimpleVO(String replyId, String replyContent, Timestamp replyUpdateDate, String inquiryId,
			String memberId, String memberName, String memberPic) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyUpdateDate = replyUpdateDate;
		this.inquiryId = inquiryId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPic = memberPic;
	}
	public String getReplyId() {
		return replyId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public Timestamp getReplyUpdateDate() {
		return replyUpdateDate;
	}
	public String getInquiryId() {
		return inquiryId;
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
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public void setReplyUpdateDate(Timestamp replyUpdateDate) {
		this.replyUpdateDate = replyUpdateDate;
	}
	public void setInquiryId(String inquiryId) {
		this.inquiryId = inquiryId;
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
		return "ReplySimpleVO [replyId=" + replyId + ", replyContent=" + replyContent + ", replyUpdateDate="
				+ replyUpdateDate + ", inquiryId=" + inquiryId + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", memberPic=" + memberPic + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inquiryId == null) ? 0 : inquiryId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberPic == null) ? 0 : memberPic.hashCode());
		result = prime * result + ((replyContent == null) ? 0 : replyContent.hashCode());
		result = prime * result + ((replyId == null) ? 0 : replyId.hashCode());
		result = prime * result + ((replyUpdateDate == null) ? 0 : replyUpdateDate.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplySimpleVO other = (ReplySimpleVO) obj;
		if (inquiryId == null) {
			if (other.inquiryId != null)
				return false;
		} else if (!inquiryId.equals(other.inquiryId))
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
		if (replyContent == null) {
			if (other.replyContent != null)
				return false;
		} else if (!replyContent.equals(other.replyContent))
			return false;
		if (replyId == null) {
			if (other.replyId != null)
				return false;
		} else if (!replyId.equals(other.replyId))
			return false;
		if (replyUpdateDate == null) {
			if (other.replyUpdateDate != null)
				return false;
		} else if (!replyUpdateDate.equals(other.replyUpdateDate))
			return false;
		return true;
	}
	
}
