package web0817_mvc.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web0817_mvc.dao.BoardDao;
import web0817_mvc.dao.BoardDaoImpl;
import web0817_mvc.dto.BoardDto;

@WebServlet("/board/insert_action")
public class BoardInsertActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardDto 생성, 데이터 저장
		BoardDto dto = new BoardDto();
		request.setCharacterEncoding("utf-8");
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContent(request.getParameter("content"));
		dto.setRegdate(new Date());
		
		String url = "/board_ok.jsp";
		
		try {
			BoardDao dao = new BoardDaoImpl();
			dao.add(dto);
			request.setAttribute("msg", "게시물 등록 성공");
		} catch (Exception e) {
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
