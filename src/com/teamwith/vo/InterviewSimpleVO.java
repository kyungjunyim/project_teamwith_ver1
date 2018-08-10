package com.teamwith.vo;

public class InterviewSimpleVO {
	private String applicationId;
	private String interviewAnswerContent;
	private String interviewQuestionContent;
	private String teamId;
	public InterviewSimpleVO() {
		super();
	}
	public InterviewSimpleVO(String applicationId, String interviewAnswerContent, String interviewQuestionContent,
			String teamId) {
		super();
		this.applicationId = applicationId;
		this.interviewAnswerContent = interviewAnswerContent;
		this.interviewQuestionContent = interviewQuestionContent;
		this.teamId = teamId;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public String getInterviewAnswerContent() {
		return interviewAnswerContent;
	}
	public String getInterviewQuestionContent() {
		return interviewQuestionContent;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public void setInterviewAnswerContent(String interviewAnswerContent) {
		this.interviewAnswerContent = interviewAnswerContent;
	}
	public void setInterviewQuestionContent(String interviewQuestionContent) {
		this.interviewQuestionContent = interviewQuestionContent;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String toString() {
		return "InterviewSimpleVO [applicationId=" + applicationId + ", interviewAnswerContent="
				+ interviewAnswerContent + ", interviewQuestionContent=" + interviewQuestionContent + ", teamId="
				+ teamId + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
		result = prime * result + ((interviewAnswerContent == null) ? 0 : interviewAnswerContent.hashCode());
		result = prime * result + ((interviewQuestionContent == null) ? 0 : interviewQuestionContent.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterviewSimpleVO other = (InterviewSimpleVO) obj;
		if (applicationId == null) {
			if (other.applicationId != null)
				return false;
		} else if (!applicationId.equals(other.applicationId))
			return false;
		if (interviewAnswerContent == null) {
			if (other.interviewAnswerContent != null)
				return false;
		} else if (!interviewAnswerContent.equals(other.interviewAnswerContent))
			return false;
		if (interviewQuestionContent == null) {
			if (other.interviewQuestionContent != null)
				return false;
		} else if (!interviewQuestionContent.equals(other.interviewQuestionContent))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
	
}
