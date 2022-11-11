package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.F_DAO;
import dto.F_DTO;

public class F_AddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("F_AddAction");
		
		String path = request.getRealPath("p_file");
		System.out.println("path:"+path);
		
		int size = 1024*1024;
		
		MultipartRequest multi = new MultipartRequest(request, 
													  path,
													  size,
													  "utf-8",
								new DefaultFileRenamePolicy());
				
		F_DTO food = new F_DTO();
//		review.setNum(multi.getParameter(""));
		food.setF_name(multi.getParameter("f_name"));
		food.setId(multi.getParameter("id"));
		food.setF_pw(multi.getParameter("f_pw"));
		food.setF_content(multi.getParameter("f_content"));
		food.setF_addr(multi.getParameter("f_addr"));
		food.setF_file(multi.getFilesystemName("f_file"));
				
		F_DAO dao = F_DAO.getInstance();
		int result = dao.insert(food);
		if(result == 1) {System.out.println("글 작성 성공");
		}else {System.out.println("글 작성 실패");}
		
		

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/F_ListAction.f");
		
		return forward;
	}

}
