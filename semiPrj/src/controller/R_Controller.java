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
import service.R_AddAction;
import service.R_Delete;
import service.R_DetailAction;
import service.R_ListAction;
import service.R_Modify;
import service.R_ModifyAction;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.r")
public class R_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println("requestURI:"+requestURI);
		System.out.println("contextPath:"+contextPath);
		System.out.println("command:"+command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 후기작성
		if(command.equals("/R_AddAction.r")) {
			try {
				action = new R_AddAction();
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 후기 작성 폼으로 넘기는
		}else if(command.equals("/R_ReviewForm.r")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./review/r_writeform.jsp");
			
			
		// 리스트 폼
		}else if(command.equals("/R_ListAction.r")) {
			try {
				action = new R_ListAction();
				forward = action.execute(request, response);
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		// 상세페이지	
		}else if(command.equals("/R_DetailAction.r")) {
			try {
				action = new R_DetailAction();
				forward = action.execute(request, response);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
				
			
			
		// 삭제 폼	
		}else if(command.equals("/R_DeleteAction.r")) {
			forward = new ActionForward();
			forward.setRedirect(false);			
			forward.setPath("./review/r_deleteform.jsp");
						
						
		// 글삭제	
		}else if(command.equals("/R_Delete.r")) {
			try {
				action = new R_Delete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
		// 글수정	
		}else if(command.equals("/R_ModifyAction.r")) {
			try {
				action = new R_ModifyAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
					
					
					
		// 글수정	
		}else if(command.equals("/R_Modify.r")){
			try {
				action = new R_Modify();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
			
			
			
		}			
	
		
		
		// 포워딩 처리
		if(forward != null) {
			if(forward.isRedirect()) {		
				response.sendRedirect(forward.getPath());
			}else {							
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
						
			}
			
			
			
		}
	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		
		doProcess(request, response); 		// doProcess() 메소드 호출
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		
		doProcess(request, response); 		// doProcess() 메소드 호출
		
	}

}
