package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.F_DAO;
import dto.F_DTO;

public class F_DetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("F_DetailAction");
		
		int f_num = Integer.parseInt(request.getParameter("f_num"));
		String page = request.getParameter("page");
		
		F_DAO dao = F_DAO.getInstance();
		dao.readcountUpdate(f_num);					// 조회수 증가
		F_DTO food = dao.getDetail(f_num);		// 상세 정보 구하기
		
		// 글 내용에서 줄바꿈
		String content = food.getF_content().replace("\n", "<br>");
		
		// 공유 설정
		request.setAttribute("food", food);
		request.setAttribute("page", page);
		request.setAttribute("content", content);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./food/f_viewform.jsp");
		
		return forward;
	}

}
