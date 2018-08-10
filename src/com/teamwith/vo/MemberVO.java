package com.teamwith.vo;

import java.sql.Timestamp;

public class MemberVO {
	private String memberId;
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private Timestamp memberBirth;
	private String memberPic;
	private int memberActive;
	private String memberPhone;
	private int memberPublic;
	private String memberIntro;
	private Timestamp memberRegisterDate;
	private Timestamp memberOutDate;
	private int memberAuth;
	private String roleId;
	public MemberVO() {
		super();
	}
	public MemberVO(String memberId, String memberName, String memberPassword, String memberEmail,
			Timestamp memberBirth, String memberPic, int memberActive, String memberPhone, int memberPublic,
			String memberIntro, Timestamp memberRegisterDate, Timestamp memberOutDate, int memberAuth, String roleId) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.memberBirth = memberBirth;
		this.memberPic = memberPic;
		this.memberActive = memberActive;
		this.memberPhone = memberPhone;
		this.memberPublic = memberPublic;
		this.memberIntro = memberIntro;
		this.memberRegisterDate = memberRegisterDate;
		this.memberOutDate = memberOutDate;
		this.memberAuth = memberAuth;
		this.roleId = roleId;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public Timestamp getMemberBirth() {
		return memberBirth;
	}
	public String getMemberPic() {
		return memberPic;
	}
	public int getMemberActive() {
		return memberActive;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public int getMemberPublic() {
		return memberPublic;
	}
	public String getMemberIntro() {
		return memberIntro;
	}
	public Timestamp getMemberRegisterDate() {
		return memberRegisterDate;
	}
	public Timestamp getMemberOutDate() {
		return memberOutDate;
	}
	public int getMemberAuth() {
		return memberAuth;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public void setMemberBirth(Timestamp memberBirth) {
		this.memberBirth = memberBirth;
	}
	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
	}
	public void setMemberActive(int memberActive) {
		this.memberActive = memberActive;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public void setMemberPublic(int memberPublic) {
		this.memberPublic = memberPublic;
	}
	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}
	public void setMemberRegisterDate(Timestamp memberRegisterDate) {
		this.memberRegisterDate = memberRegisterDate;
	}
	public void setMemberOutDate(Timestamp memberOutDate) {
		this.memberOutDate = memberOutDate;
	}
	public void setMemberAuth(int memberAuth) {
		this.memberAuth = memberAuth;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberName=" + memberName + ", memberPassword=" + memberPassword
				+ ", memberEmail=" + memberEmail + ", memberBirth=" + memberBirth + ", memberPic=" + memberPic
				+ ", memberActive=" + memberActive + ", memberPhone=" + memberPhone + ", memberPublic=" + memberPublic
				+ ", memberIntro=" + memberIntro + ", memberRegisterDate=" + memberRegisterDate + ", memberOutDate="
				+ memberOutDate + ", memberAuth=" + memberAuth + ", roleId=" + roleId + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memberActive;
		result = prime * result + memberAuth;
		result = prime * result + ((memberBirth == null) ? 0 : memberBirth.hashCode());
		result = prime * result + ((memberEmail == null) ? 0 : memberEmail.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberIntro == null) ? 0 : memberIntro.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberOutDate == null) ? 0 : memberOutDate.hashCode());
		result = prime * result + ((memberPassword == null) ? 0 : memberPassword.hashCode());
		result = prime * result + ((memberPhone == null) ? 0 : memberPhone.hashCode());
		result = prime * result + ((memberPic == null) ? 0 : memberPic.hashCode());
		result = prime * result + memberPublic;
		result = prime * result + ((memberRegisterDate == null) ? 0 : memberRegisterDate.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (memberActive != other.memberActive)
			return false;
		if (memberAuth != other.memberAuth)
			return false;
		if (memberBirth == null) {
			if (other.memberBirth != null)
				return false;
		} else if (!memberBirth.equals(other.memberBirth))
			return false;
		if (memberEmail == null) {
			if (other.memberEmail != null)
				return false;
		} else if (!memberEmail.equals(other.memberEmail))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberIntro == null) {
			if (other.memberIntro != null)
				return false;
		} else if (!memberIntro.equals(other.memberIntro))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberOutDate == null) {
			if (other.memberOutDate != null)
				return false;
		} else if (!memberOutDate.equals(other.memberOutDate))
			return false;
		if (memberPassword == null) {
			if (other.memberPassword != null)
				return false;
		} else if (!memberPassword.equals(other.memberPassword))
			return false;
		if (memberPhone == null) {
			if (other.memberPhone != null)
				return false;
		} else if (!memberPhone.equals(other.memberPhone))
			return false;
		if (memberPic == null) {
			if (other.memberPic != null)
				return false;
		} else if (!memberPic.equals(other.memberPic))
			return false;
		if (memberPublic != other.memberPublic)
			return false;
		if (memberRegisterDate == null) {
			if (other.memberRegisterDate != null)
				return false;
		} else if (!memberRegisterDate.equals(other.memberRegisterDate))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
	
	
}
