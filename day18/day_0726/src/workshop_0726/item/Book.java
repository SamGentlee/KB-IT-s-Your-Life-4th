package workshop_0726.item;

public class Book extends Item{
	
	private String publisher;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int manageNum, String title, int price, String publisher, int qty) {
		super(manageNum, title, price, qty);
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "도서 : "+super.toString()+", 출판사 = " + publisher;
	}
}
