package day11;
//java.lang.Runnable 인터페이스를 상속받아 구현 => 추상메서드: run()
public class Snail implements Runnable 
{
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("달팽이가 기어갑니다~~");
			int sec=(int)(Math.random()*2000);
			try {
				Thread.sleep(sec);
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}

}
