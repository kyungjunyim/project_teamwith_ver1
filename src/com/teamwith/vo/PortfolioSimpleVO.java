package com.teamwith.vo;

import java.sql.Timestamp;

public class PortfolioSimpleVO {
	private String memberName;
	private String memberId;
	private String portfolioId;
	private Timestamp portfolioUpdateDate;
	private String portfolioTitle;
	private String portfolioPic;
	private String portfolioBest;
	private String projectCategoryId;
	public PortfolioSimpleVO() {
		super();
	}
	public PortfolioSimpleVO(String memberName, String memberId, String portfolioId, Timestamp portfolioUpdateDate,
			String portfolioTitle, String portfolioPic, String portfolioBest, String projectCategoryId) {
		super();
		this.memberName = memberName;
		this.memberId = memberId;
		this.portfolioId = portfolioId;
		this.portfolioUpdateDate = portfolioUpdateDate;
		this.portfolioTitle = portfolioTitle;
		this.portfolioPic = portfolioPic;
		this.portfolioBest = portfolioBest;
		this.projectCategoryId = projectCategoryId;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getPortfolioId() {
		return portfolioId;
	}
	public Timestamp getPortfolioUpdateDate() {
		return portfolioUpdateDate;
	}
	public String getPortfolioTitle() {
		return portfolioTitle;
	}
	public String getPortfolioPic() {
		return portfolioPic;
	}
	public String getPortfolioBest() {
		return portfolioBest;
	}
	public String getProjectCategoryId() {
		return projectCategoryId;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	public void setPortfolioUpdateDate(Timestamp portfolioUpdateDate) {
		this.portfolioUpdateDate = portfolioUpdateDate;
	}
	public void setPortfolioTitle(String portfolioTitle) {
		this.portfolioTitle = portfolioTitle;
	}
	public void setPortfolioPic(String portfolioPic) {
		this.portfolioPic = portfolioPic;
	}
	public void setPortfolioBest(String portfolioBest) {
		this.portfolioBest = portfolioBest;
	}
	public void setProjectCategoryId(String projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}
	public String toString() {
		return "PortfolioSimpleVO [memberName=" + memberName + ", memberId=" + memberId + ", portfolioId=" + portfolioId
				+ ", portfolioUpdateDate=" + portfolioUpdateDate + ", portfolioTitle=" + portfolioTitle
				+ ", portfolioPic=" + portfolioPic + ", portfolioBest=" + portfolioBest + ", projectCategoryId="
				+ projectCategoryId + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((portfolioBest == null) ? 0 : portfolioBest.hashCode());
		result = prime * result + ((portfolioId == null) ? 0 : portfolioId.hashCode());
		result = prime * result + ((portfolioPic == null) ? 0 : portfolioPic.hashCode());
		result = prime * result + ((portfolioTitle == null) ? 0 : portfolioTitle.hashCode());
		result = prime * result + ((portfolioUpdateDate == null) ? 0 : portfolioUpdateDate.hashCode());
		result = prime * result + ((projectCategoryId == null) ? 0 : projectCategoryId.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortfolioSimpleVO other = (PortfolioSimpleVO) obj;
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
		if (portfolioBest == null) {
			if (other.portfolioBest != null)
				return false;
		} else if (!portfolioBest.equals(other.portfolioBest))
			return false;
		if (portfolioId == null) {
			if (other.portfolioId != null)
				return false;
		} else if (!portfolioId.equals(other.portfolioId))
			return false;
		if (portfolioPic == null) {
			if (other.portfolioPic != null)
				return false;
		} else if (!portfolioPic.equals(other.portfolioPic))
			return false;
		if (portfolioTitle == null) {
			if (other.portfolioTitle != null)
				return false;
		} else if (!portfolioTitle.equals(other.portfolioTitle))
			return false;
		if (portfolioUpdateDate == null) {
			if (other.portfolioUpdateDate != null)
				return false;
		} else if (!portfolioUpdateDate.equals(other.portfolioUpdateDate))
			return false;
		if (projectCategoryId == null) {
			if (other.projectCategoryId != null)
				return false;
		} else if (!projectCategoryId.equals(other.projectCategoryId))
			return false;
		return true;
	}
	
}
