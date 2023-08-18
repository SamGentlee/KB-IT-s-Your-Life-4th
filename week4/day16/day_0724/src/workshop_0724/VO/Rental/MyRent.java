package workshop_0724.VO.Rental;

import java.util.Date;

public class MyRent {
	
	private int rentalNum;
	private int carNum;
	private int userNum;
	private int price;
	private Date rentDate;
	private int rentHour;
	private Date returnDate;
	private int returnHour;
	
	public MyRent() {
		// TODO Auto-generated constructor stub
	}
	
	public MyRent(int rentalNum, int carNum, int userNum, int price, Date rentDate, int rentHour, Date returnDate,
			int returnHour) {
		super();
		this.rentalNum = rentalNum;
		this.carNum = carNum;
		this.userNum = userNum;
		this.price = price;
		this.rentDate = rentDate;
		this.rentHour = rentHour;
		this.returnDate = returnDate;
		this.returnHour = returnHour;
	}

	public int getRentalNum() {
		return rentalNum;
	}

	public void setRentalNum(int rentalNum) {
		this.rentalNum = rentalNum;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public int getRentHour() {
		return rentHour;
	}

	public void setRentHour(int rentHour) {
		this.rentHour = rentHour;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getReturnHour() {
		return returnHour;
	}

	public void setReturnHour(int returnHour) {
		this.returnHour = returnHour;
	}
	
	
}
