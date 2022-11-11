package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Action;
import service.ActionForward;
import service.IndexAction;
import service.P_DetailAction;
import service.S_DetailAction;
import service.S_ListAction;

@WebServlet("*.s")
public class S_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI:" + requestURI); 
		System.out.println("contextPath:" + contextPath); 
		System.out.println("command:" + command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 검색 목록
		if (command.equals("/S_ListAction.s")) {
			try {
				action = new S_ListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		
		// 상세 페이지	
		} else if (command.equals("/S_DetailAction.s")) {
			try {
				action = new S_DetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 수정폼
		}
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get");
		
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post");
		
		doProcess(request, response);
	}

}
