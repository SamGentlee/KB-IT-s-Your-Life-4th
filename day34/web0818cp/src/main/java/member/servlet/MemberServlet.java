package member.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//작업명 추출
				String command = "list";
				request.setCharacterEncoding("utf-8");
				command = request.getParameter("command");
				if(command == null || command.trim().length()==0) {
					command = "list";
				}
				String view = "";
				try {
					if(command.equals("insert_form")) {
						view += insert_form(request, response); 
					}
//					else if(command.equals("insert_action")) {
//						view += insert_action(request, response);
//					}else if(command.equals("list")) {
//						view += list(request,response);
//					}else if(command.equals("detail")) {
//						view += detail(request,response);
//					}else if(command.equals("update_form")) {
//						view += update_form(request,response);
//					}else if(command.equals("update_action")) {
//						view += update_action(request,response);
//					}else if(command.equals("delete_form")) {
//						view += delete_form(request,response);
//					}else if(command.equals("delete_action")) {
//						view += delete_action(request,response);
//					}
				} catch (Exception e) {
					e.printStackTrace();
					view+= "/member/member_error";
					request.setAttribute("err_msg", e.getMessage());
				}
				view = view + ".jsp";
				request.getRequestDispatcher(view).forward(request, response);
	}
	
	private String insert_form(HttpServletRequest request, HttpServletResponse response) {
		
		return "/member/insert_form";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
