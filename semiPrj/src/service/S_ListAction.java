package service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.S_DAO;
import dto.S_DTO;


public class S_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("S_ListAction");
		
		request.setCharacterEncoding("utf-8");

		int page = 1;
		int limit = 10;
		String sear = request.getParameter("sear");
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		S_DAO dao = S_DAO.getInstance();
		int listcount = dao.getCount(sear);
		System.out.println("listcount:" + listcount);
		
		List<S_DTO> boardlist = dao.getList(startRow, endRow, sear);
		System.out.println("boardlist:" + boardlist);
		
		int pageCount = listcount/(limit)+((listcount%10==0) ? 0:1);
		
		int startPage = ((page-1)/10) * (limit) + 1;
		int endPage = startPage + 10 - 1;
		
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage); 
		request.setAttribute("sear", sear); 
		request.setAttribute("startRow", startRow);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./search/s_listform.jsp");
		
		return forward;
	}

}
