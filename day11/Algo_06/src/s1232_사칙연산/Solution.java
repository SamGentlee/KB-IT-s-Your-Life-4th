package s1232_사칙연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node{
		int value; //노드값
		char opr; //연산자
		int left, right; //자식 노드번호
		
		public Node(int value) {
			this(value,'\0',0,0);
		}
		
		public Node(int value, char opr, int left, int right) {
			super();
			this.value = value;
			this.opr = opr;
			this.left = left;
			this.right = right;
		}
	}
	
	static int N; //노드개수
	static int result; //계산결과
	static Node[] nodes; 
	static int value; //노드값
	static char opr; //연산자
	static int left, right; //자식 노드번호
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
		for(int t= 1; t<=10;t++) {
			st=new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			nodes=new Node[N+1];
			
			for(int i=1;i<N+1;i++) {
				st=new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					st.nextToken();
					String str = st.nextToken();
					if(st.hasMoreTokens()) {
						value=0;
						opr=str.charAt(0);
						left = Integer.parseInt(st.nextToken());
						right = Integer.parseInt(st.nextToken());
						nodes[i] = new Node(value, opr, left, right);
					}else {
						nodes[i] = new Node(Integer.parseInt(str));
					}
				}
			}
			result = calc(nodes[1]);
			System.out.println("#"+t+" "+result);
		}
	}

	private static int calc(Node node) {
		//연산자 뽑기
		char opr = node.opr;
		if(opr == '+') {
			return calc(nodes[node.left]) + calc(nodes[node.right]);
		}else if (opr == '-') {
			return calc(nodes[node.left]) - calc(nodes[node.right]);
		}else if (opr == '/') {
			return calc(nodes[node.left]) / calc(nodes[node.right]);
		}else if (opr == '*') {
			return calc(nodes[node.left]) * calc(nodes[node.right]);
		}else {
			return node.value;
		}
	}

}
