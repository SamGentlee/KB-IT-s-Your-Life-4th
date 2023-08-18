package b12891;

import java.util.Scanner;

public class Main {
	/** 
	 * 입력
	첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
	
	두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
	
	세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다. 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.
	
	출력
	첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.
	*/
	//int[] checkArr=new int[4];
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Main m =new Main();
		int P = sc.nextInt();
		int S = sc.nextInt();
		String str = sc.next();
		char[] arr = new char[str.length()];
		int[] myArr=new int[4];
		int[] countArr=new int[4];
		int result=0;
		String subStr=null;
		arr=str.toCharArray();
		
		//초기 myArr설정
		subStr=str.substring(0,S);
		countArr=countDNA(subStr,countArr);
		
		//값비교
		if(checkDNA(countArr,myArr)) {
			result++;
		}
		
		int removeIndex=0;
		int addIndex=removeIndex+S;
		while(addIndex<P) {
			if(str.charAt(removeIndex)=='A') {
				countArr[0]--;
			}else if(str.charAt(removeIndex)=='C') {
				countArr[1]--;
			}else if(str.charAt(removeIndex)=='G') {
				countArr[2]--;
			}else if(str.charAt(removeIndex)=='T') {
				countArr[3]--;
			}
			if(str.charAt(addIndex)=='A') {
				countArr[0]++;
			}else if(str.charAt(addIndex)=='C') {
				countArr[1]++;
			}else if(str.charAt(addIndex)=='G') {
				countArr[2]++;
			}else if(str.charAt(addIndex)=='T') {
				countArr[3]++;
			}
			if(checkDNA(countArr,myArr)) {
				result++;
			}
			removeIndex++;
		}
		System.out.println(result);
		
	}
	public static int[] countDNA(String subStr, int[] countArr) {
		for(int i=0;i<subStr.length();i++) {
			if(subStr.charAt(i)=='A') {
				countArr[0]++;
			}else if(subStr.charAt(i)=='B') {
				countArr[1]++;
			}else if(subStr.charAt(i)=='G') {
				countArr[2]++;
			}else if(subStr.charAt(i)=='T') {
				countArr[3]++;
			}
		}
		return countArr;
	}
	
	public static boolean checkDNA(int[]countArr, int[] myArr) {
		if(countArr[0]<myArr[0] || countArr[1]<myArr[1] || countArr[2]<myArr[2]||countArr[3]<myArr[3]) {
			return false;
		}
		return true;
	}
}
