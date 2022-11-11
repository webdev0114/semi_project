package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_DAO;
import dto.Q_DTO;

public class Q_DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Q_DetailAction");

		int q_num = Integer.parseInt(request.getParameter("q_num"));
		String page = request.getParameter("page");

		Q_DAO dao = Q_DAO.getInstance();
		dao.readcountUpdate(q_num); 		// 조회수 증가
		Q_DTO board = dao.getDetail(q_num); // 상세정보 구하기

		
		String content = board.getQ_content().replace("\n", "<br>");

		// 공유 설정
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		request.setAttribute("content", content);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); 
		forward.setPath("./qna/q_viewform.jsp");
		return forward;
	}

}
