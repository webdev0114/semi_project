package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import dto.S_DTO;

public class S_DAO {
	private static S_DAO instance = new S_DAO();

	public static S_DAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}

	// 검색 데이터 갯수
	public int getCount(String sear) {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select count(*) from place";
			sql += " where p_addr like '%"+sear+"%'";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int cnt = rs.getInt(1);
				result += cnt;
			}
			
			sql = "select count(*) from food";
			sql += " where f_addr like '%"+sear+"%'";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int cnt = rs.getInt(1);
				result += cnt;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close();}catch(Exception e) {}
			if(pstmt != null) try { pstmt.close();}catch(Exception e) {}
			if(con != null) try { con.close();}catch(Exception e) {}
		}

		return result;
	}
	
	// 검색 글 목록
	public List<S_DTO> getList(int start, int end, String sear) {
		List<S_DTO> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
/*			String sql = "select * from ( select rownum rnum, p_num, p_name, p_content, p_file, p_addr, p_readcnt from ";
			sql += "(select * from place where p_name like '%"+sear+"%' order by p_num desc)) ";
			sql += "where rnum >= ? and rnum <= ?"; */
			
			String sql = "select * from  ( select rownum rnum, s.* from";
			sql += " (select * from place where p_addr like '%"+sear+"%' ";
			sql += " union select * from food where f_addr like '%"+sear+"%' ) s )";
			sql +=" where rnum >= ? and rnum <= ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				S_DTO board = new S_DTO();
				board.setId(rs.getString("id"));
				board.setS_num(rs.getInt("p_num"));
				board.setS_name(rs.getString("p_name"));
				board.setS_content(rs.getString("p_content"));
				board.setS_file(rs.getString("p_file"));
				board.setS_addr(rs.getString("p_addr"));			
				board.setS_readcnt(rs.getInt("p_readcnt"));
				board.setS_reg(rs.getTimestamp("p_reg"));
				board.setS_theme(rs.getString("p_theme"));
				
				list.add(board);
			}
			
/*			sql = "select * from ( select rownum rnum, f_num, f_name, f_content, f_file, f_addr, f_readcnt from ";
			sql += "(select * from food where f_name like '%"+sear+"%' order by f_num desc)) ";
			sql += "where rnum >= ? and rnum <= ?";			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				S_DTO board = new S_DTO();
				board.setS_num(rs.getInt("f_num"));
				board.setS_name(rs.getString("f_name"));
				board.setS_content(rs.getString("f_content"));
				board.setS_file(rs.getString("f_file"));
				board.setS_addr(rs.getString("f_addr"));			
				board.setS_readcnt(rs.getInt("f_readcnt"));
				
				list.add(board);
			} */
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close();}catch(Exception e) {}
			if(pstmt != null) try { pstmt.close();}catch(Exception e) {}
			if(con != null) try { con.close();}catch(Exception e) {}
		}
		
		return list;
	}
}
