package com.teamwith.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.teamwith.db.ConnectDB;
import com.teamwith.vo.BestMemberVO;
import com.teamwith.vo.CareerVO;
import com.teamwith.vo.LicenseVO;

public class ProfileServiceDao {
	private static ProfileServiceDao profileServiceDao;
	static {
		profileServiceDao = new ProfileServiceDao();
	}

	private ProfileServiceDao() {
	}

	public static ProfileServiceDao getInstance() {
		return profileServiceDao;
	}

	public boolean isNull(Object[] params) {
		if (params != null) {
			for (Object param : params) {
				if (param == null)
					return true;
			}
		}
		return false;
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

		if (isNull(new String[] { projectCategory, regionId }) || isNull(skillId)) {
			return null;
		}

		Map<String, List<String[]>> result = new HashMap<String, List<String[]>>();

		int skillNum = skillId.length;
		int count = 0;
		double rate = 0;
		List<String[]> myRegion = new ArrayList<String[]>();
		List<String[]> notMyRegion = new ArrayList<String[]>();
		List<String[]> memberSkills = new ArrayList<String[]>();

		Connection con = ConnectDB.connect();
		PreparedStatement pstmt = null;
		ResultSet res = null;

		try {
			pstmt = con.prepareStatement(
					"SELECT member_id, member_name, member_pic, member_tb.role_id FROM member_project_category_tb natural join member_tb WHERE project_category_id = ?");
			pstmt.setString(1, projectCategory);
			res = pstmt.executeQuery();

			if (res.next()) {
				/* ��� ���̵�� ����� ���� ��ų ����Ʈ�� �����´�. */
				memberSkills = searchMemberSkill(res.getString(1));

				/* ����� ���� ��ų�� �䱸 ��ų�� ���Ͽ� ��ġ���� ����. */
				for (String[] mskill : memberSkills) {
					for (String rskill : skillId) {
						if (mskill[0].equals(rskill)) {
							count++;
							break;
						}
					}
				}
				rate = (count + 0.0) / skillNum;

				/* ���� �������� Ÿ�������� ���Ͽ� ��� ����Ʈ�� �ִ´�. */
				for (String r : searchMemberRegion(res.getString(1))) {
					if (r.equals(regionId)) {
						myRegion.add(new String[] { res.getString(1), res.getString(2), res.getString(3),
								res.getString(4), regionId, rate + "" });
						break;
					}
				}

				notMyRegion.add(new String[] { res.getString(1), res.getString(2), res.getString(3), res.getString(4),
						"", rate + "" });

			}

			result.put("myRegion", myRegion);
			result.put("notMyRegion", notMyRegion);

			return result;

		} catch (SQLException e) {
			ConnectDB.close(con, pstmt, res);
			e.printStackTrace();
			return result;
		}
	}

	/**
	 * 3<br>
	 * Ī��Ƚ���� ���� ������ ȸ�������� number����ŭ (String[0]:ȸ�����̵� String[1]:ȸ���̸� String[2] ȸ��
	 * ���� String[3]:Ī��Ƚ��) ��ȯ�Ѵ�.<br>
	 * select * from top_praise_view order by praise_count;
	 */
	public List<BestMemberVO> searchBestMember(int number) {
		if (number <= 0) {
			return null;
		}

		List<BestMemberVO> all = searchBestMember();
		if (all.size() < number) {
			number = all.size();
		}
		List<BestMemberVO> result = new ArrayList<BestMemberVO>();
		for (int i = 0; i < number; i++) {
			result.add(all.get(i));
		}
		return result;
	}

	/**
	 * 3<br>
	 * Ī��Ƚ���� ���� ������ ȸ�������� (String[0]:ȸ�����̵� String[1]:ȸ���̸� String[2] ȸ�� ����
	 * String[3]:Ī��Ƚ��) ��ȯ�Ѵ�.<br>
	 * select * from best_member_view order by praise_total_count desc
	 */
	public List<BestMemberVO> searchBestMember() {

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<BestMemberVO> result = new ArrayList<BestMemberVO>();

		try {
			ps = conn.prepareStatement("select * from best_member_view order by praise_total_count desc");
			rs = ps.executeQuery();
			while (rs.next()) {
				BestMemberVO bestMem = new BestMemberVO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4));
				result.add(bestMem);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;

	}

