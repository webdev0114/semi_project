package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.P_DAO;
import dto.P_DTO;

public class P_ModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("P_ModifyAction");
		
		int p_num = Integer.parseInt(request.getParameter("p_num"));
		String page = request.getParameter("page");
		
		P_DAO dao = P_DAO.getInstance();
		P_DTO p = dao.getDetail(p_num);	
		
		// 공유 설정
		request.setAttribute("p", p);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);	
		forward.setPath("/place/p_modifyform.jsp");
		
		return forward;
	}

}
