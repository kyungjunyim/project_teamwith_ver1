package com.teamwith.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	
	public static Connection connect(){
		String conStr = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "fast";
		String pass = "3333";
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(conStr, user, pass);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return con;
	}
	public static void close(Connection con, Statement pstmt, ResultSet res){
		try {
			if(pstmt!=null) pstmt.close();
			if(res!=null) res.close();
			if(con!=null) con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void close(Connection con, Statement pstmt) {
		try{
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
