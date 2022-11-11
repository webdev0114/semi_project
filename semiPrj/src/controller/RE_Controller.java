package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Comment;

import service.Action;
import service.ActionForward;
import service.RE_AddAction;
import service.RE_Delete;
import service.RE_Recomment;
import service.RE_RecommentAction;
import service.RE_Update;
import service.RE_UpdateAction;
import service.R_AddAction;
import service.R_Delete;
import service.R_DetailAction;
import service.R_ListAction;
import service.R_Modify;
import service.R_ModifyAction;

@WebServlet("*.re")
public class RE_Controller extends HttpServlet{
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
		
		// 후기댓글작성
		if(command.equals("/RE_AddAction.re")) {
			try {
				action = new RE_AddAction();
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			/*
			 * // 후기 작성 폼으로 넘기는 }else if(command.equals("/RE_ReviewForm.r")) { forward = new
			 * ActionForward(); forward.setRedirect(false);
			 * forward.setPath("./review/r_writeform.jsp");
			 * 
			 */	
				
		
		
		// 삭제
		
		}else if(command.equals("/RE_Delete.re")) { 
			try { 
				action = new RE_Delete();
				forward = action.execute(request, response);
		  
				}catch(Exception e) {
						e.printStackTrace();
				} 
		
		
		
		// 수정
		}else if(command.equals("/RE_Update.re")) {
			try {
				action = new RE_Update();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		
		// 수정폼으로 이동
		}else if(command.equals("/RE_UpdateAction.re")) {
			try {
				action = new RE_UpdateAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		 
		
		// 대댓글 작성폼
		}else if(command.equals("/RE_RecommentAction.re")) {
			try {
				action = new RE_RecommentAction();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		
		// 대댓글 작성
		}else if(command.equals("/RE_Recomment.re")) {
			try {
				action = new RE_Recomment();
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
