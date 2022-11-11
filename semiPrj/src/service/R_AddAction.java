package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.R_DAO;
import dto.R_DTO;

public class R_AddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("R_AddAction");

		String path = request.getRealPath("r_file");
		System.out.println("path:" + path);

		int size = 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());

		R_DTO review = new R_DTO();
//		review.setNum(multi.getParameter(""));
		review.setId(multi.getParameter("id"));
		review.setR_pw(multi.getParameter("r_pw"));
		review.setR_title(multi.getParameter("r_title"));
		review.setR_content(multi.getParameter("r_content"));
		review.setR_file(multi.getFilesystemName("r_file"));

		R_DAO dao = R_DAO.getInstance();
		int result = dao.insert(review);
		if (result == 1) {
			System.out.println("글 작성 성공");
		} else {
			System.out.println("글 작성 실패");
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/R_ListAction.r");

		return forward;
	}

}
