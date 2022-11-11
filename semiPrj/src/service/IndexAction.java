package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("IndexAction");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./main/index.jsp");
		
		return forward;
	}

}
