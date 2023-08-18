package day_0725;
/** 도형들의 공통속성정의 */
public abstract class MyShape {
	
	private int x, y; //도형 기준 좌표
	
	public MyShape() {
		
	}
	
	public MyShape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "x = " + x + ", y = " + y;
	}
	
	public abstract String draw(); //도혀 그리기 기능 제공
	
}
