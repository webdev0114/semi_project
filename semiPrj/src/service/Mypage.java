package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mypage implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("MyPage");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./main/mypageform.jsp");
		return forward;
	}

}
