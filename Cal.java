package 응용;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Cal {
	static Calendar cal = Calendar.getInstance();
	Date data = new Date();
	char[] weeks = { '일', '월', '화', '수', '목', '금', '토' };
	char ch = '=';
	static int year = cal.get(Calendar.YEAR);
	static int month = cal.get(Calendar.MONTH);
	// =============================
	// [입력 모드]
	// static int year;
	// static int month;
	// =============================
	static int montharr[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	// 일주일은 7일 정수
	static int week = cal.get(Calendar.DAY_OF_WEEK); 
	// 현재 날짜 ..
	int Startday = cal.get(Calendar.DATE);
	// 해당 마지막일
	int Lastday = cal.getActualMaximum(Calendar.DATE);

	// 윤.평년 알고리즘
	public String Y(int year) {
		String PY;
		// 여기서 28 일이냐, 30,31 찾아도 됨
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			PY = "평";
			montharr[1] = 29;
		} else {
			PY = "윤";
			montharr[1] = 28;
		}
		return PY;
	}

	// (윤.평 비교)
	public void M(int month) {
		int x;

		System.out.println("\t" + (++month) + "월");
		/* ================================== */
		for (int j = 0; j < weeks.length * 7; j++)
			System.out.print(ch);
		System.out.println();
		for (int i = 0; i < weeks.length; i++)
			System.out.print(weeks[i] + "\t");
		System.out.println();
		for (int j = 0; j < weeks.length * 7; j++)
			System.out.print(ch);
		System.out.println();
		/* ================================== */
		int days = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;

		// 달력 마지막 일 구하기
		for (x = 1; x <= Lastday; x++) {
			System.out.print(x + "\t");
			// 7일 뒤 엔터
			if (x % 7 == 0)
				System.out.println();
			// 당일 표시
			if (x == (Startday - 1))
				System.out.print("~");
		}
	}

	public static void main(String[] args) {
		String PY;
		Cal YMcal = new Cal();
		/*Scanner sc = new Scanner(System.in);
		 * [입력모드]
		 * System.out.print("년/월 입력:"); 
		 * year = sc.nextInt();
		 * month = sc.nextInt();
		 */
		/* ================================== */
		//윤년.평년 구하기 
		PY = YMcal.Y(year);
		System.out.println("현재: (" + year + ") " + PY + "년");
		/* ================================== */
		// (일 대입) 윤.평년
		YMcal.M(month);
	}

}
