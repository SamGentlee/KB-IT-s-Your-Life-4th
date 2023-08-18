package member.dto;

public class MemberDto {
	private String id, name, pwd, status;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String id, String name, String pwd, String status) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "id = " + id + ", name = " + name + ", pwd = " + pwd + ", status = " + status;
	}
	
	
}
