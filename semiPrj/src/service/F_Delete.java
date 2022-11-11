package service;

import java.io.File;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.F_DAO;
import dto.F_DTO;

public class F_Delete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("R_Delete");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int f_num = Integer.parseInt(request.getParameter("f_num"));
		String page = request.getParameter("page");
		String f_pw =request.getParameter("f_pw");
		
		String path = request.getRealPath("p_file");
		System.out.println("path:"+path);
		
		F_DAO dao = F_DAO.getInstance();
		F_DTO old = dao.getDetail(f_num);		// 상세정보 구하기
		
		
		if(old.getF_pw().equals(f_pw)) {
			int result = dao.delete(f_num);
			if(result == 1)System.out.println("삭제 성공");
			
			// 첨부파일이 있을 경우에 첨부파일 사제
			if(old.getF_file() != "") {
				
				File file = new File(path);
				file.mkdir();
				
				// boardupload 디렉토리의 모든 첨부파일 구해오기
				File[] f = file.listFiles();
				for(int i=0; i<f.length; i++) {
					if(f[i].getName().equals(old.getF_file())) {
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
		forward.setPath("/F_ListAction.f?page="+page);

		
		return forward;
	}
	
	

}
