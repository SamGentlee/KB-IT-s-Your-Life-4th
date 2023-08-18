package workshop_0724.VO.RentCar;

public class MyRentSedan extends MyRentCar{
	
	private int passengerNum;
	
	public MyRentSedan() {
		// TODO Auto-generated constructor stub
	}

	public MyRentSedan(int carNum, int price, String carType, 
			int modelYear, int carCC, int passengerNum) {
		super(carNum, price, carType, modelYear, carCC);
		this.passengerNum = passengerNum;
	}

	public int getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}
	
}
