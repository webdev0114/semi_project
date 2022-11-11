package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_DAO;
import dto.Q_DTO;

public class Q_ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Q_ModifyAction");

		int q_num = Integer.parseInt(request.getParameter("q_num"));
		String page = request.getParameter("page");

		Q_DAO dao = Q_DAO.getInstance();
		Q_DTO board = dao.getDetail(q_num);

		// 공유 설정
		request.setAttribute("board", board);
		request.setAttribute("page", page);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./qna/q_modifyform.jsp");

		return forward;
	}

}
