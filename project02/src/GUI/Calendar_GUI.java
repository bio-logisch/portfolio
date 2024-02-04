package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

import DAO.Member_DAO;
import DAO.Plan_DAO;
import DTO.Member_DTO;
import DTO.Plan_DTO;
import button.RoundedButton;
import button.RoundedButton_RC;
//CalendarDataManager�� GUI + �޸��� + �ð�
public class Calendar_GUI extends Calendar_Manager implements ActionListener{ 
	JFrame mainFrame;
	//�����Ǻκ�(�ɼ���, �޷� ��)
	JPanel calOpPanel;
	RoundedButton_RC todayBut;
	JLabel todayLab, curMMYYYYLab;
	RoundedButton lYearBut, lMonBut, nMonBut, nYearBut;
	ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();
	JToolBar tool = new JToolBar("Menu");
	JComboBox<String> indexComboBox = new JComboBox<String>();
	//������ �޷ºκ�
	JPanel calPanel;
	JButton weekDaysName[];
	JButton dateButs[][] = new JButton[6][7];
	listenForDateButs lForDateButs = new listenForDateButs(); 
	JPanel infoPanel;
	JLabel infoClock;
	//������ �ϴܺκ�
	JPanel westBottomPanel = new JPanel();
	//�����ϴ� �ϱ��� ���� 
	JTextArea memoArea;
	JLabel selectedDate;
	JPanel memoPanel, memoSubPanel;
	JScrollPane memoAreaSP;
	RoundedButton_RC saveBut, delBut, clearBut, returnBut, readBut; 
	String writeNow;
	//������ ��� �κ�
	JTextField tfSearchWord; //�˻��� �Է°���
	JButton findBtn; //���� ã��, �ε��� �޺��ڽ� �� ��ư
	//������ ���� �г� 
	JPanel frameSubPanelEastNorth, frameSubPanelEastCenter, frameSubPanelEastBottom;
	//������ ��� �κ�
	JButton createBtn, myPageBtn, DdayBtn, viewBtn, editBtn, logOutBtn;
	JLabel buttonInfo4, buttonInfo5, buttonInfo6, buttonInfo7, buttonInfo8,buttonInfo9;
	//������ �߾� �κ� 
	JPanel eastInfoPanel, viewPanel, createPanel, editPanel, dDayPanel, myPagePanel;
	JPanel resultPanel;// �˻���� ������ ��� �г�
	JLabel infoTitle;
	JLabel yearLbl1 = new JLabel("��");		
	JLabel monthLbl1 = new JLabel("��");	
	JLabel dayLbl1 = new JLabel("��");
	JLabel hourLbl1 = new JLabel("��");
	JLabel minLbl1 = new JLabel("��");
	JLabel yearLbl2 = new JLabel("��");		
	JLabel monthLbl2 = new JLabel("��");	
	JLabel dayLbl2 = new JLabel("��");
	JLabel hourLbl2 = new JLabel("��");
	JLabel minLbl2 = new JLabel("��");
	JLabel startDateInfo, endDateInfo, startTimeInfo, endTimeInfo;
	//������ viewPanel ����
	JList<String> ls;
	JScrollPane viewSP;
	JTextArea viewArea;
	JLabel noInfo;
	JComboBox<Integer> se_year = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> se_yearModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> se_month = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> se_monthModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> se_day = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> se_dayModel = new DefaultComboBoxModel<Integer>();	
	StringBuilder scheduleText;
	int seYear, seMonth, seDay;
	JLabel yearLbl3 = new JLabel("��");		
	JLabel monthLbl3 = new JLabel("��");	
	JLabel dayLbl3 = new JLabel("��");
	RoundedButton_RC viewEventBtn = new RoundedButton_RC("view");
	//������ createPanel ����
	JLabel panelTitle2 = new JLabel("");
	JTextField tfTitle;
	JCheckBox allday, imp;
	JRadioButton type0, type1, type2, type3, type4, oneDay, moreThanTwodays;
	RoundedButton_RC savePlanBtn = new RoundedButton_RC("save"); 
	RoundedButton_RC dateBtn = new RoundedButton_RC("Next");
	ButtonGroup group1, group2; //����Ÿ�� ������ư ����
	Calendar now;
	JComboBox<Integer> s_year = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> s_yearModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> s_month = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> s_monthModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> s_day = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> s_dayModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> e_year = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> e_yearModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> e_month = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> e_monthModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> e_day = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> e_dayModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> s_hour = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> s_hourModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> s_min = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> s_minModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> e_hour = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> e_hourModel = new DefaultComboBoxModel<Integer>();		
	JComboBox<Integer> e_min = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> e_minModel = new DefaultComboBoxModel<Integer>();		
	String planTitle, planType;
	int sYear, sMonth, sDay, sHour, sMin, eYear, eMonth, eDay, eHour, eMin, ad, impo, index;		
	int year, month, day, hour, min;
	//������ resultPanel ����
	JTextArea resultArea = new JTextArea();
	//������ editPanel ����
	JLabel subInfo = new JLabel();
	JFormattedTextField tfNum = new JFormattedTextField(new NumberFormatter());
	RoundedButton_RC editFindBtn, planUpdateBtn, planDeleteBtn;
	//������ dDayPanel ����
	//������ myPagePanel ����
	JLabel mpTitle, mpName, mpBdate,  mpPass, oldPass, newPass;
	JTextField tfOldPass, tfNewPass;
	RoundedButton_RC mpUpdateBtn, mpDeleteBtn;
	//�ϴܺκ�
	JPanel frameBottomPanel1, frameBottomPanel2;
	JLabel todaysSentance;
	JLabel bottomInfo = new JLabel("INFO Check");
	//���, �޼���
	final String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
	final String title = "Dear My Diary ver 1.0 ... Main";
	final String SaveButMsg1 = " ������ MemoData ������ ����Ǿ����ϴ�.";
	final String SaveButMsg2 = "���� �ϱ⸦ �Է����ּ���.";
	final String SaveButMsg3 = "<html><font color=red>������ �ҷ��� �� �����ϴ�.</html>";
	final String DelButMsg1 = "�ϱⰡ �����Ǿ����ϴ�";
	final String DelButMsg2 = "�ϱⰡ �������� �ʾҰų� �̹� �����Ǿ����ϴ�.";
	final String DelButMsg3 = "<html><font color=red>������ �������� ���߽��ϴ�.</html>";
	final String ClrButMsg1 = "�ؽ�Ʈ�� ������ϴ�.";
	final String ReturnButMsg1 = "�ؽ�Ʈ�� �����߽��ϴ�.";
	final String SaveButMsg4 = "������ ��ϵǾ����ϴ�.";
	final String SaveButMsg5 = "���� ��Ͽ� �����Ͽ����ϴ�. [������ ����]";
	final String EditButMsg1 = "���� ������ �����Ǿ����ϴ�.";
	final String EditButMsg2 = "���� ������ �����Ͽ����ϴ�.";
	final String DelButMsg4 = "������ �����Ͽ����ϴ�.";
	final String nextButMsg1 = "���� ��¥�� �ð��� �Է��Ͻ� �� �ֽ��ϴ�.";
	final String nextButMsg2 = "������ ������ �ֽ��ϴ�. �Է� �� �ٽ� next��ư�� �����ּ���.";
	final String ReadButMsg1 = "������ �ϱ⳻���� �ҷ��Խ��ϴ�.";
	final String ReadButMsg2 = "����� �ϱ������� �����ϴ�.";
	final String UpdateButMsg1 = "������ �ϱ⳻���� �ҷ��Խ��ϴ�.";
	final String EditButMsg3 = "��й�ȣ�� �����Ͽ����ϴ�.";
	final String DelButMsg5 = "ȸ��Ż�� ó���Ǿ����ϴ�. �����մϴ�.";

	//��Ʈ ����
	Font f1 = new Font("Arial", Font.PLAIN, 12);
	Font f2 = new Font("Arial", Font.PLAIN, 15);
	Font f3 = new Font("Arial", Font.BOLD, 17); 
	Font f4 = new Font("���� ���", Font.BOLD, 13); 
	Font f5 = new Font("���� ���", Font.BOLD, 17); 

