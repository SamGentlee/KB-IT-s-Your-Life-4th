package web0816.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindNumberMvcServlet
 */
@WebServlet("/findNumberMvcServlet")
public class FindNumberMvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int com_num = new Random().nextInt(100)+1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(com_num);
		String snum = request.getParameter("num");
		int num = Integer.parseInt(snum);
		String msg = "";
		if(com_num == num) {
			msg="추카추카~ 정답입니다.(입력한 값: "+num+")";
		}else if(com_num < num) {
			msg="틀렸습니다. 숫자를 내려주세요 (입력한 값: "+num+")";
		}else {
			msg="틀렸습니다. 숫자를 올려주세요 (입력한 값: "+num+")";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("com_num", com_num);
		request.setAttribute("num", num);
		request.getRequestDispatcher("/find_number_mvc.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
