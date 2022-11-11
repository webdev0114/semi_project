package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.M_DAO;
import dto.M_DTO;


public class UpdateMember implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("UpdateMember");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		M_DAO dao = M_DAO.getInstance();
		M_DTO member = dao.getMember(id);
		System.out.println("수정 폼 : "+ member);
		
		request.setAttribute("member", member); // 공유 설정
		
		ActionForward forward = new ActionForward();		
		forward.setRedirect(false);
		forward.setPath("./main/updateform.jsp");
		
		return forward;
	}
}
