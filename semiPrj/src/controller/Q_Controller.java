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
import service.Q_AddAction;
import service.Q_Delete;
import service.Q_DetailAction;
import service.Q_ListAction;
import service.Q_Modify;
import service.Q_ModifyAction;
import service.Q_Reply;
import service.Q_ReplyAction;

@WebServlet("*.q")
public class Q_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("requestURI: " + requestURI);
		System.out.println("contextPath: " + contextPath);
		System.out.println("command: " + command);

		Action action = null;
		ActionForward forward = null;

		// 문의글 작성
		if (command.equals("/Q_AddAction.q")) {
			try {
				action = new Q_AddAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// 글 작성 폼
		} else if (command.equals("/Q_QnaForm.q")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./qna/q_writeform.jsp");	
		// 문의글 목록
		} else if (command.equals("/Q_ListAction.q")) {
			try {
				action = new Q_ListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// 문의글 상세 내용
		} else if (command.equals("/Q_DetailAction.q")) {
			try {
				action = new Q_DetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 답변 양식 
		} else if (command.equals("/Q_ReplyAction.q")) {
			try {
				action = new Q_ReplyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 답변 작성
		} else if (command.equals("/Q_Reply.q")) {
			try {
				action = new Q_Reply();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 수정 양식
		} else if (command.equals("/Q_ModifyAction.q")) {
			try {
				action = new Q_ModifyAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 수정하기
		} else if (command.equals("/Q_Modify.q")) {
			try {
				action = new Q_Modify();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 삭제 양식 
		} else if (command.equals("/Q_DeleteAction.q")) {
			forward = new ActionForward();
			forward.setRedirect(false); // dispatcher 방식으로 포워딩
			forward.setPath("./qna/q_deleteform.jsp");

		// 삭제하기
		} else if (command.equals("/Q_Delete.q")) {
			try {
				action = new Q_Delete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 포워딩 설정
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	} // - doProcess() END -

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
