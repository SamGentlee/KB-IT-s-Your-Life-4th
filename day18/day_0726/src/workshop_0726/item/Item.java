package workshop_0726.item;

public class Item {
	
	private int manageNum;
	private String title;
	private int price;
	private int qty;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(int manageNum, String title, int price, int qty) {
		super();
		this.manageNum = manageNum;
		this.title = title;
		this.price = price;
		this.qty = qty;
	}

	public int getManageNum() {
		return manageNum;
	}

	public void setManageNum(int manageNum) {
		this.manageNum = manageNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "관리번호 = " + manageNum + ", 제목 = " + title + ", 가격 = " + price + ", 수량 = " + qty;
	}
	
	
}
