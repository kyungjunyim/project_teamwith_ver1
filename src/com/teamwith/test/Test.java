package com.teamwith.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teamwith.db.ConnectDB;

public class Test {

	public static void main(String[] args) {
		String id = "hong";
		String pwd = null;
		insert(id, pwd);
	}

	public static void insert(String id, String pwd) {
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO test2 VALUES (?, ?)");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(con, pstmt);
		}
	}
}
