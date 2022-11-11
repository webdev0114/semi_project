package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.F_DAO;
import dto.F_DTO;

public class F_ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("F_ModifyAction");
		
		int f_num = Integer.parseInt(request.getParameter("f_num"));
		String page = request.getParameter("page");
		
		F_DAO dao = F_DAO.getInstance();
		F_DTO food = dao.getDetail(f_num);
		
		request.setAttribute("food", food);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./food/f_modify.jsp");
		return forward;
	}

}
