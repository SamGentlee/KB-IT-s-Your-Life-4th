package HW_07_1반_이성준.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW_07_1반_이성준.dao.MemberDao;
import HW_07_1반_이성준.dao.MemberDaoImpl;
import HW_07_1반_이성준.dto.MemberDto;

/**
 * Servlet implementation class MemberDeleteActionServlet
 */
@WebServlet("/member/delete_action")
public class MemberDeleteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDao dao =new MemberDaoImpl();
		String url = "/member_ok.jsp";
		try {
			MemberDto dto = dao.findById(id);
			dao.delete(id);
			request.setAttribute("dto", dto);
			request.setAttribute("msg", "회원 정보 삭제가 성공하였습니다.");
		} catch (Exception e) {
			url="/member_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		} 
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
