package workshop_0724.VO.RentCar;

public class MyRentTruck extends MyRentCar{
	
	private int capacity;
	
	public MyRentTruck() {
		// TODO Auto-generated constructor stub
	}

	public MyRentTruck(int carNum, int price, String carType, 
			int modelYear, int carCC, int capacity) {
		super(carNum, price, carType, modelYear, carCC);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
}
