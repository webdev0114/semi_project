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
import service.F_AddAction;
import service.F_Delete;
import service.F_DetailAction;
import service.F_ListAction;
import service.F_Modify;
import service.F_ModifyAction;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.f")
public class F_Controller extends HttpServlet {
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

		// 글 작성
		if (command.equals("/F_AddAction.f")) {
			try {
				action = new F_AddAction();
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		// 글 작성 폼
		} else if (command.equals("/F_BoardForm.f")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./food/f_writeform.jsp");

		// 리스트(상세페이지)
		} else if (command.equals("/F_ListAction.f")) {
			try {
				action = new F_ListAction();
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		// 상세페이지
		} else if (command.equals("/F_DetailAction.f")) {
			try {
				action = new F_DetailAction();
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		// 삭제 폼
		} else if (command.equals("/F_DeleteAction.f")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./food/f_deleteform.jsp");

		// 글 삭제
		} else if (command.equals("/F_Delete.f")) {
			try {
				action = new F_Delete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 글 수정 폼
		} else if (command.equals("/F_ModifyAction.f")) {
			try {
				action = new F_ModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 글 수정
		} else if (command.equals("/F_Modify.f")) {
			try {
				action = new F_Modify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 포워딩 처리
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("get");

		doProcess(request, response); // doProcess() 메소드 호출

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("post");

		doProcess(request, response); // doProcess() 메소드 호출

	}

}
