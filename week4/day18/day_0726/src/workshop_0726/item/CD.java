package workshop_0726.item;

public class CD extends Item{
	
	private String singer;
	
	public CD() {
		// TODO Auto-generated constructor stub
	}

	public CD(int manageNum, String title, int price , String singer, int qty) {
		super(manageNum, title, price, qty);
		this.singer = singer;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "CD : "+super.toString()+", 가수 = " + singer + "]";
	}
	
	
}