	/**
	 * 56<br>
	 * �ڱ� �ڽ��� �������� ����<br>
	 * ����Ǿ� �ִ� ������ ������ ���� �ҷ�����<br>
	 * �� ȸ���� Ȱ�� ����(���� ��)�� �迭�� ��ȯ select region_id from member_region_tb where
	 * member_id='?'
	 */
	public List<String> searchMemberRegion(String memberId) {
		if (memberId == null) {
			return null;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();

		try {
			ps = conn.prepareStatement("select region_id from member_region_tb where member_id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				String region = rs.getString(1);
				result.add(region);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;

	}

	/**
	 * 57<br>
	 * �ڱ� �ڽ��� �������� ����<br>
	 * ����Ǿ� �ִ� ������ ������ ���� �ҷ�����<br>
	 * �� ȸ���� ���� �о�(���� ��)�� ����Ʈ�� ��ȯ select project_category_id from
	 * member_project_category_tb where member_id='?'
	 */
	public List<String> searchMemberProjectCategory(String memberId) {
		if (memberId == null) {
			return null;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();

		try {
			ps = conn.prepareStatement("select project_category_id from member_project_category_tb where member_id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				String category = rs.getString(1);
				result.add(category);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;

	}

	/**
	 * 58.<br>
	 * �ڱ� �ڽ��� �������� ����<br>
	 * ����Ǿ� �ִ� ������ ������ ���� �ҷ�����<br>
	 * �� ȸ���� ��� ������ �ҷ����� select skill_id,skill_level from member_skill_tb where
	 * member_id='?'
	 */
	public List<String[]> searchMemberSkill(String memberId) {
		if (memberId == null) {
			return null;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String[]> result = new ArrayList<String[]>();

		try {
			ps = conn.prepareStatement("select skill_id,skill_level from member_skill_tb where member_id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				String[] skill = new String[] { rs.getString(1), rs.getString(2) };
				result.add(skill);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;

	}

	/**
	 * 59<br>
	 * �ڱ� �ڽ��� �������� ����<br>
	 * ����Ǿ� �ִ� ������ ������ ���� �ҷ�����<br>
	 * �� ȸ���� ��� ������ �ҷ�����<br>
	 * select career_id, career_name, career_start_date, career_end_date,
	 * career_role, career_explain from career_tb where member_id='?'<br>
	 * CareerVO -> String careerId, String careerName, Timestamp
	 * careerStartDate, Timestamp careerEndDate, String careerRole, String
	 * careerExplain
	 */
	public List<CareerVO> searchMemberCareer(String memberId) {
		if (memberId == null) {
			return null;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CareerVO> result = new ArrayList<CareerVO>();

		try {
			ps = conn.prepareStatement("select * from career_tb where member_id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				CareerVO career = new CareerVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4),
						rs.getTimestamp(5), rs.getString(6), rs.getString(7));
				result.add(career);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;
	}

	/**
	 * 59.<br>
	 * �ڱ� �ڽ��� �������� ����<br>
	 * ����Ǿ� �ִ� ������ ������ ���� �ҷ�����<br>
	 * �� ȸ���� �ڰ��� ���� �ҷ�����<br>
	 * select license_id, license_name,license_date,license_level from
	 * license_tb where member_id='?'<br>
	 * LicenseVO -> String licenseId, String licenseName, Timestamp licenseDate,
	 * String licenseLevel
	 */
	public List<LicenseVO> searchMemberLicense(String memberId) {
		if (memberId == null) {
			return null;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<LicenseVO> result = new ArrayList<LicenseVO>();

		try {
			ps = conn.prepareStatement("select * from license_tb where member_id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				LicenseVO license = new LicenseVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4),
						rs.getString(5));
				result.add(license);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;
	}

	/**
	 * 59.<br>
	 * �ڱ� �ڽ��� �������� ����<br>
	 * ����Ǿ� �ִ� ������ ������ ���� �ҷ�����<br>
	 * �� ȸ���� ���� ���� �ҷ�����<br>
	 * select role_id from member_tb where member_id='?'
	 */
	public String searchMemberRole(String memberId) {
		if (memberId == null) {
			return null;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = null;

		try {
			ps = conn.prepareStatement("select role_id from member_tb where member_id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;
	}

	/**
	 * 60.<br>
	 * �ڱ� �ڽ��� �������� ����<br>
	 * ����Ǿ� �ִ� ������ ������ ���� �ҷ�����<br>
	 * �� ȸ���� ���� ���� �ҷ�����<br>
	 * select tendency_id, tendency_figure from member_tendency_tb where
	 * member_id=?<br>
	 * Map<String tendencyId, Integer tendency_figure> map�� set5��..
	 */
	public Map<String, Integer> searchMemberTendency(String memberId) {
		if (memberId == null) {
			return null;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Integer> result = new HashMap<String, Integer>();

		try {
			ps = conn.prepareStatement("select tendency_id, tendency_figure from member_tendency_tb where member_id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.put(rs.getString(1), rs.getInt(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;
	}

	/**
	 * 61.����Ǿ� �ִ� ������ ������ ���� �ٲٱ�(����) update member_region_tb set
	 * region_id='region-2' where member_id='jongseung1' and
	 * region_id='region-1'; <br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 * 
	 */
	public int updateRegion(String memberId, String oldRegionId, String newRegionId) {
		if (isNull(new String[] { memberId, oldRegionId, newRegionId })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("update member_region_tb set region_id= ? where member_id=? and region_id= ?");
			ps.setString(1, newRegionId);
			ps.setString(2, memberId);
			ps.setString(3, oldRegionId);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * 61.����Ǿ� �ִ� �������� ���� delete from member_region_tb where
	 * member_id='jongseung1' return �� 0: ����, 1: DB Connect / Network ����, 2:
	 * parameter�� null�� ���, 3:������Ʈ ����
	 */
	public int removeMemberRegion(String memberId) {
		if (isNull(new String[] { memberId })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("delete from member_region_tb where member_id=?");
			ps.setString(1, memberId);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;
	}

	/**
	 * 62.����Ǿ� �ִ� ������ ������ ���� �ٲٱ�(���ɺо�)<br>
	 * update member_project_category_tb set
	 * project_category_id='project_category-1' where member_id='jongseung1' and
	 * project_category_id='project_category-2';<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int updateProjectCategory(String memberId, String oldProjectCategoryId, String newProjectCategoryId) {
		if (isNull(new String[] { memberId, oldProjectCategoryId, newProjectCategoryId })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement(
					"update member_project_category_tb set project_category_id= ? where member_id=? and project_category_id= ?");
			ps.setString(1, newProjectCategoryId);
			ps.setString(2, memberId);
			ps.setString(3, oldProjectCategoryId);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * 62.����Ǿ��ִ� ���ɺо� ���� ���� delete from member_project_category_tb where
	 * member_id='jongseung1' return �� 0: ����, 1: DB Connect / Network ����, 2:
	 * parameter�� null�� ���, 3:������Ʈ ����
	 */
	public int removeMemberProjectCategory(String memberId) {
		if (isNull(new String[] { memberId })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("delete from member_project_category_tb where member_id=?");
			ps.setString(1, memberId);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;
	}

	/**
	 * 63.����Ǿ� �ִ� ������ ������ ���� �ٲٱ�(����) update member_skill_tb set skill_level=4
	 * where member_id='jongseung1' and skill_id='skill-1'; return �� 0: ����, 1:
	 * DB Connect / Network ����, 2: parameter�� null�� ���, 3:������Ʈ ����
	 */

	public int updateSkill(String memberId, String skillId, String skillLevel) {
		if (isNull(new String[] { memberId, skillId, skillLevel })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("update member_skill_tb set skill_level= ? where member_id=? and skill_id= ?");
			ps.setString(1, skillLevel);
			ps.setString(2, memberId);
			ps.setString(3, skillId);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * 63.����Ǿ� �ִ� ���� ���� ���� delete from member_skill_tb where
	 * memberId='jongseung1' return �� 0: ����, 1: DB Connect / Network ����, 2:
	 * parameter�� null�� ���, 3:������Ʈ ����
	 */
	public int removeMemberSkill(String memberId) {
		if (isNull(new String[] { memberId })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("delete from member_skill_tb where member_id=?");
			ps.setString(1, memberId);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * 64.����Ǿ� �ִ� ������ ������ ���� �ٲٱ�(�ڰ���)<br>
	 * update license_tb set license_name="����ó�����",set license_date=TIMESTAMP
	 * '2005-05-13 07:15:31.123456789',license_level='��' where
	 * license_id='license-1';<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int updateLicense(String licenseId, String licenseName, Timestamp licenseDate, String licenseLevel) {
		if (isNull(new String[] { licenseId, licenseName }) || licenseDate == null) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement(
					"update license_tb set license_name= ?, license_date=?, license_level=? where license_id= ?");
			ps.setString(1, licenseName);
			ps.setTimestamp(2, licenseDate);
			ps.setString(3, licenseLevel);
			ps.setString(4, licenseId);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * 64.����Ǿ� �ִ� �ڰ��� ���� 1�� ����<br>
	 * ���̼��� ���̵��ϳ��� �޾Ƽ� �ش� �ڰ����� �����Ѵ�.<br>
	 * delete from license_tb where license_id='license-1'<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int removeMemberLicense(String licenseId) {
		if (isNull(new String[] { licenseId })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("delete from license_tb where license_id=?");
			ps.setString(1, licenseId);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}
		return 0;
	}

	/**
	 * 64.����Ǿ� �ִ� ��� ���� 1�� ����<br>
	 * ��� ���̵� �ϳ��� �޾Ƽ� �ش� ����� �����Ѵ�.<br>
	 * delete from career_tb where career_id='career-1'<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int removeMemberCareer(String careerId) {
		if (isNull(new String[] { careerId })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("delete from career_tb where career_id=?");
			ps.setString(1, careerId);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}
		return 0;

	}

	/**
	 * 64.����Ǿ��ִ� ��� ���� ���� <br>
	 * update career_tb set
	 * career_name='�ڰ����̸�',career_start_date='������',career_end_date='������',career_role='����',career_explain='����'
	 * where career_id='��¾��̵�';
	 */
	public int updateMemberCareer(String careerId, String careerName, Timestamp careerStartDate,
			Timestamp careerEndDate, String careerRole, String careerExplain) {

		if (isNull(new Object[] { careerId, careerName })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("update career_tb set career_name=?,career_start_date=?,"
					+ "career_end_date=?,career_role=?,career_explain=? where career_id= ?");
			ps.setString(1, careerName);
			ps.setTimestamp(2, careerStartDate);
			ps.setTimestamp(3, careerEndDate);
			ps.setString(4, careerRole);
			ps.setString(5, careerExplain);
			ps.setString(6, careerId);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * 65.����Ǿ� �ִ� ������ ������ ���� �ٲٱ�(����)<br>
	 * update member_tendency_tb set tendency_figure=6 where
	 * member_id='jongseung1' and tendency_id='tendency-1';<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int updateTendency(String memberId, String tendencyId, int tendencyFigure) {
		if (isNull(new String[] { memberId, tendencyId }) || tendencyFigure <= 0) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement(
					"update member_tendency_tb set tendency_figure= ? where member_id=? and tendency_id= ?");
			ps.setInt(1, tendencyFigure);
			ps.setString(2, memberId);
			ps.setString(3, tendencyId);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {

			return 3;
		}

		return 0;

	}

	/**
	 * 67<br>
	 * �ڱ� �ڽ��� ������(����)�� ���<br>
	 * INSERT INTO member_region_tb VALUES (?, ?);<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int addMemberRegion(String regionId, String memberId) {
		if (isNull(new String[] { memberId, regionId })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("INSERT INTO member_region_tb VALUES (?, ?)");
			ps.setString(1, regionId);
			ps.setString(2, memberId);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;
	}

	/**
	 * 68<br>
	 * �ڱ� �ڽ��� ������(���� �о�) �������� ���<br>
	 * INSERT INTO member_project_category_tb VALUES (?, ?);<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int addMemberProjectCategory(String[] projectCategoryIds, String memberId) {
		if (projectCategoryIds == null || isNull(projectCategoryIds) || memberId == null) {
			return 2;
		}
		for (String pc : projectCategoryIds) {
			if (addMemberProjectCategory(pc, memberId) == 3) {
				return 3;
			}
		}
		return 0;
	}

	/**
	 * 68<br>
	 * �ڱ� �ڽ��� ������(���� �о�) 1���� ���<br>
	 * INSERT INTO member_project_category_tb VALUES (?, ?);<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int addMemberProjectCategory(String projectCategoryId, String memberId) {
		if (isNull(new String[] { memberId, projectCategoryId })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("INSERT INTO member_project_category_tb VALUES (?, ?)");
			ps.setString(1, memberId);
			ps.setString(2, projectCategoryId);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * 69<br>
	 * �ڱ� �ڽ��� ������(���)�� 1���� ���<br>
	 * INSERT INTO member_skill_tb VALUES (?, ?, ?);<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */

	public int addMemberSkill(String memberId, String skillId) {
		return addMemberSkill(memberId, skillId, 1);
	}

	public int addMemberSkill(String memberId, String skillId, int skillLevel) {
		if (isNull(new String[] { memberId, skillId }) || skillLevel < 0) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("INSERT INTO member_skill_tb VALUES (?, ?, ?)");
			ps.setString(1, memberId);
			ps.setString(2, skillId);
			ps.setInt(3, skillLevel);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * 69<br>
	 * �ڱ� �ڽ��� ������(���)�� �������� ���<br>
	 * INSERT INTO member_skill_tb VALUES (?, ?, ?);<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int addMemberSkill(String memberId, String[] skillIds) {
		if (isNull(skillIds) || memberId == null ||skillIds==null) {
			return 2;
		}
		for (int i = 0; i < skillIds.length; i++) {
			if (addMemberSkill(memberId, skillIds[i]) == 3) {
				return 3;
			}
		}
		return 0;
	}

	public int addMemberSkill(String memberId, String[] skillIds, int[] skillLevels) {
		if (isNull(skillIds) || skillLevels == null || memberId == null || skillIds.length != skillLevels.length) {
			return 2;
		}
		for (int i = 0; i < skillIds.length; i++) {
			if (addMemberSkill(memberId, skillIds[i], skillLevels[i]) == 3) {
				return 3;
			}
		}
		return 0;

	}

	/**
	 * 70<br>
	 * �ڱ� �ڽ��� ������(��»���)�� ���<br>
	 * INSERT INTO career_tb VALUES (?, ?, ?, ?, ?, ?, ?);<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int addMemberCareer(String memberId, String careerName, Timestamp careerStartDate, Timestamp careerEndDate,
			String careerRole, String careerExplain) {

		if (isNull(new Object[] { memberId, careerName })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("INSERT INTO career_tb VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, generateId("career"));
			ps.setString(2, memberId);
			ps.setString(3, careerName);
			ps.setTimestamp(4, careerStartDate);
			ps.setTimestamp(5, careerEndDate);
			ps.setString(6, careerRole);
			ps.setString(7, careerExplain);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;
	}

	/**
	 * 70<br>
	 * �ڱ� �ڽ��� ������(�ڰ���)�� ���<br>
	 * INSERT INTO license_tb VALUES (?, ?, ?, ?, ?);<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int addMemberLicense(String memberId, String licenseName, Timestamp licenseDate, String licenseLevel) {
		if (isNull(new Object[] { memberId, licenseName })) {
			return 2;
		}

		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("INSERT INTO license_tb VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, generateId("license"));
			ps.setString(2, memberId);
			ps.setString(3, licenseName);
			ps.setTimestamp(4, licenseDate);
			ps.setString(5, licenseLevel);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * 71<br>
	 * �ڱ� �ڽ��� ������(����)�� ���<br>
	 * ���� ����� �ý����� �ϴ� ���̹Ƿ� ���Ⱚ�� ����Ʈ�� �����Ͽ� �Է��Ѵ�.<br>
	 * INSERT INTO member_tendency_tb VALUES (?, ?, ?);<br>
	 * return �� 0: ����, 1: DB Connect / Network ����, 2: parameter�� null�� ���,
	 * 3:������Ʈ ����
	 */
	public int addMemberTendency(String memberId, String tendencyId) {
		if (isNull(new Object[] { memberId, tendencyId })) {
			return 2;
		}
		int tendencyFigure = 5;
		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		int result = 0;

		try {
			ps = conn.prepareStatement("INSERT INTO member_tendency_tb VALUES (?, ?, ?)");
			ps.setInt(1, tendencyFigure);
			ps.setString(2, memberId);
			ps.setString(3, tendencyId);

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps);
		}
		if (result == 0) {
			return 3;
		}

		return 0;

	}

	/**
	 * ���̺���� �Ķ���ͷ� �޾Ƽ� �ش� ���̺� Ű�� �ִ밪�� 1 ���� ���� �����Ѵ�.
	 */
	private String generateId(String tbName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		String max = null;
		boolean check = true;
		try {
			con = ConnectDB.connect();
			pstmt = con.prepareStatement(
					"select " + tbName + "_id from " + tbName + "_tb order by " + tbName + "_id desc");
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
				return "DB����";
		}

		if (max == null) {
			return tbName + "-" + 1;
		}
		return tbName + "-" + (Integer.parseInt(max) + 1);
	}

}
