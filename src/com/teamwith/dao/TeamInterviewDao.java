package com.teamwith.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.teamwith.db.ConnectDB;
import com.teamwith.vo.ApplicationSimpleVO;

public class TeamInterviewDao {
	private static TeamInterviewDao teamInterviewDao;
	
	static {
		teamInterviewDao = new TeamInterviewDao();
	}
	
	private TeamInterviewDao() {
	}

	public static TeamInterviewDao getInstance() {
		return teamInterviewDao;
	}
	
	public boolean isNull(Object[] params) {
		for(Object param : params) {
			if(param == null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 테이블명을 파라미터로 받아서 해당 테이블 키의 최대값에 1 더한 값을 리턴한다.
	 */
	private String generateId(String tbName) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String max = null;
		int temp = -1;
		boolean check = true;
		try {
			con = ConnectDB.connect();
			pstmt = con.prepareStatement(
					"select " + tbName + "_id from " + tbName + "_tb order by " + tbName + "_id desc ");
			res = pstmt.executeQuery();
			while (res.next()) {
				max = res.getString(1);
				max = max.split("-")[1];
				if(temp < Integer.parseInt(max)) {
					temp = Integer.parseInt(max);
				}
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
		return tbName + "-" + (temp + 1);
	}

	/**
	 * 팀 지원 정보 등록하기<br>
	 * return 0: 성공적으로 지원이 완료된 경우, 1: DB Connect/Network 오류, 2: Parameter가 Null인 경우, 3: 지원 등록에 실패한 경우<br>
	 * INSERT INTO application_tb (application_id, member_id, application_freewriting, team_id, role_id) VALUES (?, ?, ?, ?, ?)
	 */
	public int addApplicationInfo(String memberId, String applicationFreewriting, String teamId, String roleId) {
		
		if(isNull(new String[] {memberId, teamId, roleId})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		
		String applicationId = generateId("application");
		try {
			pstmt = con.prepareStatement("INSERT INTO application_tb (application_id, member_id, application_freewriting, team_id, role_id) VALUES (?, ?, ?, ?, ?)");
			pstmt.setString(1, applicationId);
			pstmt.setString(2, memberId);
			pstmt.setString(3, applicationFreewriting);
			pstmt.setString(4, teamId);
			pstmt.setString(5, roleId);
			
			if(pstmt.executeUpdate() == 1) {
				ConnectDB.close(con, pstmt);
				return 0;
			}
		}
		catch (SQLException e) {
			ConnectDB.close(con, pstmt);
			e.printStackTrace();
			return 1;
		}
		ConnectDB.close(con, pstmt);
		return 3;		
	}

	/**
	 * 팀 지원 정보(면접 답변) 등록하기<br>
	 * return 0: 성공적으로 지원이 완료된 경우, 1: DB Connect/Network 오류, 2: Parameter가 Null인 경우, 3: 지원 등록에 실패한 경우<br>
	 * INSERT INTO interview_answer_tb VALUES (?, ?, ?, ?)
	 */
	public int addInterviewAnswer(String interviewQuestionId, String applicationId, String interviewAnswerContent) {
		
		if(isNull(new String[] {interviewQuestionId, applicationId, interviewAnswerContent})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		
		String interviewAnswerId = generateId("interview_answer");
		
		try {
			pstmt = con.prepareStatement("INSERT INTO interview_answer_tb VALUES (?, ?, ?, ?)");
			pstmt.setString(1, interviewAnswerId);
			pstmt.setString(2, interviewQuestionId);
			pstmt.setString(3, applicationId);
			pstmt.setString(4, interviewAnswerContent);
			
			if(pstmt.executeUpdate() == 1) {
				ConnectDB.close(con, pstmt);
				return 0;
			}
		} 
		catch (SQLException e) {
			ConnectDB.close(con, pstmt);
			e.printStackTrace();
			return 1;
		}
		ConnectDB.close(con, pstmt);
		return 3;
	}

	/**
	 * 면접 질문 등록하기<br>
	 * return 0: 성공적으로 지원이 완료된 경우, 1: DB Connect/Network 오류, 2: Parameter가 Null인 경우, 3: 지원 등록에 실패한 경우<br>
	 * insert into interview_question_tb values(인터뷰질문아이디, 팀아이디, ?인터뷰질문);
	 */
	public int addInterviewQuestion(String teamId, String interviewQuestionContent) {
		
		if(isNull(new String[] {teamId, interviewQuestionContent})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		
		String interviewQuestionId = generateId("interview_question");
		
		try {
			pstmt = con.prepareStatement("INSERT INTO interview_question_tb VALUES (?, ?, ?)");
			pstmt.setString(1, interviewQuestionId);
			pstmt.setString(2, teamId);
			pstmt.setString(3, interviewQuestionContent);
			
			if(pstmt.executeUpdate() == 1) {
				ConnectDB.close(con, pstmt);
				return 0;
			}
		}
		catch (SQLException e) {
			ConnectDB.close(con, pstmt);
			e.printStackTrace();
			return 1;
		}
		ConnectDB.close(con, pstmt);
		return 3;
	}

	/**
	 * 간단 면접 정보 불러오기<br>
	 * SELECT interview_question_content FROM interview_question_tb WHERE team_id=?
	 */
	public List<String> searchInterviewQuestionContent(String teamId) {
		
		if(isNull(new String[] {teamId})) {
			return null;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		List<String> list = new ArrayList<String>();
		
		try {
			pstmt = con.prepareStatement("SELECT interview_question_content FROM interview_question_tb WHERE team_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(1, teamId);
			res = pstmt.executeQuery();
			System.out.println(res.getRow());
			if(!res.next()) {
				return null;
			}
			else {
				res.previous();
				System.out.println(res.getRow());
				while(res.next()) {
					
					System.out.println(res.getRow());
					list.add(res.getString(1));
				}
				ConnectDB.close(con, pstmt, res);
				return list;
			}
		} 
		catch (SQLException e) {
			ConnectDB.close(con, pstmt, res);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 나의 지원 내역 불러오기<br>
	 * SELECT * FROM application_simple_view WHERE member_id=?
	 */
	public List<ApplicationSimpleVO> getMyApplicationList(String memberId) {
		
		if(isNull(new String[] {memberId})) {
			return null;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM application_simple_view WHERE member_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(1, memberId);
			
			res = pstmt.executeQuery();
			
			if(!res.next()) {
				return null;
			}
			else {
				List<ApplicationSimpleVO> list = new ArrayList<ApplicationSimpleVO>();
				res.previous();
				while(res.next()) {
					String myId = res.getString(1);
					String teamPic = res.getString(2);
					String teamName = res.getString(3);
					String roleId = res.getString(4);
					Timestamp applicationDate = res.getTimestamp(5);
					int applicationStatus = res.getInt(6);
					String applicationFreewriting = res.getString(7);
							
					ApplicationSimpleVO obj = new ApplicationSimpleVO(myId, teamPic, teamName, roleId, applicationDate, applicationStatus, applicationFreewriting);
					list.add(obj);
				}
				ConnectDB.close(con, pstmt, res);
				return list;
			}
			
		} catch (SQLException e) {
			ConnectDB.close(con, pstmt, res);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 팀 등록 정보 수정하기<br>
	 * return 0: 성공적으로 지원이 완료된 경우, 1: DB Connect/Network 오류, 2: Parameter가 Null인 경우, 3: 지원 등록에 실패한 경우<br>
	 * UPDATE team_tb set ~;
	 */
	public int updateTeamInfo(String teamId, String projectName, String teamName, String teamSummary, String teamContent, String projectCategoryId, String regionId, Timestamp teamEndDate, int teamStatus, Timestamp teamUpdateDate, String teamPic, String teamContestName, String teamContestLink, String memberId) {
		
		if(isNull(new Object[] {teamId, projectName, teamName, teamSummary, teamContent, projectCategoryId, regionId, teamEndDate, teamStatus, teamUpdateDate, teamPic, teamContestName, teamContestLink, memberId})) {
			return 2;
		}
		
		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement("UPDATE team_tb SET team_project_name=?, team_name=?, team_summary=?, team_content=?, project_category_id=?, region_id=?, team_end_date=?, team_status=?, team_update_date=?, team_pic=?, team_contest_name=?, team_contest_link=? WHERE team_id=? AND member_id=?");
			pstmt.setString(1, projectName);
			pstmt.setString(2, teamName);
			pstmt.setString(3, teamSummary);
			pstmt.setString(4, teamContent);
			pstmt.setString(5, projectCategoryId);
			pstmt.setString(6, regionId);
			pstmt.setTimestamp(7, teamEndDate);
			pstmt.setInt(8, teamStatus);
			pstmt.setTimestamp(9, teamUpdateDate);
			pstmt.setString(10, teamPic);
			pstmt.setString(11, teamContestName);
			pstmt.setString(12, teamContestLink);
			pstmt.setString(13, teamId);
			pstmt.setString(14, memberId);
			
			if(pstmt.executeUpdate() == 1) {
				ConnectDB.close(con, pstmt);
				return 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(con, pstmt);
			return 1;
		}
		ConnectDB.close(con, pstmt);
		return 3;
	}
}
