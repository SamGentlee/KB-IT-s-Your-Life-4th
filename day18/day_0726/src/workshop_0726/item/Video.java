package workshop_0726.item;

public class Video extends Item{
	
	private String manufacturer;
	
	public Video() {
	}

	public Video(int manageNum, String title, int price ,String manufacturer, int qty) {
		super(manageNum, title, price, qty);
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "비디오 : "+super.toString()+", 제작사 = " + manufacturer;
	}
}
