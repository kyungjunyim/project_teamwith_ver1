package com.teamwith.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.teamwith.db.ConnectDB;
import com.teamwith.vo.MemberVO;

public class LoginServiceDao {
	private static LoginServiceDao loginServiceDao;

	static {
		loginServiceDao = new LoginServiceDao();
	}

	private LoginServiceDao() {

	}

	public static LoginServiceDao getInstance() {
		return loginServiceDao;
	}

	/**
	 * 5<br>
	 * �Էµ� ���̵�/��й�ȣ�� ���Ͽ� �α��� ó���ϱ�(ȸ���� Ż�� ���� üũ�ϱ�!)<br>
	 * select * from member_tb where member_id='jongseung1' and
	 * member_password='k123456!' and member_public=0;<br>
	 * <br>
	 * �α��� ���� �� ��� ���� ����, ���н� null ���� (Ż��ȸ���� ���̵� ��й�ȣ ��ġ�� ��� ������ �����Ѵ�. ���񽺿���
	 * Ż��ȸ������ üũ�Ѵ�.)
	 */
	public MemberVO login(String memberId, String memberPassword) {
		if (memberId == null || memberPassword == null) {
			return null;
		}
		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberVO result = null;
		try {
			ps = conn.prepareStatement("select * from member_tb where member_id=? and member_password=?");
			ps.setString(1, memberId);
			ps.setString(2, memberPassword);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getTimestamp(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9),
						rs.getString(10), rs.getTimestamp(11), rs.getTimestamp(12), rs.getInt(13), rs.getString(14));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;
	}

	/**
	 * 5<br>
	 * �Էµ� ���̵�/��й�ȣ�� ���Ͽ� ��ġ ���� Ȯ���ϱ�(ȸ���� Ż�� ���� üũ�ϱ�!)<br>
	 * select * from member_tb where member_id='jongseung1' and
	 * member_password='k123456!' and member_public=0;<br>
	 * MemberAccountVO(memberId:String, memberName:String, memberPic:String,
	 * memberAuth:int, )??<br>
	 * return �� true:Ż������ ���� ȸ��, false:Ż���� ȸ��
	 */
	public boolean existMember(String memberId, String memberPassword) {
		boolean result = false;
		if (memberId == null) {
			return result;
		}
		Connection conn = ConnectDB.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("select member_password from member_tb where member_id=?");
			ps.setString(1, memberId);
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equals(memberPassword)) {
					result = true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectDB.close(conn, ps, rs);
		}
		return result;
	}
}
