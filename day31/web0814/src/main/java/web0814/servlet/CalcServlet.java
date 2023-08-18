package web0814.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calcServlet") // 호출명 수정
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		String opr = request.getParameter("opr");
		int i1 = Integer.parseInt(n1);
		int i2 = Integer.parseInt(n2);
		int result = 0;
		System.out.println(opr);
		switch (opr) {
		case "+":
			result = i1 + i2;
			break;
		case "-":
			result = i1 - +i2;
			break;
		case "*":
			result = i1 * i2;
			break;
		case "/":
			result = i1 / i2;
			break;
		}
		response.getWriter().append("" + result); // append는 문자열만 받기때문에 빈문자열과 연결
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
