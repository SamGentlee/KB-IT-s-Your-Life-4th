package 배열리뷰;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class 지뢰빨리찾기 {

	/**
	 * 10x10좌룦에 10개 임의의 위치에 지뢰를 매설 사용자는 행,열 좌표를 입력, 
	 * 해당좌표가 지뢰이면 X표시. 아니면 주위8칸내 지뢰갯수
	 * 표시 열지않은 좌표는 "+" 표시
	 * 
	 * 1. 12x12 정수배열생성 
	 * 2. 중복되지않는 10개 좌표 생성 11 22 33 44 55 66 77 88 99 1010 
	 * 3. 각 좌표에
	 * 9저장. 주위 8개에 1씩증가 
	 * 4. (반복) 
	 * 5. 사용자로부터 좌표입력(행,열) 
	 * 6. 해당좌표의 값이 9이상이면 해당좌표는 지뢰임 
	 * 7. 해당좌표가 9미만이면 지뢰아님 
	 * 8. 전체배열 출력(+:오픈안한 좌표, 숫자: 지뢰아닌곳, X:지뢰) 
	 * 9. 지뢰 10개를 다 찾으면 종료. 아니면 5번부터 반복
	 */
	public static void main(String[] args) throws IOException{
		//12x12좌표생성
		int[][] arr = new int[12][12];
		//좌표오픈여부
		boolean[][] open= new boolean[12][12];
		//남은 지뢰갯수
		int remainMines = 1;
		//2. 중복되지안흔 10개 좌표 생성
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		for (int i = 0; i < remainMines; i++) {
			int r = (int)(Math.random()*list.size());
			int x = list.remove(r);
			int row = x / 10 + 1;
			int col = x % 10 + 1;
			arr[row][col] = 9; // 지뢰값 지정
			
			arr[row - 1][col - 1]++;
			arr[row - 1][col]++;
			arr[row - 1][col + 1]++;
			arr[row][col - 1]++;
			arr[row][col + 1]++;
			arr[row + 1][col - 1]++;
			arr[row + 1][col]++;
			arr[row + 1][col + 1]++;
		}
		
		//출력
		Scanner sc = new Scanner(System.in);
		while(remainMines != 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			if(open[row][col]) {
				System.out.println("이미 열었던 좌표입니다!"); 
				continue;
			}
			if(arr[row][col]>=9) {
				System.out.println("지뢰찾음");
				open[row][col]=true;
				remainMines--;
			}else if(arr[row][col]<9) {
				System.out.println("지뢰아님");
				open[row][col]=true;
			}
			for(int i=1;i<11;i++) {
				for(int j=1;j<11;j++) {
					if(open[i][j]==true) {
						if(arr[i][j] >=9) System.out.printf("%3s","X");
						else System.out.printf("%3d",arr[i][j]);
					}else System.out.printf("%3s","+");
				}
				System.out.println();
			}
		}
		System.out.println("게임 종료!!");
		sc.close();
	}
}
