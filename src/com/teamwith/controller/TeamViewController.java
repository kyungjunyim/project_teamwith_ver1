package com.teamwith.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamwith.bean.MemberBean;
import com.teamwith.dao.PologServiceDao;
import com.teamwith.dao.TeamInterviewDao;
import com.teamwith.dao.TeamServiceDao;
import com.teamwith.vo.ApplicantSimpleVO;
import com.teamwith.vo.FaqVO;
import com.teamwith.vo.InquiryMemberVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.RecruitRequireSkillVO;
import com.teamwith.vo.ReplySimpleVO;
import com.teamwith.vo.TeamDetailVO;
import com.teamwith.vo.TeamSimpleVO;

public class TeamViewController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		PologServiceDao pologServiceDao = PologServiceDao.getInstance();
		TeamServiceDao teamServiceDao = TeamServiceDao.getInstance();
		List<PortfolioSimpleVO> recentPortfolioList = pologServiceDao.searchRecentPortfolio();
		request.setAttribute("recentPortfolioList", recentPortfolioList);

		String teamId = request.getParameter("teamId");
		MemberBean member = (MemberBean) request.getSession().getAttribute("memberBean");
		HttpSession session = request.getSession();
		request.setAttribute("member", session.getAttribute("memberBean"));

		if (member != null) {
			int myApplicationCount = teamServiceDao.getApplicationCount(member.getMemberId());
			request.setAttribute("myApplicationCount", myApplicationCount);
			List<TeamSimpleVO> myTeamList = teamServiceDao.searchMyTeam(member.getMemberId());
			request.setAttribute("myTeamList", myTeamList);
			List<ApplicantSimpleVO> myTeamApplicantList = teamServiceDao.getMyTeamApplicant(teamId);
			request.setAttribute("myTeamApplicantList", myTeamApplicantList);
		}

		TeamDetailVO teamDetailVO = teamServiceDao.searchTeam(teamId);
		request.setAttribute("teamDetailVO", teamDetailVO);

		List<String[]> recruitRoleList = teamServiceDao.getRecruitRole(teamId);
		request.setAttribute("recruitRoleList", recruitRoleList);

		List<List<RecruitRequireSkillVO>> recruitRequireSkillList = new ArrayList<List<RecruitRequireSkillVO>>();

		for (String[] recruitRoles : recruitRoleList) {
			recruitRequireSkillList.add(teamServiceDao.searchRequireSkill(recruitRoles[0]));
		}
		request.setAttribute("recruitRequireSkillList", recruitRequireSkillList);

		List<FaqVO> faqList = teamServiceDao.searchFaq(teamId);
		request.setAttribute("faqList", faqList);

		List<InquiryMemberVO> inquiryMemberList = teamServiceDao.searchInquiry(teamId);
		request.setAttribute("inquiryMemberList", inquiryMemberList);

		List<List<ReplySimpleVO>> replyList = new ArrayList<List<ReplySimpleVO>>();
		for (int i = 0; i < inquiryMemberList.size(); i++) {
			replyList.add(teamServiceDao.searchReply(inquiryMemberList.get(i).getInquiryId()));
		}
		request.setAttribute("replyList", replyList);

		
		TeamInterviewDao teamInterviewDao=TeamInterviewDao.getInstance();
		List<String> interviewQuestionList = teamInterviewDao.searchInterviewQuestionContent(teamId);
		request.setAttribute("interviewQuestionList",interviewQuestionList);

		RequestDispatcher rd = request.getRequestDispatcher("/teambuilding/jsp/teamInfo.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
