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
	//로그인창
	private JPanel contentPane, contentPane2;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JButton loginBtn, joinBtn;
	Member_DAO mdao = new Member_DAO();
	final String title = "Dear My Diary ver 1.0 ... Login";
	public static boolean chkLog = false; //로그인 여부 체크 
	private static String logID = null; //로그인 완료 시 아이디 저장
	private static String logPass = null; //로그인 완료 시 비밀번호 저장
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
		//창이름 설정
		this.setTitle(title);
		//메인 창, Layout 설정
		this.setSize(1000,800); //가로,세로
		this.setLayout(new GridLayout(1,2));
		setLocationRelativeTo(null);
		
		//원래코드기반 로그인창
		contentPane = new JPanel();
		contentPane.setSize(500,800);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);

		//임시추가
		contentPane2 = new JPanel();
		contentPane2.setSize(500, 800);
		contentPane2.setLayout(null);
		this.add(contentPane);
		this.add(contentPane2);
		
		//로그인 상단 타이틀 - neu
		ImagePanel mainTitle = new ImagePanel(new ImageIcon("D:\\SRC\\JAVA\\Test1120_neu"
											+ "\\Image\\LoginTitle.png").getImage());
		mainTitle.setBounds(50, 70, 400, 140);
		contentPane.add(mainTitle);	
		
		//로그인창 우측하단 로고
		ImagePanel LoginLogo = new ImagePanel(new ImageIcon("D:\\SRC\\JAVA\\Test1120_neu"
												+ "\\Image\\LoginLogo.png").getImage());
		LoginLogo.setBounds(50, 600, 400, 135);
		contentPane2.add(LoginLogo);		
		
		//세부 라벨
		JLabel lblLogin = new JLabel("ID");
		Font f1 = new Font("돋움", Font.BOLD, 15); //궁서 바탕 돋움
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
				logID = null; //아이디 초기화
				logPass = null; //비밀번호 초기화
				String newId = tfUsername.getText();
				char[] pwChar = tfPassword.getPassword();
				String newPass = new String(pwChar);
				//String newPass = new String(tfPassword.getPassword()); //위 두줄 간단히 하면 이렇게 됨
				//JPasswordField는 다른 텍스트박스와 달리 getText()로 문자열을 가져올 수 없음
				//JPasswordField의  getPassword()메서드는 char[]값을 반환함(이를 String타입으로 변환해주어야 함 
				int cnt = mdao.chkId(newId);
				if(cnt == 0) { //가입한 아이디가 아니면
					JOptionPane.showMessageDialog(null, "Login failed [ID Error]");
				} else if(cnt == 1) { //가입한 아이디면
					Member_DTO mdto = mdao.selectOne1(newId);
					if(newPass.equals(mdto.getPass())) {  //해당 아이디의 비밀번호가 맞으면
						JOptionPane.showMessageDialog(null, "Login succeed");
						chkLog = true;
						logID = newId; //로그인한 아이디 정보 저장
						logPass = newPass;
						new Calendar_GUI();
						dispose();
					} else {  //해당 아이디의 비밀번호가 아니면
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
			System.out.println("[이벤트 발생] - 회원가입 버튼 선택");
			System.out.println(e.getSource());
			this.setVisible(false); //로그인창 종료
			new Join_Frame(); //회원가입 메서드 호출
		} 
	}
	public static String getLogID() {
		return logID;
	}	

}