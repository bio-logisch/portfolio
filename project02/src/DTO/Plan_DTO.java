package DTO;

import java.awt.Component;

public class Plan_DTO { //EditGUI, Plan_DAO�� ���� 

	int num = 0; //����������ȣ - ������ ���� ���� �ڹ��ڵ�� ����
	String title = null; //���� ����
	int allday = 0; //������������ ���� üũ - 0�̸� ����x 1�̸� ����o(boolean���� ����)
	String type = null; //���� �з�(Task, Event, Appointment, etc.) 4������ �ϳ��� ����
	int imp = 0; //�߿����� ����üũ - �⺻��0, 0�̸� ���߿�, 1�̸� �߿�
	int s_year = 0; //���� ���ۿ��� 
	int s_month = 0; //���� ���ۿ� 
	int s_day = 0; //���� ������ 
	int e_year = 0; //���� ���Ῥ�� 
	int e_month = 0; //���� ����� 
	int e_day = 0; //���� ������ 
	int s_hour = 0; //���� ���۽ð� 
	int s_min = 0; //���� ���ۺ� 
	int e_hour = 0; //���� ����ð� 
	int e_min = 0; //���� ����� 
	String w_id = null; //�ش� ���� ������ ����� ���̵�
	
	//���� ��¿� �޼���
	public String prt() {
		//���� ��� �� ����� �� 4����(�ʿ���� ������Ʈ ��Ȱ��ȭ�� ó��)
		//1) ���� ����O + �Ϸ�����O + �߿� ����O/X : ��������
		//2) ���� ����O + �Ⱓ����O + �߿� ����O/X : �������� / ��������
		//3) ���� ����X + �Ϸ�����O + �߿� ����O/X: �������� / ���۽ð� / ����ð� 
		//4) ���� ����X + �Ⱓ����O + �߿� ����O/X: �������� /�������� / ���۽ð� / ����ð� - 4�� �����ϰ� �Է¹���
		//��쿡 ���� �Է¹��� �ʴ� ���� null�� �Է��� �� ��� 77�� �Է°����� DB�� ������
		String prtPlan1 = num+"�� >> ���� : " + title;
		String prtPlan12 = "\n�з� : "+type;
		String prtPlan21 = "\n���Ͽ��� : O";
		String prtPlan22 = "\n���Ͽ��� : X";
		String prtPlan31 = "  �߿����� : O";
		String prtPlan32 = "  �߿����� : X";
		String prtPlan33 = "  �Ϸ����� : O";
		String prtPlan34 = "  �Ⱓ���� : O";
		String prtPlan4 = "\n������ : " +s_year+"�� "+s_month+"�� "+s_day+"��";
		String prtPlan5 = "\n���۽ð� : " +s_hour+"�� "+s_min+"��";
		String prtPlan6 = "\n������ : " +e_year+"�� "+e_month+"�� "+e_day+"��";
		String prtPlan7 = "\n����ð� : " +e_hour+"�� "+e_min+"��";
		String prtPlanAll = null;
		if(allday == 0) { //�������� �ƴϸ�
			if(prtPlan6.contains("77")) { //���� �����ε� �������ڸ� �Է¹��� �ʾҴٸ�, �Ϸ������� �ش�
				//3�� ���(��������, ���۽ð�, ����ð�)
				if(imp == 0) { //�߿����� �ƴϸ�
					prtPlanAll = prtPlan1+prtPlan12+prtPlan22+prtPlan32+prtPlan33+prtPlan4+prtPlan5+prtPlan7+"\n";
				}else if(imp == 1) { //�߿������̸�
					prtPlanAll = prtPlan1+prtPlan12+prtPlan22+prtPlan31+prtPlan33+prtPlan4+prtPlan5+prtPlan7+"\n";
				}	
			}//else�� ��� 4�� ���� ������
		}else if(allday == 1) {//���������̸�, �ð��ʿ�x
			if(prtPlan6.contains("77")) { //�������ڸ� ���� ���� ��� - 1�� ���(��������)
				if(imp == 0) {
					prtPlanAll = prtPlan1+prtPlan12+prtPlan21+prtPlan32+prtPlan33+prtPlan4+"\n";
				}else if(imp == 1) {
					prtPlanAll = prtPlan1+prtPlan12+prtPlan21+prtPlan31+prtPlan33+prtPlan4+"\n";	
				}
			} else { //�������ڸ� ���� ��� - 2�� ���(��������, ��������)
				if(imp == 0) {
					prtPlanAll = prtPlan1+prtPlan12+prtPlan21+prtPlan32+prtPlan34+prtPlan4+prtPlan6+"\n";
				}else if(imp == 1) {
					prtPlanAll = prtPlan1+prtPlan12+prtPlan21+prtPlan31+prtPlan34+prtPlan4+prtPlan6+"\n";
				}
			}
		}
		return prtPlanAll;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAllday() {
		return allday;
	}
	public void setAllday(int allday) {
		this.allday = allday;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getImp() {
		return imp;
	}
	public void setImp(int imp) {
		this.imp = imp;
	}
	public int getS_year() {
		return s_year;
	}
	public void setS_year(int s_year) {
		this.s_year = s_year;
	}
	public int getS_month() {
		return s_month;
	}
	public void setS_month(int s_month) {
		this.s_month = s_month;
	}
	public int getS_day() {
		return s_day;
	}
	public void setS_day(int s_day) {
		this.s_day = s_day;
	}
	public int getE_year() {
		return e_year;
	}
	public void setE_year(int e_year) {
		this.e_year = e_year;
	}
	public int getE_month() {
		return e_month;
	}
	public void setE_month(int e_month) {
		this.e_month = e_month;
	}
	public int getE_day() {
		return e_day;
	}
	public void setE_day(int e_day) {
		this.e_day = e_day;
	}
	public int getS_hour() {
		return s_hour;
	}
	public void setS_hour(int s_hour) {
		this.s_hour = s_hour;
	}
	public int getS_min() {
		return s_min;
	}
	public void setS_min(int s_min) {
		this.s_min = s_min;
	}
	public int getE_hour() {
		return e_hour;
	}
	public void setE_hour(int e_hour) {
		this.e_hour = e_hour;
	}
	public int getE_min() {
		return e_min;
	}
	public void setE_min(int e_min) {
		this.e_min = e_min;
	}

	public String getW_id() {
		return w_id;
	}

	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	
}
