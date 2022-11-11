package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.S_DAO;
import dto.S_DTO;

public class S_DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("S_DetailAction");
		
//		int s_num = Integer.parseInt(request.getParameter("s_num"));
		String page = request.getParameter("page");
		
//		S_DAO dao = S_DAO.getInstance();
//		dao.readcountUpdate(s_num);
//		S_DTO s = dao.getDetail(s_num);
		
//		String content = s.getP_content().replace("\n", "<br>");
		
//		request.setAttribute("s", s);
		request.setAttribute("page", page);
//		request.setAttribute("content", content);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./search/s_detailform.jsp");
		
		return forward;
	}

}
