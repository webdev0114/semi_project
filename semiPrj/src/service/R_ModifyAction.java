package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.R_DAO;
import dto.R_DTO;

public class R_ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("R_ModifyAction");
		
		int r_num = Integer.parseInt(request.getParameter("r_num"));
		String page = request.getParameter("page");
		
		R_DAO dao = R_DAO.getInstance();
		R_DTO review = dao.getDetail(r_num);
		
		request.setAttribute("review", review);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./review/r_modify.jsp");
		return forward;
	}

}
