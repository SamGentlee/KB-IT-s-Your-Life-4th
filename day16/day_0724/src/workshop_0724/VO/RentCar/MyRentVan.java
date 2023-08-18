package workshop_0724.VO.RentCar;

public class MyRentVan extends MyRentCar{
	
	private int passengerNum;
	private int capacity;
	
	public MyRentVan() {
		// TODO Auto-generated constructor stub
	}

	public MyRentVan(int carNum, int price, String carType, 
			int modelYear, int carCC, int passengerNum, int capacity) {
		super(carNum, price, carType, modelYear, carCC);
		this.passengerNum = passengerNum;
		this.capacity = capacity;
	}

	public int getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
}
