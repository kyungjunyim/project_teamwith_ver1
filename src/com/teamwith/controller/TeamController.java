package com.teamwith.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamwith.bean.MemberBean;
import com.teamwith.dao.PologServiceDao;
import com.teamwith.dao.ProfileServiceDao;
import com.teamwith.dao.TeamInterviewDao;
import com.teamwith.dao.TeamServiceDao;
import com.teamwith.vo.BestMemberVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.TeamSimpleVO;

public class TeamController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		TeamServiceDao teamServiceDao = TeamServiceDao.getInstance();
		PologServiceDao pologServiceDao = PologServiceDao.getInstance();
		ProfileServiceDao profileServiceDao = ProfileServiceDao.getInstance();

		if (request.getSession().getAttribute("memberBean") != null) {
			// 나의 팀 불러오는 서비스 메소드 호출
			MemberBean member = (MemberBean) request.getSession().getAttribute("memberBean");
			teamServiceDao = TeamServiceDao.getInstance();
			List<TeamSimpleVO> myTeamList = teamServiceDao.searchMyTeam(member.getMemberId());
			request.setAttribute("myTeamList", myTeamList);

			int myApplicationCount = teamServiceDao.getApplicationCount(member.getMemberId());
			request.setAttribute("myApplicationCount", myApplicationCount);
		}

		pologServiceDao = PologServiceDao.getInstance();
		List<PortfolioSimpleVO> recentPortfolioList = pologServiceDao.searchRecentPortfolio();
		request.setAttribute("recentPortfolioList", recentPortfolioList);

		List<TeamSimpleVO> recentTeamList = teamServiceDao.searchRecentTeam();
		request.setAttribute("recentTeamList", recentTeamList);

		List<BestMemberVO> bestMemberList = profileServiceDao.searchBestMember();
		request.setAttribute("bestMemberList", bestMemberList);

		String job = (String) request.getParameter("job");
		System.out.println(job);
		if (job.equals("teamRegister")) {
			RequestDispatcher rd = request.getRequestDispatcher("/teambuilding/jsp/teamRegist.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (job.equals("addTeam")) {
			if (job.equals("addTeam")) { // 팀 등록하는 과정
				String projectName = request.getParameter("team_project_name");
				String teamName = request.getParameter("team_name");
				String teamSummary = request.getParameter("team_summary");
				String teamContent = request.getParameter("team_content");
				String projectCategoryId = request.getParameter("team_project_category_id");
				String regionId = request.getParameter("region_id");
				Timestamp teamRegisterDate = Timestamp.valueOf(LocalDateTime.now());
				Timestamp teamEndDate = Timestamp.valueOf(request.getParameter("team_end_date") + " 00:00:00");
				String teamContestName = request.getParameter("team_contest_name");
				String teamContestLink = request.getParameter("team_contest_link");
				MemberBean member = (MemberBean) request.getSession().getAttribute("memberBean");
				String memberId = member.getMemberId();
				/* ############################################################## */
				/* ## */ String teamId = teamServiceDao.generateId("team"); /* ## */
				/* ############################################################## */
				String teamPic = "/teamwith/image/team/" + teamId + ".jpg";
				teamServiceDao.addTeamInfo(projectName, teamName, teamSummary, teamContent, projectCategoryId, regionId,
						teamRegisterDate, teamEndDate, teamPic, teamContestName, teamContestLink, memberId);
				String faqQuestion = request.getParameter("faq_question");
				String faqAnswer = request.getParameter("faq_answer");
				teamServiceDao.addFAQ(faqQuestion, faqAnswer, teamId);
				System.out.println(request.getParameter("recruit_people_num"));
				int recruitPeopleNum = Integer.parseInt(request.getParameter("recruit_people"));
				String recruitPreference = request.getParameter("recruit_preference");
				String recruitExplain = request.getParameter("recruit_explain");
				String roleId = request.getParameter("role_id");
				String recruitId = teamServiceDao.generateId("recruit");
				teamServiceDao.addRecruit(recruitPeopleNum, recruitPreference, recruitExplain, roleId, teamId);
				String[] skills = request.getParameterValues("skill");
				for (int i = 0; i < skills.length; i++) {
					teamServiceDao.addRequireSkill(recruitId, skills[i]);
				}
				TeamInterviewDao teamInterviewDao = TeamInterviewDao.getInstance();
				String interviewQuestionContent = request.getParameter("interview_question_content");
				teamInterviewDao.addInterviewQuestion(teamId, interviewQuestionContent);

				RequestDispatcher rd1 = request.getRequestDispatcher("/teambuilding/jsp/home.jsp");
				try {
					rd1.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
