package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import dto.R_DTO;

public class R_DAO {

	private static R_DAO instance = new R_DAO();

	public static R_DAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}

	// 글 작성
	public int insert(R_DTO review) {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "insert into review values(review_seq.nextval,?,?,?,?,?,sysdate,review_seq.nextval,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, review.getId());
			pstmt.setString(2, review.getR_title());
			pstmt.setString(3, review.getR_content());
			pstmt.setString(4, review.getR_file());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.setString(8, review.getR_pw());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}

		return result;
	}

	// 총 데이터 갯수
	public int getCount() {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select count(*) from review";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
//						result = rs.getInt("count(*)");
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

	// 목록
	public List<R_DTO> getList(int start, int end) {
		List<R_DTO> list = new ArrayList<R_DTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from (select rownum rnum, board.* from ";
			sql += " (select * from review order by r_ref desc, ";
			sql += " r_step asc) board ) where rnum >= ? and rnum <= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				R_DTO review = new R_DTO();
				review.setR_num(rs.getInt("r_num"));
				review.setId(rs.getString("id"));
				review.setR_title(rs.getString("r_title"));
				review.setR_content(rs.getString("r_content"));
				review.setR_file(rs.getString("r_file"));
				review.setR_readcnt(rs.getInt("r_readcnt"));
				review.setR_reg(rs.getTimestamp("r_reg"));
				review.setR_ref(rs.getInt("r_ref"));
				review.setR_step(rs.getInt("r_step"));
				review.setR_lvl(rs.getInt("r_lvl"));
				review.setR_pw(rs.getString("r_pw"));

				list.add(review);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}

		return list;
	}

	// 조회수 증가
	public void readcountUpdate(int r_num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = getConnection();
			String sql = "update review set r_readcnt=r_readcnt+1 where r_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			pstmt.executeUpdate(); // sql문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}

	}

	// 상세 페이지
	public R_DTO getDetail(int r_num) {
		R_DTO review = new R_DTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "select * from review where r_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				review.setR_num(rs.getInt("r_num"));
				review.setId(rs.getString("id"));
				review.setR_title(rs.getString("r_title"));
				review.setR_content(rs.getString("r_content"));
				review.setR_file(rs.getString("r_file"));
				review.setR_readcnt(rs.getInt("r_readcnt"));
				review.setR_reg(rs.getTimestamp("r_reg"));
				review.setR_ref(rs.getInt("r_ref"));
				review.setR_step(rs.getInt("r_step"));
				review.setR_lvl(rs.getInt("r_lvl"));
				review.setR_pw(rs.getString("r_pw"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return review;
	}

	// 글 삭제
	public int delete(int r_num) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "delete from review where r_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return result;
	}

	// 글 수정
	public int update(R_DTO review) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update review set r_title=?,";
			sql += " r_content=?, r_file=? where r_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, review.getR_title());
			pstmt.setString(2, review.getR_content());
			pstmt.setString(3, review.getR_file());
			pstmt.setInt(4, review.getR_num());
			
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
