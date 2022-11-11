package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.Q_DTO;
import dto.RE_DTO;
import dto.R_DTO;

public class RE_DAO {
	private static RE_DAO instance = new RE_DAO();
	
	public static RE_DAO getinstacne() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
		return ds.getConnection();
	}
	
	// 댓글 작성
	public int insert(RE_DTO comment) {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "insert into r_comment values(comment_seq.nextval,?,?,sysdate,?,?,comment_seq.nextval,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, comment.getR_num());
			pstmt.setString(2, comment.getRe_comment());
			pstmt.setString(3, comment.getId());
			pstmt.setString(4, comment.getRe_file());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			result = pstmt.executeUpdate();
			
			System.out.println("insert 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}

		return result;
	}

	
	// 총 데이터 갯수
	public int getCount(int r_num) {
		int result = 0;
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "select count(*) from r_comment where r_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
					result = rs.getInt(1);
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
	
	
	// 댓글 리스트
	public List<RE_DTO> getList(int r_num) {
		List<RE_DTO> list = new ArrayList<RE_DTO>();
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			
			/*
			 * String sql="select * from ( select rownum rnum, comment.* from ";
			 * sql+=" ( select * from r_comment order by re_re_ref desc, ";
			 * sql+=" re_re_seq asc) comment ) "; sql+=" where rnum >= ? and rnum <= ?";
			 */
			String sql = "select * from r_comment where r_num=? order by re_re_ref desc, re_re_seq asc";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RE_DTO comment = new RE_DTO();
				comment.setR_num(rs.getInt("r_num"));
				comment.setRe_num(rs.getInt("re_num"));
				comment.setRe_comment(rs.getString("re_comment"));
				comment.setRe_reg(rs.getTimestamp("re_reg"));
				comment.setId(rs.getString("id"));		
				comment.setRe_file(rs.getString("re_file"));
				comment.setRe_re_ref(rs.getInt("re_re_ref"));
				comment.setRe_re_lev(rs.getInt("re_re_lev"));
				comment.setRe_re_seq(rs.getInt("re_re_seq"));

				list.add(comment);

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
	
	
	
	// 댓글 상세정보
		public RE_DTO getDetail(int re_num) {
			RE_DTO comment = new RE_DTO();
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = getConnection();
				String sql = "select * from r_comment where re_num=?";

				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, re_num);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					comment.setR_num(rs.getInt("r_num"));
					comment.setRe_num(rs.getInt("re_num"));
					comment.setRe_comment(rs.getString("re_comment"));
					comment.setRe_reg(rs.getTimestamp("re_reg"));
					comment.setId(rs.getString("id"));
					comment.setRe_file(rs.getString("re_file"));
					comment.setRe_re_ref(rs.getInt("re_re_ref"));
					comment.setRe_re_lev(rs.getInt("re_re_lev"));
					comment.setRe_re_seq(rs.getInt("re_re_seq"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null) try { rs.close();} catch (Exception e) {}
				if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
				if (con != null) try { con.close();} catch (Exception e) {}
			}
			return comment;
		}
	
		
		// 댓글삭제
		public int delete(RE_DTO old) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = "";
			try {
				con = getConnection();
				
				if(old.getRe_re_lev() == 2) {
					sql = "delete from r_comment where re_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, old.getRe_num());
					result = pstmt.executeUpdate();

				
				}else {
					sql = "update r_comment set re_comment=?, re_file=? where re_num=?";

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "삭제된 댓글입니다.");
					pstmt.setString(2, null);
					pstmt.setInt(3, old.getRe_num());
					result = pstmt.executeUpdate();
					
					

					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
				if (con != null) try { con.close();} catch (Exception e) {}
			}
			return result;
		}
		
		
		// 댓글 수정
		public int update(RE_DTO comment) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			
			try {
				con = getConnection();
				
				String sql="update r_comment set re_comment=?, re_file=? where re_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, comment.getRe_comment());
				pstmt.setString(2, comment.getRe_file());
				pstmt.setInt(3, comment.getRe_num());
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
				if (con != null) try { con.close();} catch (Exception e) {}
			}
			return result;
		}
		
		
		// 대댓글 작성
		public int reRecomment(RE_DTO comment) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			// 댓글에 대한 정보
			int re_ref = comment.getRe_re_ref();
			int re_lev = comment.getRe_re_lev();
			int re_seq = comment.getRe_re_seq();
			
			
			try {
				con = getConnection();
				
				String sql = "update r_comment set re_re_seq = re_re_seq+1 ";
				sql += " where re_re_ref = ? and re_re_seq > ?";					
				
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, re_ref);
					pstmt.setInt(2, re_seq);
					pstmt.executeUpdate();
					
					sql = "insert into r_comment values(comment_seq.nextval,?,?,sysdate,?,?,?,?,?)";
				
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, comment.getR_num());
					pstmt.setString(2, comment.getRe_comment());
					pstmt.setString(3, comment.getId());
					pstmt.setString(4, comment.getRe_file());
					pstmt.setInt(5, re_ref);
					pstmt.setInt(6, re_lev+1);
					pstmt.setInt(7, re_seq+1);
					result = pstmt.executeUpdate();
					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) try { pstmt.close();}catch(Exception e) {}
				if(con != null) try { con.close();}catch(Exception e) {}
			}
			
			return result;
		}

		
	
	
}
