package com.teamwith.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> urlList = null;
	public void init() {		
		urlList = new HashMap<String, Controller>();
		Controller homeController = new HomeController();
		Controller loginController = new LoginController();
		Controller teamViewController = new TeamViewController();
		Controller teamMemberController = new TeamMemberController();
		Controller teamController = new TeamController();
		Controller pologController = new PologController();
		Controller pologViewController = new PologViewController();
		Controller profileController = new ProfileController();
		urlList.put("/home.do", homeController);
		urlList.put("/login.do", loginController);
		//urlList.put("/polog.do", pologController);
		urlList.put("/myApplication.do", teamMemberController);
		urlList.put("/myTeam.do", teamViewController);
		urlList.put("/teamDetail.do", teamViewController);
		urlList.put("/portfolioDetail.do", pologViewController);
		urlList.put("/teamRegister.do", teamController);
		urlList.put("/myApplicant.do", teamMemberController);
		urlList.put("/polog/jsp/polog.do", profileController);
		urlList.put("/polog/jsp/profileEdit.do", profileController);
		urlList.put("/polog/jsp/profileUpdate.do", profileController);
		urlList.put("/polog/jsp/pologEdit.do", pologController);
		urlList.put("/polog/jsp/pologUpdate.do", pologController);
		urlList.put("/polog/jsp/portfolioRegister.do",pologController);
		urlList.put("/polog/jsp/portfolioAdd.do",pologController);
		urlList.put("/polog/jsp/portfolioDelete.do",pologController);
		urlList.put("/polog/jsp/portfolioDetail.do",pologViewController);
		System.out.println(getServletContext().getContextPath());
		
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = urlList.get(path);
		subController.execute(request, response);
	}
}
