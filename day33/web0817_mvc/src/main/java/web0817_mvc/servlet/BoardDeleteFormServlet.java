package web0817_mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0817_mvc.dao.BoardDao;
import web0817_mvc.dao.BoardDaoImpl;
import web0817_mvc.dto.BoardDto;

/**
 * Servlet implementation class BoardDeleteFormServlet
 */
@WebServlet("/board/delete_form")
public class BoardDeleteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDto dto = new BoardDto();
		String url = "/delete_form.jsp";
		BoardDao dao = new BoardDaoImpl();
		try {
			dto=dao.findById(no);
			request.setAttribute("dto",dto);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "/board_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
