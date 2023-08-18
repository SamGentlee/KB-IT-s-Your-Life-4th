package b10157;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int a=Integer.parseInt(str.split(" ")[0]);
		int b=Integer.parseInt(str.split(" ")[1]);
//		Scanner sc2=new Scanner(System.in);
//		int seat = sc2.nextInt();
		
		int [][] arr=new int[a][b];
		int cnt=1; //시작번호
		int i=0;
		int x=0 ,y=0; // x=행시작값 , y=열시작값
		while(x<a && y<b) {
			for(i=y;i<b;i++) {
				arr[x][i]=cnt++;
			}
			x++;
			for(i=x;i<a;i++) {
				arr[i][b-1]=cnt++;
			}
			b--;
			if(x < a) {
				for(i = b-1; i>=y;i--) {
					arr[a-1][i]=cnt++;
				}
				a++;
			}
			if(y < b) {
				for(i = a-1;i>=x;i--) {
					arr[i][y]=cnt++;
				}
				y++;
			}
		}
		for(x=0; x < arr.length; x++) {
            for(y=0; y< arr[x].length; y++) {
                System.out.print(arr[x][y] + ", ");
            }
            System.out.println();
        }
		
		
	}
}	
