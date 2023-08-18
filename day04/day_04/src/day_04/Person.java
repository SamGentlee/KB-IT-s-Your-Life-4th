package day_04;

public class Person {
	
	private String id, name;
	
	public Person() { //기본생성자가 있어야 자식한테 상속할수있음
	}
	
	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		return builder.toString();
	}
	
	
}
