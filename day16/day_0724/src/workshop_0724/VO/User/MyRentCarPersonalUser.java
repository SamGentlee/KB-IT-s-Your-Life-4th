package workshop_0724.VO.User;

public class MyRentCarPersonalUser extends MyRentCarUser{
	
	private String userName;
	private String userTel;
	
	public MyRentCarPersonalUser() {
		// TODO Auto-generated constructor stub
	}

	public MyRentCarPersonalUser(int userNum, String userType, String userName, String userTel) {
		super(userNum, userType);
		this.userName = userName;
		this.userTel = userTel;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}	
