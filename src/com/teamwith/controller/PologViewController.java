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
			System.out.println("��Ʈ������ ��ȸ!");
			List<List<PortfolioContentElementVO>> list=new ArrayList<List<PortfolioContentElementVO>>();
			PortfolioContentElementVO a1=new PortfolioContentElementVO("jongseung1","portfolio-1","element-1","layout-1","sh2","�̹���","cat.jpg",1);
			PortfolioContentElementVO a2=new PortfolioContentElementVO("jongseung1","portfolio-1","element-2","layout-2","sh2","������","https://www.youtube.com/embed/ufsrgE0BYf0?ecver=1",1);
			PortfolioContentElementVO a3=new PortfolioContentElementVO("jongseung1","portfolio-1","element-3","layout-3","lh1","�ؽ�Ʈ","�ȳ��ϼ��� ��� ������ ���������� �����ߴ� ������Ʈ�Դϴ�. ��������Ʈ�� ������ ����� "
					+ "�����κ��� Scala�� ���� ������ Ŀ�� �� ���ݾ� ������. ������, ������ Scala�� ���������� ������ ��ʴ� ���� ���� �� ����. �׷���, Scala�� ������ ���� � ������ �ڵ��� �ϴ� ���� ���ؼ�, �׵��� ��� �͵��� �����غ����� �Ѵ�."
					+"1. Java�� ȣȯScala�� compile language�̴�. compile�� �ϸ�, Java Virtual Machine(JVM)�󿡼� �����ϴ� byte code�� ���������. �̹� ������ VM�̶� �� �� �ִ� JVM���� �����ϱ� ������, ruby�� python�� VM�� �ʿ�� �ϴ� �ٸ� ��� ��� ���ϸ� �������̴�. �Դٰ� compile ����̱� ������ �̷��� interpret ���� ������.Scala�� JVM���� �����ϸ鼭, Java�� ������ ���� �����ϱ� ������ Java�� ��� ���̺귯���� �״�� ����� �� �ִ�. ������ Java�� �� open source ���̺귯������ ��� Scala�� ���̺귯���̱⵵ �� ���̴�!2. ���� ���꼺(productivity)Scala�� object oriented language�̸鼭 ���ÿ� functional language�̴�. object oriented ������� �ϴٰ��� �ʿ��� ���, functional language���� �͵��� ���� �� �� �ִ�. �̰��� ��ġ, �߱������� ¥����� �԰��� ���¸� �Ĵ翡�� ��︱ ���� Ƽ��̽� �ɟ��� �Ľ����� �Դ� �Ϳ� ������ �� �ְڴ�.�׷���, Scala���� �����ϰ� ���̴� functional language���� feature ����� �Ұ����ڴ�",2);
			list.add(new ArrayList<PortfolioContentElementVO>());
			list.add(new ArrayList<PortfolioContentElementVO>());
			list.get(0).add(a1);
			list.get(0).add(a2);
			list.get(1).add(a3);
			
			request.setAttribute("portfolioContentElementList",list);
			String id=request.getParameter("portfolio_id");
			String title=request.getParameter("portfolio_title");
			PortfolioBean pb=new PortfolioBean(id,title,"�ȳ��ϼ��� ��� ������ ���������� �����ߴ� ������Ʈ�Դϴ�. ��������Ʈ�� ������ ����� "
					+ "�����κ��� Scala�� ���� ������ Ŀ�� �� ���ݾ� ������. ������, ������ Scala�� ���������� ������ ��ʴ� ���� ���� �� ����. �׷���, Scala�� ������ ���� � ������ �ڵ��� �ϴ� ���� ���ؼ�, �׵��� ��� �͵��� �����غ����� �Ѵ�."
					+"1. Java�� ȣȯScala�� compile language�̴�. compile�� �ϸ�, Java Virtual Machine(JVM)�󿡼� �����ϴ� byte code�� ���������. �̹� ������ VM�̶� �� �� �ִ� JVM���� �����ϱ� ������, ruby�� python�� VM�� �ʿ�� �ϴ� �ٸ� ��� ��� ���ϸ� �������̴�. �Դٰ� compile ����̱� ������ �̷��� interpret ���� ������.Scala�� JVM���� �����ϸ鼭, Java�� ������ ���� �����ϱ� ������ Java�� ��� ���̺귯���� �״�� ����� �� �ִ�. ������ Java�� �� open source ���̺귯������ ��� Scala�� ���̺귯���̱⵵ �� ���̴�!2. ���� ���꼺(productivity)Scala�� object oriented language�̸鼭 ���ÿ� functional language�̴�. object oriented ������� �ϴٰ��� �ʿ��� ���, functional language���� �͵��� ���� �� �� �ִ�. �̰��� ��ġ, �߱������� ¥����� �԰��� ���¸� �Ĵ翡�� ��︱ ���� Ƽ��̽� �ɟ��� �Ľ����� �Դ� �Ϳ� ������ �� �ְڴ�.�׷���, Scala���� �����ϰ� ���̴� functional language���� feature ����� �Ұ����ڴ�","FastBooster","DB����");
			request.setAttribute("list", list);
			request.setAttribute("portfolio",pb);
			dispatcherUrl="dd.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);
	}

}
