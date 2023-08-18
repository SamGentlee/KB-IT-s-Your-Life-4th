package day_04;
/** 그림판 어플 예제 */
public class DrawExam {
	
	public static void main(String[] args) {
		//그려진 도형정보를 관리
		//선, 원, 삼각, 사각 ...
		//Line : (x,y)시작, (x2,y2)끝
		//Circle : (x,y)중앙좌표,radius 반지름
		//Shape{ x,y }
		//Line extends Shape{ x2, y2 }
		//Circle extends Shape{ radius }
		/*
		Line[] lines = new Line[100];
		int lineCount = 0;
		Circle[] circles= new Circle[100];
		int circleCount = 0;
		//순서가 명확하게 나오지 않는다
		lines[lineCount++] = new Line(...);
		circles[circleCount++] = new Circle(...);
		circles[circleCount++] = new Circle(...);
		lines[lineCount++] = new Line(...);
		//순서를 기억하기위해 부모타입형태로 저장한다 - UpCasting (형변환)
		Shape[] shapes = new Shape[100];
		int shapeCount = 0;
		shapes[shapeCount++] = new Line(...);
		shapes[shapeCount++] = new Circle(...);
		shapes[shapeCount++] = new Circle(...);
		shapes[shapeCount++] = new Line(...);*/
	}
}
