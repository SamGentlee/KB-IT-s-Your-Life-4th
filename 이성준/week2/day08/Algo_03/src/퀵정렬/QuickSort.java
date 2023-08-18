package 퀵정렬;

import java.util.Scanner;

public class QuickSort {
	
	static void swap(int[] arr, int idx1, int idx2) {
		int tmp=arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=tmp;
	}//---------------------------
	
	static void quickSort(int[] arr, int left, int right) {
		
		int pl=left; //왼쪽 커서
		int pr=right; //오른쪽 커서
		int pivot = arr[(pl+pr)/2];
		
		do {
			while (arr[pl] < pivot) pl++;
			while (arr[pr] > pivot) pr--;
			if(pl <= pr) swap(arr, pl++ , pr-- );
		} while ( pl <= pr );
		
		if( left < pr) quickSort(arr, left, pr);
		if( pl < right) quickSort(arr, pl, right);
		
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("퀵 정렬");
		System.out.println("요소수 : ");
		int n = sc.nextInt();
		int[] arr=new int[n];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
			System.out.println("arr["+i+"] = "+arr[i]);
		}
		
		quickSort(arr,0,n-1);
		
		System.out.println("--------퀵 정렬후 --------");
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr["+i+"] = "+arr[i]);
		}
	}
	
}
