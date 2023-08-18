package workshop_0724.VO.RentCar;

public class MyRentCar {
	
	private int carNum;
	private int price;
	private String carType;
	private int modelYear;
	private int carCC;
	
	public MyRentCar() {
		// TODO Auto-generated constructor stub
	}

	public MyRentCar(int carNum, int price, String carType, int modelYear, int carCC) {
		super();
		this.carNum = carNum;
		this.price = price;
		this.carType = carType;
		this.modelYear = modelYear;
		this.carCC = carCC;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public int getCarCC() {
		return carCC;
	}

	public void setCarCC(int carCC) {
		this.carCC = carCC;
	}
	
}
