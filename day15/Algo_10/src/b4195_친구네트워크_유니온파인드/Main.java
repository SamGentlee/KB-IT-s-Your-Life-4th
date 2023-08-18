package b4195_친구네트워크_유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/** 
 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며,
 *  이 값은 100,000을 넘지 않는다. 다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다. 
 *  친구 관계는 두 사용자의 아이디로 이루어져 있으며, 
 * 알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.
 */
public class Main {
	
	static int n;
	static HashMap<String, Integer> map;
	static int[] node;
	static int[] count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int t=0;t<tc;t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			
			node=new int[2*n];
			count = new int[2*n];
			for(int i =0;i<2*n;i++) {
				node[i]=i;
				count[i]=1;
			}
			
			map=new HashMap<String, Integer>();
			int index=0;
			for(int i=1;i<n+1;i++) {
				st=new StringTokenizer(br.readLine());
				String id1=st.nextToken();
				String id2=st.nextToken();
				if(!map.containsKey(id1)) {
					map.put(id1, index++);
				}
				if(!map.containsKey(id2)) {
					map.put(id2, index++);
				}
				System.out.println(union(map.get(id1),map.get(id2)));
			}
			
		
		
		}
	}

	private static int union(int a, int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			if(a<b) {
				node[b] =a;
				count[a]+=count[b];
				return count[a];
			}else {
				node[a]=b;
				count[b]+=count[a];
				return count[b];
			}
		}
		return count[a];
	}

	private static int find(int a) {
		if(node[a]==a) return a;
		return node[a]=find(node[a]);
	}

}
