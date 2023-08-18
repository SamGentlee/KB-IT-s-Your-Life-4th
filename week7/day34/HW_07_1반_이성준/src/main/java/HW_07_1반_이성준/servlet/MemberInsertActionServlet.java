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

@WebServlet("/member/insert_action")
public class MemberInsertActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		MemberDto dto = new MemberDto(id,name,pwd,"Y");
		MemberDao dao = new MemberDaoImpl();
		
		String url = "/member_ok.jsp";
		try {
			dao.add(dto);
			request.setAttribute("dto", dto);
			request.setAttribute("msg", "회원 등록에 성공하였습니다.");
		} catch (SQLException e) {
			url="/member_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		} catch (DuplicatedIdException e) {
			url="/member_error.jsp";
			request.setAttribute("err_msg", id+"는 이미 존재합니다");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
