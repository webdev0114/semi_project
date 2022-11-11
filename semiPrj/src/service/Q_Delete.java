package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_DAO;
import dto.Q_DTO;

public class Q_Delete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Q_Delete");

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		int q_num = Integer.parseInt(request.getParameter("q_num"));
		String page = request.getParameter("page");
		String q_pw = request.getParameter("q_pw");

		Q_DAO dao = Q_DAO.getInstance();
		Q_DTO old = dao.getDetail(q_num); 

		if (old.getQ_pw().equals(q_pw)) { 
			int result = dao.delete(q_num); 
			if (result == 1)
				System.out.println("삭제 성공");


		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();

			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Q_ListAction.q?page=" + page);

		return forward;
	}

}