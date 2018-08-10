package com.teamwith.vo;

public class PortfolioContentElementVO {
	private String memberId;
	private String portfolioId;
	private String elementId;
	private String layoutId;
	private String layoutName;
	private String elementName;
	private String elementContent;
	private int contentOrder;
	public PortfolioContentElementVO() {
		super();
	}
	public PortfolioContentElementVO(String memberId, String portfolioId, String elementId, String layoutId,String layoutName,
			String elementName, String elementContent, int contentOrder) {
		super();
		this.memberId = memberId;
		this.portfolioId = portfolioId;
		this.elementId = elementId;
		this.layoutId = layoutId;
		this.layoutName=layoutName;
		this.elementName = elementName;
		this.elementContent = elementContent;
		this.contentOrder = contentOrder;
	}
	
	public String getLayoutName() {
		return layoutName;
	}
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getPortfolioId() {
		return portfolioId;
	}
	public String getElementId() {
		return elementId;
	}
	public String getLayoutId() {
		return layoutId;
	}
	public String getElementName() {
		return elementName;
	}
	public String getElementContent() {
		return elementContent;
	}
	public int getContentOrder() {
		return contentOrder;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public void setElementContent(String elementContent) {
		this.elementContent = elementContent;
	}
	public void setContentOrder(int contentOrder) {
		this.contentOrder = contentOrder;
	}
	public String toString() {
		return "PortfolioContentElementVO [memberId=" + memberId + ", portfolioId=" + portfolioId + ", elementId="
				+ elementId + ", layoutId=" + layoutId + ", elementName=" + elementName + ", elementContent="
				+ elementContent + ", contentOrder=" + contentOrder + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contentOrder;
		result = prime * result + ((elementContent == null) ? 0 : elementContent.hashCode());
		result = prime * result + ((elementId == null) ? 0 : elementId.hashCode());
		result = prime * result + ((elementName == null) ? 0 : elementName.hashCode());
		result = prime * result + ((layoutId == null) ? 0 : layoutId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((portfolioId == null) ? 0 : portfolioId.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortfolioContentElementVO other = (PortfolioContentElementVO) obj;
		if (contentOrder != other.contentOrder)
			return false;
		if (elementContent == null) {
			if (other.elementContent != null)
				return false;
		} else if (!elementContent.equals(other.elementContent))
			return false;
		if (elementId == null) {
			if (other.elementId != null)
				return false;
		} else if (!elementId.equals(other.elementId))
			return false;
		if (elementName == null) {
			if (other.elementName != null)
				return false;
		} else if (!elementName.equals(other.elementName))
			return false;
		if (layoutId == null) {
			if (other.layoutId != null)
				return false;
		} else if (!layoutId.equals(other.layoutId))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (portfolioId == null) {
			if (other.portfolioId != null)
				return false;
		} else if (!portfolioId.equals(other.portfolioId))
			return false;
		return true;
	}
	
}
