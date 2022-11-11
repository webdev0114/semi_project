package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.P_DAO;
import dto.P_DTO;

public class P_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("P_ListAction");
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		P_DAO dao = P_DAO.getInstance();
		int listcount = dao.getCount();
		System.out.println("listcount:" + listcount);
		
		List<P_DTO> boardlist = dao.getList(startRow, endRow);
		System.out.println("boardlist:" + boardlist);
		
		int pageCount = listcount/limit+((listcount%10==0) ? 0:1);
		
		int startPage = ((page-1)/10) * limit + 1;
		int endPage = startPage + 10 - 1;
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage); 
		request.setAttribute("startRow", startRow); 
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./place/p_listform.jsp");
		
		return forward;
	}

}
