package com.teamwith.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamwith.dao.LoginServiceDao;
import com.teamwith.dao.PologServiceDao;
import com.teamwith.dao.ProfileServiceDao;
import com.teamwith.vo.MemberVO;
import com.teamwith.vo.PologVO;

@WebServlet("/ProfileController")
public class ProfileController implements Controller {
	private static final long serialVersionUID = 1L;

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String[] uri = request.getRequestURI().split("/");
		String lastUrl = uri[uri.length - 1];
		
		if (lastUrl.equals("profileEdit.do") || lastUrl.equals("polog.do")) {
			System.out.println("polog do invocation");
			LoginServiceDao ls = LoginServiceDao.getInstance();
			ProfileServiceDao ps = ProfileServiceDao.getInstance();
			PologServiceDao pos = PologServiceDao.getInstance();

			String memberId = request.getParameter("memberId");
			if (memberId == null) {
				memberId = ((MemberVO) request.getSession().getAttribute("pologOwner")).getMemberId();
			}
			PologVO pologInfo = pos.searchPolog(memberId);
			request.getSession().setAttribute("polog", pologInfo);
			MemberVO memberInfo = ls.login(memberId, "hwang1234");
			System.out.println("프콘56:"+memberId);
			if (memberId.equals("joran")) {
				memberInfo = ls.login(memberId, "jo1234");
			}

			List<String> regions = ps.searchMemberRegion(memberId);
			List<String> categories = ps.searchMemberProjectCategory(memberId);
			System.out.println(memberId);
			List<String[]> skillList = ps.searchMemberSkill(memberId);
			String[] skills = null;
			if (skillList != null) {
				skills = new String[skillList.size()];
				for (int i = 0; i < skillList.size(); i++) {
					skills[i] = skillList.get(i)[0];
				}
			}

			Map<String, Integer> tendencyMap = ps.searchMemberTendency(memberId);

			String[] tendencies = new String[5];
			for (int i = 0; i < 5; i++) {

				tendencies[i] = tendencyMap.get("tendency-" + (i + 1)) + "";
				System.out.println("프콘 80:"+tendencies[i]);
			}

			request.getSession().setAttribute("pologOwner", memberInfo);
			request.setAttribute("region", regions);
			request.setAttribute("category", categories);
			request.setAttribute("skill", skills);
			request.setAttribute("tendency", tendencies);
			if (lastUrl.equals("profileEdit.do")) {
				System.out.println("member_active:" + request.getParameter("member_active"));
				RequestDispatcher rd = request.getRequestDispatcher("profileEdit.jsp");
				rd.forward(request, response);
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("polog.jsp");
				rd.forward(request, response);
				return;
			}
		} else if (lastUrl.equals("profileUpdate.do")) {

			ProfileServiceDao ps = ProfileServiceDao.getInstance();

			for (String s : request.getParameterMap().keySet()) {
				System.out.println(s);
			}
			String memberId = request.getParameter("member_id");
			String file = request.getParameter("member_pic");
			String active = request.getParameter("member_pic");
			String[] regions = request.getParameterValues("region");

			if (regions != null) {
				ps.removeMemberRegion(memberId);
				for (String regionId : regions) {
					ps.addMemberRegion(regionId, memberId);
				}
			}
			String intro = request.getParameter("member_intro");
			String[] categories = request.getParameterValues("category");
			if (categories != null) {
				ps.removeMemberProjectCategory(memberId);
				ps.addMemberProjectCategory(categories, memberId);
			}
			String role = request.getParameter("member_role");
			String[] skills = request.getParameterValues("skill");
			if (skills != null) {
				ps.removeMemberSkill(memberId);
				ps.addMemberSkill(memberId, skills);
			}
			String tendency[] = new String[5];
			for (int i = 0; i < 5; i++) {
				tendency[i] = request.getParameter("tendency" + (i + 1));

				System.out.println("프콘140 :" + "tendency-" + (1 + i) + tendency[i]);
				if (tendency[i] != null) {
					System.out
							.println(ps.updateTendency(memberId, "tendency-" + (1 + i), Integer.parseInt(tendency[i])));

				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("polog.do");
			rd.forward(request, response);
			return;
		}
	}

}
