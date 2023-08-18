package HW_07_1반_이성준.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW_07_1반_이성준.dao.MemberDao;
import HW_07_1반_이성준.dao.MemberDaoImpl;
import HW_07_1반_이성준.dto.MemberDto;
import HW_07_1반_이성준.exception.DuplicatedIdException;
import HW_07_1반_이성준.exception.RecordNotFoundException;

/**
 * Servlet implementation class MemberUpdateActionServlet
 */
@WebServlet("/member/update_action")
public class MemberUpdateActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String status = request.getParameter("status");
		
		MemberDto dto = new MemberDto(id,name,pwd,status);
		MemberDao dao = new MemberDaoImpl();
		
		String url = "/member_ok.jsp";
		try {
			dao.update(dto);
			request.setAttribute("dto", dto);
			request.setAttribute("msg", "회원정보 수정에 성공하였습니다.");
		} catch (Exception e) {
			url="/member_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		} 
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
