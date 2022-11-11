package service;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RE_DAO;
import dao.R_DAO;
import dto.RE_DTO;
import dto.R_DTO;

public class RE_Delete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RE_Delete");
		
		response.setContentType("text/html; charset=utf-8");
		
		
		
		
		PrintWriter out = response.getWriter();
		
		String page = request.getParameter("page");
		String id = request.getParameter("id");
		int r_num = Integer.parseInt(request.getParameter("r_num"));
		int re_num = Integer.parseInt(request.getParameter("re_num"));
		
		/*
		 * RE_DAO redao = RE_DAO.getinstacne(); RE_DTO comment =
		 * redao.getDetail(re_num);
		 */
		
		String path = request.getRealPath("re_file");
		
		
		RE_DAO dao = RE_DAO.getinstacne();
		RE_DTO old = dao.getDetail(re_num);
		
		if(old.getId().equals(id)) {
			int result = dao.delete(old);
			System.out.println("삭제 성공");
			
				// 첨부파일 삭제
				if(old.getRe_file() != "") {
					
					File file = new File(path);
					file.mkdir();
					
					// 모든 첨부파일 구해오기
					File[] f = file.listFiles();
					for(int i=0; i<f.length; i++) {
						if(f[i].getName().equals(old.getRe_file())) {
							f[i].delete();
						}
					}

				}
		}else {
			out.println("<script>");
			out.println("alert('아이디가 일치하지 않습니다');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/R_DetailAction.r?r_num="+r_num+"&page="+page);
		
		return forward;
	}

}
