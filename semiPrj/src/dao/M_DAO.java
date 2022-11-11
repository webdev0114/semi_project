package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import dto.M_DTO;

public class M_DAO {
	
	private static M_DAO instance = new M_DAO();
	
	public static M_DAO getInstance() {
		return instance;
	}
	
	@SuppressWarnings("unused")
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 회원가입
	public int insert(M_DTO member) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "insert into member ";
			sql += " values(?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPost());
			pstmt.setString(5, member.getAddr());
			pstmt.setString(6, member.getJumin1());
			pstmt.setString(7, member.getJumin2());
			pstmt.setString(8, member.getTel1());
			pstmt.setString(9, member.getTel2());
			pstmt.setString(10, member.getTel3());
			pstmt.setString(11, member.getMail());
			pstmt.setString(12, member.getDomain());
			pstmt.setString(13, member.getSeller());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}

		}
		return result;
	}

	// ID 중복검사 (ajax)
	public int idcheck(String id) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from member where id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 중복ID
				result = 1;
			} else { // 사용 가능 ID
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}

		return result;
	}

	// 로그인 (Member 인증)
	public int M_Auth(String id, String pw) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from member where id=? and pw=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 회원 인증 성공
				result = 1;
			} else { // 회원 인증 실패
				result = -1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		
		return result;
		
	}
	
	// Member 상세 정보 반환
	public M_DTO getMember(String id) {
		M_DTO member = new M_DTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from member where id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setPost(rs.getString("post"));
				member.setAddr(rs.getString("addr"));
				member.setJumin1(rs.getString("jumin1"));
				member.setJumin2(rs.getString("Jumin2"));
				member.setTel1(rs.getString("tel1"));
				member.setTel2(rs.getString("tel2"));
				member.setTel3(rs.getString("tel3"));
				member.setMail(rs.getString("mail"));
				member.setDomain(rs.getString("domain"));
				member.setReg(rs.getTimestamp("reg"));
				member.setSeller(rs.getString("seller"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		
		return member;
	}
	
	// 회원정보 수정
	public int update(M_DTO member) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update member set name=?, post=?, addr=?,";
			sql += " tel1=?, tel2=?, tel3=?, mail=?, domain=? where id=? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPost());
			pstmt.setString(3, member.getAddr());
			pstmt.setString(4, member.getTel1());
			pstmt.setString(5, member.getTel2());
			pstmt.setString(6, member.getTel3());
			pstmt.setString(7, member.getMail());
			pstmt.setString(8, member.getDomain());
			pstmt.setString(9, member.getId());
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}

		return result;
	}

	// 회원 탈퇴
	public int delete(String id) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "delete from member where id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();

		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}

		return result;
	}
}
