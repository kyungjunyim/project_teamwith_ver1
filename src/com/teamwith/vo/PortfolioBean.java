package com.teamwith.vo;

public class PortfolioBean {
	private String portfolioId;
	private String portfolioTitle;
	private String portfolioIntro;
	private String portfolioTeam;
	private String portfolioRole;
	public PortfolioBean(String portfolioId, String portfolioTitle, String portfolioIntro, String portfolioTeam,
			String portfolioRole) {
		super();
		this.portfolioId = portfolioId;
		this.portfolioTitle = portfolioTitle;
		this.portfolioIntro = portfolioIntro;
		this.portfolioTeam = portfolioTeam;
		this.portfolioRole = portfolioRole;
	}
	public String getPortfolioId() {
		return portfolioId;
	}
	public String getPortfolioTitle() {
		return portfolioTitle;
	}
	public String getPortfolioIntro() {
		return portfolioIntro;
	}
	public String getPortfolioTeam() {
		return portfolioTeam;
	}
	public String getPortfolioRole() {
		return portfolioRole;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	public void setPortfolioTitle(String portfolioTitle) {
		this.portfolioTitle = portfolioTitle;
	}
	public void setPortfolioIntro(String portfolioIntro) {
		this.portfolioIntro = portfolioIntro;
	}
	public void setPortfolioTeam(String portfolioTeam) {
		this.portfolioTeam = portfolioTeam;
	}
	public void setPortfolioRole(String portfolioRole) {
		this.portfolioRole = portfolioRole;
	}
	
	
	
}
