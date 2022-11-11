package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Q_DAO;
import dto.Q_DTO;

public class Q_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Q_ListAction");
		
		int page = 1;
		int limit = 10; 	// 한 페이지 당 노출되는 문의글 갯수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		Q_DAO dao = Q_DAO.getInstance();
		int listcount = dao.getCount();
		System.out.println("listcount: " + listcount);
		
		List<Q_DTO> boardlist = dao.getList(startRow, endRow);
		System.out.println("boardlist: " + boardlist);
		
		// 총 페이지  
		int pageCount = listcount/limit + ((listcount%limit == 0) ? 0 : 1);
		
		int startPage =((page-1)/10) * limit + 1;
		int endPage = startPage + 10 - 1;
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false); 
		forward.setPath("./qna/q_listform.jsp");
		
		return forward;
	}

}