	//DAO,DTO����
	Plan_DAO pdao = new Plan_DAO();
	Member_DAO mdao = new Member_DAO();

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Calendar_GUI();
			}
		});
	}
	public Calendar_GUI(){ //������� ������ ���ĵǾ� ����. �� �ǳ� ���̿� ���ٷ� ����

		mainFrame = new JFrame(title);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1000,800);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		//		mainFrame.setIconImage(icon.getImage());
		try{  //LookAndFeel Windows ��Ÿ�� ����
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(mainFrame) ;
		}catch(Exception e){
			bottomInfo.setText("ERROR : LookAndFeel setting failed");
		}
		calOpPanel = new JPanel();
		//���� ��¥�� ���ƿ��� ��ư �� ���� ��¥ �� �߰�
		todayBut = new RoundedButton_RC("Today");
		todayBut.setToolTipText("Today");
		todayBut.addActionListener(lForCalOpButtons);
		todayLab = new JLabel(today.get(Calendar.YEAR)+"/"+(today.get(Calendar.MONTH)+1)
				+"/"+today.get(Calendar.DAY_OF_MONTH));
		//���� �ð� �˷��ִ� �ǳ� �߰�
		infoPanel = new JPanel();
		infoPanel.setLayout(new BorderLayout());
		infoClock = new JLabel("", SwingConstants.LEFT);
		infoClock.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		infoPanel.add(infoClock, BorderLayout.NORTH);
		infoClock.setForeground(new Color(238, 161, 28));
		//�۳�,������,������,���� �̵� ��ư �߰�
		lYearBut = new RoundedButton("<<");
		lYearBut.setToolTipText("Previous Year");
		lYearBut.addActionListener(lForCalOpButtons);
		lMonBut = new RoundedButton("<");
		lMonBut.setToolTipText("Previous Month");
		lMonBut.addActionListener(lForCalOpButtons);
		//�߾� ���� �� ǥ��
		curMMYYYYLab = new JLabel("<html><table width=100><tr><th><font size=5>"
				+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "+calYear
				+"</th></tr></table></html>");
		nMonBut = new RoundedButton(">");
		nMonBut.setToolTipText("Next Month");
		nMonBut.addActionListener(lForCalOpButtons);
		nYearBut = new RoundedButton(">>");
		nYearBut.setToolTipText("Next Year");
		nYearBut.addActionListener(lForCalOpButtons);
		calOpPanel.setLayout(null);
		todayBut.setBounds(10, 15, 80, 30);
		todayLab.setBounds(100, 15, 100, 30);
		lYearBut.setBounds(10, 60, 50, 30);
		lMonBut.setBounds(70, 60, 50, 30);
		curMMYYYYLab.setBounds(130, 60, 100, 30);
		nMonBut.setBounds(245, 60, 50, 30);
		nYearBut.setBounds(305, 60, 50, 30);
		infoPanel.setBounds(170, 13, 100, 30); //�ǽð� �ð�

		calOpPanel.add(todayBut); //���ó�¥ Ȯ�ι�ư
		calOpPanel.add(todayLab); //���ó�¥ ǥ�ⷦ
		calOpPanel.add(lYearBut); //�ϳ��� �̵� ��ư
		calOpPanel.add(lMonBut); //�Ѵ��� �̵� ��ư
		calOpPanel.add(curMMYYYYLab); //���� �� ǥ�ⷦ
		calOpPanel.add(nMonBut); //������ �̵� ��ư
		calOpPanel.add(nYearBut); //���� �̵� ��ư
		//��Ʈ ���� �߰�
		todayBut.setForeground(new Color(0, 1, 0)); 
		todayLab.setForeground(new Color(61, 105, 220)); 
		lYearBut.setForeground(Color.black);
		lMonBut.setForeground(Color.black);
		curMMYYYYLab.setForeground(new Color(61, 105, 220)); 
		nMonBut.setForeground(Color.black);
		nYearBut.setForeground(Color.black);
		//�޷��� �κ� - ����
		calPanel=new JPanel();
		weekDaysName = new JButton[7];
		for(int i=0 ; i<CAL_WIDTH ; i++){
			weekDaysName[i] = new JButton(WEEK_DAY_NAME[i]);
			weekDaysName[i].setBorderPainted(false);
			weekDaysName[i].setContentAreaFilled(false);
			weekDaysName[i].setForeground(Color.WHITE);
			weekDaysName[i].setFont(f3);
			if(i == 0) weekDaysName[i].setBackground(new Color(219, 105, 82)); //Sun
			else if (i == 6) weekDaysName[i].setBackground(new Color(110, 161, 215)); //Sat
			else weekDaysName[i].setBackground(new Color(79, 213, 128)); //Mon~Fri
			weekDaysName[i].setOpaque(true);
			weekDaysName[i].setFocusPainted(false);
			calPanel.add(weekDaysName[i]);
		}
		for(int i=0 ; i<CAL_HEIGHT ; i++){
			for(int j=0 ; j<CAL_WIDTH ; j++){
				dateButs[i][j] = new JButton();
				dateButs[i][j].setBorderPainted(false); 
				dateButs[i][j].setContentAreaFilled(true);
				dateButs[i][j].setBackground(new Color(229,248,249));
				dateButs[i][j].setOpaque(true);
				dateButs[i][j].addActionListener(lForDateButs);
				dateButs[i][j].setFont(f2);
				calPanel.add(dateButs[i][j]);
			}
		}
		calPanel.setLayout(new GridLayout(0,7,2,2));
		calPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		showCal(); // �޷��� ǥ��

		//calOpPanel, calPanel, infoPanel��  frameSubPanelWest�� ��ġ
		JPanel frameSubPanelWest = new JPanel();
		frameSubPanelWest.setLayout(null);
		calOpPanel.setBounds(10, 0, 690, 100);
		calPanel.setBounds(15, 100, 530, 420);

		frameSubPanelWest.add(calOpPanel);
		frameSubPanelWest.add(calPanel);
		frameSubPanelWest.add(infoPanel);

		Dimension frameSubPanelWestSize = frameSubPanelWest.getPreferredSize();
		frameSubPanelWestSize.width = 560;
		frameSubPanelWestSize.height = 700;
		frameSubPanelWest.setPreferredSize(frameSubPanelWestSize);
		frameSubPanelWest.setBounds(0,0,560,730);

		//������ �� ���� �˻�â, �˻���ư, �ε��� ��ư �߰� 
		tfSearchWord = new JTextField();
		tfSearchWord.setBounds(370, 60, 116, 30);
		calOpPanel.add(tfSearchWord);
		tfSearchWord.setColumns(10);

		//���� �г� �˻���ư �߰�
		ImageIcon find = new ImageIcon("./Image/icon_search(25).png");
		findBtn = new JButton(find);
		findBtn.setBounds(490, 63, 25, 25);
		calOpPanel.add(findBtn);

		findBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[�̺�Ʈ �߻�] - Find ��ư");
				//�˻�â�� �� ������ ���� select arrayList �� ���� �ǳڿ� �����ֱ�
				//JList�� ����ϰ� ���콺�� Ŭ���� �ش� ����Ʈ �ε��� ��ȣ �����ؼ� ���� Ŭ�� �� �󼼺��� ��� ����
				JLabel resultInfo = new JLabel("");
				resultArea = new JTextArea();
				resultArea.setText("");
				resultArea.setLineWrap(true);
				resultArea.setWrapStyleWord(true);
				JScrollPane resultAreaSP = 
						new JScrollPane(resultArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				ArrayList<Plan_DTO> plist = 
						pdao.selectsearch3(tfSearchWord.getText(),Login_Frame.getLogID());
				if(plist.size() == 0) resultInfo.setText("Search result : NO RESULTS");
				else {
					resultInfo.setText("Search result : "+plist.size()+" event(s) founded.");
					for(Plan_DTO p : plist) {
						resultArea.append(p.prt()+"\n");
						resultArea.setCaretPosition(resultArea.getDocument().getLength());
					}
				}
				resultInfo.setBounds(25,25,300,30);
				resultInfo.setForeground(Color.blue);
				resultInfo.setFont(f3);
				resultArea.setBounds(15,60,375,500);
				resultPanel.removeAll();
				resultPanel.add(resultInfo);
				resultPanel.add(resultAreaSP);
				resultPanel.add(resultArea);
				mainFrame.repaint();
				viewPanel.setVisible(false);
				resultPanel.setVisible(true);
				createPanel.setVisible(false);
				editPanel.setVisible(false);
				dDayPanel.setVisible(false);
				myPagePanel.setVisible(false);			
			}
		});
		//�ε��� ���� �޺��ڽ�
		indexComboBox.setBounds(410, 15, 120, 30);
		indexComboBox.addItem("view All");
		indexComboBox.addItem("Task");
		indexComboBox.addItem("Anniversary");
		indexComboBox.addItem("Appointment");
		indexComboBox.addItem("etc.");
		tool.add(indexComboBox);
		calOpPanel.add(indexComboBox);
		calOpPanel.add(tool, BorderLayout.NORTH);		

		//�ϱ��� ���� �ڵ�
		selectedDate = new JLabel("<Html><font size=3>"+today.get(Calendar.YEAR)
		+"/"+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DAY_OF_MONTH)
		+"&nbsp;(Today)</html>", SwingConstants.LEFT);
		selectedDate.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

		memoPanel=new JPanel();
		memoPanel.setBorder(BorderFactory.createTitledBorder("  Write diary here "));
		memoArea = new JTextArea();
		memoArea.setSize(250,300);
		memoArea.setLineWrap(true);
		memoArea.setWrapStyleWord(true);
		memoAreaSP = new JScrollPane(memoArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		readMemo();
		memoSubPanel=new JPanel();
		saveBut = new RoundedButton_RC("Save"); 
		delBut = new RoundedButton_RC("Delete");
		clearBut = new RoundedButton_RC("Clear");
		returnBut = new RoundedButton_RC("Return");
		readBut = new RoundedButton_RC("Read");
		//�ϱ��ۼ� �� txt���Ϸ� ����
		saveBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {		
					File f= new File("MemoData");
					if(!f.isDirectory()) f.mkdir();
					String memo = memoArea.getText();
					if(memo.length()>0){
						BufferedWriter out = new BufferedWriter(new FileWriter(
								"MemoData/"+calYear+((calMonth+1)<10?"0":"")
								+(calMonth+1)+(calDayOfMon<10?"0":"")
								+calDayOfMon+".txt"));
						String str = memoArea.getText();
						out.write(str);  
						out.close();
						bottomInfo.setText(calYear+((calMonth+1)<10?"0":"")
								+(calMonth+1)+(calDayOfMon<10?"0":"")
								+calDayOfMon+".txt"+SaveButMsg1);
					}
					else 
						bottomInfo.setText(SaveButMsg2);
				} catch (IOException e) {
					bottomInfo.setText(SaveButMsg3);
				}
				showCal();
			}					
		});
		//�������� ���ϸ��� �ϱ����� ����
		delBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				memoArea.setText("");
				File f =new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")
						+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt");
				if(f.exists()){
					f.delete();
					showCal();
					bottomInfo.setText(DelButMsg1);
				}
				else bottomInfo.setText(DelButMsg2);					
			}					
		});
		//memoArea�� �Է��� �ؽ�Ʈ �ʱ�ȭ
		clearBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				writeNow = memoArea.getText();
				memoArea.setText(null);
				bottomInfo.setText(ClrButMsg1);
			}
		});
		//�ʱ�ȭ�� �ؽ�Ʈ ����
		returnBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				memoArea.setText(writeNow);
				bottomInfo.setText(ReturnButMsg1);
			}
		});
		//�������� �ϱ����� ���� �о����
		readBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				File f =new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")
						+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt");
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(
							new FileReader("MemoData/"+calYear+((calMonth+1)<10?"0":"")
									+(calMonth+1)+(calDayOfMon<10?"0":"")
									+calDayOfMon+".txt"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				if(f.exists()){       
					String str;        
					try {
						while ((str = reader.readLine()) != null) {            
							memoArea.setText(str);
							bottomInfo.setText(ReadButMsg1);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}         
					try {
						reader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}        
				}else bottomInfo.setText(ReadButMsg2);
			}
		});
		memoSubPanel.add(saveBut);
		memoSubPanel.add(delBut);
		memoSubPanel.add(clearBut);
		memoSubPanel.add(returnBut);
		memoSubPanel.add(readBut);
		memoPanel.setLayout(new BorderLayout());
		memoPanel.add(selectedDate, BorderLayout.NORTH);
		memoPanel.add(memoAreaSP,BorderLayout.CENTER);
		memoPanel.add(memoSubPanel,BorderLayout.SOUTH);
		memoPanel.setBounds(10,530,530,200);
		frameSubPanelWest.add(memoPanel);

		//���� �ϴ� �г� - �ȳ����� ��¿�
		frameBottomPanel2 = new JPanel();
		frameBottomPanel2.setBounds(0,730,820,40);
		frameBottomPanel2.add(bottomInfo);
		//���� ��� �г� - ��ư �߰�
		frameSubPanelEastNorth = new JPanel();
		frameSubPanelEastNorth.setBounds(0, 0, 425, 55);
		frameSubPanelEastNorth.setLayout(null);
		//���� �߾� �г� - �г���ȯ�� 
		frameSubPanelEastCenter = new JPanel();
		frameSubPanelEastCenter.setBounds(560, 0, 425, 700);
		frameSubPanelEastCenter.setLayout(null);
		//���� �ϴ� �г� 
		frameSubPanelEastBottom = new JPanel();
		frameSubPanelEastBottom.setLayout(null);
		frameSubPanelEastBottom.setBounds(825, 715, 150, 40);	
		//���� ��� �ȳ����� �� �޴���ư 6���� �߰�
		JLabel buttonInfo1 = new JLabel("   select");
		JLabel buttonInfo2 = new JLabel("Button");
		JLabel buttonInfo3 = new JLabel(">>>");
		buttonInfo1.setBounds(0,10,50,35);
		buttonInfo2.setBounds(55,10,40,35);
		buttonInfo3.setBounds(100,10,40,35);
		buttonInfo4 = new JLabel("view"); //Ư������ �˻� ���
		buttonInfo5 = new JLabel(" new"); //���� ��� ���
		buttonInfo6 = new JLabel(" edit"); //���� ����, ���� ���
		buttonInfo7 = new JLabel("D-day"); //���� Ȯ�� ���
		buttonInfo8 = new JLabel("mypage"); //����������(Ȯ��,��й�ȣ ����,Ż��)���
		buttonInfo9 = new JLabel("logout"); //�α׾ƿ� ���
		buttonInfo4.setBounds(140,40,30,15);
		buttonInfo5.setBounds(185,40,30,15);
		buttonInfo6.setBounds(230,40,30,15);
		buttonInfo7.setBounds(272,40,40,15);
		buttonInfo8.setBounds(315,40,50,15);
		buttonInfo9.setBounds(370,40,40,15);

		ImageIcon view = new ImageIcon("./Image/icon_cal(30).png");
		viewBtn = new JButton(view); 
		viewBtn.setBounds(140,5,30,30);
		ImageIcon create = new ImageIcon("./Image/icon_plus(30).png");
		createBtn = new JButton(create); 
		createBtn.setBounds(185,5,30,30);
		ImageIcon edit = new ImageIcon("./Image/icon_delete(30).png");
		editBtn = new JButton(edit); 
		editBtn.setBounds(230,5,30,30);
		ImageIcon dDay = new ImageIcon("./Image/icon_heart(30).png");
		DdayBtn = new JButton(dDay); 
		DdayBtn.setBounds(275,5,30,30);
		ImageIcon myPage = new ImageIcon("./Image/icon_person(30).png");
		myPageBtn = new JButton(myPage); 
		myPageBtn.setBounds(320,5,30,30);
		ImageIcon logOut = new ImageIcon("./Image/icon_right(30).png");
		logOutBtn = new JButton(logOut); 
		logOutBtn.setBounds(370,5,30,30);

		frameSubPanelEastNorth.add(buttonInfo1);
		frameSubPanelEastNorth.add(buttonInfo2);
		frameSubPanelEastNorth.add(buttonInfo3);
		frameSubPanelEastNorth.add(buttonInfo4);
		frameSubPanelEastNorth.add(buttonInfo5);
		frameSubPanelEastNorth.add(buttonInfo6);
		frameSubPanelEastNorth.add(buttonInfo7);
		frameSubPanelEastNorth.add(buttonInfo8);
		frameSubPanelEastNorth.add(buttonInfo9);
		frameSubPanelEastNorth.add(viewBtn);
		frameSubPanelEastNorth.add(createBtn);
		frameSubPanelEastNorth.add(editBtn);
		frameSubPanelEastNorth.add(DdayBtn);
		frameSubPanelEastNorth.add(myPageBtn);
		frameSubPanelEastNorth.add(logOutBtn);

		//���� �߾� �г� - �⺻��
		eastInfoPanel = new JPanel(new CardLayout());
		eastInfoPanel.setLayout(null);
		eastInfoPanel.setBounds(10,80,405,610);
		frameSubPanelEastCenter.add(eastInfoPanel);
		//���� �߾� �г� ��ȯ �غ�
		viewPanel = new JPanel();
		viewPanel.setLayout(null);
		viewPanel.setBackground(new Color(241, 241, 177)); //�������
		viewPanel.setBounds(0,0,405,610); 

		resultPanel = new JPanel();
		resultPanel.setLayout(null);
		resultPanel.setBackground(new Color(213, 247, 204)); //���ʷ�
		resultPanel.setBounds(0,0,405,610); 

		createPanel = new JPanel();
		createPanel.setLayout(null);
		createPanel.setBackground(new Color(191, 216, 240)); //���ϴû�
		createPanel.setBounds(0,0,405,610); 

		editPanel = new JPanel();
		editPanel.setLayout(null);
		editPanel.setBackground(new Color(224, 214, 241)); //������
		editPanel.setBounds(0,0,405,610); 

		dDayPanel = new JPanel();
		dDayPanel.setLayout(null);
		dDayPanel.setBackground(new Color(239, 214, 241)); //����ũ
		dDayPanel.setBounds(0,0,405,610); 

		myPagePanel = new JPanel();
		myPagePanel.setLayout(null);
		myPagePanel.setBackground(new Color(246, 233, 213)); //����Ȳ
		myPagePanel.setBounds(0,0,405,610); 

		eastInfoPanel.add(viewPanel); //�޷¿� Ŭ���� �� �������� �г�
		eastInfoPanel.add(resultPanel); //�˻�������� �г�
		eastInfoPanel.add(createPanel); //���� ��� �г�
		eastInfoPanel.add(editPanel); //���� ����,���� �г�
		eastInfoPanel.add(dDayPanel); //���� ���� �г�(Event ī�װ� �ش� ���� �������� �� ����)
		eastInfoPanel.add(myPagePanel);//������ ���� �г�(ȸ������ âó�� �����ؼ� ����, �Ʒ� Ż���ư�߰�)

		//���� �ϴܿ� �ΰ� �߰�
		ImagePanel Logo = new ImagePanel(new ImageIcon(
				"D:\\SRC\\JAVA\\Test1127\\Image\\TitleLogo(150_48).png").getImage());
		frameSubPanelEastBottom.add(Logo);

		//ū �����г� �߰�
		mainFrame.setLayout(null);
		mainFrame.add(frameSubPanelWest);
		frameSubPanelEastCenter.add(frameSubPanelEastNorth);
		mainFrame.add(frameSubPanelEastCenter);
		mainFrame.add(frameSubPanelEastBottom);
		mainFrame.add(frameBottomPanel2);

		//���� ����
		mainFrame.setBackground(Color.white);
		calPanel.setBackground(Color.white);
		calOpPanel.setBackground(Color.white);
		memoSubPanel.setBackground(Color.white);
		memoPanel.setBackground(Color.white);
		frameBottomPanel2.setBackground(Color.white);
		infoPanel.setBackground(Color.white);
		eastInfoPanel.setBackground(Color.pink);
		frameSubPanelWest.setBackground(Color.white);
		frameSubPanelEastNorth.setBackground(Color.white);
		frameSubPanelEastCenter.setBackground(Color.white);
		frameSubPanelEastBottom.setBackground(Color.green);

		//��ư �� ������Ʈ �׼� ó��
		todayBut.addActionListener(this); 
		lYearBut.addActionListener(this);
		lMonBut.addActionListener(this);
		nMonBut.addActionListener(this);
		nYearBut.addActionListener(this);
		//indexComboBox.addActionListener(this);
		tfSearchWord.addActionListener(this);
		logOutBtn.addActionListener(this);

		viewArea = new JTextArea();//(20,5);

		//�׼�ó��
		dateBtn.addActionListener(new ActionListener() {
			boolean isActionPerformed = false; 
			public void actionPerformed(ActionEvent e) {
				if (!isActionPerformed) {
					isActionPerformed = true; 
					if (Login_Frame.chkLog) {
						System.out.println("[�̺�Ʈ �߻�] - next ��ư");
						if(!allday.isSelected()) { //����X
							if(oneDay.isSelected()) { //�Ϸ�
								bottomInfo.setText(nextButMsg1);
								s_year.setVisible(true);		
								s_month.setVisible(true);			
								s_day.setVisible(true);				
								e_year.setVisible(false);					
								e_month.setVisible(false);			
								e_day.setVisible(false);		
								s_hour.setVisible(true);			
								s_min.setVisible(true);				
								e_hour.setVisible(true);					
								e_min.setVisible(true);
								startDateInfo.setVisible(true);	
								endDateInfo.setVisible(false);	
								startTimeInfo.setVisible(true);	
								endTimeInfo.setVisible(true);	
								yearLbl1.setVisible(true);	
								monthLbl1.setVisible(true);	
								dayLbl1.setVisible(true);
								hourLbl1.setVisible(true);
								minLbl1.setVisible(true);
								yearLbl2.setVisible(false);	
								monthLbl2.setVisible(false);	
								dayLbl2.setVisible(false);
								hourLbl2.setVisible(true);
								minLbl2.setVisible(true);	
								savePlanBtn.setVisible(true);
							}
						}else if(allday.isSelected()) { //����O
							if(oneDay.isSelected()) { //�Ϸ� - startdate�� true
								bottomInfo.setText(nextButMsg1);
								s_year.setVisible(true);		
								s_month.setVisible(true);			
								s_day.setVisible(true);				
								e_year.setVisible(false);					
								e_month.setVisible(false);			
								e_day.setVisible(false);		
								s_hour.setVisible(false);			
								s_min.setVisible(false);				
								e_hour.setVisible(false);					
								e_min.setVisible(false);
								startDateInfo.setVisible(true);	
								endDateInfo.setVisible(false);	
								startTimeInfo.setVisible(false);	
								endTimeInfo.setVisible(false);	
								yearLbl1.setVisible(true);	
								monthLbl1.setVisible(true);	
								dayLbl1.setVisible(true);
								hourLbl1.setVisible(false);
								minLbl1.setVisible(false);
								yearLbl2.setVisible(false);	
								monthLbl2.setVisible(false);	
								dayLbl2.setVisible(false);
								hourLbl2.setVisible(false);
								minLbl2.setVisible(false);	
								savePlanBtn.setVisible(true);
							}else if(moreThanTwodays.isSelected()) { //2���̻�(�Ⱓ)
								bottomInfo.setText(nextButMsg1);
								s_year.setVisible(true);		
								s_month.setVisible(true);			
								s_day.setVisible(true);				
								e_year.setVisible(true);					
								e_month.setVisible(true);			
								e_day.setVisible(true);		
								s_hour.setVisible(false);			
								s_min.setVisible(false);				
								e_hour.setVisible(false);					
								e_min.setVisible(false);
								startDateInfo.setVisible(true);	
								endDateInfo.setVisible(true);	
								startTimeInfo.setVisible(false);	
								endTimeInfo.setVisible(false);	
								yearLbl1.setVisible(true);	
								monthLbl1.setVisible(true);	
								dayLbl1.setVisible(true);
								hourLbl1.setVisible(false);
								minLbl1.setVisible(false);
								yearLbl2.setVisible(true);	
								monthLbl2.setVisible(true);	
								dayLbl2.setVisible(true);
								hourLbl2.setVisible(false);
								minLbl2.setVisible(false);	
								savePlanBtn.setVisible(true);
							}
						}					
						return;
					}
				}
				isActionPerformed = false;
			}		 
		});

		savePlanBtn.addActionListener(new ActionListener() {
			boolean isActionPerformed = false; 
			public void actionPerformed(ActionEvent e) {
				if (!isActionPerformed) {
					isActionPerformed = true; 
					if (Login_Frame.chkLog) {
						System.out.println("[�̺�Ʈ �߻�] - savePlan ��ư");				
						Plan_DTO dto1 = new Plan_DTO();
						sYear = (Integer)s_year.getSelectedItem();			
						sMonth = (Integer)s_month.getSelectedItem();	
						sDay = (Integer)s_day.getSelectedItem();	
						eYear = (Integer)e_year.getSelectedItem();			
						eMonth = (Integer)e_month.getSelectedItem();	
						eDay = (Integer)e_day.getSelectedItem();
						sHour = (Integer)s_hour.getSelectedItem();	
						sMin = (Integer)s_min.getSelectedItem();	
						eHour = (Integer)e_hour.getSelectedItem();			
						eMin = (Integer)e_min.getSelectedItem();	
						if(!allday.isSelected()) { //����X
							if(oneDay.isSelected()) { 
								//�Ϸ� - startdate, startime, endtime//enddate����x
								eYear = 77;		
								eMonth = 77;	
								eDay = 77;	
								ad = 0;
							}
						}else if(allday.isSelected()) { //����O
							ad = 1;
							if(oneDay.isSelected()) { //�Ϸ� - startdate�� ����
								eYear = 77;		
								eMonth = 77;	
								eDay = 77;
								sHour = 77;
								sMin = 77;	
								eHour = 77;			
								eMin = 77;	
							}else if(moreThanTwodays.isSelected()) { 
								//2���̻�(�Ⱓ)  - startdate, enddate //�ð�����x
								sHour = 77;	
								sMin = 77;
								eHour = 77;			
								eMin = 77;	
							}
						}
						if(imp.isSelected()) impo = 1;	
						else impo = 0;
						planTitle = tfTitle.getText();	
						dto1.setTitle(planTitle);
						dto1.setAllday(ad); //���Ͽ��� üũ(üũ-1, ��üũ-0)
						dto1.setImp(impo); //
						dto1.setType(planType);
						dto1.setS_year(sYear);
						dto1.setS_month(sMonth);
						dto1.setS_day(sDay);
						dto1.setE_year(eYear);
						dto1.setE_month(eMonth);
						dto1.setE_day(eDay);
						dto1.setS_hour(sHour);
						dto1.setS_min(sMin);
						dto1.setE_hour(eHour);
						dto1.setE_min(eMin);
						dto1.setW_id(Login_Frame.getLogID());
						pdao.insert(dto1);
						bottomInfo.setText(SaveButMsg4); //��� �Ϸ� �ȳ� �޼���
						return;
					}
				}
				isActionPerformed = false;
			}		 
		});


		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Login_Frame.chkLog) {
					System.out.println("[�̺�Ʈ �߻�] - Edit ��ư");
					panelTitle2.setText("edit your Event");
					panelTitle2.setBounds(25,10,150,30);
					panelTitle2.setFont(f3);
					panelTitle2.setForeground(new Color(58, 137, 226));	
					subInfo.setText("enter the number of Event >> ");
					subInfo.setBounds(25,50,250,30);
					tfNum.setBounds(265,50,45,30);
					tfNum.setColumns(10);
					editFindBtn = new RoundedButton_RC("search");
					editFindBtn.setBounds(325, 50, 55, 30);

					editPanel.removeAll();
					editPanel.add(panelTitle2);
					editPanel.add(subInfo);
					editPanel.add(tfNum);
					editPanel.add(editFindBtn);

					editFindBtn.addActionListener(this);

					mainFrame.repaint();
					viewPanel.setVisible(false);
					resultPanel.setVisible(false);
					createPanel.setVisible(false);
					editPanel.setVisible(true);
					dDayPanel.setVisible(false);
					myPagePanel.setVisible(false);

					editFindBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println("[�̺�Ʈ �߻�] - EditFind ��ư(num�˻�)");			
							int a = Integer.parseInt(tfNum.getText());
							Plan_DTO b = pdao.selectOne1(a);
							resultArea.setText(b.prt());
							resultArea.setBounds(15,90,370,300);

							planDeleteBtn = new RoundedButton_RC("delete");
							planDeleteBtn.setBounds(100,600,40,30);
							planUpdateBtn = new RoundedButton_RC("change");
							planUpdateBtn.setBounds(250,600,40,30);

							editPanel.add(resultArea);
							editPanel.add(planDeleteBtn);
							editPanel.add(planUpdateBtn);

							planDeleteBtn.addActionListener(this);
							planUpdateBtn.addActionListener(this);	
							planDeleteBtn.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									System.out.println("[�̺�Ʈ �߻�] - PlanDelete ��ư");	
								}
							});
							
							planUpdateBtn.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									System.out.println("[�̺�Ʈ �߻�] - PlanUpdate ��ư");	
								}
							});


						}
					});


				}else {
					JOptionPane.showMessageDialog(null, "login required");	
					mainFrame.setVisible(false);
					new Login_Frame();
				}	
			}
		});	

		DdayBtn.addActionListener(new ActionListener() { //plan_dto���� prt()�޼��� �߰�(dday��)
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Login_Frame.chkLog) {
					System.out.println("[�̺�Ʈ �߻�] - D-DAY ��ư");
					panelTitle2.setText(
							"check your D-DAY, "+mdao.selectOne1(Login_Frame.getLogID()).getName()+" !");
					panelTitle2.setBounds(25,10,250,30);
					panelTitle2.setFont(f5);
					panelTitle2.setForeground(new Color(58, 137, 226 ));









					dDayPanel.removeAll();
					dDayPanel.add(panelTitle2);
					mainFrame.repaint();
					viewPanel.setVisible(false);
					resultPanel.setVisible(false);
					createPanel.setVisible(false);
					editPanel.setVisible(false);
					dDayPanel.setVisible(true);
					myPagePanel.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "login required");	
					mainFrame.setVisible(false);
					new Login_Frame();
				}	
			}	
		});	

		myPageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Login_Frame.chkLog) {
					System.out.println("[�̺�Ʈ �߻�] - My Page ��ư");
					mpTitle = new JLabel(Login_Frame.getLogID()+" 's Info");
					mpTitle.setFont(f3);
					mpTitle.setForeground(new Color(58, 137, 226 ));
					mpName = new JLabel("Name : "+mdao.selectOne1(Login_Frame.getLogID()).getName());
					mpBdate = new JLabel("Birthdate(yymmdd) : "+mdao.selectOne1(Login_Frame.getLogID()).getbDate());
					mpPass = new JLabel("Password : "+mdao.selectOne1(Login_Frame.getLogID()).getPass());
					JLabel updateInfo = new JLabel("If you want change Password, please type here ��");
					updateInfo.setForeground(new Color(58, 137, 226 ));
					oldPass = new JLabel("your Password : ");
					newPass = new JLabel("new Password : ");
					tfOldPass = new JTextField();
					tfNewPass = new JTextField();	
					mpUpdateBtn = new RoundedButton_RC("change");
					mpDeleteBtn = new RoundedButton_RC("leave");

					mpTitle.setBounds(40,25,200,30);
					mpName.setBounds(30,70,200,30);
					mpBdate.setBounds(30,115,250,30);
					mpPass.setBounds(30,160,200,30);
					updateInfo.setBounds(40,220,360,30);
					oldPass.setBounds(30,265,120,30);
					newPass.setBounds(30,310,120,30);
					tfOldPass.setBounds(170,265,170,30);
					tfNewPass.setBounds(170,310,170,30);
					mpUpdateBtn.setBounds(300,360,80,30);
					mpDeleteBtn.setBounds(300,550,80,30);

					myPagePanel.removeAll();
					myPagePanel.add(mpTitle);
					myPagePanel.add(mpName);
					myPagePanel.add(mpBdate);
					myPagePanel.add(mpPass);
					myPagePanel.add(updateInfo);
					myPagePanel.add(oldPass);
					myPagePanel.add(newPass);
					myPagePanel.add(tfOldPass);
					myPagePanel.add(tfNewPass);
					myPagePanel.add(mpUpdateBtn);
					myPagePanel.add(mpDeleteBtn);
					mpUpdateBtn.addActionListener(this);
					mpDeleteBtn.addActionListener(this);
					mainFrame.repaint(); 
					viewPanel.setVisible(false);
					resultPanel.setVisible(false);
					createPanel.setVisible(false);
					editPanel.setVisible(false);
					dDayPanel.setVisible(false);
					myPagePanel.setVisible(true);

					mpUpdateBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println("[�̺�Ʈ �߻�] - Pass change ��ư");
							Member_DTO mdto = mdao.selectOne1(Login_Frame.getLogID());
							if(tfOldPass.getText().equals(mdao.selectOne1(Login_Frame.getLogID()).getPass())) {
								if(!tfOldPass.getText().equals(tfNewPass.getText())) {
									mdto.setPass(tfNewPass.getText());
									mdao.update(mdto);
									bottomInfo.setText(EditButMsg3);
								} else JOptionPane.showMessageDialog(null, "[Error] please type new Password again.");
							}else JOptionPane.showMessageDialog(null, "[Error] please type your Password again.");
						}
					});	

					mpDeleteBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							System.out.println("[�̺�Ʈ �߻�] - leave ��ư");
							String nowPass = JOptionPane.showInputDialog("Please type your Password here");
							if(nowPass.equals(mdao.selectOne1(Login_Frame.getLogID()).getPass())) {
								mdao.delete(Login_Frame.getLogID());
								bottomInfo.setText(DelButMsg5);
								Login_Frame.chkLog = false;
							}	
						}

					});	
				}else {
					JOptionPane.showMessageDialog(null, "login required");	
					mainFrame.setVisible(false);
					new Login_Frame();
				}	
			}
		});

		indexComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Login_Frame.chkLog) {
					if(indexComboBox.getSelectedIndex() == 0) { //��ü����(view All)
						indexComboBox.setBackground(new Color(218, 72, 72)); //������
					} else if(indexComboBox.getSelectedIndex() == 1) { //Task
						indexComboBox.setBackground(new Color(180, 218, 72)); //���ʷ�
					} else if(indexComboBox.getSelectedIndex() == 2) { //Event
						indexComboBox.setBackground(new Color(162, 72, 218)); //����
					} else if(indexComboBox.getSelectedIndex() == 3) { //Appointment
						indexComboBox.setBackground(new Color(72, 152, 218)); //����
					} else if(indexComboBox.getSelectedIndex() == 4) { //etc.
						indexComboBox.setBackground(new Color(72, 218, 175)); //���޶���
					}
				}
			} 
		});	

		// viewBtn�� ���� ActionListener ���
		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleViewButtonAction();
			}
		});
		// viewEventBtn�� ���� ActionListener ���
		viewEventBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleViewEventButtonAction();
			}
		});

		createBtn.addActionListener(this);
		//viewBtn.addActionListener(this);
		//viewEventBtn.addActionListener(this);
		logOutBtn.addActionListener(this);


		mainFrame.setVisible(true);
		focusToday(); //���� ��¥�� focus�� �� (mainFrame.setVisible(true) ���Ŀ� ��ġ�ؾ���)

		//Thread �۵�(�ð�, bottomMsg �����ð��� ����)
		ThreadControl threadCnl = new ThreadControl();
		threadCnl.start();	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == allday) {
			if (allday.isSelected()) moreThanTwodays.setVisible(true);
			else moreThanTwodays.setVisible(false);
		}
		if(e.getSource() == type1) { //���� Ÿ�� ����
			planType = "Task";	
		} else if(e.getSource() == type2) {
			planType = "Anniversary";
		} else if(e.getSource() == type3) {
			planType = "Appointment";
		} else if(e.getSource() == type4) {
			planType = "etc.";
			//�α��� ���� �ƴϾ �α׾ƿ� ��ư�� ������ �������� ó��
		}	
		if(e.getSource() == createBtn) {
			if (Login_Frame.chkLog) {
				System.out.println("[�̺�Ʈ �߻�] - create ��ư");
				//�����Է¶�
				panelTitle2.setBounds(10,10,150,30);
				panelTitle2.setFont(f3);
				panelTitle2.setText("create new Event");

				JLabel titleInfo = new JLabel("Title*");
				titleInfo.setBounds(10, 40, 50, 30);
				tfTitle = new JTextField();
				tfTitle.setBackground(new Color(240, 213, 178 )); //�Է�â ���� ����Ȳ��
				tfTitle.setBounds(70,40,200,30);
				tfTitle.setFont(f3);

				allday = new JCheckBox("All-day"); 
				allday.setBounds(10,80,80,30);
				imp = new JCheckBox("Important");
				imp.setBounds(90,80,80,30);

				JLabel selectInfo = new JLabel("Duration*");
				selectInfo.setFont(f1);
				selectInfo.setBounds(10,120,55,30);
				group1 = new ButtonGroup();
				oneDay = new JRadioButton("1Day");
				moreThanTwodays = new JRadioButton(">= 2Day");
				group1.add(oneDay);
				group1.add(moreThanTwodays);
				oneDay.setBounds(70,120,65,30);
				moreThanTwodays.setBounds(135,120,80,30);

				JLabel typeInfo = new JLabel("Type*");
				typeInfo.setFont(f1);
				typeInfo.setBounds(10,160,35,30);
				group2 = new ButtonGroup();
				type1 = new JRadioButton("Task");
				type2 = new JRadioButton("Anniversary");
				type3 = new JRadioButton("Appointment");
				type4 = new JRadioButton("etc.");
				group2.add(type1);
				group2.add(type2);
				group2.add(type3);
				group2.add(type4);
				type1.setBounds(70,160,60,30);
				type2.setBounds(130,160,100,30);
				type3.setBounds(230,160,100,30);
				type4.setBounds(330,160,50,30);

				dateBtn.setBounds(10, 210, 50, 30);
				JLabel required = new JLabel("required*");
				required.setBounds(80,210,100,30);
				required.setFont(f2);
				required.setForeground(Color.red);

				//������, ���۽ð�, ������, ����ð� ���	
				now = Calendar.getInstance();	//���� ��¥		
				year = now.get(Calendar.YEAR);		
				month = now.get(Calendar.MONTH)+1;		
				day = now.get(Calendar.DATE); //���߿� �����ʿ���(������ ���� �°� �������� �ִ밪�� ��������)
				//int lastDate = now.getActualMaximum(Calendar.DAY_OF_MONTH);	//�� ���� ������ ��
				hour = 23;
				min = 59;

				for(int i=calYear; i <= calYear+100; i++){			
					s_yearModel.addElement(i);
					e_yearModel.addElement(i);
				}		
				s_year.setModel(s_yearModel);		
				s_year.setSelectedItem(year);	//���� �⵵ ����		
				sYear = (int) s_year.getSelectedItem();
				s_year.setBounds(10, 300, 60, 30);
				yearLbl1.setBounds(75, 300, 15, 30);

				e_year.setModel(e_yearModel);		
				e_year.setSelectedItem(year);	//���� �⵵ ����		
				eYear = (int) e_year.getSelectedItem();
				e_year.setBounds(10, 460, 60, 30);
				yearLbl2.setBounds(75, 460, 15, 30);

				for(int i=1; i<=12; i++){			
					s_monthModel.addElement(i);	
					e_monthModel.addElement(i);		
				}		
				s_month.setModel(s_monthModel);		
				s_month.setSelectedItem(month);			
				sMonth = (int) s_month.getSelectedItem();
				s_month.setBounds(100, 300, 60, 30);
				monthLbl1.setBounds(165, 300, 15, 30);

				e_month.setModel(e_monthModel);		
				e_month.setSelectedItem(month);		
				eMonth = (int) e_month.getSelectedItem();
				e_month.setBounds(100, 460, 60, 30);
				monthLbl2.setBounds(165, 460, 15, 30);

				for(int i=1; i<=31; i++) {
					s_dayModel.addElement(i);	
					e_dayModel.addElement(i);	
				}
				s_day.setModel(s_dayModel);		
				s_day.setSelectedItem(day);			
				sDay = (int) s_day.getSelectedItem();
				s_day.setBounds(190, 300, 60, 30);
				dayLbl1.setBounds(255, 300, 15, 30);

				e_day.setModel(e_dayModel);		
				e_day.setSelectedItem(day);			
				eDay = (int) e_day.getSelectedItem();
				e_day.setBounds(190, 460, 60, 30);
				dayLbl2.setBounds(255, 460, 15, 30);

				for(int i=0; i<=hour; i++) {
					s_hourModel.addElement(i);	
					e_hourModel.addElement(i);	
				}
				s_hour.setModel(s_hourModel);		
				s_hour.setSelectedItem(hour);			
				sHour = (int) s_hour.getSelectedItem();
				s_hour.setBounds(10,380,50,30);
				hourLbl1.setBounds(65, 380, 15, 30);

				e_hour.setModel(e_hourModel);		
				e_hour.setSelectedItem(hour);			
				eHour = (int) e_hour.getSelectedItem();
				e_hour.setBounds(10,540,50,30);
				hourLbl2.setBounds(65, 540, 15, 30);

				for(int i=0; i<=min; i++) {
					if(i%5 == 0) {	
						s_minModel.addElement(i);	
						e_minModel.addElement(i);	
					}
				}
				s_min.setModel(s_minModel);		
				s_min.setSelectedItem(min);			
				s_min.setBounds(100, 380, 50, 30);
				minLbl1.setBounds(155, 380, 15, 30);		

				e_min.setModel(e_minModel);		
				e_min.setSelectedItem(min);			
				e_min.setBounds(100, 540, 50, 30);
				minLbl2.setBounds(155, 540, 15, 30);

				//������, ���۽ð�, ������, ����ð� GUI
				startDateInfo = new JLabel("Start_date : ");
				startDateInfo.setFont(f1);
				startDateInfo.setBounds(10,260,70,30);

				startTimeInfo = new JLabel("Start_time : ");
				startTimeInfo.setFont(f1);
				startTimeInfo.setBounds(10,340,70,30);

				endDateInfo = new JLabel("End_date : ");
				endDateInfo.setFont(f1);
				endDateInfo.setBounds(10,420,70,30);

				endTimeInfo = new JLabel("End_time : ");
				endTimeInfo.setFont(f1);
				endTimeInfo.setBounds(10,500,70,30);

				//��Ϲ�ư ������ �ϰ� ����
				savePlanBtn.setBounds(310,570,70,30);
				createPanel.removeAll();
				createPanel.add(panelTitle2);
				createPanel.add(titleInfo);
				createPanel.add(tfTitle);
				createPanel.add(allday);
				createPanel.add(imp);
				createPanel.add(selectInfo); //duration
				createPanel.add(oneDay);
				createPanel.add(moreThanTwodays);
				createPanel.add(typeInfo);
				createPanel.add(type1);
				createPanel.add(type2);
				createPanel.add(type3);
				createPanel.add(type4);
				createPanel.add(dateBtn); //next��ư
				createPanel.add(required);

				createPanel.add(startDateInfo);
				createPanel.add(s_year);
				createPanel.add(yearLbl1);//��
				createPanel.add(s_month);
				createPanel.add(monthLbl1);	//��
				createPanel.add(s_day);	
				createPanel.add(dayLbl1); //��
				createPanel.add(endDateInfo);
				createPanel.add(e_year);
				createPanel.add(yearLbl2);//��	
				createPanel.add(e_month);
				createPanel.add(monthLbl2);	//��
				createPanel.add(e_day);	
				createPanel.add(dayLbl2); //��	
				createPanel.add(startTimeInfo);
				createPanel.add(s_hour);
				createPanel.add(hourLbl1); //��
				createPanel.add(s_min);		
				createPanel.add(minLbl1); //��	
				createPanel.add(endTimeInfo);
				createPanel.add(e_hour);
				createPanel.add(hourLbl2); //��	
				createPanel.add(e_min);
				createPanel.add(minLbl2); //��	
				createPanel.add(savePlanBtn);

				mainFrame.repaint();
				moreThanTwodays.setVisible(false);
				s_year.setVisible(false);		
				s_month.setVisible(false);			
				s_day.setVisible(false);				
				e_year.setVisible(false);					
				e_month.setVisible(false);			
				e_day.setVisible(false);		
				s_hour.setVisible(false);			
				s_min.setVisible(false);				
				e_hour.setVisible(false);					
				e_min.setVisible(false);

				startDateInfo.setVisible(false);	
				endDateInfo.setVisible(false);	
				startTimeInfo.setVisible(false);	
				endTimeInfo.setVisible(false);	

				yearLbl1.setVisible(false);	
				monthLbl1.setVisible(false);	
				dayLbl1.setVisible(false);
				hourLbl1.setVisible(false);
				minLbl1.setVisible(false);
				yearLbl2.setVisible(false);	
				monthLbl2.setVisible(false);	
				dayLbl2.setVisible(false);
				hourLbl2.setVisible(false);
				minLbl2.setVisible(false);
				savePlanBtn.setVisible(false);

				allday.addActionListener(this);
				imp.addActionListener(this);
				oneDay.addActionListener(this);
				moreThanTwodays.addActionListener(this);
				type1.addActionListener(this);
				type2.addActionListener(this);
				type3.addActionListener(this);
				type4.addActionListener(this);
				s_year.addActionListener(this);		
				s_month.addActionListener(this);			
				s_day.addActionListener(this);			
				e_year.addActionListener(this);					
				e_month.addActionListener(this);			
				e_day.addActionListener(this);	
				s_hour.addActionListener(this);		
				s_min.addActionListener(this);				
				e_hour.addActionListener(this);					
				e_min.addActionListener(this);		

				viewPanel.setVisible(false);
				resultPanel.setVisible(false);
				createPanel.setVisible(true);
				editPanel.setVisible(false);
				dDayPanel.setVisible(false);
				myPagePanel.setVisible(false);
			}
		}

		/*		if(e.getSource() == viewBtn) {
			if (Login_Frame.chkLog) { // && viewArea != null������ �ʿ����� Ȯ���ʿ�
				System.out.println("[�̺�Ʈ �߻�] - menu view ��ư");
				//GUI ���� - ��¥ �Է¹޾Ƽ� �ش��Ͽ� ���� ���� �����ֱ�	
				now = Calendar.getInstance();	//���� ��¥		
				year = now.get(Calendar.YEAR);		
				month = now.get(Calendar.MONTH)+1;		
				day = now.get(Calendar.DATE); 
				for(int i=calYear; i <= calYear+10; i++){			
					se_yearModel.addElement(i);
				}		
				se_year.setModel(se_yearModel);		
				se_year.setSelectedItem(year);	//���� �⵵ ����		
				seYear = (int) se_year.getSelectedItem();
				se_year.setBounds(25, 30, 60, 30);
				yearLbl3.setBounds(90, 30, 15, 30);

				for(int i=1; i<=12; i++){			
					se_monthModel.addElement(i);	
				}		
				se_month.setModel(se_monthModel);		
				se_month.setSelectedItem(month);			
				seMonth = (int) se_month.getSelectedItem();
				se_month.setBounds(115, 30, 60, 30);
				monthLbl3.setBounds(180, 30, 15, 30);
				for(int i=1; i<=31; i++) {
					se_dayModel.addElement(i);	
				}
				se_day.setModel(se_dayModel);		
				se_day.setSelectedItem(day);			
				seDay = (int) se_day.getSelectedItem();
				se_day.setBounds(205, 30, 60, 30);
				dayLbl3.setBounds(270, 30, 15, 30);
				viewEventBtn.setBounds(295,30,40,30);
				viewPanel.setBorder(BorderFactory.createTitledBorder("  View Event on "));
				viewArea.setBounds(25,90,350,500);
				viewArea.setLineWrap(true);
				viewArea.setWrapStyleWord(true);
				viewSP = 
						new JScrollPane(viewArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

				noInfo = new JLabel("");
				noInfo.setBounds(25,50,300,20);
				noInfo.setFont(f4);

				viewPanel.removeAll();
				viewArea.add(noInfo);
				viewPanel.add(se_year);				
				viewPanel.add(yearLbl3);//��
				viewPanel.add(se_month);				
				viewPanel.add(monthLbl3);//��
				viewPanel.add(se_day);				
				viewPanel.add(dayLbl3);//��
				viewPanel.add(viewEventBtn);
				viewPanel.add(viewSP);	
				viewPanel.add(viewArea);
				mainFrame.repaint();
				viewPanel.setVisible(true);
				resultPanel.setVisible(false);
				createPanel.setVisible(false);
				editPanel.setVisible(false);
				dDayPanel.setVisible(false);
				myPagePanel.setVisible(false);	
				se_year.addActionListener(this);
				se_month.addActionListener(this);
				se_day.addActionListener(this);

			}
		}*/
		/*	if(e.getSource() == viewEventBtn) {
			if (Login_Frame.chkLog && viewArea != null) {
				System.out.println("[�̺�Ʈ �߻�] - view ��ư");
				//dao ���� �޷¿� Ư�� ��¥�ڽ� Ŭ�� �� view��ư ������ �ش��� ������ �������� ����
				ArrayList<Plan_DTO> list = pdao.selectsearch1(seYear, seMonth, seDay);
				if(!list.isEmpty()) { //�����Ͽ� ������ �ִ� ���
					scheduleText = new StringBuilder();
					for (Plan_DTO plan : list) {
						scheduleText.append(plan.prt()).append("\n");
					}
					viewArea.setText(scheduleText.toString()); //
				}else { //�����Ͽ� ������ ���� ���
					noInfo.setText("�ش� ��¥���� ������ �����ϴ�.");
				}
			}
		}	*/
		if(e.getSource() == logOutBtn) {
			System.out.println("[�̺�Ʈ �߻�] - LogOut ��ư");
			//�α����� ���� flag������ �ΰ� false�� �����ϱ�
			//Main_Frameâ���� ���ư��� ���� â �ݱ�
			Login_Frame.chkLog = false; //�α׾ƿ�ó��
			mainFrame.setVisible(false); //���� ȭ�� �ݱ�
			new Main_Frame();
		}	
	}	

	private void handleViewButtonAction() {
		if (Login_Frame.chkLog) { // && viewArea != null������ �ʿ����� Ȯ���ʿ�	
			System.out.println("[�̺�Ʈ �߻�] - menu view ��ư");
			//GUI ���� - ��¥ �Է¹޾Ƽ� �ش��Ͽ� ���� ���� �����ֱ�	
			now = Calendar.getInstance();	//���� ��¥		
			year = now.get(Calendar.YEAR);		
			month = now.get(Calendar.MONTH)+1;		
			day = now.get(Calendar.DATE); 
			for(int i=calYear; i <= calYear+10; i++){			
				se_yearModel.addElement(i);
			}		
			se_year.setModel(se_yearModel);		
			se_year.setSelectedItem(year);	//���� �⵵ ����		
			seYear = (int) se_year.getSelectedItem();
			se_year.setBounds(25, 30, 60, 30);
			yearLbl3.setBounds(90, 30, 15, 30);

			for(int i=1; i<=12; i++){			
				se_monthModel.addElement(i);	
			}		
			se_month.setModel(se_monthModel);		
			se_month.setSelectedItem(month);			
			seMonth = (int) se_month.getSelectedItem();
			se_month.setBounds(115, 30, 60, 30);
			monthLbl3.setBounds(180, 30, 15, 30);
			for(int i=1; i<=31; i++) {
				se_dayModel.addElement(i);	
			}
			se_day.setModel(se_dayModel);		
			se_day.setSelectedItem(day);			
			seDay = (int) se_day.getSelectedItem();
			se_day.setBounds(205, 30, 60, 30);
			dayLbl3.setBounds(270, 30, 15, 30);
			viewEventBtn.setBounds(295,30,40,30);
			viewPanel.setBorder(BorderFactory.createTitledBorder("  View Event on "));
			viewArea.setBounds(25,90,350,500);
			viewArea.setLineWrap(true);
			viewArea.setWrapStyleWord(true);
			viewSP = 
					new JScrollPane(viewArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			noInfo = new JLabel("");
			noInfo.setBounds(25,50,300,20);
			noInfo.setFont(f4);

			viewPanel.removeAll();
			viewArea.add(noInfo);
			viewPanel.add(se_year);				
			viewPanel.add(yearLbl3);//��
			viewPanel.add(se_month);				
			viewPanel.add(monthLbl3);//��
			viewPanel.add(se_day);				
			viewPanel.add(dayLbl3);//��
			viewPanel.add(viewEventBtn);
			viewPanel.add(viewSP);	
			viewPanel.add(viewArea);
			mainFrame.repaint();
			viewPanel.setVisible(true);
			resultPanel.setVisible(false);
			createPanel.setVisible(false);
			editPanel.setVisible(false);
			dDayPanel.setVisible(false);
			myPagePanel.setVisible(false);	
			se_year.addActionListener(this);
			se_month.addActionListener(this);
			se_day.addActionListener(this);

		}
	}

	private void handleViewEventButtonAction() {
		if (Login_Frame.chkLog && viewArea != null) {
			//�տ� üũ�ڽ� ������ ���� �� view��ư ������ �Է¹޾ƾ��ϴ� ��¥, �ð� ������� �������� ����
			System.out.println("[�̺�Ʈ �߻�] - view ��ư");
			ArrayList<Plan_DTO> list = pdao.selectsearch1(seYear, seMonth, seDay);
			if(!list.isEmpty()) {
				scheduleText = new StringBuilder();
				for (Plan_DTO plan : list) {
					scheduleText.append(plan.prt()).append("\n");
				}
				viewArea.setText(scheduleText.toString());
			}else {
				noInfo.setText("�ش� ��¥���� ������ �����ϴ�.");
			}
		}
	}	

	private void focusToday(){
		if(today.get(Calendar.DAY_OF_WEEK) == 1)
			dateButs[today.get(Calendar.WEEK_OF_MONTH)][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
		else
			dateButs[today.get(Calendar.WEEK_OF_MONTH)-1][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
	}
	void showCal(){
		for(int i=0;i<CAL_HEIGHT;i++){
			for(int j=0;j<CAL_WIDTH;j++){
				String fontColor="black";
				if(j==0) fontColor="red";
				else if(j==6) fontColor="blue";

				File f = new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDates[i][j]<10?"0":"")+calDates[i][j]+".txt");
				if(f.exists()){
					dateButs[i][j].setText("<html><b><font color="+fontColor+">"+calDates[i][j]+"</font></b></html>");
				}
				else dateButs[i][j].setText("<html><font color="+fontColor+">"+calDates[i][j]+"</font></html>");

				JLabel todayMark = new JLabel("<html><font color=orange>��</html>");
				dateButs[i][j].removeAll();
				if(calMonth == today.get(Calendar.MONTH) &&
						calYear == today.get(Calendar.YEAR) &&
						calDates[i][j] == today.get(Calendar.DAY_OF_MONTH)){
					dateButs[i][j].add(todayMark);
					dateButs[i][j].setToolTipText("Today");
				}

				if(calDates[i][j] == 0) dateButs[i][j].setVisible(false);
				else dateButs[i][j].setVisible(true);
			}
		}
	}

	private class ListenForCalOpButtons implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == todayBut){
				setToday();
				lForDateButs.actionPerformed(e);
				focusToday();
			}
			else if(e.getSource() == lYearBut) moveMonth(-12);
			else if(e.getSource() == lMonBut) moveMonth(-1);
			else if(e.getSource() == nMonBut) moveMonth(1);
			else if(e.getSource() == nYearBut) moveMonth(12);

			curMMYYYYLab.setText("<html><table width=100><tr><th><font size=5>"
					+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "
					+calYear+"</th></tr></table></html>");
			showCal();
		}
	}

	void readMemo(){
		try{
			File f = new File("MemoData/"+calYear+"/"+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt");
			if(f.exists()){
				BufferedReader in = new BufferedReader(new FileReader("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt"));
				String memoAreaText= new String();
				while(true){
					String tempStr = in.readLine();
					if(tempStr == null) break;
					memoAreaText = memoAreaText + tempStr + System.getProperty("line.separator");
				}
				memoArea.setText(memoAreaText);
				in.close();	
			}
			else memoArea.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class listenForDateButs implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int k=0,l=0;
			for(int i=0 ; i<CAL_HEIGHT ; i++){
				for(int j=0 ; j<CAL_WIDTH ; j++){
					if(e.getSource() == dateButs[i][j]){ 
						k=i;
						l=j;
					}
				}
			}
			if(!(k ==0 && l == 0)) calDayOfMon = calDates[k][l]; 
			//today��ư�� ���������� �� actionPerformed�Լ��� ����Ǳ� ������ ����
			cal = new GregorianCalendar(calYear,calMonth,calDayOfMon);
			String dDayString = new String();
			int dDay=((int)((cal.getTimeInMillis() - today.getTimeInMillis())/1000/60/60/24));
			if(dDay == 0 && (cal.get(Calendar.YEAR) == today.get(Calendar.YEAR)) 
					&& (cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (cal.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH))) 
				dDayString = "Today"; 
			else if(dDay >=0) dDayString = "D-"+(dDay+1);
			else if(dDay < 0) dDayString = "D+"+(dDay)*(-1);

			selectedDate.setText("<Html><font size=3>"+calYear+"/"+(calMonth+1)
					+"/"+calDayOfMon+"&nbsp;("+dDayString+")</html>");
			readMemo();
		}
	}
	private class ThreadControl extends Thread{
		public void run(){
			boolean msgCntFlag = false;
			int num = 0;
			String curStr = new String();
			while(true){
				try{
					today = Calendar.getInstance();
					String amPm = (today.get(Calendar.AM_PM)==0?"AM":"PM");
					String hour;
					if(today.get(Calendar.HOUR) == 0) hour = "12"; 
					else if(today.get(Calendar.HOUR) == 12) hour = " 0";
					else hour = (today.get(Calendar.HOUR)<10?" ":"")+today.get(Calendar.HOUR);
					String min = (today.get(Calendar.MINUTE)<10?"0":"")+today.get(Calendar.MINUTE);
					String sec = (today.get(Calendar.SECOND)<10?"0":"")+today.get(Calendar.SECOND);
					infoClock.setText(amPm+" "+hour+":"+min+":"+sec);
					sleep(1000);
					String infoStr = bottomInfo.getText();

					if(infoStr != " " && (msgCntFlag == false || curStr != infoStr)){
						num = 5;
						msgCntFlag = true;
						curStr = infoStr;
					}
					else if(infoStr != " " && msgCntFlag == true){
						if(num > 0) num--;
						else{
							msgCntFlag = false;
							bottomInfo.setText(" ");
						}
					}		
				}
				catch(InterruptedException e){
					System.out.println("Thread:Error");
				}
			}
		}
	}
	public void createDayStart(){		
		s_day.setVisible(false);	//�����		
		e_day.setVisible(false);	//�����		

		dayPrint((Integer)s_year.getSelectedItem(), (Integer)s_month.getSelectedItem());		
		s_day.setVisible(true);	//�г� �����		

		dayPrint((Integer)e_year.getSelectedItem(), (Integer)e_month.getSelectedItem());		
		e_day.setVisible(true);	//�г� �����	
	}		
	public void dayPrint(int y, int m){		
		Calendar cal = Calendar.getInstance(); //Calendar �ڷ����� new�� ��ü���� �Ұ���		
		cal.set(y, m-1, 1);	//����� ù���� ��ü �����.		
		int week = cal.get(Calendar.DAY_OF_WEEK);	//1�Ͽ� ���� ����	�Ͽ��� : 0		
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	//�� ���� ������ ��		
		for(int i=1; i<week; i++){	//��¥ ��� �������� ���� ���			
			//s_day.add(new JLabel(" "));	
			//e_day.add(new JLabel(" "));		
		}		
		for(int i=1; i<=lastDate; i++){			
			JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);			
			cal.set(y, m-1, i);	//��, ��, ��		
			int outWeek = cal.get(Calendar.DAY_OF_WEEK);			
			if(outWeek == 1){				
				lbl.setForeground(Color.red);							
			}else if(outWeek == 7){				
				lbl.setForeground(Color.BLUE);			
			}			
			//s_day.add(lbl);		
			//e_day.add(lbl);		
		}	
	}		
}	