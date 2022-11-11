package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_DAO;
import dto.Q_DTO;

public class Q_Modify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Q_Modify");

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		int q_num = Integer.parseInt(request.getParameter("q_num"));
		String page = request.getParameter("page");
		String q_pw = request.getParameter("q_pw");

		Q_DTO board = new Q_DTO();
		board.setQ_num(q_num);
		board.setId(request.getParameter("id"));
		board.setQ_title(request.getParameter("q_title"));
		board.setQ_content(request.getParameter("q_content"));

		Q_DAO dao = Q_DAO.getInstance();
		Q_DTO old = dao.getDetail(q_num); 

		// 비밀번호 비교
		if (old.getQ_pw().equals(q_pw)) { 
			int result = dao.update(board);
			if (result == 1)
				System.out.println("수정 성공");

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
		forward.setPath("/Q_DetailAction.q?q_num=" + q_num + "&page=" + page);

		return forward;
	}

}