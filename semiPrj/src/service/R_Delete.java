package service;

import java.io.File;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.R_DAO;
import dto.R_DTO;

public class R_Delete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("R_Delete");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int r_num = Integer.parseInt(request.getParameter("r_num"));
		String page = request.getParameter("page");
		String r_pw =request.getParameter("r_pw");
		
		String path = request.getRealPath("r_file");
		System.out.println("path:"+path);
		
		R_DAO dao = R_DAO.getInstance();
		R_DTO old = dao.getDetail(r_num);		// 상세정보 구하기
		
		
		if(old.getR_pw().equals(r_pw)) {
			int result = dao.delete(r_num);			
			if(result == 1)System.out.println("삭제 성공");
			
			// 첨부파일이 있을 경우에 첨부파일 삭제
			if(old.getR_file() != "") {
				
				File file = new File(path);
				file.mkdir();
				
				// boardupload 디렉토리의 모든 첨부파일 구해오기
				File[] f = file.listFiles();
				for(int i=0; i<f.length; i++) {
					if(f[i].getName().equals(old.getR_file())) {
						f[i].delete();
					}
				}

			}
			
			
		}else {
			System.out.println("비밀번호 불일치");
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/R_ListAction.r?page="+page);

		
		return forward;
	}
	
	

}
