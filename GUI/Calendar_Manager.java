package GUI;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Calendar_Manager{ // 6*7�迭�� ��Ÿ�� �޷� ���� ���ϴ� class
	static final int CAL_WIDTH = 7;
	final static int CAL_HEIGHT = 6;
	int calDates[][] = new int[CAL_HEIGHT][CAL_WIDTH];
	int calYear;
	int calMonth;
	int calDayOfMon;
	final int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
	int calLastDate;
	Calendar today = Calendar.getInstance();
	Calendar cal;
	
	public Calendar_Manager(){ 
		setToday(); 
	}
	public void setToday(){
		calYear = today.get(Calendar.YEAR); 
		calMonth = today.get(Calendar.MONTH);
		calDayOfMon = today.get(Calendar.DAY_OF_MONTH);
		makeCalData(today);
	}
	public void makeCalData(Calendar cal){
		// 1���� ��ġ�� ������ ��¥�� ���� 
		int calStartingPos = (cal.get(Calendar.DAY_OF_WEEK)+7-(cal.get(Calendar.DAY_OF_MONTH))%7)%7;
		if(calMonth == 1) calLastDate = calLastDateOfMonth[calMonth] + leapCheck(calYear);
		else calLastDate = calLastDateOfMonth[calMonth];
		// �޷� �迭 �ʱ�ȭ
		for(int i = 0 ; i<CAL_HEIGHT ; i++){
			for(int j = 0 ; j<CAL_WIDTH ; j++){
				calDates[i][j] = 0;
			}
		}
		// �޷� �迭�� �� ä���ֱ�
		for(int i = 0, num = 1, k = 0 ; i<CAL_HEIGHT ; i++){
			if(i == 0) k = calStartingPos;
			else k = 0;
			for(int j = k ; j<CAL_WIDTH ; j++){
				if(num <= calLastDate) calDates[i][j]=num++;
			}
		}
	}
	public int leapCheck(int year){ // �������� Ȯ���ϴ� �Լ�
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) return 1;
		else return 0;
	}
	public void moveMonth(int mon){ // ����޷� ���� n�� ���ĸ� �޾� �޷� �迭�� ����� �Լ�(1���� +12, -12�޷� �̵� ����)
		calMonth += mon;
		if(calMonth>11) while(calMonth>11){
			calYear++;
			calMonth -= 12;
		} else if (calMonth<0) while(calMonth<0){
			calYear--;
			calMonth += 12;
		}
		cal = new GregorianCalendar(calYear,calMonth,calDayOfMon);
		makeCalData(cal);
	}
}