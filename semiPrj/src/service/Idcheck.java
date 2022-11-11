package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.M_DAO;

public class Idcheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Idcheck");
		
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		
		M_DAO dao = M_DAO.getInstance();
		int result = dao.idcheck(id);
		System.out.println("result : " + result);
		
		out.println(result);	
		
		return null;
	}

}
