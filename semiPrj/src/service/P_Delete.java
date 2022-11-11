package service;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.P_DAO;
import dto.P_DTO;

public class P_Delete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("P_Delete");

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		int p_num = Integer.parseInt(request.getParameter("p_num"));
		String page = request.getParameter("page");
		String p_pw = request.getParameter("p_pw");

		String path = request.getRealPath("p_file");
		System.out.println("path:" + path);

		P_DAO dao = P_DAO.getInstance();
		P_DTO old = dao.getDetail(p_num);

		int result = 0;
		
		if (old.getP_pw().equals(p_pw)) { 
			result = dao.delete(p_num); 
			if (result == 1)
				System.out.println("삭제 성공");

			// 첨부파일 있을 경우 첨부파일 삭제
			if (old.getP_file() != "") {

				File file = new File(path);
				file.mkdir();

				// boardupload 디렉토리의 모든 첨부파일 구해오기
				File[] f = file.listFiles();
				for (int i = 0; i < f.length; i++) {
					if (f[i].getName().equals(old.getP_file())) {
						f[i].delete();
					}
				}

			}

		} else { 
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();

			return null;
		}

		request.setAttribute("result", result);
		request.setAttribute("page", page);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
//		forward.setPath("/P_ListAction.p?page="+page);
		forward.setPath("/place/p_deleteresult.jsp");

		return forward;
	}

}
