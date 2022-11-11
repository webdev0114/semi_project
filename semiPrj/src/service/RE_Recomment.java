package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.RE_DAO;
import dto.RE_DTO;

public class RE_Recomment implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RE_Recomment");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		String path = request.getRealPath("re_file");
		System.out.println("path:" + path);
		
		int size = 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());

		
		String page = multi.getParameter("page");
		String re_comment = multi.getParameter("re_comment");
		String id = multi.getParameter("id");
		int comment_re_ref = Integer.parseInt(multi.getParameter("comment_re_ref"));
		int comment_re_lev = Integer.parseInt(multi.getParameter("comment_re_lev"));
		int comment_re_seq = Integer.parseInt(multi.getParameter("comment_re_seq"));
		int r_num = Integer.parseInt(multi.getParameter("r_num"));
		int re_num = Integer.parseInt(multi.getParameter("re_num"));
		

		
		
		RE_DTO comment = new RE_DTO();
		comment.setRe_re_ref(comment_re_ref);
		comment.setRe_re_lev(comment_re_lev);
		comment.setRe_re_seq(comment_re_seq);
		comment.setR_num(r_num);
		comment.setRe_num(re_num);
		comment.setId(id);
		comment.setRe_comment(re_comment);
		comment.setRe_file(multi.getFilesystemName("re_file"));
		

		System.out.println("reRecomment 위까지 성공");
		
		RE_DAO redao = RE_DAO.getinstacne();
		int result = redao.reRecomment(comment);
		if(result == 1) {
			System.out.println("대댓글 작성 성공");
		}
				
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/R_DetailAction.r?r_num="+r_num+"&page="+page);
		return forward;
	}

}
