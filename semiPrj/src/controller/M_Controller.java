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
import service.Delete;
import service.Idcheck;
import service.Insert;
import service.Login;
import service.Update;
import service.UpdateMember;

@WebServlet("*.m")
public class M_Controller extends HttpServlet {
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

		// 회원가입
		if (command.equals("/Insert.m")) {
			try {
				action = new Insert();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// 마이 페이지
		} else if(command.equals("/Mypage.m")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./main/mypageform.jsp");
			
		// ID 중복검사 (ajax)
		} else if (command.equals("/Idcheck.m")) {
			try {
				action = new Idcheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		// 로그인(회원인증)
		} else if (command.equals("/Login.m")) {
			try {
				action = new Login();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 로그인 폼
		} else if (command.equals("/loginform.m")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./main/loginform.jsp");

		// 로그아웃
		} else if (command.equals("/Logout.m")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./main/logout.jsp");

		// 회원가입 폼
		} else if (command.equals("/joinform.m")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./main/joinform.jsp");

		// 회원정보 수정폼
		} else if (command.equals("/UpdateMember.m")) {
			try {
				action = new UpdateMember();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 회원정보 수정
		} else if (command.equals("/Update.m")) {
			try {
				action = new Update();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		// 회원탈퇴 폼
		} else if (command.equals("/DeleteMember.m")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./main/deleteform.jsp");

		// 회원탈퇴
		} else if (command.equals("/Delete.m")) {
			try {
				action = new Delete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// 포워딩
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	} // doprocess() end

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("get");

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post");

		doProcess(request, response);
	}

}
