package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.RE_DAO;
import dao.R_DAO;
import dto.RE_DTO;
import dto.R_DTO;

public class RE_Update implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RE_Update");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		int size = 1024 * 1024;

		
		PrintWriter out = response.getWriter();
		
		String path = request.getRealPath("re_file");

		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());

		String page = multi.getParameter("page");
		String id = multi.getParameter("id");
		String re_comment = multi.getParameter("re_comment");
		int r_num = Integer.parseInt(multi.getParameter("r_num"));
		int re_num = Integer.parseInt(multi.getParameter("re_num"));
		String upload = multi.getFilesystemName("re_file");
		

		RE_DTO comment = new RE_DTO();
		comment.setR_num(r_num);
		comment.setRe_num(re_num);
		comment.setRe_comment(re_comment);
		

		RE_DAO dao = RE_DAO.getinstacne();
		RE_DTO old = dao.getDetail(re_num);
		
		if (upload != null) {
			comment.setRe_file(upload); // 첨부파일 수정한 경우
		} else {
			comment.setRe_file(old.getRe_file()); // 첨부파일 수정하지 않은 경우
			
		}
		
		if(old.getId().equals(id)) {
			int result = dao.update(comment);
			if(result==1) {
				System.out.println("글 수정 성공");
			}
		}else {
			out.println("<script>");
			out.println("alert('아이디가 일치하지 않습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/R_DetailAction.r?r_num="+r_num+"&page="+page);
		return forward;
	}
	

}
