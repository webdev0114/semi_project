package service;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.M_DAO;
import dto.M_DTO;

public class Login implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Login");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("pw");
		
//		String s_id = request.getParameter("p_id");
//		String s_pw = request.getParameter("p_pw");
		
		M_DAO dao = M_DAO.getInstance();
		int result = dao.M_Auth(id, passwd);
		
		if (result == 1) {
			System.out.println("회원 인증 성공");
		}
		
		if (result == 1) { 
			M_DTO member = dao.getMember(id);
			
			session.setAttribute("id", id); // 세션 공유
			session.setAttribute("seller", member.getSeller()); // 세션 공유
		} else {
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			
			return null; 
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./main/index.jsp");
		
		return forward;
	}

}
