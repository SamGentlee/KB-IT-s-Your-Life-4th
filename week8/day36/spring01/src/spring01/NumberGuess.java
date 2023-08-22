package spring01;
/** 난수와 판정메서드를 제공 */
public class NumberGuess {
	//난수
	private int com_num = new java.util.Random().nextInt(100)+1;
	//판정메서드
	public String checkNumber(int num) {
		if(com_num == num) return "정답";
		else if(com_num < num) return "낮춰주세요";
		else if(com_num > num) return "높여주세요";
		return null;
	}//end checkNum()
}
