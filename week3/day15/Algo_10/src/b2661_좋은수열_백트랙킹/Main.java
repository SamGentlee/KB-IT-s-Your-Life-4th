package b2661_좋은수열_백트랙킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		goodSeq("");
	}

	private static void goodSeq(String res) {
		if(res.length() == n) {
			System.out.println(res);
			System.exit(0);// 현재 실행하고 있는 프로세스를 강제 종료
			//return;
		}
		for(int i=1;i<=3;i++) {
			if(isGoodSeq(res+i)) {
				goodSeq(res+i);
			}
		}
	}
/*
 * 마지막 1개와 그 앞의 1개의 수가 동일한지
마지막 2개와 그 앞의 2개의 수가 동일한지
마지막 3개와 그 앞에 3개의 수가 동일한지
....
마지막 N/2개와 그 앞에 N/2개의 수가 동일한지 비교
substring(i,j) == i번째부터 j번째앞에까지 반환
System.exit(0) 을 이용하면 최초 출력 후 프로세스를 강제 종료할 수 있다.

 
*/
	private static boolean isGoodSeq(String res) {
		int len=res.length()/2;
		for(int i=1;i<=len;i++) {
			if(res.substring(res.length()-i)
					.equals(res.substring(res.length()-2*i,res.length()-i))) {
				return false;
			}
		}
		return true;
	}
}
