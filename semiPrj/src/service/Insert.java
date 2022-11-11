package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.M_DAO;
import dto.M_DTO;

public class Insert implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Insert");
		
		request.setCharacterEncoding("utf-8");
		
		M_DTO member = new M_DTO();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setPost(request.getParameter("post"));
		member.setAddr(request.getParameter("addr"));
		member.setJumin1(request.getParameter("jumin1"));
		member.setJumin2(request.getParameter("jumin2"));
		member.setTel1(request.getParameter("tel1"));
		member.setTel2(request.getParameter("tel2"));
		member.setTel3(request.getParameter("tel3"));
		member.setMail(request.getParameter("mail"));
		member.setDomain(request.getParameter("domain"));
		member.setSeller(request.getParameter("selection"));
		
		M_DAO dao = M_DAO.getInstance();
		int result = dao.insert(member);
		
		if (result == 1) {
			System.out.println("회원 가입 성공");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./main/loginform.jsp");
		return forward;
	}
	
}
