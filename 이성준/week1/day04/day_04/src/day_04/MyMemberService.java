package day_04;

public class MyMemberService {
	
	private MyMember[] mems = new MyMember[300];
	private int count = 0; //객체저장위치 -> 저장개수
	
	public int getCount() {
		return count;
	}
	
	//회원등록
	public void add(MyMember mm) {
		mems[count]=mm;
		count++;
	}//end add()
	
	
	//목록출현
	public void printAll() {
		System.out.println(" *** 전체 출력 ***");
		System.out.println(" * 저장 개수 : "+count);
		for(int i=0;i<count;i++) {
			System.out.println(i+1+". "+mems[i]);
		}//end for
		System.out.println();
	}// end printAll()
	
	//검색(이름)
	public MyMember searchByName(String findName) {
		System.out.println("*** 회원 검색 ***");
		for(int i=0;i<count;i++) {
			if(findName == mems[i].getName())
				return mems[i];
		}//end for
		System.out.println();
		return null;//검색 실패
	}//end searchByName()

	//수정(나이 +1)
	public boolean update(String string, int i) {
		MyMember m = searchByName(string);
		if(m==null) {
			return false; //실패
		}
		int age = m.getAge();
		m.setAge(age+1);
		return true; //성공
	}//end update()

	

	
	
	

	
}
