package board.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터 init()");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		// place your code here
		System.out.println("Do Filter");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println("필터 종료");
	}
}
