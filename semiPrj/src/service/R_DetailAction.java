package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RE_DAO;
import dao.R_DAO;
import dto.RE_DTO;
import dto.R_DTO;

public class R_DetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("R_DetailAction");
		
		int r_num = Integer.parseInt(request.getParameter("r_num"));
		String page = request.getParameter("page");
		
		R_DAO dao = R_DAO.getInstance();
		dao.readcountUpdate(r_num);					// 조회수 증가
		R_DTO review = dao.getDetail(r_num);		// 상세정보 구하기
		
		// 글 내용에서 줄바꿈
		String content = review.getR_content().replace("\n", "<br>");
		
		// 공유 설정
		request.setAttribute("review", review);
		request.setAttribute("page", page);
		request.setAttribute("content", content);
		
		
		
		// 댓글 페이징 처리
		int pages = 1;			
		int limit = 10;	
		
		
		
		// 댓글목록 구하기
		RE_DAO redao = RE_DAO.getinstacne();
		List<RE_DTO> re_list = redao.getList(r_num);
		System.out.println("re_list:"+re_list);
		
		// 총 댓글수 구하기
		int relistcount = redao.getCount(r_num);			//총 데이터 갯수
		System.out.println("relistcount:"+relistcount);
		
		
		
		request.setAttribute("re_list", re_list);	
		request.setAttribute("relistcount", relistcount);	
		
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);	
		forward.setPath("./review/r_viewform.jsp");
		
		return forward;
	}

}
