package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.R_DAO;
import dto.R_DTO;

public class R_Modify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("R_Modify");
		
		response.setContentType("text/html; charset=utf-8");
		
		String path = request.getRealPath("r_file");
		System.out.println("path:" + path);
		
		int size = 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		PrintWriter out = response.getWriter();
		
		int r_num = Integer.parseInt(multi.getParameter("r_num"));
		String page = multi.getParameter("page");
		String r_pw = multi.getParameter("r_pw");
		String upload = multi.getFilesystemName("r_file");
		
		R_DTO review = new R_DTO();
		review.setR_num(r_num);
		review.setR_title(multi.getParameter("r_title"));
		review.setR_content(multi.getParameter("r_content"));
		
		R_DAO dao = R_DAO.getInstance();
		R_DTO old = dao.getDetail(r_num);
		
		if (upload != null) {
			review.setR_file(upload); // 첨부파일 수정한 경우
		} else {
			review.setR_file(old.getR_file()); // 첨부파일 수정하지 않은 경우
			
		}
		
		if(old.getR_pw().equals(r_pw)) {
			int result = dao.update(review);
			if(result==1) System.out.println("글 수정 성공");
			// model2board/delete
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
		forward.setPath("/R_ListAction.r");
		return forward;
	}

}
