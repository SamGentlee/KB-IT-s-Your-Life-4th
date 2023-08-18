package day_03;

public class ProductExam {
	public static void main(String[] args) {
		Product p1 = new Product("a100", "냉장고", "삼성", 100);
		p1.printInfo();
		p1.count++; // 인스턴스 방벅으로 static 접근 - 비효율(he static field Product.count should be accessed in a static way)
		
		Product p2 = new Product("a100", "냉장고", "삼성", 100);
		System.out.println(Product.count); // static 접근방법
		System.out.println("End");
	}
}
