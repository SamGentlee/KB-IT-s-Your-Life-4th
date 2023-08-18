package 그림판;

public class MyCircle extends MyShape{
	
	private int radius;
	
	public MyCircle() {
		// TODO Auto-generated constructor stub
	}

	public MyCircle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString()+", radius = " + radius + "]";
	}
	
	@Override
	public String draw() {
		return "CIRCLE";
	}
}
