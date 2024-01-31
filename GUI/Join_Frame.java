package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import DAO.Member_DAO;
import DTO.Member_DTO;

public class Join_Frame extends JFrame implements ActionListener{
	//회원가입창
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
		//창이름 설정
		this.setTitle(title);
		//창 레이아웃, 크기 설정
		this.setSize(1000,800); //가로,세로
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
		
		//조인창 좌측하단 로고
		ImagePanel JoinLogo = new ImagePanel(new ImageIcon(
								"C:\\SRC\\JAVA\\Test1127\\Image\\JoinLogo.png").getImage());
		JoinLogo.setBounds(50, 600, 400, 135);
		contentPane.add(JoinLogo);
		
		//조인 상단 타이틀 - neu
		ImagePanel mainTitle = new ImagePanel(new ImageIcon(
								"C:\\SRC\\JAVA\\Test1127\\Image\\JoinTitle.png").getImage());
		mainTitle.setBounds(50, 70, 400, 140);
		contentPane2.add(mainTitle);
		
		//아이디 부분
		JLabel lblUsername = new JLabel("ID");
		lblUsername.setBounds(70, 300, 50, 15);
		lblUsername.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(163, 293, 140, 34);
		JLabel idInfo = new JLabel("  max.10 words");
		idInfo.setBounds(163, 332, 100, 15);
		idchkBtn = new JButton("Check"); //아이디 중복여부확인 버튼
		idchkBtn.setBounds(310, 293, 110, 23); //위치는 tf 바로 옆으로 
		idchkBtn.setBackground(new Color(20, 180, 73));
		idchkBtn.setForeground(Color.white);
		idchk = new JLabel("");//아이디 사용가능여부 안내문구
		idchk.setBounds(320, 326, 83, 15); //위치는 tf 바로 아래
		contentPane2.add(lblUsername);
		contentPane2.add(idInfo);
		contentPane2.add(tfUsername);
		contentPane2.add(idchkBtn);
		contentPane2.add(idchk);

		//비밀번호 부분
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(70, 366, 100, 15);
		lblPassword.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(163, 359, 140, 34);
		JLabel passInfo = new JLabel("  max.5 words");
		passInfo.setBounds(163, 398, 100, 15);
		passchkBtn = new JButton("check"); //비밀번호 글자수 확인 버튼
		passchkBtn.setBounds(310, 359, 110, 23); //위치는 tf 바로 옆으로 
		passchkBtn.setBackground(new Color(20, 180, 73));
		passchkBtn.setForeground(Color.white);
		passchk = new JLabel("");//비밀번호 가능여부 안내문구
		passchk.setBounds(320, 392, 200, 15); //위치는 tf 바로 아래
		contentPane2.add(lblPassword);
		contentPane2.add(tfPassword);
		contentPane2.add(passInfo);
		contentPane2.add(passchkBtn);
		contentPane2.add(passchk);

		//이름 부분
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblName.setBounds(70, 422, 50, 15);
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(163, 422, 140, 34);
		contentPane2.add(lblName);
		contentPane2.add(tfName);

		//생년월일 부분
		JLabel lblBdate = new JLabel("Birth Date"); //(yy/mm/dd)
		lblBdate.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblBdate.setBounds(70, 490, 90, 15);
		tfBdate = new JTextField();
		tfBdate.setColumns(10);
		tfBdate.setBounds(163, 483, 140, 34);
		JLabel bDateInfo = new JLabel("  6 numbers [ yymmdd ]");
		bDateInfo.setBounds(163, 522, 160, 15);
		contentPane2.add(lblBdate);
		contentPane2.add(tfBdate);
		contentPane2.add(bDateInfo);

		//회원가입 완료 버튼
		joinCompleteBtn = new JButton("complete");
		joinCompleteBtn.setBounds(143, 560, 183, 34);
		joinCompleteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinCompleteBtn.setBackground(new Color(56, 162, 114));
		contentPane2.add(joinCompleteBtn);

		//우측하단 뒤로가기 버튼
		backBtn = new JButton();
		backBtn.setText("back");
		backBtn.setBounds(350, 640, 100, 30);
		backBtn.setBackground(new Color(226, 229, 47));
		contentPane2.add(backBtn);

		//이벤트 처리
		backBtn.addActionListener(this);
		joinCompleteBtn.addActionListener(this); 
		idchkBtn.addActionListener(this); 
		passchkBtn.addActionListener(this); 
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//회원가입완료 액션
		joinCompleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { //완료 시 알림창 띄우기
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				dispose();
				new Main_Frame();
			}	
		});		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == idchkBtn) {
			System.out.println("[이벤트 발생] - 아이디 중복확인 버튼");
			//아이디 중복확인 후 해당되는 메시지 등록
			String newId = tfUsername.getText();
			Member_DTO dto1 = mdao.selectOne1(newId);
			if(dto1 ==  null) idchk.setText("available"); //중복되는 아이디가 없으면	
			else idchk.setText("[ duplicate ]");
			if(tfUsername.getText().equals("")) idchk.setText("[ type your ID ]");
		}else if(e.getSource() == passchkBtn) {
			//비밀번호 자리수 확인 후 해당되는 메시지 등록
			String newPass = tfPassword.getText();
			if(newPass.length() <= 5) passchk.setText("available");
			else passchk.setText("[ limit error ]");
			if(tfPassword.getText().equals("")) passchk.setText("[ type your Password ]");

		}else if(e.getSource() == joinCompleteBtn) {
			System.out.println("[이벤트 발생] - 회원가입 완료 버튼");
			//입력한 내용 db에 저장
			String newId = tfUsername.getText();
			String newPass = tfPassword.getText();
			String newName = tfName.getText();
			String newBdate = tfBdate.getText();
			Member_DTO mdto = new Member_DTO();
			//아이디 중복 x, 비밀번호 5자리 이하이면 저장
			mdto.setId(newId);
			mdto.setPass(newPass);
			mdto.setName(newName);
			mdto.setbDate(newBdate);
			mdao.insert(mdto);
			System.out.println("회원가입 정보 DB 저장완료");
		}else if(e.getSource() == backBtn) {
			System.out.println("[이벤트 발생] - 뒤로가기 버튼");
			this.setVisible(false);
			new Main_Frame();
		}
	}
}
