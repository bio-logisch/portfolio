package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.*;

import button.RoundedButton_RC;

//Main Ŭ���� ȭ�� ����
public class Main_Frame extends JFrame implements ActionListener, MouseListener{
	//��ư �߰�
	RoundedButton_RC joinBtn = new RoundedButton_RC();
	RoundedButton_RC loginBtn = new RoundedButton_RC();
	RoundedButton_RC howToBtn = new RoundedButton_RC();
	RoundedButton_RC exitBtn = new RoundedButton_RC();
	//	JLabel title1 = new JLabel("Dear My Diary");
	JLabel title2 = new JLabel("Dear My Diary");

	//Panel �߰� 
	JPanel jp1 = new JPanel(); //��� �߾�(���α׷� �̹���)
	JPanel jp2 = new JPanel(); //���߾�(���α׷� �Ұ� ����)
	//â�̸� ����
	final String title = "Dear My Diary ver 1.0";

	//������
	public Main_Frame() {
		//â�̸� ����
		this.setTitle(title);
		//���� â, Layout ����
		this.setSize(1000,800); //����,����
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//������Ʈ �߰�(��ư, �ǳ�)
		setComponents();	
	}
	private void colorSetting() {
		//		title1.setForeground(Color.BLACK);
		title2.setForeground(Color.BLACK);
		this.setBackground(Color.WHITE);
		jp2.setBackground(Color.white);
		joinBtn.setBackground(Color.white);
		loginBtn.setBackground(Color.white);
		howToBtn.setBackground(Color.white);
		exitBtn.setBackground(Color.white);
	}

	private void setComponents() {	
		//�ǳ� �߰�
		jp1.setLayout(new GridLayout(1,1));
		jp1.setSize(500, 162);
		jp1.setLocation(250, 70);
		jp2.setLayout(new GridLayout(1,1));
		jp2.setSize(950, 164);
		jp2.setLocation(17, 280);
		add(jp1);
		add(jp2);
		//		this.add(title1,"North");
		//		title2.setHorizontalAlignment(SwingConstants.CENTER);
		//		jp2.add(title2,"Center");
		this.getContentPane().setBackground(Color.white);

		//�̹��� �г� �߰�
		ImagePanel mainPanel = new ImagePanel(new ImageIcon(
				"D:\\SRC\\JAVA\\Test1120_neu\\Image\\Title.png").getImage());
		mainPanel.setBounds(0, 0, 500, 162);
		jp1.add(mainPanel);

		ImagePanel subPanel = new ImagePanel(new ImageIcon(
				"D:\\SRC\\JAVA\\Test1120_neu\\Image\\Subtitle(500_86).png").getImage());
		subPanel.setBounds(230, 0, 500, 86);
		jp2.add(subPanel);

		//��ư �߰�
		joinBtn.setText("JOIN");
		joinBtn.setBounds(150,520,200,100);
		joinBtn.setSize(100,100);
		//		button1.setLocation(10,10);
		this.add(joinBtn);

		loginBtn.setText("LOGIN");
		loginBtn.setBounds(350,520,200,100);
		loginBtn.setSize(100,100);
		this.add(loginBtn);

		howToBtn.setText("INTRODUCE");
		howToBtn.setBounds(550,520,200,100);
		howToBtn.setSize(100,100);
		this.add(howToBtn);

		exitBtn.setText("EXIT");
		exitBtn.setBounds(750,520,200,100);
		exitBtn.setSize(100,100);
		this.add(exitBtn);
		//�����߰�
		colorSetting();
		//�̺�Ʈ ó��
		joinBtn.addActionListener(this); 
		loginBtn.addActionListener(this); 
		howToBtn.addActionListener(this); 
		exitBtn.addActionListener(this); 

		joinBtn.addMouseListener(this);
		loginBtn.addMouseListener(this);
		howToBtn.addMouseListener(this);
		exitBtn.addMouseListener(this); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == joinBtn) {
			System.out.println("[�̺�Ʈ �߻�] - ȸ������ ��ư ����");
			System.out.println(e.getSource());
			this.setVisible(false); //���θ޴�â ����
			new Join_Frame(); //ȸ������ �޼��� ȣ��

		}else if(e.getSource() == loginBtn) {
			System.out.println("[�̺�Ʈ �߻�] - �α��� ��ư ����");
			System.out.println(e.getSource());
			this.setVisible(false); //���θ޴�â ����
			new Login_Frame(); //�α��� ���� �� new Main_Menu(); //ȸ�� ���� �޴��� �̵�

		}else if(e.getSource() == howToBtn) {
			System.out.println("[�̺�Ʈ �߻�] - �Ұ� ��ư ����");
			System.out.println(e.getSource());
			new Intro_Frame(); //���� �ȳ� �޼��� ȣ��

		}else if(e.getSource() == exitBtn) {
			System.out.println("[�̺�Ʈ �߻�] - ������ ��ư ����");
			System.out.println(e.getSource());
			System.exit(0); //��ü ���α׷� ����
			this.setVisible(false); //���θ޴�â ����
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		RoundedButton_RC j = (RoundedButton_RC)e.getSource();
		//		Point p = e.getPoint();
		//		System.out.println(p.getX()+" / "+p.getY());	
		j.setBackground(randomColor());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		RoundedButton_RC j = (RoundedButton_RC)e.getSource();
		j.setBackground(randomColor());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		RoundedButton_RC j = (RoundedButton_RC)e.getSource();
		j.setBackground(randomColor());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		RoundedButton_RC j = (RoundedButton_RC)e.getSource();
		j.setBackground(randomColor());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		RoundedButton_RC j = (RoundedButton_RC)e.getSource();
		j.setBackground(randomColor());
	}
	public Color randomColor() {
		Map<Integer, Color> map = new HashMap<Integer, Color>();
		map.put(1,(new Color(241, 124, 120)));
		map.put(2,(new Color(241, 188, 120)));
		map.put(3,(new Color(241, 238, 120)));
		map.put(4,(new Color(204, 240, 130)));
		map.put(5,(new Color(161, 237, 241)));
		map.put(6,(new Color(173, 194, 240)));
		map.put(7,(new Color(209, 189, 246)));

		Random r = new Random();
		for(int i=0; i<1; i++){
			int a = r.nextInt(map.size());
			Color randC = map.get(a); 
			return randC;
		}
		return null;	
	}

}
