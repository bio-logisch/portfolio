package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.Member_DAO;
import DTO.Member_DTO;

public class Login_Frame extends JFrame implements ActionListener{
	//�α���â
	private JPanel contentPane, contentPane2;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JButton loginBtn, joinBtn;
	Member_DAO mdao = new Member_DAO();
	final String title = "Dear My Diary ver 1.0 ... Login";
	public static boolean chkLog = false; //�α��� ���� üũ 
	private static String logID = null; //�α��� �Ϸ� �� ���̵� ����
	private static String logPass = null; //�α��� �Ϸ� �� ��й�ȣ ����
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					Login_Frame frame = new Login_Frame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login_Frame () {		
		//â�̸� ����
		this.setTitle(title);
		//���� â, Layout ����
		this.setSize(1000,800); //����,����
		this.setLayout(new GridLayout(1,2));
		setLocationRelativeTo(null);
		
		//�����ڵ��� �α���â
		contentPane = new JPanel();
		contentPane.setSize(500,800);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);

		//�ӽ��߰�
		contentPane2 = new JPanel();
		contentPane2.setSize(500, 800);
		contentPane2.setLayout(null);
		this.add(contentPane);
		this.add(contentPane2);
		
		//�α��� ��� Ÿ��Ʋ - neu
		ImagePanel mainTitle = new ImagePanel(new ImageIcon("D:\\SRC\\JAVA\\Test1120_neu"
											+ "\\Image\\LoginTitle.png").getImage());
		mainTitle.setBounds(50, 70, 400, 140);
		contentPane.add(mainTitle);	
		
		//�α���â �����ϴ� �ΰ�
		ImagePanel LoginLogo = new ImagePanel(new ImageIcon("D:\\SRC\\JAVA\\Test1120_neu"
												+ "\\Image\\LoginLogo.png").getImage());
		LoginLogo.setBounds(50, 600, 400, 135);
		contentPane2.add(LoginLogo);		
		
		//���� ��
		JLabel lblLogin = new JLabel("ID");
		Font f1 = new Font("����", Font.BOLD, 15); //�ü� ���� ����
		lblLogin.setFont(f1); 
		lblLogin.setBounds(138, 270, 100, 40);
		contentPane.add(lblLogin);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(f1); 
		lblPassword.setBounds(138, 330, 100, 40);
		contentPane.add(lblPassword);

		tfUsername = new JTextField();
		tfUsername.setBounds(232, 270, 200, 40);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);

		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(232, 330, 200, 40);
		contentPane.add(tfPassword);

		joinBtn = new JButton("JOIN");
		joinBtn.setBounds(53, 410, 170, 40);
		contentPane.add(joinBtn);

		loginBtn = new JButton("LOGIN");
		loginBtn.setBounds(250, 410, 170, 40);
		contentPane.add(loginBtn);

		contentPane.setBackground(Color.white);
		contentPane2.setBackground(new Color(208, 240, 118));
		joinBtn.setBackground(new Color(118, 173, 240));
		loginBtn.setBackground(Color.orange);
		joinBtn.addActionListener(this); 
		loginBtn.addActionListener(this); 

		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logID = null; //���̵� �ʱ�ȭ
				logPass = null; //��й�ȣ �ʱ�ȭ
				String newId = tfUsername.getText();
				char[] pwChar = tfPassword.getPassword();
				String newPass = new String(pwChar);
				//String newPass = new String(tfPassword.getPassword()); //�� ���� ������ �ϸ� �̷��� ��
				//JPasswordField�� �ٸ� �ؽ�Ʈ�ڽ��� �޸� getText()�� ���ڿ��� ������ �� ����
				//JPasswordField��  getPassword()�޼���� char[]���� ��ȯ��(�̸� StringŸ������ ��ȯ���־�� �� 
				int cnt = mdao.chkId(newId);
				if(cnt == 0) { //������ ���̵� �ƴϸ�
					JOptionPane.showMessageDialog(null, "Login failed [ID Error]");
				} else if(cnt == 1) { //������ ���̵��
					Member_DTO mdto = mdao.selectOne1(newId);
					if(newPass.equals(mdto.getPass())) {  //�ش� ���̵��� ��й�ȣ�� ������
						JOptionPane.showMessageDialog(null, "Login succeed");
						chkLog = true;
						logID = newId; //�α����� ���̵� ���� ����
						logPass = newPass;
						new Calendar_GUI();
						dispose();
					} else {  //�ش� ���̵��� ��й�ȣ�� �ƴϸ�
						JOptionPane.showMessageDialog(null, "Login failed [Password Error]");
						dispose();
					}
				}
			}	
		});	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == joinBtn) {
			System.out.println("[�̺�Ʈ �߻�] - ȸ������ ��ư ����");
			System.out.println(e.getSource());
			this.setVisible(false); //�α���â ����
			new Join_Frame(); //ȸ������ �޼��� ȣ��
		} 
	}
	public static String getLogID() {
		return logID;
	}	

}