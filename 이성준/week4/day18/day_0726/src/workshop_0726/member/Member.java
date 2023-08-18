package workshop_0726.member;

public class Member {
	
	private String id;
	private String name;
	private String pwd;
	private String tel;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id ,String name, String pwd, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "회원이름 = "+ name +", 아이디 = " + id + ", 비밀번호 = " + pwd + ", 연락처 = " + tel;
	}
	
	
	
}
