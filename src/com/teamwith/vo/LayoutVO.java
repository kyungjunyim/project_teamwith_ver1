package com.teamwith.vo;

public class LayoutVO {
	private String layoutId;
	private String layoutName;
	private String layoutPosition;

	public LayoutVO() {
		super();
	}
	
	public LayoutVO(String layoutId, String layoutName, String layoutPosition) {
		super();
		this.layoutId = layoutId;
		this.layoutName = layoutName;
		this.layoutPosition = layoutPosition;
	}

	public String getLayoutId() {
		return layoutId;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public String getLayoutPosition() {
		return layoutPosition;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	public void setLayoutPosition(String layoutPosition) {
		this.layoutPosition = layoutPosition;
	}

	public String toString() {
		return "LayoutBVO [layoutId=" + layoutId + ", layoutName=" + layoutName + ", layoutPosition=" + layoutPosition
				+ "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((layoutId == null) ? 0 : layoutId.hashCode());
		result = prime * result + ((layoutName == null) ? 0 : layoutName.hashCode());
		result = prime * result + ((layoutPosition == null) ? 0 : layoutPosition.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LayoutVO other = (LayoutVO) obj;
		if (layoutId == null) {
			if (other.layoutId != null)
				return false;
		} else if (!layoutId.equals(other.layoutId))
			return false;
		if (layoutName == null) {
			if (other.layoutName != null)
				return false;
		} else if (!layoutName.equals(other.layoutName))
			return false;
		if (layoutPosition == null) {
			if (other.layoutPosition != null)
				return false;
		} else if (!layoutPosition.equals(other.layoutPosition))
			return false;
		return true;
	}
	
	
}
