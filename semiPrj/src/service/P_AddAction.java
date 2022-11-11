package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.P_DAO;
import dto.P_DTO;

public class P_AddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stubs
		System.out.println("P_AddAction");
		
		String path = request.getRealPath("p_file");
		System.out.println("path:"+ path);
		
		int size = 1024 * 1024;
		
		MultipartRequest multi =
				new MultipartRequest(request,
									 path,
									 size,
									 "utf-8",
				new DefaultFileRenamePolicy());
		P_DTO p = new P_DTO();
		p.setP_name(multi.getParameter("p_name"));
		p.setId(multi.getParameter("id"));
		p.setP_pw(multi.getParameter("p_pw"));
		p.setP_content(multi.getParameter("p_content"));
		p.setP_addr(multi.getParameter("p_addr"));
		p.setP_file(multi.getFilesystemName("p_file"));		
		
		
		P_DAO dao = P_DAO.getInstance();
		int result = dao.insert(p); // 원문 글작성
		if(result == 1) System.out.println("글 작성 성공");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/P_ListAction.p");

		return forward;
	}

}
