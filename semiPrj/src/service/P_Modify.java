package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.P_DAO;
import dto.P_DTO;

public class P_Modify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		System.out.println("P_Modify");
		
		response.setContentType("text/html; charset=utf-8");
		
		String path = request.getRealPath("p_file");
		System.out.println("path:" + path);
		
		int size = 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		PrintWriter out = response.getWriter();
		
		int p_num = Integer.parseInt(multi.getParameter("p_num"));
		String page = multi.getParameter("page");
		String p_pw = multi.getParameter("p_pw");
		String upload = multi.getFilesystemName("p_file");
		
		P_DTO p = new P_DTO();
		p.setP_num(p_num);
		p.setP_name(multi.getParameter("p_name"));
		p.setP_content(multi.getParameter("p_content"));
		p.setP_addr(multi.getParameter("p_addr"));
		
		P_DAO dao = P_DAO.getInstance();
		P_DTO old = dao.getDetail(p_num);	
		
		if (upload != null) {
			p.setP_file(upload); // 첨부파일 수정한 경우
		} else {
			p.setP_file(old.getP_file()); // 첨부파일 수정하지 않은 경우
		}
		
		if(old.getP_pw().equals(p_pw)) {
			int result = dao.update(p);	
			if(result == 1) System.out.println("글 수정 성공");
			
		}else {	
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			
			return null;
		}
	
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/P_DetailAction.p?p_num="+p_num+"&page="+page);
		return forward;

	}
}
	
