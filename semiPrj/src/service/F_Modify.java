package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.F_DAO;
import dto.F_DTO;

public class F_Modify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("F_Modify");
		
		response.setContentType("text/html; charset=utf-8");
		
		String path = request.getRealPath("p_file");
		System.out.println("path:" + path);
		
		int size = 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		PrintWriter out = response.getWriter();
		
		int f_num = Integer.parseInt(multi.getParameter("f_num"));
		String page = multi.getParameter("page");
		String f_pw = multi.getParameter("f_pw");
		String upload = multi.getFilesystemName("f_file");
		
		F_DTO food = new F_DTO();
		food.setF_num(f_num);
		food.setF_name(multi.getParameter("f_name"));
		food.setF_content(multi.getParameter("f_content"));
		food.setF_addr(multi.getParameter("f_addr"));
			
		F_DAO dao = F_DAO.getInstance();
		F_DTO old = dao.getDetail(f_num);
		
		if (upload != null) {
			food.setF_file(upload); // 첨부파일 수정한 경우
		} else {
			food.setF_file(old.getF_file()); // 첨부파일 수정하지 않은 경우
		}
		
		if(old.getF_pw().equals(f_pw)) {
			int result = dao.update(food);
			if(result==1)System.out.println("글 수정 성공");
			
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
		forward.setPath("/F_ListAction.f?page="+page);
		return forward;
	}

}
