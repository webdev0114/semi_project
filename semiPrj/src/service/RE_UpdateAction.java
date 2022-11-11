package service;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RE_DAO;
import dao.R_DAO;
import dto.RE_DTO;
import dto.R_DTO;

public class RE_UpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		System.out.println("RE_UpdateAction");
		PrintWriter out = response.getWriter();

		
		int re_num = Integer.parseInt(request.getParameter("re_num"));
		String page = request.getParameter("page");
		String id = request.getParameter("id");
		String re_comment = request.getParameter("re_comment");
		int r_num = Integer.parseInt(request.getParameter("r_num"));
		
		
		RE_DAO re_dao = RE_DAO.getinstacne();
		RE_DTO old = re_dao.getDetail(re_num);
		
		if(old.getId().equals(id)) {
			
			R_DAO dao = R_DAO.getInstance();
			R_DTO review = dao.getDetail(r_num);
			
			RE_DAO redao = RE_DAO.getinstacne();
			RE_DTO comment = redao.getDetail(re_num);
			
			
			request.setAttribute("review", review);
			request.setAttribute("comment", comment);
			request.setAttribute("page", page);
			request.setAttribute("re_comment", re_comment);
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./review/re_update.jsp");
			return forward;
						

		}else {
			out.println("<script>");
			out.println("alert('아이디가 일치하지 않습니다');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}

		
	}

}
