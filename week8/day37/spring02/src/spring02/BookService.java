package spring02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring02.dao.BookDao;
import spring02.dto.BookDto;

@Service
public class BookService {
	@Autowired
	BookDao dao;// ���� ���Ȯ���� �� ��� �������� ���� �ʿ�
	
	public BookService() {
	}
	
	//xml�� ���� �����ø� �ʿ�
	BookService(BookDao dao){		// ������ ����
		this.dao = dao;
	}
	
	public void setDao(BookDao dao) {	// setter ����
		this.dao = dao;
	}
	
	public void add(BookDto dto) {	
		dao.insert(dto);
	}
	

}