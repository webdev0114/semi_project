package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.P_DAO;
import dto.P_DTO;

public class P_DetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("P_DetailAction");
		
		int p_num = Integer.parseInt(request.getParameter("p_num"));
		String page = request.getParameter("page");
		
		P_DAO dao = P_DAO.getInstance();
		dao.readcountUpdate(p_num);
		P_DTO p = dao.getDetail(p_num);
		
		String content = p.getP_content().replace("\n", "<br>");
		
		request.setAttribute("p", p);
		request.setAttribute("page", page);
		request.setAttribute("content", content);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./place/p_detailform.jsp");
		
		return forward;
	}

}
