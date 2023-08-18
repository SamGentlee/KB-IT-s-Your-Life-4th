package kb1반_이성준;

import java.util.Scanner;

public class kb1반_알고리즘1번_이성준 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		selectionSort(arr,N);
		for(int k : arr) {
			System.out.println(k);
		}
	}
	
	static void selectionSort(int[] arr, int n) {
		for(int i=0;i<n-1;i++) {
			int max = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]>arr[max])
					max=j;
			}
			swap(arr, i, max);
		}
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		int r = arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=r;
	}
}
