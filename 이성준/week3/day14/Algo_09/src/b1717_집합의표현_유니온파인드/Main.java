package b1717_집합의표현_유니온파인드;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static int[] node;
	
	
	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
		int n = sc.nextInt();
		int m = sc.nextInt();
		node=new int[n+1];
		for(int i=1;i<n+1;i++) {
			node[i]=i;
		}
		
		for(int i=0;i<m;i++)	{
//			st=new StringTokenizer(br.readLine());
//			int q = Integer.parseInt(st.nextToken());
//			int index1 = Integer.parseInt(st.nextToken());
//			int index2 = Integer.parseInt(st.nextToken());
			int q = sc.nextInt();
			int index1=sc.nextInt();
			int index2=sc.nextInt();
			if(q==0) {
				union(index1, index2);
			}else {
				if(isUnion(index1, index2)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	
	public static int find(int index) {
		if(node[index]==index)
			return index;
		return node[index]=find(node[index]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) node[b] = a;
	}
	
	public static boolean isUnion(int a, int b) {
		a= find(a);
		b=find(b);
		if(a==b) return true;
		return false;
	}
}
