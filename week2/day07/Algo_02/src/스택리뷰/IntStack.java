package 스택리뷰;

import 스택리뷰.IntStack.EmptyIntStackException;
import 스택리뷰.IntStack.OverflowIntStackException;

public class IntStack {

	private int[] stk; //저장공간
	private int capacity; //최대저장개수
	private int ptr =0; //현재 저장할 위치인데스
	
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	} //예외적인상황 - 보통: 독립클래스 
	
	public IntStack(int len) {
		stk = new int[len];
		capacity = len;
	}
	
	public IntStack() {
		this(64); //객체 초기화 목적(기능)
	}

	public int push(int i) {
		if(ptr == capacity)
			throw new OverflowIntStackException();
		stk[ptr++] = i;
		return i;	
	}

	public int pop() throws EmptyIntStackException{
		if(ptr==0) 
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	
}
