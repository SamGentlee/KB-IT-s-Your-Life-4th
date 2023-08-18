package workshop_0724.Service;

import java.util.ArrayList;
import java.util.Date;

import workshop_0724.VO.RentCar.MyRentCar;
import workshop_0724.VO.Rental.MyRent;
import workshop_0724.VO.User.MyRentCarUser;

public class RentService {
	
	private ArrayList<MyRentCar> cars = new ArrayList<>();
	private ArrayList<MyRentCarUser> mems = new ArrayList<>();
	private ArrayList<MyRent> rents = new ArrayList<>();
	private int rentalNum = 1000;
	
	public void add(MyRentCar rentCar) {
		cars.add(rentCar);
	}
	public void add(MyRentCarUser rentUser) {
		mems.add(rentUser);
	}
	public void rent(int userNum, int carNum,int price, Date rentDate, int rentHour, 
			Date returnDate, int returnHour) {
		rents.add(new MyRent(rentalNum++, carNum, userNum, price, 
				rentDate, rentHour,returnDate, returnHour));
	}
	
	public int getRentCount() {
		int rentCount = rents.size();
		return rentCount;
	}
	
}
