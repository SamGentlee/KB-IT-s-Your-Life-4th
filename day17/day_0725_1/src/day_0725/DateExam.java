package day_0725;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExam {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.getHours()); //취소선
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DAY_OF_MONTH);
		int day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(year);
		System.out.println(month+1);
		System.out.println(date);
		System.out.println(day);
		/////////////////////////////////
		SimpleDateFormat format = new SimpleDateFormat("yyyy년MM월dd일 HH:mm:ss");
		String today =format.format(new Date());
		System.out.println(today);
	}
}
