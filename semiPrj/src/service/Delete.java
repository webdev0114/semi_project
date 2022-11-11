package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.M_DAO;
import dto.M_DTO;

public class Delete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Delete");

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		M_DAO dao = M_DAO.getInstance();
		M_DTO old = dao.getMember(id);

		if (old.getPw().equals(pw)) { // 비밀번호 일치
			int result = dao.delete(id);
			
			if (result == 1) System.out.println("회원 탈퇴 성공");

			session.invalidate(); // 세션 삭제
			
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
		forward.setPath("./main/index.jsp");

		return forward;
	}

}
