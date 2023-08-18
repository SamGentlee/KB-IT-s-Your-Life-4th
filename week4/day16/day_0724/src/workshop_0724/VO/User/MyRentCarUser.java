package workshop_0724.VO.User;

public class MyRentCarUser {
	
	private int userNum;
	private String userType;
	
	
	public MyRentCarUser() {
		// TODO Auto-generated constructor stub
	}
	public MyRentCarUser(int userNum, String userType) {
		super();
		this.userNum = userNum;
		this.userType = userType;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
}
