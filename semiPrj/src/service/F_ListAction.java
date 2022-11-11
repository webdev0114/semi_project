package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.F_DAO;
import dto.F_DTO;

public class F_ListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("F_ListAction");
		
		
		int page = 1;			// 현재 페이지
		int limit = 10;			// 화면 출력할 데이터 갯수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page-1) * limit + 1;
		int endRow = page * limit;
		
		F_DAO dao = F_DAO.getInstance();
		int listcount = dao.getCount();			//총 데이터 갯수
		System.out.println("listcount:"+listcount);
		
		List<F_DTO> foodlist = dao.foodlist(startRow, endRow);
		System.out.println("foodlist:"+foodlist);
		
//		int f_num = Integer.parseInt(request.getParameter("f_num"));
//		F_DTO food = dao.getDetail(f_num);
//		String content = food.getF_content().replace("\n", "<br>");

		
		// 총 페이지수
		int pageCount = listcount/limit +((listcount%10==0)?0:1);
		
		int startPage = ((page-1)/10) * limit + 1;		
		int endPage = startPage + 10 -1;				
		
		if(endPage > pageCount) endPage = pageCount;
		
		
		request.setAttribute("page", page);
		request.setAttribute("listcount", listcount);
		request.setAttribute("foodlist", foodlist);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startRow", startRow);
		
//		request.setAttribute("content", content); // 줄바꿈된 내용 공유 설정
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./food/f_listform.jsp");
		
		return forward;
	}

}
