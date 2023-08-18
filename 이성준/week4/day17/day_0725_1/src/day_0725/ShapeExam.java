package day_0725;

public class ShapeExam {
	public static void main(String[] args) {
		MyLine ml = new MyLine(0,0,5,5);
		MyShape ms = ml;
		ml.draw();
//		ms.draw(); // 오류 : MyShape 에는 draw() 메서드가없다
		MyDrawable md = ml;
		md.draw();
		MyCircle mc = new MyCircle(3,3,9);
		MyDrawable md2 = mc;
		md2.draw();
		//////////////////////
		MyDrawable[] mdarr = new MyDrawable[3];
		mdarr[0]=new MyLine(0,0,3,3);
		mdarr[1]=new MyCircle(5,5,9);
		mdarr[2]=new Student("홍길동","컴공");
		mdarr[0].draw();
		mdarr[1].draw();
		mdarr[2].draw();
	}
}
