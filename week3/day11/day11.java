day06 (Algorithm)
yoongrammer.tistory.com/79  - 시간복잡도 설명
코딩테스트연습
 - 정올
 - 백준
 - SWEA
 - 프로그래머스
 - 코드트리
 
이클립스  디버거사용법
 - 소스 작성 완료
 - 브레이크포인트 설정(줄번호 더블클릭) : 디버거 실행중단점
 - 디버거실행(F11)
 - 입력값 넣고 엔터(Perspective 변경)
 - 브레이크포인트에서 중지(실행할 줄)
 - F5:Step Into(메서드 실행할 경우 메서드 안으로 들어가서 한줄씩 실행)
   F6:Step Over(메서드 실행할 경우 메서드 실행하고 다음줄로 이동)
 - 우측의 Varables 탭	에서 변수명과 값을 확인
 
 백준 - 11659 코딩테스트 교재 46p
 bufferedReader - 
 inputstreamReader(inputstream - 8bit, reader 16bit 처리)
 문자는 16비트로 처리해야하는데 inputstream은 16비트데이터를 하나로 제공
 bufferedReader 쓰는 이유 : readLine()때문
 readLine() - enter 입력도 포함함
 fufferedReader - 1k~8k까지의 데이터 버퍼제공
 
 자바 <-> 외부장치    = 60ms
		 내부:DRAM = 60ns 
		 cpu      = 1~ 2 ns

StringTokenizer - 공백(디폴트)문자기준으로 문자 분활(공백,탭,엔터)

자바예외(Exception) 오류
 - 가벼운 오류 : Exception - 전처리를 통해 예방가능(if...)
 NullPointerException : 변수에 null있을때 객체의 메서드 호출하는경우
 String s = null;  s.length; -> NullPointerException
 if(s != null) s.length; -> if로 예방가능
 - 심각한 오류 : Error - 전처리로 예방 불가능한 오류
 StackOverFlowError
 
 Exception
 - 일반적인 예외 : Exception
 - 실행시간 예외 : RuntimeException
 
  public void a(){
	new FileReader("a.txt"); // 1. 파일존재 , 2.파일없음
	//1. 오류발생시 호출메서드에 안알려주고 내부처리
	try{...}catch(Exception e){...}
	//2. 호출한 메서드에게 오류발생을 알림
	public void a() throws Exception{...}
  }
  
  * 내일 학습내용
  - 투포인터 알고리즘
  - 슬라이딩 윈도우
  - 입문4장(자료구조) 스택, 큐, 8장(리스트)연결리스트
  
  /////////////////////////////
  day07
  
  스택 - LIFO(Last-in-First-Out), 깊이우선탐색(DFS)
  
  - top : 삽입과 삭제가 일어나느 위치
  
  - push : top위치에 새로운 데이터를 삽입하는 연산
  - pop : top위치에 현재있는 데이터를 삭제하고 확인하는 연산
  - peerk : top위치에 현재있는 데이터를 단순 확인하는 연산
  
  큐 - FIFO(First-in-First-Out), 너비우선탐색(BFS)
  
  - rear : 큐에서 가장 끝 데이터를 가리키는 영역
  - front : 가장앞의 데이터를 가리키는 영역
  
  - add : rear부분에 새로운 데이터 삽입하는 연산
  - poll : front부분에 있는 데이터를 삭제하고 확인하는  연산
  - peek : front부분에 있는 데이터를 확인하는 연산
  
  스택 - 클래스 직접구현
  
////////////////////////////////
  day08
  
 학습내용

- 입문 6장 정렬
- 코딩테스트 4장 정렬(버블,선택,삽입,퀵,병합,기수)
- 재귀 호출 - for 퀵정렬

////////////////////////////////////////////////////////////////////////////////

day09

 - 완전 탐색
2보다 작은 숫자갯수: 1
2빼고 4보다 작은 숫자 갯수: 2
2,4빼고 3보다 작은 숫자 갯수: 1
+ 1
1 * 6 + 2*2 + 1*1 + 1 = 6 + 4 + 1 + 1 = 12