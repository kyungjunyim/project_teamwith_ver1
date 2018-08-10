package com.teamwith.vo;

import java.sql.Timestamp;

public class CareerVO {
	private String careerId;
	private String memberId;
	private String careerName;
	private Timestamp careerStartDate;
	private Timestamp careerEndDate;
	private String careerRole;
	private String careerExplain;
	public CareerVO() {
		super();
	}
	public CareerVO(String careerId, String memberId, String careerName, Timestamp careerStartDate,
			Timestamp careerEndDate, String careerRole, String careerExplain) {
		super();
		this.careerId = careerId;
		this.memberId = memberId;
		this.careerName = careerName;
		this.careerStartDate = careerStartDate;
		this.careerEndDate = careerEndDate;
		this.careerRole = careerRole;
		this.careerExplain = careerExplain;
	}
	public String getCareerId() {
		return careerId;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getCareerName() {
		return careerName;
	}
	public Timestamp getCareerStartDate() {
		return careerStartDate;
	}
	public Timestamp getCareerEndDate() {
		return careerEndDate;
	}
	public String getCareerRole() {
		return careerRole;
	}
	public String getCareerExplain() {
		return careerExplain;
	}
	public void setCareerId(String careerId) {
		this.careerId = careerId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}
	public void setCareerStartDate(Timestamp careerStartDate) {
		this.careerStartDate = careerStartDate;
	}
	public void setCareerEndDate(Timestamp careerEndDate) {
		this.careerEndDate = careerEndDate;
	}
	public void setCareerRole(String careerRole) {
		this.careerRole = careerRole;
	}
	public void setCareerExplain(String careerExplain) {
		this.careerExplain = careerExplain;
	}
	public String toString() {
		return "CareerVO [careerId=" + careerId + ", memberId=" + memberId + ", careerName=" + careerName
				+ ", careerStartDate=" + careerStartDate + ", careerEndDate=" + careerEndDate + ", careerRole="
				+ careerRole + ", careerExplain=" + careerExplain + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((careerEndDate == null) ? 0 : careerEndDate.hashCode());
		result = prime * result + ((careerExplain == null) ? 0 : careerExplain.hashCode());
		result = prime * result + ((careerId == null) ? 0 : careerId.hashCode());
		result = prime * result + ((careerName == null) ? 0 : careerName.hashCode());
		result = prime * result + ((careerRole == null) ? 0 : careerRole.hashCode());
		result = prime * result + ((careerStartDate == null) ? 0 : careerStartDate.hashCode());
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
		CareerVO other = (CareerVO) obj;
		if (careerEndDate == null) {
			if (other.careerEndDate != null)
				return false;
		} else if (!careerEndDate.equals(other.careerEndDate))
			return false;
		if (careerExplain == null) {
			if (other.careerExplain != null)
				return false;
		} else if (!careerExplain.equals(other.careerExplain))
			return false;
		if (careerId == null) {
			if (other.careerId != null)
				return false;
		} else if (!careerId.equals(other.careerId))
			return false;
		if (careerName == null) {
			if (other.careerName != null)
				return false;
		} else if (!careerName.equals(other.careerName))
			return false;
		if (careerRole == null) {
			if (other.careerRole != null)
				return false;
		} else if (!careerRole.equals(other.careerRole))
			return false;
		if (careerStartDate == null) {
			if (other.careerStartDate != null)
				return false;
		} else if (!careerStartDate.equals(other.careerStartDate))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
}
