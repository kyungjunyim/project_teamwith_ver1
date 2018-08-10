package com.teamwith.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamwith.bean.MemberBean;
import com.teamwith.dao.PologServiceDao;
import com.teamwith.vo.PologVO;
import com.teamwith.vo.PortfolioBean;
import com.teamwith.vo.PortfolioContentElementVO;

public class PologController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String dispatcherUrl = "";
		String[] uri = request.getRequestURI().split("/");
		String lastUrl = uri[uri.length - 1];
		PologServiceDao ps = PologServiceDao.getInstance();

		if (lastUrl.equals("portfolioRegister.do")) {
			dispatcherUrl = "portfolioRegister.jsp";
		} 
		else if (lastUrl.equals("portfolioAdd.do")) {

			 String title=request.getParameter("portfolio_title");
			 String intro=request.getParameter("portfolio_intro");
			 String team=request.getParameter("portfolio_team_name"); 
			 String role=request.getParameter("portfolio_role"); 
			  String start=request.getParameter("portfolio_start_date");
			  String end=request.getParameter("portfolio_end_date");
			  String people=request.getParameter("portfolio_people_num");
			  String work=request.getParameter("portfolio_work");
			  String skill=request.getParameter("portfolio_skill");
			  PortfolioBean pb=new PortfolioBean("portfolio-5",title,intro,team,role); 
			  String t="프로젝트 소개 : "+intro+"<br>시작 일자 : "+start+"<br>종료 일자 : "+end+" <br>역할 : "+role+"<br>팀 이름 : "+team+"<br>참여 인원 : "+people+" 명<br>업무 내용 : "+work+"<br>사용 기술 : "+skill;
			 
			  List<List<PortfolioContentElementVO>> list=new
			  ArrayList<List<PortfolioContentElementVO>>();
			  System.out.println(t);
			  System.out.println("언녕");
			  PortfolioContentElementVO a1=new
			  PortfolioContentElementVO("jongseung1","portfolio-1","element-1",
			  "layout-1","sh2","이미지","cat.jpg",1); PortfolioContentElementVO
			  a2=new
			  PortfolioContentElementVO("jongseung1","portfolio-1","element-2",
			  "layout-2","sh2","동영상",
			  "https://www.youtube.com/embed/ufsrgE0BYf0?ecver=1",1);
			  PortfolioContentElementVO a3=new
			  PortfolioContentElementVO("jongseung1","portfolio-1","element-3",
			  "layout-3","lh1","텍스트",t,2); list.add(new
			  ArrayList<PortfolioContentElementVO>()); list.add(new
			 ArrayList<PortfolioContentElementVO>()); list.get(0).add(a1);
			  list.get(0).add(a2); list.get(1).add(a3);
			  System.out.println("dd");
			  System.out.println(list.get(1).get(0).getLayoutId());
			  
			  request.setAttribute("portfolio", pb);
			  
			  request.setAttribute("portfolioContentElementList",list);
			  dispatcherUrl="dd.jsp";
			 
		} else if (lastUrl.equals("portfolioDelete.do")) {
			System.out.println("포트폴리오 삭제!");
			String str = request.getParameter("dd");
			if (str != null) {
				request.setAttribute("message", "삭제성공");
			} else {
				request.setAttribute("message", "삭제실패");
			}
			System.out.println((String) request.getAttribute("message"));
			dispatcherUrl = "main.jsp";
		}

		else if (lastUrl.equals("portfolioUpdate.do")) {
			System.out.println("포트폴리오 수정!");

		}

		else if (lastUrl.equals("pologUpdate.do")) {
			String requestMemberId;
			MemberBean m =(MemberBean)(request.getSession().getAttribute("memberBean"));
			requestMemberId = m.getMemberId();

			System.out.println(requestMemberId);
			PologVO polog = ps.searchPolog(requestMemberId);
			System.out.println("pol title:" + request.getParameter("polog_title"));

			request.setAttribute("myTitle", request.getParameter("polog_title"));
			polog.setPologTitle(request.getParameter("polog_title"));
			if (polog.getPologMenuPosition().equals("l1")) {
				polog.setPologMenuPosition("r1");
			} else {
				polog.setPologMenuPosition("l1");
			}
			request.setAttribute("color", request.getParameter("theme_color"));

			ps.updatePologInfo(requestMemberId, polog);

			dispatcherUrl="polog.do";

			// polog.setPologThemeColor(request.getParameter("theme_color"));

		} else if (lastUrl.equals("pologEdit.do")) {
			System.out.println("pologCont 103");
			PologVO pologInfo = ps.searchPolog("kyujin1");
			request.setAttribute("polog", pologInfo);
			request.setAttribute("PologEdit", "true");
			dispatcherUrl="polog.do";
		}
		RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);

	}

}