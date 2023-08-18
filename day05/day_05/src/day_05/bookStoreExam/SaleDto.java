package day_05.bookStoreExam;

public class SaleDto {
	
	private int mno;
	private String isbn;
	private int quatity;
	
	public SaleDto() {
		// TODO Auto-generated constructor stub
	}

	public SaleDto(int mno, String isbn, int quatity) {
		super();
		this.mno = mno;
		this.isbn = isbn;
		this.quatity = quatity;
	}

	@Override
	public String toString() {
		return "SaleDto [mno=" + mno + ", isbn=" + isbn + ", quatity=" + quatity + "]";
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	
	
	
}
