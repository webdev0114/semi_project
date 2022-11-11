package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.R_DAO;
import dto.R_DTO;

public class R_ListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("R_ListAction");
		
		int page = 1;			// 현재 페이지
		int limit = 10;			// 화면 출력할 데이터 갯수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		R_DAO dao = R_DAO.getInstance();
		int listcount = dao.getCount();			//총 데이터 갯수
		System.out.println("listcount:"+listcount);
		
		List<R_DTO> reviewlist = dao.getList(startRow, endRow);
		System.out.println("reviewlist:"+reviewlist);
		
		// 총 페이지수
		int pageCount = listcount/limit +((listcount%10==0)?0:1);
		
		int startPage = ((page-1)/10) * limit + 1;		
		int endPage = startPage + 10 -1;				
		
		if(endPage > pageCount) endPage = pageCount;
		
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("reviewlist", reviewlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startRow", startRow);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./review/r_listform.jsp");
		
		return forward;
	}

}
