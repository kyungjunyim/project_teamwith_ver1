package com.teamwith.vo;

public class PologVO {
	private String memberId;
	private String pologTitle;
	private String pologTitlePosition;
	private String pologTitlePic;
	private String pologThemeColor;
	private String pologBgColor;
	private String pologBgPic;
	private String pologMenuPosition;
	private String pologIntro;
	public PologVO() {
		super();
	}
	public PologVO(String memberId, String pologTitle, String pologTitlePosition, String pologTitlePic,
			String pologThemeColor, String pologBgColor, String pologBgPic, String pologMenuPosition,
			String pologIntro) {
		super();
		this.memberId = memberId;
		this.pologTitle = pologTitle;
		this.pologTitlePosition = pologTitlePosition;
		this.pologTitlePic = pologTitlePic;
		this.pologThemeColor = pologThemeColor;
		this.pologBgColor = pologBgColor;
		this.pologBgPic = pologBgPic;
		this.pologMenuPosition = pologMenuPosition;
		this.pologIntro = pologIntro;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getPologTitle() {
		return pologTitle;
	}
	public String getPologTitlePosition() {
		return pologTitlePosition;
	}
	public String getPologTitlePic() {
		return pologTitlePic;
	}
	public String getPologThemeColor() {
		return pologThemeColor;
	}
	public String getPologBgColor() {
		return pologBgColor;
	}
	public String getPologBgPic() {
		return pologBgPic;
	}
	public String getPologMenuPosition() {
		return pologMenuPosition;
	}
	public String getPologIntro() {
		return pologIntro;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setPologTitle(String pologTitle) {
		this.pologTitle = pologTitle;
	}
	public void setPologTitlePosition(String pologTitlePosition) {
		this.pologTitlePosition = pologTitlePosition;
	}
	public void setPologTitlePic(String pologTitlePic) {
		this.pologTitlePic = pologTitlePic;
	}
	public void setPologThemeColor(String pologThemeColor) {
		this.pologThemeColor = pologThemeColor;
	}
	public void setPologBgColor(String pologBgColor) {
		this.pologBgColor = pologBgColor;
	}
	public void setPologBgPic(String pologBgPic) {
		this.pologBgPic = pologBgPic;
	}
	public void setPologMenuPosition(String pologMenuPosition) {
		this.pologMenuPosition = pologMenuPosition;
	}
	public void setPologIntro(String pologIntro) {
		this.pologIntro = pologIntro;
	}
	public String toString() {
		return "PologVO [memberId=" + memberId + ", pologTitle=" + pologTitle + ", pologTitlePosition="
				+ pologTitlePosition + ", pologTitlePic=" + pologTitlePic + ", pologThemeColor=" + pologThemeColor
				+ ", pologBgColor=" + pologBgColor + ", pologBgPic=" + pologBgPic + ", pologMenuPosition="
				+ pologMenuPosition + ", pologIntro=" + pologIntro + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((pologBgColor == null) ? 0 : pologBgColor.hashCode());
		result = prime * result + ((pologBgPic == null) ? 0 : pologBgPic.hashCode());
		result = prime * result + ((pologIntro == null) ? 0 : pologIntro.hashCode());
		result = prime * result + ((pologMenuPosition == null) ? 0 : pologMenuPosition.hashCode());
		result = prime * result + ((pologThemeColor == null) ? 0 : pologThemeColor.hashCode());
		result = prime * result + ((pologTitle == null) ? 0 : pologTitle.hashCode());
		result = prime * result + ((pologTitlePic == null) ? 0 : pologTitlePic.hashCode());
		result = prime * result + ((pologTitlePosition == null) ? 0 : pologTitlePosition.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PologVO other = (PologVO) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (pologBgColor == null) {
			if (other.pologBgColor != null)
				return false;
		} else if (!pologBgColor.equals(other.pologBgColor))
			return false;
		if (pologBgPic == null) {
			if (other.pologBgPic != null)
				return false;
		} else if (!pologBgPic.equals(other.pologBgPic))
			return false;
		if (pologIntro == null) {
			if (other.pologIntro != null)
				return false;
		} else if (!pologIntro.equals(other.pologIntro))
			return false;
		if (pologMenuPosition == null) {
			if (other.pologMenuPosition != null)
				return false;
		} else if (!pologMenuPosition.equals(other.pologMenuPosition))
			return false;
		if (pologThemeColor == null) {
			if (other.pologThemeColor != null)
				return false;
		} else if (!pologThemeColor.equals(other.pologThemeColor))
			return false;
		if (pologTitle == null) {
			if (other.pologTitle != null)
				return false;
		} else if (!pologTitle.equals(other.pologTitle))
			return false;
		if (pologTitlePic == null) {
			if (other.pologTitlePic != null)
				return false;
		} else if (!pologTitlePic.equals(other.pologTitlePic))
			return false;
		if (pologTitlePosition == null) {
			if (other.pologTitlePosition != null)
				return false;
		} else if (!pologTitlePosition.equals(other.pologTitlePosition))
			return false;
		return true;
	}
	
}
