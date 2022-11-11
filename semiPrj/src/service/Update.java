package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.M_DAO;
import dto.M_DTO;

public class Update implements Action {
 
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Update");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		M_DTO member = new M_DTO();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setPost(request.getParameter("post"));
		member.setAddr(request.getParameter("addr"));
		member.setTel1(request.getParameter("tel1"));
		member.setTel2(request.getParameter("tel2"));
		member.setTel3(request.getParameter("tel3"));
		member.setMail(request.getParameter("mail"));
		member.setDomain(request.getParameter("domain"));

		M_DAO dao = M_DAO.getInstance();
		M_DTO old = dao.getMember(member.getId());
		
		if(old.getPw().equals(member.getPw())) {// 비밀번호 일치
			int result = dao.update(member);	
			if(result == 1) System.out.println("회원 수정 성공");
		}else {	// 비밀번호 불일치
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
