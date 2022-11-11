package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Q_DTO;

public class Q_DAO {

	private static Q_DAO instance = new Q_DAO();

	public static Q_DAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}

	// 문의글 작성
	public int insert(Q_DTO board) {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "insert into qna values(qna_seq.nextval, ?, ?, ?,";
			sql += " sysdate, qna_seq.nextval, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getQ_title());
			pstmt.setString(2, board.getQ_content());
			pstmt.setInt(3, board.getQ_readcnt());
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setString(6, board.getId());
			pstmt.setString(7, board.getQ_pw());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}

		return result;
	}

	// 총 문의글의 갯수 구하기
	public int getCount() {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select count(*) from qna";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			if (rs.next()) {
				result = rs.getInt("count(*)");
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

	// 문의글 목록
	public List<Q_DTO> getList(int start, int end) {
		List<Q_DTO> list = new ArrayList<Q_DTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from (select rownum rnum, board.* from ";
			sql += " (select * from qna order by q_ref desc, q_step asc) board ) ";
			sql += " where rnum >= ? and rnum <= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Q_DTO board = new Q_DTO();
				board.setQ_num(rs.getInt("q_num"));
				board.setQ_title(rs.getString("q_title"));
				board.setQ_content(rs.getString("q_content"));
				board.setQ_readcnt(rs.getInt("q_readcnt"));
				board.setQ_reg(rs.getTimestamp("q_reg"));
				board.setQ_ref(rs.getInt("q_ref"));
				board.setQ_step(rs.getInt("q_step"));
				board.setQ_lvl(rs.getInt("q_lvl"));
				board.setId(rs.getString("id"));
				board.setQ_pw(rs.getString("q_pw"));

				list.add(board);
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
	public void readcountUpdate(int q_num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update qna set q_readcnt = q_readcnt+1 ";
			sql += " where q_num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q_num);
			pstmt.executeUpdate(); // SQL문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
	}

	// 상세 페이지
	public Q_DTO getDetail(int q_num) {
		Q_DTO board = new Q_DTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select * from qna where q_num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q_num);
			rs = pstmt.executeQuery(); 

			if (rs.next()) {
				board.setQ_num(rs.getInt("q_num"));
				board.setQ_title(rs.getString("q_title"));
				board.setQ_content(rs.getString("q_content"));
				board.setQ_readcnt(rs.getInt("q_readcnt"));
				board.setQ_reg(rs.getTimestamp("q_reg"));
				board.setQ_ref(rs.getInt("q_ref"));
				board.setQ_step(rs.getInt("q_step"));
				board.setQ_lvl(rs.getInt("q_lvl"));
				board.setId(rs.getString("id"));
				board.setQ_pw(rs.getString("q_pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return board;
	}

	// 댓글 작성
	@SuppressWarnings("resource")
	public int boardReply(Q_DTO board) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;

		// 부모글에 대한 정보
		int q_ref = board.getQ_ref(); // 글 그룹 번호
		int q_lvl = board.getQ_lvl(); // 댓글의 깊이
		int q_step = board.getQ_step(); // 댓글의 출력순서

		try {
			con = getConnection();

			String sql = "update qna set q_step = q_step+1 ";
			sql += " where q_ref = ? and q_step > ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q_ref);
			pstmt.setInt(2, q_step);
			pstmt.executeUpdate(); // SQL문 실행

			sql = "insert into qna values(qna_seq.nextval, ?,?,?,";
			sql += "sysdate, ?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, board.getQ_title());
			pstmt.setString(2, board.getQ_content());
			pstmt.setInt(3, board.getQ_readcnt());
			pstmt.setInt(4, q_ref);
			pstmt.setInt(5, q_step + 1);
			pstmt.setInt(6, q_lvl + 1);
			pstmt.setString(7, board.getId());
			pstmt.setString(8, board.getQ_pw());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return result;
	}

	// 글수정
	public int update(Q_DTO board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "update qna set q_title=?, q_content=? where q_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getQ_title());
			pstmt.setString(2, board.getQ_content());
			pstmt.setInt(3, board.getQ_num());
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return result;
	}

	// 글삭제
	public int delete(int q_num) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "delete from qna where q_num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q_num);
			result = pstmt.executeUpdate(); // SQL문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return result;
	}

}
