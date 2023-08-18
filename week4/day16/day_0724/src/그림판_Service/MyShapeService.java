package 그림판_Service;

import java.util.Iterator;

import 그림판.MyShape;

/** MyShape 파생 객체를 저장 */
public class MyShapeService {
	
	private MyShape[] shapes = new MyShape[100];
	private int count = 0; //저장된 위치, 저장된 갯수;
	
	public void add(MyShape ms) {
		shapes[count++] = ms;
	}
//	public void add(MyLine ml) {
//		shapes[count++] = ml;
//	}
//	public void add(MyCircle mc) {
//		shapes[count++] = mc;
//	}
	
	public int getCount() {
		return count;
	}

	public MyShape findByPosition(int startx, int starty) {
		//실제저장 마지막위치 = count
		for (int i = 0; i < count; i++) {
			MyShape myShape = shapes[i];
			if(myShape.getX()==startx && myShape.getY()==starty) {
				return myShape;
			}
		}
		return null; //못찾으면 null반환
	}

	public boolean remove(MyShape findShape) {
		for (int i = 0; i < count; i++) {
			MyShape myShape = shapes[i];
			if(myShape.equals(findShape)) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	/** i번째 객체 삭제 */
	private void remove(int i) {
		// n-> i ~ < n
		for(int j=i; j< count-1; j++) {
			shapes[j]=shapes[j+1];
		}
		count--;
	}

	public void printAll() {
		System.out.println(" ** 전체 출력 ** ");
		for (int i = 0; i < count; i++) {
			System.out.println(shapes[i]);
		}
	}
}
