package com.teamwith.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

import com.teamwith.db.ConnectDB;

public class MemberServiceDao {
	private static MemberServiceDao memberServiceDao;
	
	static {
		memberServiceDao = new MemberServiceDao();
	}
	private MemberServiceDao() {}
	
	public static MemberServiceDao getInstance() {
		return memberServiceDao;
	}
	
	public boolean isNull(String[] params) {
		for(String param : params) {
			if(param == null) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ���� ���̵� Ż���� ȸ���� �ƴ��� �˻��Ѵ�<br>
	 * return - 0: Ż���� ȸ���� �ƴ� ���, 1: DB Connect / Network ����, 2: parameter�� null�� ���, 3: Ż���� ȸ���� ���<br>
	 * select * from member_tb where member_auth=0;
	 */
	public int isMember(String memberId) {
		
		if(isNull(new String[] {memberId})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM member_tb WHERE member_id=? AND member_auth != -1");
			pstmt.setString(1, memberId);
			res = pstmt.executeQuery();
			
			if(!res.next()) {
				ConnectDB.close(con, pstmt, res);
				return 3;
			}
		}
		catch (SQLException e) {
			ConnectDB.close(con, pstmt, res);
			e.printStackTrace();
			return 1;
		}
		return 0;
	}

	/**
	 * ���� ���̵� �������� ȸ������ �˻��Ѵ�<br>
	 * return - 0: ���� ���� ȸ���� ���, 1: DB Connect / Network ����, 2: parameter�� null�� ���, 3: ���� ���� ȸ���� �ƴ� ���<br>
	 * SELECT * FROM member_tb WHERE member_id=? AND member_public=0
	 */ 
	public int isPublic(String memberId) {
		
		if(isNull(new String[] {memberId})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM member_tb WHERE member_id=? AND member_public != -1");
			pstmt.setString(1, memberId);
			res = pstmt.executeQuery();
			
			if(!res.next()) {
				ConnectDB.close(con, pstmt, res);
				return 3;
			}
		}
		catch (SQLException e) {
			ConnectDB.close(con, pstmt, res);
			e.printStackTrace();
			return 1;
		}
		return 0;
	}

	/**
	 * ���� ���̵� Ȱ��ȸ������ �˻��Ѵ�<br>
	 * return - 0: Ȱ�� ������ ȸ���� ���, 1: DB Connect / Network ����, 2: parameter�� null�� ���, 3: Ȱ�� ���°� �ƴ� ȸ���� ���<br>
	 * SELECT * FROM member_tb WHERE member_id=? AND member_active=0
	 */
	public int isActive(String memberId) {
		
		if(isNull(new String[] {memberId})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM member_tb WHERE member_id=? AND member_active != -1");
			pstmt.setString(1, memberId);
			res = pstmt.executeQuery();
			
			if(!res.next()) {
				ConnectDB.close(con, pstmt, res);
				return 3;
			}
		}
		catch (SQLException e) {
			ConnectDB.close(con, pstmt, res);
			e.printStackTrace();
			return 1;
		}
		return 0;		
	}
	
	/**
	 * ���̵� �ߺ� �˻�<br>
	 * return - 0: �ߺ��� �ƴ� ���, 1: DB Connect / Network ����, 2: parameter�� null�� ���, 3: �ߺ��� ���<br>
	 * "select * from member_tb where member_id='jongseung1';
	 */
	public int isIdDuplicated(String memberId) {
		
		if(isNull(new String[] {memberId})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM member_tb WHERE member_id=?");
			pstmt.setString(1, memberId);
			res = pstmt.executeQuery();
			
			if(!res.next()) {
				ConnectDB.close(con, pstmt, res);
				return 0;
			}
		}
		catch (SQLException e) {
			ConnectDB.close(con, pstmt, res);
			e.printStackTrace();
			return 1;
		}
		return 3;		
	}

	/**
	 * �̸��� �ߺ� �˻�<br>
	 * return - 0: �ߺ��� �ƴ� ���, 1: DB Connect / Network ����, 2: parameter�� null�� ���, 3: �ߺ��� ���<br>
	 * select * from member_tb where member_email='kimjong@gmail.com'
	 */
	public int isEmailDuplicated(String memberEmail) {
		
		if(isNull(new String[] {memberEmail})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM member_tb WHERE member_email=?");
			pstmt.setString(1, memberEmail);
			res = pstmt.executeQuery();
			
			if(!res.next()) {
				ConnectDB.close(con, pstmt, res);
				return 0;
			}
		}
		catch (SQLException e) {
			ConnectDB.close(con, pstmt, res);
			e.printStackTrace();
			return 1;
		}
		return 3;
	}

	/**
	 * �Էµ� ���� ������ �����ϱ�<br>
	 * return - 0: ���� ������ ���������� ������ ���, 1: DB Connect / Network ����, 2: parameter�� null�� ���, 3: ���̵� �ߺ��� ���, 4: �̸����� �ߺ��� ���<br>
	 * return - 5: ���� ������ �������� ���� ���, 6: ���� ������ �����Ǿ�����, ���α� ������ �������� ���� ���<br>
	 * insert into member_tb(member_id, member_name, member_password,member_email, member_birth,member_phone)
	 * values('jongseung1','������','k123456!','kimjong@gmail.com','930427','010-3298-3597');"
	 */
	public int addMember(String memberId, String memberName, String memberPassword, String memberEmail, String memberBirth, String memberPhone) {

		if(isNull(new String[] {memberId, memberName, memberPassword, memberEmail, memberBirth, memberPhone})) {
			return 2;
		}
		
		if(isIdDuplicated(memberId) == 3) {
			return 3;
		}
		if(isEmailDuplicated(memberEmail) == 3) {
			return 4;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		
		Timestamp time = Timestamp.valueOf(memberBirth + " 00:00:00");
		
		try {
			pstmt = con.prepareStatement("INSERT INTO member_tb (member_id, member_name, member_password, member_email, member_birth, member_phone) VALUES (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberName);
			pstmt.setString(3, memberPassword);
			pstmt.setString(4, memberEmail);
			pstmt.setTimestamp(5, time);
			pstmt.setString(6, memberPhone);
			
			
			if(pstmt.executeUpdate() == 1) {
				ConnectDB.close(con, pstmt);
				// ���α� �ڵ����� �����ϱ�
				if(addPolog(memberId, memberName) != 0) {
					return 6;
				}
				else {
					return 0;
				}
			}
		}
		catch (SQLException e) {
			ConnectDB.close(con, pstmt);
			e.printStackTrace();
			return 1;
		}
		ConnectDB.close(con, pstmt);
		return 5;
	}

	/**
	 * �Էµ� ���� ������ ���α� �����ϱ�<br>
	 * return - 0: ���������� ������ ���, 1: DB Connect / Network ����, 2: ���������� ó������ ���� ���<br>
	 * insert into polog_tb(member_id) values('?');
	 */
	private int addPolog(String memberId, String memberName) {
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
	
		try {
			pstmt = con.prepareStatement("INSERT INTO polog_tb (member_id, polog_title) VALUES (?, ?)");
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberName + "���� ���α�");
			
			if(pstmt.executeUpdate() == 1) {
				ConnectDB.close(con, pstmt);
				return 0;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(con, pstmt);
			return 1;
		}
		ConnectDB.close(con, pstmt);
		return 2;
	}

	/**
	 * �Էµ� �̸��� �ּ�, ��������� ���Ͽ� ���̵� �����ֱ�<br>
	 * return: �̸��� �ּ�, ��������� ��ġ�ϸ� ���̵� ���� / �׷��� ������ null ����<br>
	 * select member_id from member_tb where member_email=? and member_birth=?
	 */
	public String searchMemberId(String memberEmail, String memberBirth) {
		
		if(isNull(new String[] {memberEmail, memberBirth})) {
			return null;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement("SELECT member_id FROM member_tb WHERE member_email=? AND member_birth=?");
			pstmt.setString(1, memberEmail);
			Timestamp ts = Timestamp.valueOf(memberBirth + " 00:00:00"); 
			pstmt.setTimestamp(2, ts);
			
			res = pstmt.executeQuery();
			
			if(!res.next()) {
				ConnectDB.close(con, pstmt, res);
				return null;
			}
			else {
				return res.getString(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(con, pstmt);
			return null;
		}
	}

	/**
	 * �Էµ� �̸��� �ּ�, �������, ���̵� ���Ͽ� ��й�ȣ �����ֱ�(Controller���� �̸��� ������)<br>
	 * return: �̸��� �ּ�, �������, ���̵� ��ġ�ϸ� ���̵� ���� / �׷��� ������ null ����<br>
	 * select member_password from member_tb where member_email=? and member_id=? and member_birth=?
	 */
	public String searchMemberPassword(String memberEmail, String memberId, String memberBirth) {
		
		if(isNull(new String[] {memberEmail, memberId, memberBirth})) {
			return null;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement("SELECT member_id FROM member_tb WHERE member_email=? AND member_id=? AND member_birth=?");
			pstmt.setString(1, memberEmail);
			pstmt.setString(2, memberId);
			Timestamp ts = Timestamp.valueOf(memberBirth + " 00:00:00"); 
			pstmt.setTimestamp(3, ts);
			
			res = pstmt.executeQuery();
			
			if(!res.next()){
				ConnectDB.close(con, pstmt, res);
				return null;
			}
			else {
				con = ConnectDB.connect();
				
				String id = res.getString(1);
				// �ӽ� ��й�ȣ ����
				String temp = generateTempMemberPassword();
				
				// �ӽ� ��й�ȣ�� ��й�ȣ ����
				pstmt = con.prepareStatement("UPDATE member_tb SET member_password=? WHERE member_id=?");
				pstmt.setString(1, temp);
				pstmt.setString(2, id);
				
				if(pstmt.executeUpdate() == 1) {
					ConnectDB.close(con, pstmt, res);
					return temp;
				}
				else {
					ConnectDB.close(con, pstmt, res);
					return null;
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(con, pstmt);
			return null;
		}
	}
	
	/**
	 * �ӽ� ��й�ȣ�� �����ϴ� �Լ�<br>
	 * ����, �����ҹ���, �����빮�� 10�ڷ� �ӽ� ��й�ȣ ����<br>
	 * */
	private String generateTempMemberPassword() {
		
		StringBuffer temp = new StringBuffer();
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
		    int rIndex = random.nextInt(3);
		    switch (rIndex) {
		    case 0:
		        // a-z
		        temp.append((char)((int)(random.nextInt(26)) + 97));
		        break;
		    case 1:
		        // A-Z
		        temp.append((char)((int)(random.nextInt(26)) + 65));
		        break;
		    case 2:
		        // 0-9
		        temp.append((random.nextInt(10)));
		        break;
		    }
		}
		
		temp.trimToSize();
		
		return temp.toString();
	}
	
	/**
	 * ȸ���� ������ ����(Ż��) �ϱ�<br>
	 * return - 0: ���������� ������ ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���<br>
	 * */
	public int deleteMember(String memberId) {
		
		if(isNull(new String[] {memberId})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement("DELETE FROM member_project_category_tb WHERE member_id=?");
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("DELETE FROM member_skill_tb WHERE member_id=?");
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("DELETE FROM member_region_tb WHERE member_id=?");
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("DELETE FROM member_tendency_tb WHERE member_id=?");
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("DELETE FROM polog_tb WHERE member_id=?");
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("DELETE FROM career_tb WHERE member_id=?");
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("DELETE FROM license_tb WHERE member_id=?");
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("DELETE FROM member_portfolio_tb WHERE member_id=?");
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("UPDATE member_tb SET member_pic='', member_intro='', role_id='' WHERE member_id=?");
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
			
			ConnectDB.close(con, pstmt);
			return 0;
		}
		catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(con, pstmt);
			return 1;
		}
	}
	
	/**
	 * �Էµ� ��й�ȣ�� ȸ���� ��й�ȣ�� �����ϱ�<br>
	 * return - 0: ���������� ��й�ȣ ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���, 3: ��й�ȣ ���� ����<br>
	 * UPDATE member_tb SET member_password=? WHERE member_id=?;
	 */
	public int updatePassword(String memberId, String oldMemberPassword, String newMemberPassword) {
		
		if(isNull(new String[] {memberId, oldMemberPassword, newMemberPassword})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement("UPDATE member_tb SET member_password=? WHERE member_id=? AND member_password=?");
			pstmt.setString(1, newMemberPassword);
			pstmt.setString(2, memberId);
			pstmt.setString(3, oldMemberPassword);
			if(pstmt.executeUpdate() == 1) {
				ConnectDB.close(con, pstmt);
				return 0;
			}
			else {
				return 3;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(con, pstmt);
			return 1;
		}
	}
}
