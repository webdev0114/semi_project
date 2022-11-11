package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.RE_DAO;
import dao.R_DAO;
import dto.RE_DTO;
import dto.R_DTO;

public class RE_AddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("RE_AddAction");

	
		
		
		
		String path = request.getRealPath("re_file");
		System.out.println("path:" + path);

		int size = 1024 * 1024;
		
		String page = request.getParameter("page");
//		int r_num = Integer.parseInt(request.getParameter("r_num"));
		
		System.out.println("multi 위까지 정상");
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());

		RE_DTO comment = new RE_DTO();
		comment.setRe_comment(multi.getParameter("re_comment"));
		comment.setId(multi.getParameter("id"));
		comment.setR_num(Integer.parseInt(multi.getParameter("r_num")));
		comment.setRe_file(multi.getFilesystemName("re_file"));
		
		int r_num = comment.getR_num();
		
		RE_DAO redao = RE_DAO.getinstacne();
		int result = redao.insert(comment);
		if(result == 1) System.out.println("글 작성됨");
		

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/R_DetailAction.r?r_num="+r_num+"&page="+page);

		return forward;
	}

}
