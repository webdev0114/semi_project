// 1:1 문의 원글

package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Q_DAO;
import dto.Q_DTO;

public class Q_AddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Q_AddAction");

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Q_DTO board = new Q_DTO();
		board.setQ_title(request.getParameter("q_title"));
		board.setQ_content(request.getParameter("q_content"));
		board.setId(request.getParameter("id"));
		board.setQ_pw(request.getParameter("q_pw"));
	
		Q_DAO dao = Q_DAO.getInstance();
		int result = dao.insert(board);
		if(result == 1) System.out.println("글 작성됨");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Q_ListAction.q");
		
		
		return forward;
	}

}