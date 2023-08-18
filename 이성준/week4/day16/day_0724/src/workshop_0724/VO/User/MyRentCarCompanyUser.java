package workshop_0724.VO.User;

public class MyRentCarCompanyUser extends MyRentCarUser{
	
	private String companyName;
	private int companyNum;
	private String companyTel;
	
	public MyRentCarCompanyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyRentCarCompanyUser(int userNum, String userType, String companyName, 
			int companyNum, String companyTel) {
		super(userNum, userType);
		this.companyName = companyName;
		this.companyNum = companyNum;
		this.companyTel = companyTel;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}

	public String getCompanyTel() {
		return companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	
	
}
