package com.teamwith.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.teamwith.db.ConnectDB;
import com.teamwith.vo.PologVO;
import com.teamwith.vo.PortfolioContentElementVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.PortfolioVO;

public class PologServiceDao {
	
	private static PologServiceDao pologServiceDao;
	static {
		pologServiceDao = new PologServiceDao();
	}
	
	private PologServiceDao(){
		
	}
	public static PologServiceDao getInstance(){
		return pologServiceDao;
	}
	public boolean isNull(Object[] params) {
	     for(Object param : params) {
		       if(param == null) return true;
		    }
		    return false;
		 }

	/**
	 * 4<br>
	 * 업데이트 순으로 포트폴리오 간략 정보를 최근날짜 date로부터 number개만큼 반환한다.<br>
	 * select * from portfolio_simple_view(update 날짜 포함하기) order by portfolio_update_date;<br>
	 * PortfolioSimpleVO(String memberName, String memberId, String portfolioId, Timestamp portfolioUpdateDate,
			String portfolioTitle, String portfolioPic, String portfolioBest, String projectCategoryId)
	 */
	public List<PortfolioSimpleVO> searchRecentPortfolio(Timestamp date, int number) {
		if(isNull(new Object[]{date})){
			return null;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List<PortfolioSimpleVO> list=new ArrayList<PortfolioSimpleVO>();
		PortfolioSimpleVO portfolioSimple=null;
		boolean check=true;
		int count=0;
		try{
			//일단은 count로 함 sql로 변경하기
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("select * from portfolio_simple_view order by portfolio_update_date");
			res=pstmt.executeQuery();
			while(res.next()&&count<4){
				portfolioSimple=new PortfolioSimpleVO(res.getString(1),res.getString(2),res.getString(3),res.getTimestamp(4),res.getString(5),
						res.getString(6),res.getString(7),res.getString(8));
				list.add(portfolioSimple);
				count++;
			}
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, pstmt, res);
			if(!check)
				return null;
		}
		return list;
		
	}
	
	/**
	 * 4<br>
	 * 업데이트 순으로 포트폴리오 간략 정보를 반환한다.<br>
	 * select * from portfolio_simple_view(update 날짜 포함하기) order by portfolio_update_date;<br>
	 * SimplePortfolio(memberName:String, portfolioTitle:String, portfolioPic:String, portfolioId:String, portfolioUpdateDate:TimeStamp)
	 */
	public List<PortfolioSimpleVO> searchRecentPortfolio() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		PortfolioSimpleVO portfolioSimple=null;
		List<PortfolioSimpleVO> list=new ArrayList<PortfolioSimpleVO>();
		boolean check=true;
		try {
			con=ConnectDB.connect();
			System.out.println(con);
			pstmt=con.prepareStatement("select * from portfolio_simple_view order by portfolio_update_date");
			res=pstmt.executeQuery();
			while(res.next()){
				portfolioSimple=new PortfolioSimpleVO(res.getString(1),res.getString(2),res.getString(3),res.getTimestamp(4),res.getString(5)
						,res.getString(6),res.getString(7),res.getString(8));
				list.add(portfolioSimple);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			check=false;
		}
		finally{
			ConnectDB.close(con, pstmt, res);
			if(!check){
				return null;
			}
		}
		return list;
	}
	/**
	 * 48. 폴로그 메인화면   79. 폴로그 꾸미기 화면<br>
	 * 저장되어 있는 폴로그 정보 불러오기, 비공개여부 체크<br>
	 * select * from polog_tb;<br>
	 * select member_public from member_tb where member_id='';<br>
	 * PologVO: polog_tb 그대로 가져오기
	 * */
	public PologVO searchPolog(String memberId){
		if(isNull(new Object[]{memberId})){
			return null;	
		}
		if(MemberServiceDao.getInstance().isPublic(memberId)!=0){
			return null;
		}
		
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet res=null;
			PologVO polog=null;
			boolean check=true;
		try{
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("select * from polog_tb where member_id=?");
			pstmt.setString(1, memberId);
			res=pstmt.executeQuery();
			while(res.next()){
				polog=new PologVO(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),
						res.getString(6),res.getString(7),res.getString(8),res.getString(9));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			check=false;
		}
		finally{
			ConnectDB.close(con, pstmt, res);
			if(!check)
				return null;
		}
		return polog;
				
	}
	
