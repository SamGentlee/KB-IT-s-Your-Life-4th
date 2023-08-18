package 그림판_Service;

import java.util.ArrayList;

import 그림판.MyShape;

public class MyShapeListService {
	
	private ArrayList<MyShape> shapes = new ArrayList<>();

	public void add(MyShape ms) {
		shapes.add(ms);
	}

	public int getCount() {
		return shapes.size();
	}

	public MyShape findByPosition(int startx, int starty) {
		for (MyShape myShape : shapes) {
			if(myShape.getX()==startx && myShape.getY()==starty) {
				return myShape;
			}
		}
		return null;
	}

	public boolean remove(MyShape findShape) {
		return shapes.remove(findShape);
	}

	public void printAll() {
		System.out.println(" ** 전체 출력 ** ");
		for (MyShape myShape : shapes) {
			System.out.println(myShape);
		}
	}
	
}
