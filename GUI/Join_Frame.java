package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import DAO.Member_DAO;
import DTO.Member_DTO;

public class Join_Frame extends JFrame implements ActionListener{
	//ȸ������â
	private JPanel contentPane, contentPane2;
	private JButton idchkBtn, passchkBtn, joinCompleteBtn, backBtn;
	private JTextField tfUsername, tfPassword, tfName, tfBdate;
	private JLabel idchk, passchk;

	Member_DAO mdao = new Member_DAO();
	final String title = "Dear My Diary ver 1.0 ... Join";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join_Frame frame = new Join_Frame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Join_Frame() {	
		//â�̸� ����
		this.setTitle(title);
		//â ���̾ƿ�, ũ�� ����
		this.setSize(1000,800); //����,����
		this.setBackground(Color.white);
		this.setLayout(new GridLayout(1,2));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setSize(500, 800);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		contentPane2 = new JPanel();
		contentPane2.setBounds(100, 100, 500, 500);
		contentPane2.setSize(500, 800);
		contentPane2.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setBackground(new Color(237, 217, 162));
		contentPane2.setLayout(null);
		this.add(contentPane);
		this.add(contentPane2);
		
		//����â �����ϴ� �ΰ�
		ImagePanel JoinLogo = new ImagePanel(new ImageIcon(
								"C:\\SRC\\JAVA\\Test1127\\Image\\JoinLogo.png").getImage());
		JoinLogo.setBounds(50, 600, 400, 135);
		contentPane.add(JoinLogo);
		
		//���� ��� Ÿ��Ʋ - neu
		ImagePanel mainTitle = new ImagePanel(new ImageIcon(
								"C:\\SRC\\JAVA\\Test1127\\Image\\JoinTitle.png").getImage());
		mainTitle.setBounds(50, 70, 400, 140);
		contentPane2.add(mainTitle);
		
		//���̵� �κ�
		JLabel lblUsername = new JLabel("ID");
		lblUsername.setBounds(70, 300, 50, 15);
		lblUsername.setFont(new Font("���� ���", Font.BOLD, 16));
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(163, 293, 140, 34);
		JLabel idInfo = new JLabel("  max.10 words");
		idInfo.setBounds(163, 332, 100, 15);
		idchkBtn = new JButton("Check"); //���̵� �ߺ�����Ȯ�� ��ư
		idchkBtn.setBounds(310, 293, 110, 23); //��ġ�� tf �ٷ� ������ 
		idchkBtn.setBackground(new Color(20, 180, 73));
		idchkBtn.setForeground(Color.white);
		idchk = new JLabel("");//���̵� ��밡�ɿ��� �ȳ�����
		idchk.setBounds(320, 326, 83, 15); //��ġ�� tf �ٷ� �Ʒ�
		contentPane2.add(lblUsername);
		contentPane2.add(idInfo);
		contentPane2.add(tfUsername);
		contentPane2.add(idchkBtn);
		contentPane2.add(idchk);

		//��й�ȣ �κ�
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(70, 366, 100, 15);
		lblPassword.setFont(new Font("���� ���", Font.BOLD, 16));
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(163, 359, 140, 34);
		JLabel passInfo = new JLabel("  max.5 words");
		passInfo.setBounds(163, 398, 100, 15);
		passchkBtn = new JButton("check"); //��й�ȣ ���ڼ� Ȯ�� ��ư
		passchkBtn.setBounds(310, 359, 110, 23); //��ġ�� tf �ٷ� ������ 
		passchkBtn.setBackground(new Color(20, 180, 73));
		passchkBtn.setForeground(Color.white);
		passchk = new JLabel("");//��й�ȣ ���ɿ��� �ȳ�����
		passchk.setBounds(320, 392, 200, 15); //��ġ�� tf �ٷ� �Ʒ�
		contentPane2.add(lblPassword);
		contentPane2.add(tfPassword);
		contentPane2.add(passInfo);
		contentPane2.add(passchkBtn);
		contentPane2.add(passchk);

		//�̸� �κ�
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("���� ���", Font.BOLD, 16));
		lblName.setBounds(70, 422, 50, 15);
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(163, 422, 140, 34);
		contentPane2.add(lblName);
		contentPane2.add(tfName);

