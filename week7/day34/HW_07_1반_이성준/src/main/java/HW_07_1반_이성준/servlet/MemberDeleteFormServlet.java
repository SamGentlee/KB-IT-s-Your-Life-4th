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

@WebServlet("/member/delete_form")
public class MemberDeleteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String url = "/member_delete_form.jsp";
		MemberDao dao = new MemberDaoImpl();
		try {
			MemberDto dto = dao.findById(id);
			request.setAttribute("dto", dto);
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