	/**
	 * 48. 폴로그 메인화면<br>
	 * 저장되어 있는 대표 포트폴리오 불러오기<br>
	 * select *, portfolio_update_date from portfolio_simple_view;<br>
	 * PortfolioSimpleVO: 대표 포트폴리오 목록, portfolio_simple_view 그대로 가져오기
	 * */
	public List<PortfolioSimpleVO> searchMemberPortfolio(String memberId){
		if(isNull(new Object[]{memberId})|| MemberServiceDao.getInstance().isMember(memberId) != 0){
			return null;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		PortfolioSimpleVO portfolioSimple=null;
		List<PortfolioSimpleVO> list=new ArrayList<PortfolioSimpleVO>();
		boolean check=true;
		try{
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("select * from portfolio_simple_view where member_id=? and portfolio_best=1");
			pstmt.setString(1, memberId);
			res=pstmt.executeQuery();
			while(res.next()){
				portfolioSimple=new PortfolioSimpleVO(res.getString(1),res.getString(2),res.getString(3),res.getTimestamp(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8));
				list.add(portfolioSimple);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, pstmt, res);
			if(!check)
				return null;
		}
		return list;
	}
	/**
	 * 74<br>
	 * 입력된 포트폴리오 정보를 저장하기<br>
	 * insert into portfolio_tb values(?,?,?,?,?,?,?,?,?,?,systimestamp,?,?,?);<br>
	 * 0 :성공, 1 :DB 오류 , 2 :param 오류
	 */
	public int addMemberPortfolio(String memberId,String portfolioTitle,String portfolioProjectIntro,Timestamp portfolioStartDate,
			Timestamp portfolioEndDate,String portfolioTeamName,int portfolioPeopleNum,String portfolioRole,
			String portfolioWork,String portfolioSkill,int portfolioBest,
			String portfolioPic,String projectCategoryId) {
		
		if(isNull(new Object[]{portfolioTitle,portfolioSkill,projectCategoryId })
				||portfolioBest<0||portfolioBest>1|| MemberServiceDao.getInstance().isMember(memberId) != 0){
			return 2;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean check=true;
		try{
			con=ConnectDB.connect();
			String key=this.generateId("portfolio");
			pstmt=con.prepareStatement("insert into portfolio_tb values(?,?,?,?,?,?,?,?,?,?,systimestamp,?,?,?)");
			pstmt.setString(1, key);
			pstmt.setString(2, portfolioTitle);
			pstmt.setString(3, portfolioProjectIntro);
			pstmt.setTimestamp(4,portfolioStartDate);
			pstmt.setTimestamp(5,portfolioEndDate);
			pstmt.setString(6,portfolioTeamName);
			pstmt.setInt(7,portfolioPeopleNum);
			pstmt.setString(8,portfolioRole);
			pstmt.setString(9,portfolioWork);
			pstmt.setString(10,portfolioSkill);
			
			pstmt.setInt(11, portfolioBest);
			pstmt.setString(12, portfolioPic);
			pstmt.setString(13, projectCategoryId);
			int r=pstmt.executeUpdate();
			
			
			if(r==1){
				pstmt.close();
				pstmt=con.prepareStatement("insert into member_portfolio_tb values(?,?)");
				pstmt.setString(1, memberId);
				pstmt.setString(2, key);
				pstmt.executeUpdate();
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
			
		}
		finally{
			ConnectDB.close(con, pstmt);
			if(!check)
				return 1;	
		}
		return 0;
		
	}
	/**
	 * 74<br>
	 * 입력된 포트폴리오 정보를 저장하기(요소저장)<br>
	 * insert into element_tb values(?,?,?,?)<br>
	 * 0 :성공, 1 :DB 오류 , 2 :param 오류
	 */
	public int addMemberPortfolioContent(String portfolioId,int contentOrder,String layoutId,String elementName,String elementContent) {
		
		if(isNull(new Object[]{portfolioId,layoutId,elementName,elementContent })
				||contentOrder<1||contentOrder<=this.getLastOrder(portfolioId)){
			return 2;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		boolean check=true;
		try{
			con=ConnectDB.connect();
			String key=this.generateId("element");
			pstmt=con.prepareStatement("insert into element_tb values(?,?,?,?)");
			pstmt.setString(1, key);
			pstmt.setString(2, layoutId);
			pstmt.setString(3, elementName);
			pstmt.setString(4, elementContent);
			int r=pstmt.executeUpdate();
			
			
			if(r==1){
				pstmt.close();
				pstmt=con.prepareStatement("insert into portfolio_content_tb values(?,?,?)");
				pstmt.setString(1, portfolioId);
				pstmt.setString(2, key);
				pstmt.setInt(3, contentOrder);
				pstmt.executeUpdate();
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
			
		}
		finally{
			ConnectDB.close(con, pstmt);
			if(!check)
				return 1;	
		}
		return 0;
		
	}
	/**
	 * 75. 77. 포트폴리오 상세화면    <br>
	 * 포트폴리오 번호로 저장되어있는 포트폴리오 정보를 모두 불러온다.<br>
	 * select * from portfolio_tb where portfolio_id = ?;<br>
	 * Portfolio : portfolio_detail_view 그대로 들고오기
	 * */
	public PortfolioVO searchPortfolioInfo(String portfolioId){
		if(isNull(new Object[]{portfolioId})){
			return null;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		PortfolioVO portfolio=null;
		boolean check=true;
		try{
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("select * from portfolio_tb where portfolio_id=?");
			pstmt.setString(1, portfolioId);
			res=pstmt.executeQuery();
			if(res.next()){
				portfolio=new PortfolioVO(res.getString(1),res.getString(2),res.getString(3),res.getTimestamp(4),
						res.getTimestamp(5),res.getString(6),res.getInt(7),res.getString(8),res.getString(9),
						res.getString(10),res.getTimestamp(11),res.getInt(12),res.getString(13),res.getString(14));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, pstmt, res);
			if(!check)
				return null;
		}
		return portfolio;
	}

	/**
	 * 75. 77. 포트폴리오 상세화면    <br>
	 * 포트폴리오 번호로 저장되어있는 포트폴리오 내용 정보를 모두 불러온다.<br>
	 * select * from portfolio_element_view where portfolio_id=?<br>
	 * PortfolioContentElementVO : portfolio_detail_view 그대로 들고오기
	 * */
	public List<PortfolioContentElementVO> searchPortfolioContent(String portfolioId){
		if(isNull(new Object[]{portfolioId})){
			return null;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		PortfolioContentElementVO portfolioContentElement=null;
		List<PortfolioContentElementVO> list=new ArrayList<PortfolioContentElementVO>();
		boolean check=true;
		try{
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("select * from portfolio_element_view where portfolio_id=?");
			pstmt.setString(1, portfolioId);
			res=pstmt.executeQuery();
			while(res.next()){
				portfolioContentElement=new PortfolioContentElementVO(res.getString(1),res.getString(2),
						res.getString(3),res.getString(4),res.getString(5),res.getString(6),"",res.getInt(7));
				list.add(portfolioContentElement);
			}
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, pstmt, res);
			if(!check)
				return null;
		}
		return list;
	}
	/**
	 * 76.포트폴리오 상세화면<br>
	 * 포트폴리오 번호로 포트폴리오를 삭제한다.<br>
	 * delete * from portfolio_tb where portfolio_id =?;
	 * 0 :성공, 1 :DB 오류 , 2 :param 오류
	 * */
	public int removePortfolio(String portfolioId){
		if(isNull(new Object[]{portfolioId})){
			return 2;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		int res=0;
		boolean check=true;
		try{
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("delete from portfolio_tb where portfolio_id =?");
			pstmt.setString(1,portfolioId);
			res=pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, pstmt);
			if(!check||res!=1)
				return 1;
		}
		return 0;
	}
	
	/**
	 * 76<br>
	 * 포트폴리오 수정<br>
	 * 포트폴리오의 엘리먼트 번호로 포트폴리오 컨텐트의 엘리먼트를 삭제한다.
	 * 0 :성공, 1 :DB 오류 , 2 :param 오류
	 * */
	public int removePortfolioContent(String elementId){
		if(isNull(new Object[]{elementId})){
			return 2;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		int res=0;
		boolean check=true;
		try{
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("delete from element_tb where element_id =?");
			pstmt.setString(1,elementId);
			res=pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, pstmt);
			if(!check||res!=1)
				return 1;
		}
		return 0;
	}
	/**
	 * 78.포트폴리오 상세화면<br>
	 * 포트폴리오 번호와 내용으로 포트폴리오 정보를 수정한다.<br>
	 * 0 :성공, 1 :DB 오류 , 2 :param 오류
	 * */
	public int updatePortfolio(String portfolioId, PortfolioVO portfolio){
		if(isNull(new Object[]{portfolioId,portfolio})){
			return 2;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		int res=0;
		boolean check=true;
		try{
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("update portfolio_tb set portfolio_title=?,portfolio_project_intro=?,"
					+ "portfolio_start_date=?,portfolio_end_date=?,portfolio_team_name=?,portfolio_people_num=?,"
					+ "portfolio_role=?,portfolio_work=?,portfolio_skill=?,portfolio_update_date=SYSTIMESTAMP,"
					+ "portfolio_best=?,portfolio_pic=?,project_category_id=? where portfolio_id=?");
			pstmt.setString(1, portfolio.getPortfolioTitle());
			pstmt.setString(2,portfolio.getPortfolioProjectIntro());
			pstmt.setTimestamp(3, portfolio.getPortfolioStartDate());
			pstmt.setTimestamp(4, portfolio.getPortfolioEndDate());
			pstmt.setString(5, portfolio.getPortfolioTeamName());
			pstmt.setInt(6, portfolio.getPortfolioPeopleNum());
			pstmt.setString(7, portfolio.getPortfolioRole());
			pstmt.setString(8, portfolio.getPortfolioWork());
			pstmt.setString(9, portfolio.getPortfolioSkill());
			pstmt.setInt(10, portfolio.getPortfolioBest());
			pstmt.setString(11,portfolio.getPortfolioPic());
			pstmt.setString(12, portfolio.getProjectCategoryId());
			pstmt.setString(13, portfolioId);
			res=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, pstmt);
			if(!check||res!=1)
				return 1;
			
		}
		return 0;
	}
	
	/**
	 * 78.포트폴리오 상세화면<br>
	 * 엘리먼트 번호와 내용으로 포트폴리오 컨텐트의 엘리먼트를 수정한다.<br>
	 * 0 :성공, 1 :DB 오류 , 2 :param 오류
	 * */
	public int updatePortfolio(String elementId, PortfolioContentElementVO portfolioContent){
		if(isNull(new Object[]{elementId,portfolioContent})){
			return 2;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		int res=0;
		boolean check=true;
		try{
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("update portfolio_content_tb set content_order=? where element_id=?");
			pstmt.setInt(1, portfolioContent.getContentOrder());
			pstmt.setString(2, portfolioContent.getElementId());
			int r=pstmt.executeUpdate();
			if(r==1){
				pstmt.close();
				pstmt=con.prepareStatement("update element_tb set layout_id=?,element_name=?,element_content=?"
						+ " where element_id=?");
				pstmt.setString(1, portfolioContent.getLayoutId());
				pstmt.setString(2, portfolioContent.getElementName());
				pstmt.setString(3, portfolioContent.getElementContent());
				pstmt.setString(4,elementId);
				System.out.println(portfolioContent);
				res=pstmt.executeUpdate();
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, pstmt);
			if(!check||res!=1)
				return 1;
			
		}
		return 0;
	}	
	/**
	 * 80. 폴로그 꾸미기 화면 <br>
	 * 저장되어 있는 폴로그 정보를 수정한다.<br>
	 * 0 :성공, 1 :DB 오류 , 2 :param 오류
	 * */
	public int updatePologInfo(String memberId, PologVO polog){
		if(isNull(new Object[]{memberId,polog})|| MemberServiceDao.getInstance().isMember(memberId) != 0){
			return 2;
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		int res=0;
		boolean check=true;
		try{
			con=ConnectDB.connect();
			pstmt=con.prepareStatement("update polog_tb set polog_title=?,polog_title_position=?,polog_title_pic=?,polog_theme_color=?"
					+ ",polog_bg_color=?,polog_bg_pic=?,polog_menu_position=?,polog_intro=? where member_id=?");
			pstmt.setString(1, polog.getPologTitle());
			pstmt.setString(2, polog.getPologTitlePosition());
			pstmt.setString(3, polog.getPologTitlePic());
			pstmt.setString(4, polog.getPologThemeColor());
			pstmt.setString(5, polog.getPologBgColor());
			pstmt.setString(6, polog.getPologBgPic());
			pstmt.setString(7, polog.getPologMenuPosition());
			pstmt.setString(8, polog.getPologIntro());
			pstmt.setString(9, polog.getMemberId());
			res=pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, pstmt);
			if(!check||res!=1)
				return 1;
			
		}
		return 0;
		
	}
	/**
	 * 포트폴리오 content의 마지막 order를 구하는 메소드
	 * -1:db오류 -2:null params
	 * */
	private int getLastOrder(String portfolioId){
		if(isNull(new Object[]{portfolioId})){
			return -2;
		}
		Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet res = null;
	      int last = 0;
	      boolean check = true;
	      try {
	         con = ConnectDB.connect();
	         pstmt = con.prepareStatement("select content_order from portfolio_content_tb where portfolio_id=? order by content_order desc");
	         pstmt.setString(1, portfolioId);
	         res = pstmt.executeQuery();
	         if (res.next()) {
	            last = res.getInt(1);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	         check = false;
	      } finally {
	         ConnectDB.close(con, pstmt, res);
	         if (!check)
	            return -1;
	      }
	      return last;
	}
	/**
	 * 마지막으로 생성된 포트폴리오의 키값 번호를 반환한다.<br>
	 * 1 : DB 오류 
	 * */
	  private String generateId(String tbName) {
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet res = null;
	      String max = null;
	      boolean check = true;
	      try {
	         con = ConnectDB.connect();
	         pstmt = con.prepareStatement("select " + tbName + "_id from " + tbName + "_tb order by " + tbName + "_id desc");
	         res = pstmt.executeQuery();
	         if (res.next()) {
	            max = res.getString(1);
	            max = max.split("-")[1];
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	         check = false;
	      } finally {
	         ConnectDB.close(con, pstmt, res);
	         if (!check)
	            return "DB오류";
	      }
	      
	      if(max == null) {
	         return tbName + "-" + 1;
	      }
	      return tbName + "-" + (Integer.parseInt(max) + 1);
	   }
}
