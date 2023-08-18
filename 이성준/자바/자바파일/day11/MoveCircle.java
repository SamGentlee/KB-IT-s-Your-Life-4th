package day11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*  [1] Runnable을 상속받아 스레드가 할 일을 구현하세요
 *     => MyPanel의 x좌표를 반복돌면서 증가시켜주고, 갱신된 값을 적용
 * [2] 시작,중지버튼 이벤트 처리 Anonymous class로 처리해보기
 *     시작버튼 눌렀을 때 스레드를 동작시키세요
 * */

public class MoveCircle extends JFrame implements Runnable{

	Container cp;
	JPanel rootP = new JPanel();
	JButton btStart, btStop;
	MyPanel myP=new MyPanel();
	Thread tr;
	boolean flag=false;
	public MoveCircle() {
		super("::MoveCircle::");
		cp = this.getContentPane();
		cp.add(rootP, BorderLayout.NORTH);
		cp.add(myP, BorderLayout.CENTER);
		myP.setBackground(Color.white);
		
		rootP.setBackground(Color.white);
		
		rootP.add(btStart=new JButton("Start"));
		rootP.add(btStop=new JButton("Stop"));
		
		//Lambda식 
		btStart.addActionListener(e->{
			setTitle("$$$");
			flag=true;
			tr=new Thread(this);
			tr.start();
		});
		
		/*
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("###");
				flag=true;
				tr=new Thread(MoveCircle.this);
				//Runnable객체를 생성 => 스레드 생성할때 인자로 넘기기 => 스레드 스타드
				//MoveCircle r=new MoveCircle();
				//이렇게 접근하면 안된다. 문법적으로는 맞으나 실제 메모리에 올라간 객체는
				//다른 객체
				//r.setSize(200,200);
				//r.setVisible(true);
				tr.start();
				
			}
		});
		*/
		btStop.addActionListener(e->{
			flag=false;
			tr.interrupt();
		});
		/*
		btStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("@@@");
				flag=false;
				tr.interrupt();
			}
		});
		*/

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//-------------------------
	
	public void run() {
		while(flag) {
			//myP.x값을 증가
			if(myP.x>=myP.getWidth()) {
				myP.x=0;
			}
			myP.x++;
			System.out.println(myP.x);
			//repaint()해서 적용
			myP.repaint();
			//sleep()
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				System.out.println(e);
				break;
			}
		}
	}

	public static void main(String[] args) {
		MoveCircle my = new MoveCircle();
		my.setBounds(1200, 100, 500, 500);
		//x, y, w, h
		my.setVisible(true);
	}//------------------------

}//class/////////////////////////////////////
