package b9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Character> list;
	static char[] res;
	static boolean[] visited;
	static int length;
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String str = st.nextToken();
		n = Integer.parseInt(st.nextToken());
		list = new ArrayList<Character>();
		for(int i=0;i<str.length();i++) {
			list.add(str.charAt(i));
		}
		
		length = list.size();
		res = new char[length];
		visited = new boolean[length];
		//StringBuilder sb = new StringBuilder();
		if(fac(length)<n) {
			System.out.println("No permutation");
		}else order(0,n);
	}
	
	private static void order(int depth,int order) {
		if(list.isEmpty()) {
			print();
			return;
		}
		int cnt=0;
		int index=0;
		for(int i=0;i<list.size();i++) {
			if(order < i * fac(length-1)) {
				if(i>0) index=i-1;
				else index=0;
				cnt=i*fac(length-1)-order;
				break;
			}else if(order == i*fac(length-1)) {
				if(i>0) index=i-1;
				else index=0;
			}
		}
		res[depth]=list.remove(index);
		order(depth+1,cnt);
		
	}

	static int fac(int num) {
		if(num>0) {
			return num*fac(num-1);
		}
		return 1;
	}
	
	static void print() {
		for(char c:res) {
			System.out.print(c);
		}
	}
	
}
