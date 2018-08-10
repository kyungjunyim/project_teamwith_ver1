package com.teamwith.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.teamwith.db.ConnectDB;
import com.teamwith.vo.ApplicantSimpleVO;
import com.teamwith.vo.FaqVO;
import com.teamwith.vo.InquiryMemberVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.RecruitRequireSkillVO;
import com.teamwith.vo.ReplySimpleVO;
import com.teamwith.vo.TeamDetailVO;
import com.teamwith.vo.TeamSimpleVO;

public class TeamServiceDao {
	private static TeamServiceDao teamServiceDao;
	static{
		teamServiceDao=new TeamServiceDao();
	}
	private TeamServiceDao(){}
	
	public static TeamServiceDao getInstance(){
		return teamServiceDao;
	}
	
	/**
	 * 2<br>
	 * �� ��ü��ȸ���� �� ���������� ������Ʈ ������ �ֱٳ�¥ date�κ��� number����ŭ ��ȯ�Ѵ�.<br>
	 * select * from team_simple_view(������Ʈ����Ʈ ����) select * from team_simple_view
	 * order by team_update_date desc; <<- �ֱټ����� fetch
	 */
	public List<TeamSimpleVO> searchRecentTeam(int number) {
		if (number < 0) {
			return null;
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TeamSimpleVO> result = new ArrayList<TeamSimpleVO>();
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select * from team_simple_view order by team_update_date desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String teamId = rs.getString("team_id");
				String teamName = rs.getString("team_name");
				String teamPic = rs.getString("team_pic");
				String teamProjectName = rs.getString("team_project_name");
				String projectCategoryId = rs.getString("project_category_id");
				Timestamp teamUpdateDate = rs.getTimestamp("team_update_date");
				String memberName = rs.getString("member_name");
				String memberId = rs.getString("member_id");
				TeamSimpleVO teamSimpleVo = new TeamSimpleVO(teamId, teamName, teamProjectName, teamPic, projectCategoryId,
						teamUpdateDate, memberName, memberId);
				result.add(teamSimpleVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}

		ConnectDB.close(conn, pstmt, rs);
		// fetch ����� �տ��� number����ŭ �߶� ��ȯ
		return result.subList(0, number);
	}

	/**
	 * 2<br>
	 * �� ��ü��ȸ���� �� ���������� ��ȯ�Ѵ�.<br>
	 * select * from team_simple_view(������Ʈ����Ʈ ����)
	 */
	public List<TeamSimpleVO> searchRecentTeam() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TeamSimpleVO> result = new ArrayList<TeamSimpleVO>();
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select * from team_simple_view order by team_update_date desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String teamId = rs.getString("team_id");
				String teamProjectName = rs.getString("team_project_name");
				String teamName = rs.getString("team_name");
				String teamPic = rs.getString("team_pic");
				String projectCategoryId = rs.getString("project_category_id");
				Timestamp teamUpdateDate = rs.getTimestamp("team_update_date");
				String memberName = rs.getString("member_name");
				String memberId = rs.getString("member_id");
				TeamSimpleVO teamSimpleVo = new TeamSimpleVO(teamId, teamName, teamProjectName, teamPic, projectCategoryId,
						teamUpdateDate, memberName, memberId);
				result.add(teamSimpleVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 11<br>
	 * �ڽ��� ����� ���� ��������<br>
	 * select * from team_simple_view where member_id='?' (select�� ��� ���̵�
	 * �߰�)<br>
	 * TeamSimpleVO:
	 * team_id,team_name,team_pic,project_category_name,member_name, member_id
	 */
	public List<TeamSimpleVO> searchMyTeam(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TeamSimpleVO> result = new ArrayList<TeamSimpleVO>();
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select * from team_simple_view where member_id=? order by team_update_date desc");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String teamId = rs.getString("team_id");
				String teamProjectName = rs.getString("team_project_name");
				String teamName = rs.getString("team_name");
				String teamPic = rs.getString("team_pic");
				String projectCategoryId = rs.getString("project_category_id");
				Timestamp teamUpdateDate = rs.getTimestamp("team_update_date");
				String memberName = rs.getString("member_name");
				TeamSimpleVO teamSimpleVo = new TeamSimpleVO(teamId, teamName, teamProjectName, teamPic, projectCategoryId,
						teamUpdateDate, memberName, memberId);
				result.add(teamSimpleVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 12<br>
	 * ���� ������ �� �� ���� ���°� '���� �Ϸ�'�� ���� ���� ��������<br>
	 * SELECT COUNT(*) FROM application_tb WHERE member_id=? AND
	 * application_status='���� �Ϸ�'; memberId�� null�� ��� -1����
	 */
	public int getApplicationCount(String memberId) {
		if (memberId == null) {
			return -1;
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select count(*) from application_tb where member_id=? and application_status='0'");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 16<br>
	 * ȸ���� ����(������ ���� ����, ���� ����, Ȱ�� ����)�� 'Ż�� ����'�� �����ϱ�, ���� ���°� '���� �Ϸ�'�� ��� '���'��
	 * �����ϱ�<br>
	 * UPDATE member_tb SET member_active=-1, member_public=-1, member_auth=-1,
	 * member_out_date=SYSTIMESTAMP WHERE member_id=?;<br>
	 * UPDATE application_tb SET application_status='���' WHERE member_id=? AND
	 * application_status='���� �Ϸ�';<br>
	 * DELETE FROM polog_tb WHERE member_id=?;
	 */
	public boolean removeMember(String memberId) {
		if (memberId == null) {
			return false;
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement(
					"update member_tb set member_active=-1, member_public=-1, member_auth=-1, member_out_date=? where member_id=?");
			pstmt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setString(2, memberId);
			result = pstmt.execute();

			pstmt = conn.prepareStatement(
					"update application_tb set application_status=3 where member_id=? and application_status=0");
			pstmt.setString(1, memberId);
			result = pstmt.execute();

			pstmt = conn.prepareStatement("delete from polog_tb where member_id=?");
			pstmt.setString(1, memberId);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 18<br>
	 * �� ��� ���� �����ϱ�<br>
	 * insert into team_tb values(�� ���̵�, ?������Ʈ��, ?���̸�, ?���Ұ�, ?���󼼼Ұ�, ?�о�id,
	 * ?Ȱ������id, ?����������¥, ��������, �ֱپ�����Ʈ��¥, ?���������, ?�����������̸�, ?����������url. ������̵�);
	 * null�� �Ӽ��� ���ڿ� �־���Ѵ�.
	 */
	public boolean addTeamInfo(String projectName, String teamName, String teamSummary, String teamContent,
			String projectCategoryId, String regionId, Timestamp teamRegisterDate, Timestamp teamEndDate,
			String teamPic, String teamContestName, String teamContestLink, String memberId) {
		if (isNull(new Object[] { projectName, teamName, teamName, teamSummary, teamContent, projectCategoryId,
				regionId, teamRegisterDate, teamEndDate, teamPic, teamContestName, teamContestLink, memberId })) {
			return false;
		};
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		String teamId = generateId("team");
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement(
					"insert into team_tb (team_id,team_project_name,team_summary,team_content,project_category_id,region_id,team_end_date,team_pic,team_contest_name,team_contest_link,member_id,team_name) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, teamId); // Ű�� �����ϱ�
			pstmt.setString(2, projectName);
			pstmt.setString(3, teamSummary);
			pstmt.setString(4, teamContent);
			pstmt.setString(5, projectCategoryId);
			pstmt.setString(6, regionId);
			pstmt.setTimestamp(7, teamEndDate);
			pstmt.setString(8, teamPic);
			pstmt.setString(9, teamContestName);
			pstmt.setString(10, teamContestLink);
			pstmt.setString(11, memberId);
			pstmt.setString(12, teamName);
			
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 18<br>
	 * �� ��� ���� �����ϱ�<br>
	 * insert into faq_tb values(FAQ���̵�, ?faq����, ?FAQ�亯, �� ���̵�);
	 */
	public boolean addFAQ(String faqQuestion, String faqAnswer, String teamId) {
		if (isNull(new Object[] { faqQuestion, faqAnswer, teamId })) {
			return false;
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		String faqId = generateId("faq");
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("insert into faq_tb values(?,?,?,?)");
			pstmt.setString(1, faqId); // Ű�� �����ϱ�
			pstmt.setString(2, faqQuestion);
			pstmt.setString(3, faqAnswer);
			pstmt.setString(4, teamId);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 18<br>
	 * �� ��� ���� �����ϱ�<br>
	 * insert into recruit_tb values(�������̵�, ?�����̵�, ?�����ο���, ?������, ?�����󼼼���,
	 * ?�����о�id);
	 */
	public boolean addRecruit(int recruitPeopleNum, String recruitPreference, String recruitExplain, String roleId,
			String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		String recruitId = generateId("recruit");
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("insert into recruit_tb values(?,?,?,?,?,?)");
			pstmt.setString(1, recruitId); // Ű�� �����ϱ�
			pstmt.setString(2, teamId);
			pstmt.setInt(3, recruitPeopleNum);
			pstmt.setString(4, recruitPreference);
			pstmt.setString(5, recruitExplain);
			pstmt.setString(6, roleId);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 18<br>
	 * ,45 �� ��� ���� �����ϱ�<br>
	 * insert into require_skill_tb values(�������̵�, ?��ų���̵�);"
	 */
	public boolean addRequireSkill(String recruitId, String skillId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("insert into require_skill_tb values(?,?)");
			pstmt.setString(1, recruitId);
			pstmt.setString(2, skillId);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 19<br>
	 * ���� ���� ���� ���� ����<br>
	 * select inquiry_id, inquiry_content, inquiry_update_date, team_id,
	 * inquiry_tb.member_id,member_name,member_pic from inquiry_tb inner join
	 * member_tb on (member_tb.member_id=inquiry_tb.member_id) where
	 * team_id='?�����̵�';<br>
	 * InquiryMemberVO -> String ���Ǿ��̵�, String ���ǳ���, TimeStamp ������Ʈ��¥, String
	 * �����̵�, String ������ ���̵�, String ������ �̸�, String ������ ���� ���
	 */
	public List<InquiryMemberVO> searchInquiry(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<InquiryMemberVO> result = new ArrayList<InquiryMemberVO>();

		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select * from inquiry_member_view where team_id=?");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String inquiryId = rs.getString(1);
				String inquiryContent = rs.getString(2);
				Timestamp inquiryUpdateDate = rs.getTimestamp(3);
				String receiveTeamId = rs.getString(4);
				String memberId = rs.getString(5);
				String memberName = rs.getString(6);
				String memberPic = rs.getString(7);
				InquiryMemberVO inquiryMemberVO = new InquiryMemberVO(inquiryId, inquiryContent, inquiryUpdateDate,
						receiveTeamId, memberId, memberName, memberPic);
				result.add(inquiryMemberVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 20<br>
	 * ���ǿ� ���� ���� �亯 ����<br>
	 * select reply_id, reply_content, reply_update_date, inquiry_id,
	 * reply_tb.member_id,member_name,member_pic from reply_tb inner join
	 * member_tb on (member_tb.member_id=reply_tb.member_id) where
	 * inquiry_id='?';<br>
	 * ReplyInquiryVO -> String replyId, String replyContent, Timestamp
	 * replyUpdateDate, String inquiryId, String memberId, String memberName,
	 * String memberPic
	 */
	public List<ReplySimpleVO> searchReply(String inquiryId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReplySimpleVO> result = new ArrayList<ReplySimpleVO>();

		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select * from reply_simple_view where inquiry_id=?");
			pstmt.setString(1, inquiryId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String replyId = rs.getString(1);
				String replyContent = rs.getString(2);
				Timestamp replyUpdateDate = rs.getTimestamp(3);
				String receiveInquiryId = rs.getString(4);
				String memberId = rs.getString(5);
				String memberName = rs.getString(6);
				String memberPic = rs.getString(7);

				ReplySimpleVO replySimpleVO = new ReplySimpleVO(replyId, replyContent, replyUpdateDate,
						receiveInquiryId, memberId, memberName, memberPic);
				result.add(replySimpleVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 21<br>
	 * � ���� � ������ � ����� �䱸�ϴ���<br>
	 * select skill_id from require_skill_tb where recruit_id='?'
	 * require_skill_view
	 */
	public List<RecruitRequireSkillVO> searchRequireSkill(String recruitId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecruitRequireSkillVO> result = new ArrayList<RecruitRequireSkillVO>();

		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select * from recruit_require_skill_view where recruit_id=?");
			pstmt.setString(1, recruitId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String teamId = rs.getString(1);
				String receiveRecruitId = rs.getString(2);
				String skillId = rs.getString(3);

				RecruitRequireSkillVO recruitRequireSkillVO = new RecruitRequireSkillVO(teamId, receiveRecruitId,
						skillId);
				result.add(recruitRequireSkillVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 22<br>
	 * faq ���� �亯 ȸ�� �̸� ���� ��������<br>
	 * SELECT faq_question, faq_answer FROM faq_tb WHERE team_id=?;<br>
	 * SELECT member_name, member_pic FROM member_tb INNER JOIN team_tb USING
	 * (member_id) WHERE team_id=?; String[]: String faqQuestion, String
	 * faqAnswer, String memberName, String memberPic
	 */
	public List<FaqVO> searchFaq(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FaqVO> result = new ArrayList<FaqVO>();

		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select * from faq_tb where team_id=?");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String faqId = rs.getString(1);
				String faqQuestion = rs.getString(2);
				String faqAnswer = rs.getString(3);
				String receiveTeamId = rs.getString(4);

				FaqVO faqVO = new FaqVO(faqId, faqQuestion, faqAnswer, receiveTeamId);
				result.add(faqVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 23<br>
	 * ������ ������ �������� - ������ �̸�, ������ ����, ������¥, ��������, ������ �Ҹ�, ���� ����<br>
	 * SELECT * FROM application_simple_view WHERE team_id=?;<br>
	 * ApplicantVO {String memberName, String memberPic, Timestamp
	 * applicationDate, String applicationStatus, String applicationFreewriting,
	 * String roleName)
	 */
	public List<ApplicantSimpleVO> getMyTeamApplicant(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ApplicantSimpleVO> result = new ArrayList<ApplicantSimpleVO>();

		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select * from applicant_simple_view where team_id=?");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String receiveTeamId = rs.getString(1);
				String applicationId = rs.getString(2);
				String memberId = rs.getString(3);
				String memberName = rs.getString(4);
				String memberPic = rs.getString(5);
				Timestamp applicationDate = rs.getTimestamp(6);
				int applicationStatus = rs.getInt(7);
				String applicationFreewriting = rs.getString(8);
				String roleId = rs.getString(9);

				ApplicantSimpleVO applicantSimpleVO = new ApplicantSimpleVO(receiveTeamId, applicationId, memberId,
						memberName, memberPic, applicationDate, applicationStatus, applicationFreewriting, roleId);
				result.add(applicantSimpleVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 27.<br>
	 * ȸ�� ���� ���� �ҷ�����.<br>
	 * ���̵�� ȸ������, �̸� ������ �޾ƿ´�. <br>
	 * select member_id, member_name, member_pic from member_tb where
	 * member_id='kyujin1';<br>
	 * SimpleMemberVO -> String memberId, String memberName, String memberPic
	 */
	public MemberSimpleVO getMember(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberSimpleVO result = null;

		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select member_id,member_name,member_pic from member_tb where member_id=?");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String receiveMemberId = rs.getString(1);
				String memberName = rs.getString(2);
				String memberPic = rs.getString(3);

				result = new MemberSimpleVO(receiveMemberId, memberName, memberPic);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 27.<br>
	 * ���� ���� ���� �ҷ�����.<br>
	 * ���̵�� ȸ������, �̸� ������ �޾ƿ´�. <br>
	 * select member_id, member_name, member_pic from member_tb where
	 * member_id='kyujin1';<br>
	 * SimpleMemberVO -> String memberId, String memberName, String memberPic
	 */
	public MemberSimpleVO getTeamReader(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberSimpleVO result = null;

		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select member_id,member_name,member_pic from member_tb where member_id=?");
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String receiveMemberId = rs.getString(1);
				String memberName = rs.getString(2);
				String memberPic = rs.getString(3);

				result = new MemberSimpleVO(receiveMemberId, memberName, memberPic);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;
	}

	/**
	 * 27.<br>
	 * ��õ ȸ�� ���� ���� �ҷ�����.<br>
	 * ��õ ����(���ɺо�, �䱸 ���, Ȱ�� ����)�� �޾Ƽ� �ش��ϴ� ���� ���� �������(���̵�, �̸�, ����, ����, ����,
	 * ��ġ��)��ϰ� Ÿ���� ������� ����� ��ġ�� ���� ������ �����Ͽ� �����Ѵ�.<br>
	 * Ű: ��������/Ÿ����:String, ���: ���̵�, �̸�, ����, ����, ����, ��ġ��:String[] <br>
	 * select * from member_interest_view;<br>
	 * select * from member_skill_view;<br>
	 * select * from member_region_view;
	 */
	public Map<String, List<String[]>> searchRecommendMember(String projectCategory, String[] skillId,
			String regionId) {
		return null;
	}

	/**
	 * 28<br>
	 * ������ �ҷ�����<br>
	 * �� ���̵�� ���� �������� �����´�.<br>
	 * select * from team_tb where team_id='team-1'; <br>
	 * select project_category_name from project_categrooy teamId,
	 * teamProjectName, teamName, teamSummary, teamContent, projectCategoryName,
	 */
	public TeamDetailVO searchTeam(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TeamDetailVO result = null;

		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select * from team_detail_view where team_id=?");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String receiveTeamId = rs.getString(1);
				String teamProjectName = rs.getString(2);
				String teamName = rs.getString(3);
				String teamSummary = rs.getString(4);
				String teamContent = rs.getString(5);
				String projectCategoryId = rs.getString(6);
				String regionId = rs.getString(7);
				Timestamp teamEndDate = rs.getTimestamp(8);
				int teamStatus = rs.getInt(9);
				Timestamp teamUpdateDate = rs.getTimestamp(10);
				String teamPic = rs.getString(11);
				String teamContestName = rs.getString(12);
				String teamContestLink = rs.getString(13);
				String memberId = rs.getString(14);
				String memberName = rs.getString(15);
				String memberPic = rs.getString(16);
				result = new TeamDetailVO(receiveTeamId, teamProjectName, teamName, teamSummary, teamContent,
						projectCategoryId, regionId, teamEndDate, teamStatus, teamUpdateDate, teamPic, teamContestName,
						teamContestLink, memberId, memberName, memberPic);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		return result;

	}

	/**
	 * 29<br>
	 * ���� ���� ����ϱ�<br>
	 * ȸ���� ���� ���Ǹ� �����.<br>
	 * ������ true return <br>
	 * insert into inquiry_tb values('inquiry-1','team-1','joran1','�κ� ��
	 * ����ſ���?',systimestamp);
	 */
	public boolean addInquiry(String teamId, String memberId, String inquiryContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		String inquiryId = generateId("inquiry");
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement(
					"insert into inquiry_tb (inquiry_id,team_id,member_id,inquiry_content) values(?,?,?,?)");
			pstmt.setString(1, inquiryId); // Ű�� �����ϱ�
			pstmt.setString(2, teamId);
			pstmt.setString(3, memberId);
			pstmt.setString(4, inquiryContent);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 30<br>
	 * ���� �亯 ����ϱ�<br>
	 * ȸ���� ���ǿ� �亯�� �����.<br>
	 * ������ true return <br>
	 * insert into reply_tb values('reply-2','inquiry-2','kyungjun1','�˼��մϴ�...��
	 * �����ҰԿ�',systimestamp);
	 */
	public boolean addReply(String inquiryId, String memberId, String replyContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		String replyId = generateId("reply");
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement(
					"insert into reply_tb (reply_id,inquiry_id,member_id,reply_content) values (?,?,?,?)");
			pstmt.setString(1, replyId); // Ű�� �����ϱ�
			pstmt.setString(2, inquiryId);
			pstmt.setString(3, memberId);
			pstmt.setString(4, replyContent);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 31<br>
	 * ���� ���� ���� �Ϸ�� ���� �� ���� <br>
	 * update inquiry_tb set inquiry_content='?', inquiry_update_date='?' where
	 * inquiry_id='?'
	 */
	public String updateInquiry(String inquiryContent, String inquiryId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String result = null;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement(
					"update inquiry_tb set inquiry_content=? , inquiry_update_date=? where inquiry_id=?");
			pstmt.setString(1, inquiryContent);
			pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setString(3, inquiryId);
			pstmt.execute();
			result = "���� ���� ������ ���������� �Ϸ�Ǿ����ϴ�.";
		} catch (SQLException e) {
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 32<br>
	 * ���� �亯 ���� �Ϸ� ��, ����/����<br>
	 * update reply_tb set reply_content='?', reply_update_date='?' where
	 * reply_id='?'
	 */
	public String updateReply(String replyContent, String replyId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String result = null;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("update reply_tb set reply_content=?, reply_update_date=? where reply_id=?");
			pstmt.setString(1, replyContent);
			pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setString(3, replyId);
			pstmt.execute();
			result = "���� ���� ������ ���������� �Ϸ�Ǿ����ϴ�.";
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 33<br>
	 * ���� ���� ���� �Ϸ� ��, ����<br>
	 * delete from inquiry_tb where inquiry_id='?' Not null -> ���� ����
	 */
	public String removeInquiry(String inquiryId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String result = null;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("delete from inquiry_tb where inquiry_id=?");
			pstmt.setString(1, inquiryId);
			pstmt.execute();
			result = "���ǰ� ���������� �����Ǿ����ϴ�.";
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 34<br>
	 * ���� �亯 ���� �Ϸ� ��, ����<br>
	 * delete from reply_tb where reply_id='?' Not null -> ���� ����
	 */
	public String removeReply(String replyId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String result = null;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("delete from reply_tb where reply_id=?");
			pstmt.setString(1, replyId);
			pstmt.execute();
			result = "���� �亯�� ���������� �����Ǿ����ϴ�.";
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 36<br>
	 * �����о� �ҷ�����<br>
	 * select role_name from recruit_tb INNER JOIN role_tb using(role_id) where
	 * team_id='�����̵�';
	 */
	public List<String[]> getRecruitRole(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String[]> result = new ArrayList<String[]>();

		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("select recruit_id, role_id, recruit_people_num, recruit_preference, recruit_explain from recruit_tb where team_id=?");
			pstmt.setString(1, teamId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] str = new String[] {rs.getString(1), rs.getString(2), rs.getInt(3) + "", rs.getString(4), rs.getString(5)}; 
				result.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt, rs);
		}
		ConnectDB.close(conn, pstmt, rs);
		
		return result; // �̷��� �ϸ� �ǳ� ��¥?
	}

	/**
	 * 39.<br>
	 * ���� ���� ����ϱ�<br>
	 * update application_tb set application_status=3 where
	 * application_id='application-1'; Not null -> ���� ��� ����
	 */
	public boolean cancelApplication(String applicationId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("update application_tb set application_status=3 where application_id=?");
			pstmt.setString(1, applicationId);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 41<br>
	 * ���� �� ������ ���� ���� �����ϱ�<br>
	 * UPDATE application_tb SET application_status=? WHERE team_id=? AND
	 * member_id=?
	 */
	public boolean changeApplicationStatus(int newStatus, String teamId, String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = ConnectDB.connect();
			pstmt = conn
					.prepareStatement("update application_tb set application_status=? where team_id=? and member_id=?");
			pstmt.setInt(1, newStatus);
			pstmt.setString(2, teamId);
			pstmt.setString(3, memberId);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 42<br>
	 * �� ���� ���� �����ϱ�(�Ϸ�)<br>
	 * UPDATE team_tb SET team_status=1 WHERE team_id=?
	 */
	public boolean changeTeamStatus(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("update team_tb set team_status=1 where team_id=?");
			pstmt.setString(1, teamId);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * 47<br>
	 * ����Ǿ� �ִ� ������ �� ���� �����ϱ�<br>
	 * DELETE FROM team_tb WHERE team_id=?
	 */
	public boolean removeTeam(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = ConnectDB.connect();
			pstmt = conn.prepareStatement("delete from team_tb where team_id=?");
			pstmt.setString(1, teamId);
			result = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			ConnectDB.close(conn, pstmt);
		}
		ConnectDB.close(conn, pstmt);
		return result;
	}

	/**
	 * ���̺���� �Ķ���ͷ� �޾Ƽ� �ش� ���̺� Ű�� �ִ밪�� 1 ���� ���� �����Ѵ�.
	 */
	public String generateId(String tbName) {

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
				return "DB����";
		}
		if(max == null) {
			return tbName + "-" + 1;
		}
		return tbName + "-" + (temp + 1);
	}

	public boolean isNull(Object[] params) {
		for (Object param : params) {
			if (param == null)
				return true;
		}
		return false;
	}
}
