package b17608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            stack.push(Integer.parseInt(bf.readLine()));
        }
		int result = 0;
		int max = 0;
		int h=0;
		for(int i=0;i<n;i++) {
			h = stack.pop();
			if(h>max) {
				result++;
				max=h;
			}
		}
		System.out.println(result);
	}
}
