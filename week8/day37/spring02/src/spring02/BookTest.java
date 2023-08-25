package spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring02.dto.BookDto;

public class BookTest {
	public static void main(String[] args) {
//		ApplicationContext context = 
//				new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext context =
				new AnnotationConfigApplicationContext(BookContext.class);
		BookService bs = context.getBean(BookService.class);
		BookDto dto = new BookDto();
		bs.add(dto);
	}
}
