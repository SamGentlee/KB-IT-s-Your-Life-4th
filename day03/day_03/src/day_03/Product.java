package day_03;

/** 상품기본정보 정의용 */
public class Product {
	//객체 소속 - Heap영역
	String code; //상품코드
	String name; //상품이름
	String company; //제조사
	int price; //상품가격
	//클래스 소속 - Method영역( 선언 : Product.count)
	static int count = 0; 
	
	//static은 독립된 기능을 하는 경우에 사용
	static public void prn() {
		Product prn = new Product(" "," "," ",123);
		prn.price = 100;
	}
	public Product(String code, String name, String company, int price) {
		super();
		this.code = code;
		this.name = name;
		this.company = company;
		this.price = price;
		count++;
	}

	public void printInfo() {
		System.out.println("code : "+this.code+"\n"+"name : "+this.name+"\n"+"company : "+this.company+"\n"+"price : "+this.price);
	}
	

}
