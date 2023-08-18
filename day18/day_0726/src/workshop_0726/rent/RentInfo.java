package workshop_0726.rent;

import java.util.Date;

public class RentInfo {
	
	private int rentNum;
	private String id;
	private int manageNum;
	private String rentDate;
	private String rentTime;
	private String returnDate;
	private String returnTime;

	public RentInfo() {
		// TODO Auto-generated constructor stub
	}
	public RentInfo(int rentNum, String id, int manageNum, String rentDate, String rentTime) {
		this(rentNum,id,manageNum,rentDate,rentTime,null,null);
	}

	public RentInfo(int rentNum, String id, int manageNum, String rentDate, String rentTime, String returnDate,
			String returnTime) {
		super();
		this.rentNum = rentNum;
		this.id = id;
		this.manageNum = manageNum;
		this.rentDate = rentDate;
		this.rentTime = rentTime;
		this.returnDate = returnDate;
		this.returnTime = returnTime;
	}

	public int getRentNum() {
		return rentNum;
	}

	public void setRentNum(int rentNum) {
		this.rentNum = rentNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getManageNum() {
		return manageNum;
	}

	public void setManageNum(int manageNum) {
		this.manageNum = manageNum;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getRentTime() {
		return rentTime;
	}

	public void setRentTime(String rentTime) {
		this.rentTime = rentTime;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	@Override
	public String toString() {
		return "반납정보 : 대여번호 = " + rentNum + ", 회원아이디 = " + id + ", 대여물건관리번호 = " + manageNum 
				+ ", 대여날짜 = " + rentDate + ", 대여시간 = " + rentTime + ", 반납날짜 = " 
				+ returnDate + ", 반납시간 = " + returnTime + "]";
	}
	
}
