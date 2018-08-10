package com.teamwith.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamwith.vo.PortfolioBean;
import com.teamwith.vo.PortfolioContentElementVO;

public class PologViewController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String dispatcherUrl="";
		String[] uri = request.getRequestURI().split("/");
		String lastUrl = uri[uri.length - 1];
		
		if(lastUrl.equals("portfolioDetail.do")){
			System.out.println("포트폴리오 조회!");
			List<List<PortfolioContentElementVO>> list=new ArrayList<List<PortfolioContentElementVO>>();
			PortfolioContentElementVO a1=new PortfolioContentElementVO("jongseung1","portfolio-1","element-1","layout-1","sh2","이미지","cat.jpg",1);
			PortfolioContentElementVO a2=new PortfolioContentElementVO("jongseung1","portfolio-1","element-2","layout-2","sh2","동영상","https://www.youtube.com/embed/ufsrgE0BYf0?ecver=1",1);
			PortfolioContentElementVO a3=new PortfolioContentElementVO("jongseung1","portfolio-1","element-3","layout-3","lh1","텍스트","안녕하세요 경기 빅데이터 공모전에서 수상했던 프로젝트입니다. 이프로젝트는 빅데이터 기반의 "
					+ "주위로부터 Scala에 대한 관심이 커진 걸 조금씩 느낀다. 하지만, 아직도 Scala를 본격적으로 도입한 사례는 많지 않은 것 같다. 그래서, Scala의 장점과 실제 어떤 식으로 코딩을 하는 지에 대해서, 그동안 배운 것들을 공유해보려고 한다."
					+"1. Java와 호환Scala는 compile language이다. compile을 하면, Java Virtual Machine(JVM)상에서 동작하는 byte code가 만들어진다. 이미 검증된 VM이라 할 수 있는 JVM에서 동작하기 때문에, ruby나 python등 VM을 필요로 하는 다른 언어 등과 비교하면 안정적이다. 게다가 compile 언어이기 때문에 이러한 interpret 언어보다 빠르다.Scala는 JVM에서 동작하면서, Java의 문법과 아주 유사하기 때문에 Java의 모든 라이브러리를 그대로 사용할 수 있다. 수많은 Java로 된 open source 라이브러리들이 모두 Scala의 라이브러리이기도 한 것이다!2. 개발 생산성(productivity)Scala는 object oriented language이면서 동시에 functional language이다. object oriented 방식으로 하다가도 필요한 경우, functional language적인 것들을 섞어 쓸 수 있다. 이것은 마치, 중국집에서 짜장면을 먹고나서 이태리 식당에나 어울릴 법한 티라미슈 케잌을 후식으로 먹는 것에 비유할 수 있겠다.그러면, Scala에서 유용하게 쓰이는 functional language적인 feature 몇가지만 소개보겠다",2);
			list.add(new ArrayList<PortfolioContentElementVO>());
			list.add(new ArrayList<PortfolioContentElementVO>());
			list.get(0).add(a1);
			list.get(0).add(a2);
			list.get(1).add(a3);
			
			request.setAttribute("portfolioContentElementList",list);
			String id=request.getParameter("portfolio_id");
			String title=request.getParameter("portfolio_title");
			PortfolioBean pb=new PortfolioBean(id,title,"안녕하세요 경기 빅데이터 공모전에서 수상했던 프로젝트입니다. 이프로젝트는 빅데이터 기반의 "
					+ "주위로부터 Scala에 대한 관심이 커진 걸 조금씩 느낀다. 하지만, 아직도 Scala를 본격적으로 도입한 사례는 많지 않은 것 같다. 그래서, Scala의 장점과 실제 어떤 식으로 코딩을 하는 지에 대해서, 그동안 배운 것들을 공유해보려고 한다."
					+"1. Java와 호환Scala는 compile language이다. compile을 하면, Java Virtual Machine(JVM)상에서 동작하는 byte code가 만들어진다. 이미 검증된 VM이라 할 수 있는 JVM에서 동작하기 때문에, ruby나 python등 VM을 필요로 하는 다른 언어 등과 비교하면 안정적이다. 게다가 compile 언어이기 때문에 이러한 interpret 언어보다 빠르다.Scala는 JVM에서 동작하면서, Java의 문법과 아주 유사하기 때문에 Java의 모든 라이브러리를 그대로 사용할 수 있다. 수많은 Java로 된 open source 라이브러리들이 모두 Scala의 라이브러리이기도 한 것이다!2. 개발 생산성(productivity)Scala는 object oriented language이면서 동시에 functional language이다. object oriented 방식으로 하다가도 필요한 경우, functional language적인 것들을 섞어 쓸 수 있다. 이것은 마치, 중국집에서 짜장면을 먹고나서 이태리 식당에나 어울릴 법한 티라미슈 케잌을 후식으로 먹는 것에 비유할 수 있겠다.그러면, Scala에서 유용하게 쓰이는 functional language적인 feature 몇가지만 소개보겠다","FastBooster","DB설계");
			request.setAttribute("list", list);
			request.setAttribute("portfolio",pb);
			dispatcherUrl="dd.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);
	}

}
