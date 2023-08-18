package b11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(bf.readLine());
		}
		
	}

}