		//������� �κ�
		JLabel lblBdate = new JLabel("Birth Date"); //(yy/mm/dd)
		lblBdate.setFont(new Font("���� ���", Font.BOLD, 16));
		lblBdate.setBounds(70, 490, 90, 15);
		tfBdate = new JTextField();
		tfBdate.setColumns(10);
		tfBdate.setBounds(163, 483, 140, 34);
		JLabel bDateInfo = new JLabel("  6 numbers [ yymmdd ]");
		bDateInfo.setBounds(163, 522, 160, 15);
		contentPane2.add(lblBdate);
		contentPane2.add(tfBdate);
		contentPane2.add(bDateInfo);

		//ȸ������ �Ϸ� ��ư
		joinCompleteBtn = new JButton("complete");
		joinCompleteBtn.setBounds(143, 560, 183, 34);
		joinCompleteBtn.setFont(new Font("���� ���", Font.BOLD, 15));
		joinCompleteBtn.setBackground(new Color(56, 162, 114));
		contentPane2.add(joinCompleteBtn);

		//�����ϴ� �ڷΰ��� ��ư
		backBtn = new JButton();
		backBtn.setText("back");
		backBtn.setBounds(350, 640, 100, 30);
		backBtn.setBackground(new Color(226, 229, 47));
		contentPane2.add(backBtn);

		//�̺�Ʈ ó��
		backBtn.addActionListener(this);
		joinCompleteBtn.addActionListener(this); 
		idchkBtn.addActionListener(this); 
		passchkBtn.addActionListener(this); 
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//ȸ�����ԿϷ� �׼�
		joinCompleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { //�Ϸ� �� �˸�â ����
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
				dispose();
				new Main_Frame();
			}	
		});		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == idchkBtn) {
			System.out.println("[�̺�Ʈ �߻�] - ���̵� �ߺ�Ȯ�� ��ư");
			//���̵� �ߺ�Ȯ�� �� �ش�Ǵ� �޽��� ���
			String newId = tfUsername.getText();
			Member_DTO dto1 = mdao.selectOne1(newId);
			if(dto1 ==  null) idchk.setText("available"); //�ߺ��Ǵ� ���̵� ������	
			else idchk.setText("[ duplicate ]");
			if(tfUsername.getText().equals("")) idchk.setText("[ type your ID ]");
		}else if(e.getSource() == passchkBtn) {
			//��й�ȣ �ڸ��� Ȯ�� �� �ش�Ǵ� �޽��� ���
			String newPass = tfPassword.getText();
			if(newPass.length() <= 5) passchk.setText("available");
			else passchk.setText("[ limit error ]");
			if(tfPassword.getText().equals("")) passchk.setText("[ type your Password ]");

		}else if(e.getSource() == joinCompleteBtn) {
			System.out.println("[�̺�Ʈ �߻�] - ȸ������ �Ϸ� ��ư");
			//�Է��� ���� db�� ����
			String newId = tfUsername.getText();
			String newPass = tfPassword.getText();
			String newName = tfName.getText();
			String newBdate = tfBdate.getText();
			Member_DTO mdto = new Member_DTO();
			//���̵� �ߺ� x, ��й�ȣ 5�ڸ� �����̸� ����
			mdto.setId(newId);
			mdto.setPass(newPass);
			mdto.setName(newName);
			mdto.setbDate(newBdate);
			mdao.insert(mdto);
			System.out.println("ȸ������ ���� DB ����Ϸ�");
		}else if(e.getSource() == backBtn) {
			System.out.println("[�̺�Ʈ �߻�] - �ڷΰ��� ��ư");
			this.setVisible(false);
			new Main_Frame();
		}
	}
}
