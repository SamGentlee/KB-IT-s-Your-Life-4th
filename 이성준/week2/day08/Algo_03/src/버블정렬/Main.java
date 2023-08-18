package 버블정렬;

import java.util.Scanner;

public class Main {
	
	static int nx;
	static int[] x;
	
	//정렬을 위한 메서드
	static void bubbleSort(int[] x, int nx) {
		for(int i=0;i<nx-1;i++) {
			for(int j=nx-1;j>i;j--) {
				if(x[j-1]>x[j]) {
					swap(j-1,j);
				}
			}
		}
	}
	
	//앞에 인덱스에 있는 배열값이 더 클경우 서로 값을 바꾸는 메서드
	static void swap(int idx1, int idx2) {
		int t = x[idx1];
		x[idx1] = x[idx2];
		x[idx2] = t;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nx = sc.nextInt();
		x=new int[nx];
		
		//배열 저장
		for(int i=0;i<nx;i++) {
			x[i]=sc.nextInt();
		}
		
		//버블정렬
		bubbleSort(x,nx);
		
		//출력
		for(int i=0;i<nx;i++) {
			System.out.println(x[i]);
		}
	}
}
