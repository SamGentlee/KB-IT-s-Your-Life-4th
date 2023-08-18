package b2961_부분집합;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int N;
        int []arr1;
        int []arr2;
        int ans= 1000000000;
        
        Scanner sc= new Scanner(System.in);
        
        N=sc.nextInt();
        
        // 신맛 쓴맛
        arr1= new int [N];
        arr2= new int [N];
        
        for(int i=0;i<N;i++) {
            arr1[i]=sc.nextInt();
            arr2[i]=sc.nextInt();
        }
        /*
         * ### shift 연산(bit 이동 연산자)

- **a << 1 : a의 각 비트를 왼쪽으로 1씩 이동**
    
    **a=1: ⇒ 0001  a<<1  → 0010=2**
    
- **shift 연산자와 and 연산자를 사용하여 부분집합을 나눌수 있다***/
        
        // 0001부터 2^n -1 (1111)까지 .. n자리수
        // 1씩 증가시키면서 모든 부분집합 경우의 수를 구함과 동시에 신맛 쓴맛 값 비교
        for(int i=1;i<(1<<N);i++) { // 최대 n-1칸 왼쪽으로 시프트
            int a=1, b=0;
            for(int x= 0;x<N;x++) {
                if((i&1<<x)>0) {
                    a*=arr1[x];
                    b+=arr2[x];
                }
            }
            ans=Math.min(ans, Math.abs(a-b));
        }
        System.out.println(ans);
    }

}