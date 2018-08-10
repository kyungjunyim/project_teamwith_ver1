package com.teamwith.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.teamwith.db.ConnectDB;
import com.teamwith.vo.LayoutVO;
import com.teamwith.vo.SkillRoleVO;
// system pre-loading에서 메인화면 들어오기 전에 준비할 데이터를 위한 DAO
public class TeamWithServiceDao {
	private static TeamWithServiceDao teamWithServiceDao;
	static {
		teamWithServiceDao = new TeamWithServiceDao();
	}
	private TeamWithServiceDao(){
		
	}
	public static TeamWithServiceDao getInstance(){
		return teamWithServiceDao;
	}
	
	/**
	 * 17<br>
	 * 카테고리 불러오기<br>
	 * select * from project_category_tb;
	 */
	public Map<String, String> getCategory() {
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		Map<String,String> list=new HashMap<String,String>();
		boolean check=true;
		try{
			con=ConnectDB.connect();
			stmt=con.createStatement();
			res=stmt.executeQuery("select * from project_category_tb");
			while(res.next()){
				list.put(res.getString(1), res.getString(2));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, stmt, res);
			if(!check)
				return null;
		}
		return list;

	}

	/**
	 * 17<br>
	 * 활동 지역 불러오기<br>
	 * select * from region_tb;
	 */
	public Map<String, String> getRegion() {
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		Map<String,String> list=new HashMap<String,String>();
		boolean check=true;
		try{
			con=ConnectDB.connect();
			stmt=con.createStatement();
			res=stmt.executeQuery("select * from region_tb");
			while(res.next()){
				list.put(res.getString(1), res.getString(2));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, stmt, res);
			if(!check)
				return null;
		}
		return list;

	}
	

	/**
	 * 17<br>
	 * 모집 분야 불러오기<br>
	 * select * from role_tb;
	 */
	public Map<String, String> getRole() {
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		Map<String,String> list=new HashMap<String,String>();
		boolean check=true;
		try{
			con=ConnectDB.connect();
			stmt=con.createStatement();
			res=stmt.executeQuery("select * from role_tb");
			while(res.next()){
				list.put(res.getString(1), res.getString(2));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, stmt, res);
			if(!check)
				return null;
		}
		return list;

	}
	

	/**
	 * 17<br>
	 * 기술 불러오기<br>
	 * select skill_id, skill_name, role_id from skill_tb inner join role_tb using (role_id);<br>
	 * SkillRoleVO = String skillId, String skillName, String roleId
	 */
	public List<SkillRoleVO> getSkillRole() {
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		List<SkillRoleVO> list=new ArrayList<SkillRoleVO>();
		
		boolean check=true;
		try{
			con=ConnectDB.connect();
			stmt=con.createStatement();
			res=stmt.executeQuery("select skill_id, skill_name, role_id from skill_tb inner join role_tb using (role_id)");
			while(res.next()){
				list.add(new SkillRoleVO(res.getString(1),res.getString(2),res.getString(3)));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, stmt, res);
			if(!check)
				return null;
		}
		return list;
	}
	public Map<String,String> getPraise(){
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		Map<String,String> list=new HashMap<String,String>();
		boolean check=true;
		try{
			con=ConnectDB.connect();
			stmt=con.createStatement();
			res=stmt.executeQuery("select * from praise_tb");
			while(res.next()){
				list.put(res.getString(1), res.getString(2));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, stmt, res);
			if(!check)
				return null;
		}
		return list;
	}
	public Map<String,String> getTendency(){
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		Map<String,String> list=new HashMap<String,String>();
		boolean check=true;
		try{
			con=ConnectDB.connect();
			stmt=con.createStatement();
			res=stmt.executeQuery("select * from tendency_tb");
			while(res.next()){
				list.put(res.getString(1), res.getString(2));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, stmt, res);
			if(!check)
				return null;
		}
		return list;
	}
	public Map<String,String> getPologLayout(){
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		Map<String,String> list=new HashMap<String,String>();
		boolean check=true;
		try{
			con=ConnectDB.connect();
			stmt=con.createStatement();
			res=stmt.executeQuery("select * from polog_layout_tb");
			while(res.next()){
				list.put(res.getString(1), res.getString(2));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, stmt, res);
			if(!check)
				return null;
		}
		return list;
	}
	public List<LayoutVO> getLayout(){
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		List<LayoutVO> list=new ArrayList<LayoutVO>();
		boolean check=true;
		try{
			con=ConnectDB.connect();
			stmt=con.createStatement();
			res=stmt.executeQuery("select * from layout_tb");
			while(res.next()){
				list.add(new LayoutVO(res.getString(1),res.getString(2),res.getString(3)));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			check=false;
		}finally{
			ConnectDB.close(con, stmt, res);
			if(!check)
				return null;
		}
		return list;
	}

	
}
