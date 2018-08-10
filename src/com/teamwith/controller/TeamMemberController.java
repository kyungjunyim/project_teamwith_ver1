package com.teamwith.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.teamwith.vo.ApplicationSimpleVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.TeamSimpleVO;

public class TeamMemberController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String job = request.getParameter("job");
		String id = request.getParameter("memberId");
		request.setAttribute("memberId", id);

		PologServiceDao pologServiceDao = PologServiceDao.getInstance();
		List<PortfolioSimpleVO> recentPortfolioList = pologServiceDao.searchRecentPortfolio();
		request.setAttribute("recentPortfolioList", recentPortfolioList);
		
		MemberBean member = (MemberBean) request.getSession().getAttribute("memberBean");
		TeamServiceDao teamServiceDao = TeamServiceDao.getInstance();
		int myApplicationCount = teamServiceDao.getApplicationCount(member.getMemberId());
		request.setAttribute("myApplicationCount", myApplicationCount);
		
		HttpSession session = request.getSession();
		request.setAttribute("member", session.getAttribute("memberBean"));
		
		List<TeamSimpleVO> myTeamList = teamServiceDao.searchMyTeam(member.getMemberId());
		request.setAttribute("myTeamList", myTeamList);
		
		TeamInterviewDao teamInterviewDao = TeamInterviewDao.getInstance();
		List<ApplicationSimpleVO> myApplicationList = teamInterviewDao.getMyApplicationList(id);
		request.setAttribute("myApplicationList", myApplicationList);
		
		RequestDispatcher rd = null;
		switch(job) {
		case "myApplication":
			rd = request.getRequestDispatcher("/teambuilding/jsp/myApplicationList.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "myApplicant":
			rd = request.getRequestDispatcher("/teambuilding/jsp/test.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
				
		
	}
}
