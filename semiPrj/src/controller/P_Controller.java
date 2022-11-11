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
import service.P_Delete;
import service.P_Modify;
import service.P_ModifyAction;
import service.P_AddAction;
import service.P_DetailAction;
import service.P_ListAction;

@WebServlet("*.p")
public class P_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI:" + requestURI);
		System.out.println("contextPath:" + contextPath);
		System.out.println("command:" + command);

		Action action = null;
		ActionForward forward = null;

		// 글작성(원문작성)
		if (command.equals("/P_AddAction.p")) {
			try {
				action = new P_AddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 글작성 폼
		} else if (command.equals("/P_WriteForm.p")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./place/p_writeform.jsp");

			// 글목록
		} else if (command.equals("/P_ListAction.p")) {
			try {
				action = new P_ListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 상세 페이지
		} else if (command.equals("/P_DetailAction.p")) {
			try {
				action = new P_DetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 수정폼
		} else if (command.equals("/P_ModifyAction.p")) {
			try {
				action = new P_ModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 글 수정
		} else if (command.equals("/P_Modify.p")) {
			try {
				action = new P_Modify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 삭제 폼
		} else if (command.equals("/P_DeleteAction.p")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./place/p_deleteform.jsp");

			// 글 삭제
		} else if (command.equals("/P_Delete.p")) {
			try {
				action = new P_Delete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else { // dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("get");

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("post");

		doProcess(request, response);
	}

}
