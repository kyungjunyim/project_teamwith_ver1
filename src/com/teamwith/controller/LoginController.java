package com.teamwith.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamwith.bean.MemberBean;
import com.teamwith.dao.LoginServiceDao;
import com.teamwith.vo.MemberVO;

public class LoginController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Controller homeController = new HomeController();
		String job = request.getParameter("job");
		if (job != null) {
			if (job.equals("logout")) {
				HttpSession session = request.getSession();
				session.removeAttribute("memberBean");

				try {
					homeController.execute(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return;
			}
		}
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPassword");
		LoginServiceDao loginServiceDao = LoginServiceDao.getInstance();
		MemberVO memberVO = loginServiceDao.login(id, password);

		HttpSession session = request.getSession();
		session.setAttribute("memberBean",
				new MemberBean(memberVO.getMemberId(), memberVO.getMemberName(), memberVO.getMemberPic()));

		try {
			homeController.execute(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}