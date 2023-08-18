package web0814.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindNumberServlet
 */
@WebServlet("/findServlet")
public class FindNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 컴퓨터 난수
//	private int com_num = (int) (Math.random() * 100 + 1);
	private int com_num = new java.util.Random().nextInt(100) + 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		String inp = request.getParameter("num");
		System.out.println(com_num);
		try {
			int inp_num = Integer.parseInt(inp);
			if (inp_num < 1)
				throw new IllegalArgumentException("1보다 작습니다");
			if (inp_num > 100)
				throw new IllegalArgumentException("100보다 큽니다");
			if (com_num == inp_num) {
				result = "정답";
			} else if (com_num > inp_num) {
				result = "올려";
			} else {
				result = "내려";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "잘못된 입력입니다: " + e.getMessage();
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("EUC-KR"); // 한글전용
		response.getWriter().append(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
