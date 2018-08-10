package com.teamwith.vo;

import java.sql.Timestamp;

public class PortfolioVO {
	private String portfolioId;
	private String portfolioTitle;
	private String portfolioProjectIntro;
	private Timestamp portfolioStartDate;
	private Timestamp portfolioEndDate;
	private String portfolioTeamName;
	private int portfolioPeopleNum;
	private String portfolioRole;
	private String portfolioWork;
	private String portfolioSkill;
	private Timestamp portfolioUpdateDate;
	private int portfolioBest;
	private String portfolioPic;
	private String projectCategoryId;
	public PortfolioVO() {
		super();
	}
	public PortfolioVO(String portfolioId, String portfolioTitle, String portfolioProjectIntro,
			Timestamp portfolioStartDate, Timestamp portfolioEndDate, String portfolioTeamName, int portfolioPeopleNum,
			String portfolioRole, String portfolioWork, String portfolioSkill, Timestamp portfolioUpdateDate,
			int portfolioBest, String portfolioPic, String projectCategoryId) {
		super();
		this.portfolioId = portfolioId;
		this.portfolioTitle = portfolioTitle;
		this.portfolioProjectIntro = portfolioProjectIntro;
		this.portfolioStartDate = portfolioStartDate;
		this.portfolioEndDate = portfolioEndDate;
		this.portfolioTeamName = portfolioTeamName;
		this.portfolioPeopleNum = portfolioPeopleNum;
		this.portfolioRole = portfolioRole;
		this.portfolioWork = portfolioWork;
		this.portfolioSkill = portfolioSkill;
		this.portfolioUpdateDate = portfolioUpdateDate;
		this.portfolioBest = portfolioBest;
		this.portfolioPic = portfolioPic;
		this.projectCategoryId = projectCategoryId;
	}
	public String getPortfolioId() {
		return portfolioId;
	}
	public String getPortfolioTitle() {
		return portfolioTitle;
	}
	public String getPortfolioProjectIntro() {
		return portfolioProjectIntro;
	}
	public Timestamp getPortfolioStartDate() {
		return portfolioStartDate;
	}
	public Timestamp getPortfolioEndDate() {
		return portfolioEndDate;
	}
	public String getPortfolioTeamName() {
		return portfolioTeamName;
	}
	public int getPortfolioPeopleNum() {
		return portfolioPeopleNum;
	}
	public String getPortfolioRole() {
		return portfolioRole;
	}
	public String getPortfolioWork() {
		return portfolioWork;
	}
	public String getPortfolioSkill() {
		return portfolioSkill;
	}
	public Timestamp getPortfolioUpdateDate() {
		return portfolioUpdateDate;
	}
	public int getPortfolioBest() {
		return portfolioBest;
	}
	public String getPortfolioPic() {
		return portfolioPic;
	}
	public String getProjectCategoryId() {
		return projectCategoryId;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	public void setPortfolioTitle(String portfolioTitle) {
		this.portfolioTitle = portfolioTitle;
	}
	public void setPortfolioProjectIntro(String portfolioProjectIntro) {
		this.portfolioProjectIntro = portfolioProjectIntro;
	}
	public void setPortfolioStartDate(Timestamp portfolioStartDate) {
		this.portfolioStartDate = portfolioStartDate;
	}
	public void setPortfolioEndDate(Timestamp portfolioEndDate) {
		this.portfolioEndDate = portfolioEndDate;
	}
	public void setPortfolioTeamName(String portfolioTeamName) {
		this.portfolioTeamName = portfolioTeamName;
	}
	public void setPortfolioPeopleNum(int portfolioPeopleNum) {
		this.portfolioPeopleNum = portfolioPeopleNum;
	}
	public void setPortfolioRole(String portfolioRole) {
		this.portfolioRole = portfolioRole;
	}
	public void setPortfolioWork(String portfolioWork) {
		this.portfolioWork = portfolioWork;
	}
	public void setPortfolioSkill(String portfolioSkill) {
		this.portfolioSkill = portfolioSkill;
	}
	public void setPortfolioUpdateDate(Timestamp portfolioUpdateDate) {
		this.portfolioUpdateDate = portfolioUpdateDate;
	}
	public void setPortfolioBest(int portfolioBest) {
		this.portfolioBest = portfolioBest;
	}
	public void setPortfolioPic(String portfolioPic) {
		this.portfolioPic = portfolioPic;
	}
	public void setProjectCategoryId(String projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}
	public String toString() {
		return "PortfolioDTO [portfolioId=" + portfolioId + ", portfolioTitle=" + portfolioTitle
				+ ", portfolioProjectIntro=" + portfolioProjectIntro + ", portfolioStartDate=" + portfolioStartDate
				+ ", portfolioEndDate=" + portfolioEndDate + ", portfolioTeamName=" + portfolioTeamName
				+ ", portfolioPeopleNum=" + portfolioPeopleNum + ", portfolioRole=" + portfolioRole + ", portfolioWork="
				+ portfolioWork + ", portfolioSkill=" + portfolioSkill + ", portfolioUpdateDate=" + portfolioUpdateDate
				+ ", portfolioBest=" + portfolioBest + ", portfolioPic=" + portfolioPic + ", projectCategoryId="
				+ projectCategoryId + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + portfolioBest;
		result = prime * result + ((portfolioEndDate == null) ? 0 : portfolioEndDate.hashCode());
		result = prime * result + ((portfolioId == null) ? 0 : portfolioId.hashCode());
		result = prime * result + portfolioPeopleNum;
		result = prime * result + ((portfolioPic == null) ? 0 : portfolioPic.hashCode());
		result = prime * result + ((portfolioProjectIntro == null) ? 0 : portfolioProjectIntro.hashCode());
		result = prime * result + ((portfolioRole == null) ? 0 : portfolioRole.hashCode());
		result = prime * result + ((portfolioSkill == null) ? 0 : portfolioSkill.hashCode());
		result = prime * result + ((portfolioStartDate == null) ? 0 : portfolioStartDate.hashCode());
		result = prime * result + ((portfolioTeamName == null) ? 0 : portfolioTeamName.hashCode());
		result = prime * result + ((portfolioTitle == null) ? 0 : portfolioTitle.hashCode());
		result = prime * result + ((portfolioUpdateDate == null) ? 0 : portfolioUpdateDate.hashCode());
		result = prime * result + ((portfolioWork == null) ? 0 : portfolioWork.hashCode());
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
		PortfolioVO other = (PortfolioVO) obj;
		if (portfolioBest != other.portfolioBest)
			return false;
		if (portfolioEndDate == null) {
			if (other.portfolioEndDate != null)
				return false;
		} else if (!portfolioEndDate.equals(other.portfolioEndDate))
			return false;
		if (portfolioId == null) {
			if (other.portfolioId != null)
				return false;
		} else if (!portfolioId.equals(other.portfolioId))
			return false;
		if (portfolioPeopleNum != other.portfolioPeopleNum)
			return false;
		if (portfolioPic == null) {
			if (other.portfolioPic != null)
				return false;
		} else if (!portfolioPic.equals(other.portfolioPic))
			return false;
		if (portfolioProjectIntro == null) {
			if (other.portfolioProjectIntro != null)
				return false;
		} else if (!portfolioProjectIntro.equals(other.portfolioProjectIntro))
			return false;
		if (portfolioRole == null) {
			if (other.portfolioRole != null)
				return false;
		} else if (!portfolioRole.equals(other.portfolioRole))
			return false;
		if (portfolioSkill == null) {
			if (other.portfolioSkill != null)
				return false;
		} else if (!portfolioSkill.equals(other.portfolioSkill))
			return false;
		if (portfolioStartDate == null) {
			if (other.portfolioStartDate != null)
				return false;
		} else if (!portfolioStartDate.equals(other.portfolioStartDate))
			return false;
		if (portfolioTeamName == null) {
			if (other.portfolioTeamName != null)
				return false;
		} else if (!portfolioTeamName.equals(other.portfolioTeamName))
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
		if (portfolioWork == null) {
			if (other.portfolioWork != null)
				return false;
		} else if (!portfolioWork.equals(other.portfolioWork))
			return false;
		if (projectCategoryId == null) {
			if (other.projectCategoryId != null)
				return false;
		} else if (!projectCategoryId.equals(other.projectCategoryId))
			return false;
		return true;
	}
	
}
