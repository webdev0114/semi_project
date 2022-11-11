package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RE_DAO;
import dto.RE_DTO;

public class RE_RecommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RE_RecommentAction");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();


		int re_num = Integer.parseInt(request.getParameter("re_num"));
		int r_num = Integer.parseInt(request.getParameter("r_num"));
		String page = request.getParameter("page");
		String id = request.getParameter("id");
		
		
		RE_DAO redao = RE_DAO.getinstacne();
		RE_DTO comment = redao.getDetail(re_num);
		
		
		request.setAttribute("comment", comment);
		request.setAttribute("page", page);
		request.setAttribute("id", id);
		request.setAttribute("r_num", r_num);

		
		System.out.println("여기까지 성공?");
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./review/re_recom.jsp");
		return forward;
	}

}
