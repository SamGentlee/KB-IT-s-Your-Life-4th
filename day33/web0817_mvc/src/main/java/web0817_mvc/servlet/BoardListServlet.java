package web0817_mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0817_mvc.dao.BoardDao;
import web0817_mvc.dao.BoardDaoImpl;
import web0817_mvc.dto.BoardDto;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDaoImpl();
		String url = "/board_list.jsp";
		try {
			List<BoardDto> list = dao.list();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			url = "/board_error.jsp";
			request.setAttribute("err_msg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
