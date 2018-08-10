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
	 * 받은 아이디가 탈퇴한 회원이 아닌지 검사한다<br>
	 * return - 0: 탈퇴한 회원이 아닌 경우, 1: DB Connect / Network 오류, 2: parameter가 null인 경우, 3: 탈퇴한 회원인 경우<br>
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
	 * 받은 아이디가 정보공개 회원인지 검사한다<br>
	 * return - 0: 정보 공개 회원인 경우, 1: DB Connect / Network 오류, 2: parameter가 null인 경우, 3: 정보 공개 회원이 아닌 경우<br>
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
	 * 받은 아이디가 활동회원인지 검사한다<br>
	 * return - 0: 활동 상태의 회원인 경우, 1: DB Connect / Network 오류, 2: parameter가 null인 경우, 3: 활동 상태가 아닌 회원인 경우<br>
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
	 * 아이디 중복 검사<br>
	 * return - 0: 중복이 아닌 경우, 1: DB Connect / Network 오류, 2: parameter가 null인 경우, 3: 중복인 경우<br>
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
	 * 이메일 중복 검사<br>
	 * return - 0: 중복이 아닌 경우, 1: DB Connect / Network 오류, 2: parameter가 null인 경우, 3: 중복인 경우<br>
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
	 * 입력된 계정 정보를 저장하기<br>
	 * return - 0: 계정 정보가 성공적으로 생성된 경우, 1: DB Connect / Network 오류, 2: parameter가 null인 경우, 3: 아이디가 중복인 경우, 4: 이메일이 중복인 경우<br>
	 * return - 5: 계정 정보가 생성되지 않은 경우, 6: 계정 정보가 생성되었으나, 폴로그 정보가 생성되지 않은 경우<br>
	 * insert into member_tb(member_id, member_name, member_password,member_email, member_birth,member_phone)
	 * values('jongseung1','김종승','k123456!','kimjong@gmail.com','930427','010-3298-3597');"
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
				// 폴로그 자동으로 생성하기
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
	 * 입력된 계정 정보로 폴로그 생성하기<br>
	 * return - 0: 정상적으로 생성된 경우, 1: DB Connect / Network 오류, 2: 정상적으로 처리되지 않은 경우<br>
	 * insert into polog_tb(member_id) values('?');
	 */
	private int addPolog(String memberId, String memberName) {
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
	
		try {
			pstmt = con.prepareStatement("INSERT INTO polog_tb (member_id, polog_title) VALUES (?, ?)");
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberName + "님의 폴로그");
			
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
	 * 입력된 이메일 주소, 생년월일을 비교하여 아이디 보여주기<br>
	 * return: 이메일 주소, 생년월일이 일치하면 아이디를 리턴 / 그렇지 않으면 null 리턴<br>
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
	 * 입력된 이메일 주소, 생년월일, 아이디를 비교하여 비밀번호 보여주기(Controller에서 이메일 보내기)<br>
	 * return: 이메일 주소, 생년월일, 아이디가 일치하면 아이디를 리턴 / 그렇지 않으면 null 리턴<br>
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
				// 임시 비밀번호 생성
				String temp = generateTempMemberPassword();
				
				// 임시 비밀번호로 비밀번호 변경
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
	 * 임시 비밀번호를 생성하는 함수<br>
	 * 숫자, 영문소문자, 영문대문자 10자로 임시 비밀번호 생성<br>
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
	 * 회원의 데이터 삭제(탈퇴) 하기<br>
	 * return - 0: 정상적으로 데이터 삭제, 1: DB Connect / Network 오류, 2: parameter가 null인 경우<br>
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
	 * 입력된 비밀번호로 회원의 비밀번호를 수정하기<br>
	 * return - 0: 정상적으로 비밀번호 수정, 1: DB Connect / Network 오류, 2: parameter가 null인 경우, 3: 비밀번호 수정 실패<br>
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
