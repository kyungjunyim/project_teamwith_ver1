package com.teamwith.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamwith.controller.Controller;


public class FirstController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String,Controller>list = null;
	public FirstController() {
	}

	public void init(ServletConfig sc) throws ServletException {
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/polog/jsp/polog.do", new ProfileController());
		list.put("/polog/jsp/profileEdit.do", new ProfileController());
		list.put("/polog/jsp/profileUpdate.do", new ProfileController());
		list.put("/polog/jsp/pologEdit.do", new PologController());
		list.put("/polog/jsp/pologUpdate.do", new PologController());
		list.put("/polog/jsp/portfolioRegister.do",new PologController());
	      list.put("/polog/jsp/portfolioAdd.do",new PologController());
	      list.put("/polog/jsp/portfolioDelete.do",new PologController());
	      list.put("/polog/jsp/portfolioDetail.do",new PologViewController());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println(request==null);

		String url = request.getRequestURI();
		//System.out.println(url);
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.execute(request, response);
	}
}
