package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_DAO;
import dto.Q_DTO;

public class Q_Reply implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Q_Reply");

		request.setCharacterEncoding("utf-8");

		int q_num = Integer.parseInt(request.getParameter("q_num"));
		int q_ref = Integer.parseInt(request.getParameter("q_ref"));
		int q_step = Integer.parseInt(request.getParameter("q_step"));
		int q_lvl = Integer.parseInt(request.getParameter("q_lvl"));
		
		String page = request.getParameter("page");

		Q_DTO board = new Q_DTO();
		board.setQ_num(q_num);
		board.setQ_ref(q_ref);
		board.setQ_step(q_step);
		board.setQ_lvl(q_lvl);
		board.setId(request.getParameter("id"));
		board.setQ_title(request.getParameter("q_title"));
		board.setQ_content(request.getParameter("q_content"));
		board.setQ_pw(request.getParameter("q_pw"));

		Q_DAO dao = Q_DAO.getInstance();
		int result = dao.boardReply(board);
		if (result == 1)
			System.out.println("답변 작성됨");

		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./Q_ListAction.q?page=" + page);

		return forward;
	}

}
