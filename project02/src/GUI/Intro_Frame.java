package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Intro_Frame extends JFrame implements ActionListener {
	
	JPanel jp1, jp2, jp3, jp4;
	JTable table;
	JLabel lbl1;
	List ls;
	JButton backBtn;
	final String title = "Dear My Diary ver 1.0 ... Introduce";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					Intro_Frame frame = new Intro_Frame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Intro_Frame () {
		//����â�̸� ����
		this.setTitle(title);
		//����â ������, ���̾ƿ� ����
		this.setSize(1000,800); //����,����
		this.setLayout(null);
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Ÿ��Ʋ ����	
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2,1));	
		jp1.setSize(900, 200);
		jp1.setLocation(100,0 );
		ImagePanel introTitle = new ImagePanel(new ImageIcon("D:\\SRC\\JAVA\\Test1120_neu"
												+ "\\Image\\introtitle.png").getImage());
		introTitle.setBounds(0, 70, 500, 130);
		jp1.add(introTitle);
		jp1.setBackground(Color.white);
		jp2 = new JPanel();
		jp2.setLayout(new GridLayout(1,1));	
		jp2.setSize(900, 300);
		jp2.setLocation(100, 200);
		ls = new List();
		Font f2 = new Font("Arial", Font.PLAIN, 20);
		ls.setFont(f2);
		ls.add("Dear My Diary is a program to organize our daily life.");
		ls.add("");
		ls.add("");
		ls.add("  The main features of the program are : ");
		ls.add("");
		ls.add("    1. You can freely save, change, and delete schedules.");
		ls.add("    2. It is designed in a calendar format so you can conveniently view the schedule.");
		ls.add("    3. Important schedules can be indexed and checked conveniently.");
		ls.add("    4. You can collect and check the birthdays of your loved ones.");
		ls.add("");
		ls.add("");
		ls.add("Easily manage your important schedules with Dear My Diary!");
		jp2.add(ls);
		
		jp3 = new JPanel();
		jp3.setLayout(null);
		jp3.setSize(900,400);
		jp3.setLocation(100, 500);
		ImagePanel introImage = new ImagePanel(new ImageIcon(
				"D:\\SRC\\JAVA\\Test1127\\Image\\intro(315_250).jpg").getImage());
		jp3.add(introImage);
		
		jp4 = new JPanel();
		jp4.setLayout(null);
		jp4.setSize(100,800);
		jp4.setLocation(0,0);
		jp4.setBackground(new Color(189, 245, 214));
		
		//�ڷΰ��� ��ư �߰�
		backBtn = new JButton();
		backBtn.setText("back");
		backBtn.setBounds(870, 710, 100, 30);
		backBtn.setBackground(new Color(245, 228, 189));
		
//		this.getContentPane().setBackground(Color.white);
		this.add(backBtn);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);//���� �Ϸ� ���̹���
		
		//�̺�Ʈ ó��
		backBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			System.out.println("[�̺�Ʈ �߻�] - �ڷΰ��� ��ư");
			this.setVisible(false);
		}
		
	}

}
