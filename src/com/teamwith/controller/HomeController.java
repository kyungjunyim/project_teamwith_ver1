package com.teamwith.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamwith.bean.MemberBean;
import com.teamwith.dao.PologServiceDao;
import com.teamwith.dao.ProfileServiceDao;
import com.teamwith.dao.TeamServiceDao;
import com.teamwith.vo.BestMemberVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.TeamSimpleVO;

public class HomeController implements Controller {
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      try {
         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html; charset=utf-8");
      } catch (UnsupportedEncodingException e1) {
         e1.printStackTrace();
      }

      load(request, response);
      RequestDispatcher rd = request.getRequestDispatcher("/teambuilding/jsp/home.jsp");
      try {
         rd.forward(request, response);
      } catch (ServletException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void load(HttpServletRequest request, HttpServletResponse response) {
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

   }
}