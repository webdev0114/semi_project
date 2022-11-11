

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.P_DTO;
import dao.P_DAO;

public class P_DAO {

	private static P_DAO instance = new P_DAO();
	
	public static P_DAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	// 글작성: 원문작성
	public int insert(P_DTO p) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql ="insert into place values(place_seq.nextval,?,?,?,?,?,";
		    sql +="sysdate,?,?,place_seq.nextval,?,?,?,?)";
			
		    pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, p.getP_name());
		    pstmt.setString(2, p.getP_content());
		    pstmt.setString(3, p.getP_file());
		    pstmt.setString(4, p.getP_addr());
		    pstmt.setInt(5, 0);
		    pstmt.setString(6, "");
		    pstmt.setString(7, "place");
		    pstmt.setInt(8, 0);
		    pstmt.setInt(9, 0);
		    pstmt.setString(10, p.getId());
		    pstmt.setString(11,p.getP_pw());
		   
		    result = pstmt.executeUpdate();
	   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return result;
	}
	
	// 총 데이터 개수 구하기
	public int getCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select count(*) from place";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return result;
	}
	
	//글 목록
	public List<P_DTO> getList(int start, int end){
		List<P_DTO> list = new ArrayList<P_DTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from (select rownum rnum, p.* from ";
			sql+=" ( select * from place order by p_ref desc, ";
			sql+=" p_step asc) p ) ";
			sql+=" where rnum >= ? and rnum <= ?";
	   
	   		pstmt = con.prepareStatement(sql);
	   		pstmt.setInt(1, start);
	   		pstmt.setInt(2, end);
	   		rs = pstmt.executeQuery();
	   		
	   		while(rs.next()) {
	   			P_DTO p = new P_DTO();
	   			
	   			p.setP_num(rs.getInt("p_num"));
	   			p.setP_name(rs.getString("p_name"));
	   			p.setP_content(rs.getString("p_content"));
	   			p.setP_file(rs.getString("p_file"));
	   			p.setP_addr(rs.getString("p_addr"));
	   			p.setP_readcnt(rs.getInt("p_readcnt"));
	   			p.setP_reg(rs.getTimestamp("p_reg"));
	   			p.setP_loc(rs.getString("p_loc"));
	   			p.setP_theme(rs.getString("p_theme"));
	   			p.setP_ref(rs.getInt("p_ref"));
	   			p.setP_step(rs.getInt("p_step"));
	   			p.setP_lvl(rs.getInt("p_lvl"));
	   			p.setId(rs.getString("id"));
	   			p.setP_pw(rs.getString("p_pw"));
	   			
	   			list.add(p);
	   		}
	   
	   
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return list;
	}
	
	// 조회수 증가
	public void readcountUpdate(int p_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
		
			String sql="update place set p_readcnt=p_readcnt+1 ";			
			sql+=" where p_num = ?";
		       
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_num);
			pstmt.executeUpdate();
		 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}		
	}
	
	// 상세 페이지
	public P_DTO getDetail(int p_num) {
		P_DTO p = new P_DTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql = "select * from place where p_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				p.setP_num(rs.getInt("p_num"));
	   			p.setP_name(rs.getString("p_name"));
	   			p.setP_content(rs.getString("p_content"));
	   			p.setP_file(rs.getString("p_file"));
	   			p.setP_addr(rs.getString("p_addr"));
	   			p.setP_readcnt(rs.getInt("p_readcnt"));
	   			p.setP_reg(rs.getTimestamp("p_reg"));
	   			p.setP_loc(rs.getString("p_loc"));
	   			p.setP_theme(rs.getString("p_theme"));
	   			p.setP_ref(rs.getInt("p_ref"));
	   			p.setP_step(rs.getInt("p_step"));
	   			p.setP_lvl(rs.getInt("p_lvl"));
	   			p.setId(rs.getString("id"));
	   			p.setP_pw(rs.getString("p_pw"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (con != null) try { con.close();} catch (Exception e) {}
		}
		return p;
	}
	
		// 글 수정
		public int update(P_DTO p) {
			int result = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				 String sql = "update place set p_name=?, p_content=?, p_addr=?, p_file=? where p_num=?";
				 		
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, p.getP_name());
				pstmt.setString(2, p.getP_content());
				pstmt.setString(3, p.getP_addr());
				pstmt.setString(4, p.getP_file());
				pstmt.setInt(5, p.getP_num());
				
				
				result = pstmt.executeUpdate();	
				 		
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
				if (con != null) try { con.close();} catch (Exception e) {}
			}
			return result;
		}
		
		// 글 삭제
		public int delete(int p_num) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
						
				String sql = "delete from place where p_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, p_num);
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
				if (con != null) try { con.close();} catch (Exception e) {}
			}
			return result;
		}
}
