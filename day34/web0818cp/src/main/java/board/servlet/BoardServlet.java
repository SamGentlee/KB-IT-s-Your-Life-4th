package board.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import board.dto.BoardDto;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static BoardDao dao = new BoardDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//작업명 추출
		String command = "list";
		request.setCharacterEncoding("utf-8");
		command = request.getParameter("command");
		if(command == null || command.trim().length()==0) {
			command = "list";
		}
		String view = "/";
		try {
			if(command.equals("insert_form")) {
				view += insert_form(request, response); 
			}else if(command.equals("insert_action")) {
				view += insert_action(request, response);
			}else if(command.equals("list")) {
				view += list(request,response);
			}else if(command.equals("detail")) {
				view += detail(request,response);
			}else if(command.equals("update_form")) {
				view += update_form(request,response);
			}else if(command.equals("update_action")) {
				view += update_action(request,response);
			}else if(command.equals("delete_form")) {
				view += delete_form(request,response);
			}else if(command.equals("delete_action")) {
				view += delete_action(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			view+= "board_error";
			request.setAttribute("err_msg", e.getMessage());
		}
		view = view + ".jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	private String delete_action(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao dao = new BoardDaoImpl();
		BoardDto dto = new BoardDto();
		dto=dao.findById(no);
		request.setAttribute("dto", dto);
		dao.delete(no);
		request.setAttribute("msg", "게시물 삭제 성공");
		return "board_ok";
	}

	private String delete_form(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDto dto = new BoardDto();
		BoardDao dao = new BoardDaoImpl();
		dto=dao.findById(no);
		request.setAttribute("dto",dto);
		return "board_delete_form";
	}

	private String update_action(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//BoardDto 생성, 데이터 저장
		BoardDto dto = new BoardDto();
		dto.setNo(Integer.parseInt(request.getParameter("no")));
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContent(request.getParameter("content"));
		dto.setRegdate(new Date());
		
		BoardDao dao = new BoardDaoImpl();
		dao.update(dto);
		request.setAttribute("dto", dto);
		request.setAttribute("msg", "게시물 수정 성공");
		
		return "board_ok";
	}

	private String update_form(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao dao = new BoardDaoImpl();
		BoardDto dto = dao.findById(no);
		request.setAttribute("dto", dto);
		return "board_update_form";
	}

	private String detail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int no = Integer.parseInt(request.getParameter("no"));
		dao = new BoardDaoImpl();
		BoardDto dto = dao.findById(no);
		request.setAttribute("dto", dto);
		
		return "board_detail";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		BoardDao dao = new BoardDaoImpl();
		List<BoardDto> list = dao.list();
		request.setAttribute("list", list);
			
		return "board_list";
	}

	private String insert_action(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//BoardDto 생성, 데이터 저장
		BoardDto dto = new BoardDto();
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContent(request.getParameter("content"));
		dto.setRegdate(new Date());
		
		BoardDao dao = new BoardDaoImpl();
		dao.add(dto);
		request.setAttribute("dto", dto);
		request.setAttribute("msg", "게시물 등록 성공");
		
		return "board_ok";
	}

	private String insert_form(HttpServletRequest request, HttpServletResponse response) {
		
		return "board_insert_form";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
