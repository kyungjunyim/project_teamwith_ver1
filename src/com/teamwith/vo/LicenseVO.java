package com.teamwith.vo;

import java.sql.Timestamp;

public class LicenseVO {
	private String licenseId;
	private String memberId;
	private String licenseName;
	private Timestamp licenseDate;
	private String licenseLevel;
	public LicenseVO() {
		super();
	}
	public LicenseVO(String licenseId, String memberId, String licenseName, Timestamp licenseDate,
			String licenseLevel) {
		super();
		this.licenseId = licenseId;
		this.memberId = memberId;
		this.licenseName = licenseName;
		this.licenseDate = licenseDate;
		this.licenseLevel = licenseLevel;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getLicenseName() {
		return licenseName;
	}
	public Timestamp getLicenseDate() {
		return licenseDate;
	}
	public String getLicenseLevel() {
		return licenseLevel;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	public void setLicenseDate(Timestamp licenseDate) {
		this.licenseDate = licenseDate;
	}
	public void setLicenseLevel(String licenseLevel) {
		this.licenseLevel = licenseLevel;
	}
	public String toString() {
		return "LicenseVO [licenseId=" + licenseId + ", memberId=" + memberId + ", licenseName=" + licenseName
				+ ", licenseDate=" + licenseDate + ", licenseLevel=" + licenseLevel + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((licenseDate == null) ? 0 : licenseDate.hashCode());
		result = prime * result + ((licenseId == null) ? 0 : licenseId.hashCode());
		result = prime * result + ((licenseLevel == null) ? 0 : licenseLevel.hashCode());
		result = prime * result + ((licenseName == null) ? 0 : licenseName.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LicenseVO other = (LicenseVO) obj;
		if (licenseDate == null) {
			if (other.licenseDate != null)
				return false;
		} else if (!licenseDate.equals(other.licenseDate))
			return false;
		if (licenseId == null) {
			if (other.licenseId != null)
				return false;
		} else if (!licenseId.equals(other.licenseId))
			return false;
		if (licenseLevel == null) {
			if (other.licenseLevel != null)
				return false;
		} else if (!licenseLevel.equals(other.licenseLevel))
			return false;
		if (licenseName == null) {
			if (other.licenseName != null)
				return false;
		} else if (!licenseName.equals(other.licenseName))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	

	
}
