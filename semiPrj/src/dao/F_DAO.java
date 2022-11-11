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

import dto.F_DTO;

public class F_DAO {

	private static F_DAO instance = new F_DAO();
	
	public static F_DAO getInstance () {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
  		return ds.getConnection();
	}
	
	
	// 글작성
	public int insert(F_DTO food) {
		int result = 0;
		
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			
			String sql="insert into food values(food_seq.nextval,?,?,?,?,?,sysdate,?,?,food_seq.nextval,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, food.getF_name());
			pstmt.setString(2, food.getF_content());
			pstmt.setString(3, food.getF_file());
			pstmt.setString(4, food.getF_addr());
			pstmt.setInt(5, food.getF_readcnt());
			pstmt.setString(6, food.getF_loc());
			pstmt.setString(7, "food");
			pstmt.setInt(8, food.getF_step());
			pstmt.setInt(9, food.getF_lvl());
			pstmt.setString(10, food.getId());
			pstmt.setString(11, food.getF_pw());
		

			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{ pstmt.close();}catch(Exception e) {}
			if(con != null) try{ con.close();}catch(Exception e) {}
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

			String sql = "select count(*) from food";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
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
	
	// 목록
	public List<F_DTO> foodlist(int start, int end){
		List<F_DTO> list = new ArrayList<F_DTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con = getConnection();
			
			String sql = "select * from (select rownum rnum, food.* from ";
			sql += " (select * from food order by f_ref desc, ";
			sql += " f_step asc) food ) where rnum >= ? and rnum <= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				F_DTO food = new F_DTO();
				food.setF_num(rs.getInt("f_num"));
				food.setF_name(rs.getString("f_name"));
				food.setF_content(rs.getString("f_content"));
				food.setF_file(rs.getString("f_file"));
				food.setF_addr(rs.getString("f_addr"));
				food.setF_readcnt(rs.getInt("f_readcnt"));
				food.setF_reg(rs.getTimestamp("f_reg"));
				food.setF_loc(rs.getString("f_loc"));
				food.setF_theme(rs.getString("f_theme"));
				food.setF_ref(rs.getInt("f_ref"));
				food.setF_step(rs.getInt("f_step"));
				food.setF_lvl(rs.getInt("f_lvl"));
				food.setId(rs.getString("id"));
				food.setF_pw(rs.getString("f_pw"));

				list.add(food);

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(Exception e) {}
			if(pstmt!=null) try {pstmt.close();}catch(Exception e) {}
			if(con!=null) try {con.close();}catch(Exception e) {}
		}
		
		return list;
	}
	
	
	// 조회수 증가
	public void readcountUpdate(int f_num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
				
		try {
			con = getConnection();
			
			String sql = "update food set f_readcnt=f_readcnt+1 where f_num=?";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, f_num);
			pstmt.executeUpdate();			// sql문 실행
					
		}catch(Exception e) {
					e.printStackTrace();
		}finally {
			if( pstmt != null) try { pstmt.close();} catch(Exception e) {}
			if( con != null) try { con.close();} catch(Exception e) {}
		}

	}
	
	// 상세 페이지
	public F_DTO getDetail(int f_num) {
		F_DTO food = new F_DTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			con = getConnection();
			String sql="select * from food where f_num=?";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, f_num);
			rs = pstmt.executeQuery();
					
			if(rs.next()) {
				food.setF_num(rs.getInt("f_num"));
				food.setF_name(rs.getString("f_name"));
				food.setF_content(rs.getString("f_content"));
				food.setF_file(rs.getString("f_file"));
				food.setF_addr(rs.getString("f_addr"));
				food.setF_readcnt(rs.getInt("f_readcnt"));
				food.setF_reg(rs.getTimestamp("f_reg"));
				food.setF_loc(rs.getString("f_loc"));
				food.setF_theme(rs.getString("f_theme"));
				food.setF_ref(rs.getInt("f_ref"));
				food.setF_step(rs.getInt("f_step"));
				food.setF_lvl(rs.getInt("f_lvl"));
				food.setId(rs.getString("id"));
				food.setF_pw(rs.getString("f_pw"));
				
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if( rs != null) try { rs.close();} catch(Exception e) {}
			if( pstmt != null) try { pstmt.close();} catch(Exception e) {}
			if( con != null) try { con.close();} catch(Exception e) {}
		}
		return food;
	}		
			
			
	// 글 삭제
	public int delete(int f_num) {
		int result = 0;
		Connection con =null;
		PreparedStatement pstmt = null;
				
		try {
			con = getConnection();
			String sql="delete from food where f_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, f_num);
			result = pstmt.executeUpdate();
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if( pstmt != null) try { pstmt.close();} catch(Exception e) {}
			if( con != null) try { con.close();} catch(Exception e) {}
		}	
		return result;
	}
		
	
	// 글 수정
		public int update(F_DTO food) {
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
			String sql="update food set f_name=?,";
			       sql+=" f_content=?, f_file=?, f_addr=? where f_num=?";
			       
			    pstmt = con.prepareStatement(sql);
			    pstmt.setString(1, food.getF_name());
			    pstmt.setString(2, food.getF_content());
			    pstmt.setString(3, food.getF_file());
			    pstmt.setString(4, food.getF_addr());
			    pstmt.setInt(5, food.getF_num());
			    
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
