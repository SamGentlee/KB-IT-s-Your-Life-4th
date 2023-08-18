package b12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int checkArr[];
	static int myArr[];
	static int checkSecret;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Result = 0;
		char A[]=new char[S];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0;
		A=bf.readLine().toCharArray();
		st =new StringTokenizer(bf.readLine());
		for(int i =0 ;i<4;i++) {
			checkArr[i]=Integer.parseInt(st.nextToken());
			if(checkArr[i]==0) checkSecret++;
		}
		for(int i=0;i<P;i++) {
			//Add(A[i]);
		}
		if(checkSecret==4) {
			Result++;
		}
		for(int i=P;i<S;i++){
			
		}
	}
}
