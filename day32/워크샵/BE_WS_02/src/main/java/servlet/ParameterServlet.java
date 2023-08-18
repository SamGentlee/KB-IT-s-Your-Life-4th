package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ParameterDto;

@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> map = new HashMap<>();
		String job = request.getParameter("job");
		String pageNo = request.getParameter("pageNo");
		String searchWord = request.getParameter("searchWord");
//		System.out.println(job);
//		System.out.println(pageNo);
//		System.out.println(searchWord);
		map.put("job", job);
		map.put("pageNo", pageNo);
		map.put("searchWord", searchWord);
		request.setAttribute("map", map);
		request.getRequestDispatcher("/getResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // need with POST
		response.setContentType("text/html; charset=utf-8");
		ParameterDto dto = new ParameterDto();
		// 파라미터 처리하기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String hobby[] = request.getParameterValues("hobby");
//		StringBuilder sbHobby = new StringBuilder();
//		for (String h : hobby) {
//			sbHobby.append(h).append(", ");
//		}
//		sbHobby.setLength(sbHobby.length()-2);
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");
		//ParameterDto에 담기
		dto.setName(name);
		dto.setEmail(email);
		dto.setGender(gender);
		dto.setHobby(hobby);
		dto.setFavorite(favorite);
		dto.setDesc(desc);
		
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/postResult.jsp").forward(request, response);
	}

}
