package VKI_src;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import VKI_src_Listener.*;

public class javasettinggui {

	public JFrame frame;

	public JTextField[] PianoField = new JTextField[SettingClass.Instance.KeyLength];
	public JLabel[] Pianolb = new JLabel[SettingClass.Instance.KeyLength];

	public JTextField[] DrumField = new JTextField[SettingClass.Instance.DrumLength];
	public JLabel[] Drumlb = new JLabel[SettingClass.Instance.DrumLength];

	
	private MainFrame m;

	public javasettinggui(MainFrame m) {
		this.m = m;
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 335);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("ImageSoruce/titleicon.png");
		frame.setIconImage(img);
		frame.setTitle("Key_Setting");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel SettingtapPanel2 = new JPanel();
		tabbedPane.addTab("피아노 설정", null, SettingtapPanel2, null);
		SettingtapPanel2.setBackground(Color.DARK_GRAY);
		SettingtapPanel2.setLayout(null);

		JPanel SettingtapPanel1 = new JPanel();
		tabbedPane.addTab("드럼 설정", null, SettingtapPanel1, null);
		SettingtapPanel1.setBackground(Color.DARK_GRAY);
		SettingtapPanel1.setLayout(null);
		

		for (int i = 0; i < SettingClass.Instance.KeyLength; i++) 
		{
			PianoField[i] = new JTextField(SettingClass.Instance.PianoKey.get(i));
			PianoField[i].setColumns(10);
			PianoField[i].setForeground(Color.white);
			PianoField[i].addKeyListener(new JavaKey_PressedActionListner(PianoField[i]));
			PianoField[i].setFont(new Font("맑은고딕", Font.BOLD, 14));
			PianoField[i].setHorizontalAlignment(JTextField.CENTER);
			PianoField[i].setBorder(null);

			Pianolb[i] = new JLabel(SettingClass.Instance.Gye[i]);
			Pianolb[i].setFont(new Font("맑은고딕", Font.BOLD, 12));
			Pianolb[i].setHorizontalAlignment(JTextField.LEFT);
			Pianolb[i].setBackground(Color.white);
			Pianolb[i].setForeground(Color.white);
		}

		int Pf_height = 21;
		int Pf_width = 40;

		PianoField[0].setBounds(50, 20, Pf_width, Pf_height);// 도
		PianoField[0].setBackground(new Color(0,0,50));
		PianoField[1].setBounds(50, 50, Pf_width, Pf_height);
		PianoField[1].setForeground(Color.BLACK);
		

		PianoField[2].setBounds(50, 80, Pf_width, Pf_height);// 레
		PianoField[2].setBackground(new Color(0,0,50));
		PianoField[3].setBounds(50, 110, Pf_width, Pf_height);// 레#
		PianoField[3].setForeground(Color.BLACK);
		
		PianoField[4].setBounds(50, 140, Pf_width, Pf_height);
		PianoField[4].setBackground(new Color(0,0,50));
		
		PianoField[5].setBounds(50, 170, Pf_width, Pf_height);// 파
		PianoField[5].setBackground(new Color(0,0,50));
		PianoField[6].setBounds(50, 200, Pf_width, Pf_height);// 파#
		PianoField[6].setForeground(Color.BLACK);
		//
		
		PianoField[7].setBounds(150, 10, Pf_width, Pf_height);// 솔
		PianoField[7].setBackground(new Color(0,0,50));
		PianoField[8].setBounds(150, 40, Pf_width, Pf_height);
		PianoField[8].setForeground(Color.BLACK);
		
		PianoField[9].setBounds(150, 70, Pf_width, Pf_height);
		PianoField[9].setBackground(new Color(0,0,50));
		PianoField[10].setBounds(150, 100, Pf_width, Pf_height);
		PianoField[10].setForeground(Color.BLACK);

		PianoField[11].setBounds(150, 130, Pf_width, Pf_height);// 시
		PianoField[11].setBackground(new Color(0,0,50));
		//
		
		PianoField[12].setBounds(265, 20, Pf_width, Pf_height);// 도
		PianoField[12].setBackground(new Color(0,60,112));
		PianoField[13].setBounds(265, 50, Pf_width, Pf_height);
		PianoField[13].setForeground(Color.BLACK);

		PianoField[14].setBounds(265, 80, Pf_width, Pf_height);// 레
		PianoField[14].setBackground(new Color(0,60,112));
		PianoField[15].setBounds(265, 110, Pf_width, Pf_height);// 레#
		PianoField[15].setForeground(Color.BLACK);
		
		PianoField[16].setBounds(265, 140, Pf_width, Pf_height);// 미
		PianoField[16].setBackground(new Color(0,60,112));
		
		PianoField[17].setBounds(265, 170, Pf_width, Pf_height);// 파
		PianoField[17].setBackground(new Color(0,60,112));
		PianoField[18].setBounds(265, 200, Pf_width, Pf_height);
		PianoField[18].setForeground(Color.BLACK);
		
		//
		PianoField[19].setBounds(365, 10, Pf_width, Pf_height);// 솔
		PianoField[19].setBackground(new Color(0,60,112));
		PianoField[20].setBounds(365, 40, Pf_width, Pf_height);
		PianoField[20].setForeground(Color.BLACK);
		
		PianoField[21].setBounds(365, 70, Pf_width, Pf_height);// 라
		PianoField[21].setBackground(new Color(0,60,112));
		PianoField[22].setBounds(365, 100, Pf_width, Pf_height);
		PianoField[22].setForeground(Color.BLACK);
		
		PianoField[23].setBounds(365, 130, Pf_width, Pf_height);
		PianoField[23].setForeground(Color.BLACK);
		
		PianoField[24].setBounds(365, 160,Pf_width,Pf_height);
		PianoField[24].setBackground(Color.orange);
		
		int Pl_height = 20;
		int Pl_width = 50;
		Pianolb[0].setBounds(13, 20, Pl_width, Pl_height);// 도
		Pianolb[1].setBounds(13, 50, Pl_width, Pl_height);// 도#

		Pianolb[2].setBounds(13, 80, Pl_width, Pl_height);// 레
		Pianolb[3].setBounds(13, 110, Pl_width, Pl_height);// 레#

		Pianolb[4].setBounds(13, 140, Pl_width, Pl_height);// 미

		Pianolb[5].setBounds(13, 170, Pl_width, Pl_height);// 파
		Pianolb[6].setBounds(13, 200, Pl_width, Pl_height);// 파#
		
		//
		Pianolb[7].setBounds(111, 10, Pl_width, Pl_height);
		Pianolb[8].setBounds(111, 40, Pl_width, Pl_height);

		Pianolb[9].setBounds(112, 70, Pl_width, Pl_height);
		Pianolb[10].setBounds(111, 100, Pl_width, Pl_height);

		Pianolb[11].setBounds(111, 130, Pl_width, Pl_height);
		
		//
		Pianolb[12].setBounds(220, 20, Pl_width, Pl_height);
		Pianolb[13].setBounds(220, 50, Pl_width, Pl_height);

		Pianolb[14].setBounds(220, 80, Pl_width, Pl_height);
		Pianolb[15].setBounds(220, 110, Pl_width, Pl_height);

		Pianolb[16].setBounds(220, 140, Pl_width, Pl_height);

		Pianolb[17].setBounds(220, 170, Pl_width, Pl_height);// 파
		Pianolb[18].setBounds(220, 200, Pl_width, Pl_height);
		
		//
		Pianolb[19].setBounds(320, 10, Pl_width, Pl_height);
		Pianolb[20].setBounds(320, 40, Pl_width, Pl_height);

		Pianolb[21].setBounds(320, 70, Pl_width, Pl_height);
		Pianolb[22].setBounds(320, 100, Pl_width, Pl_height);

		Pianolb[23].setBounds(320, 130, Pl_width, Pl_height);
		Pianolb[24].setBounds(320, 160, Pl_width, Pl_height);

		for (int i = 0; i < SettingClass.Instance.DrumLength; i++) {
			DrumField[i] = new JTextField(SettingClass.Instance.DrumKey.get(i));
			DrumField[i].setColumns(10);
			DrumField[i].addKeyListener(new JavaKey_PressedActionListner(DrumField[i]));
			DrumField[i].setFont(new Font("맑은고딕", Font.BOLD, 14));
			DrumField[i].setHorizontalAlignment(JTextField.CENTER);
			DrumField[i].setForeground(Color.white);
			DrumField[i].setBorder(null);
			
			Drumlb[i] = new JLabel(SettingClass.Instance.Drum[i]);
			Drumlb[i].setFont(new Font("맑은고딕", Font.BOLD, 14));
			Drumlb[i].setForeground(Color.white);
		}
		
		int Dmlb_height = 15;
		int Dmlb_width = 50;
		

		int Dmfd_height = 21;
		int Dmfd_width = 50;
		
		DrumField[0].setBounds(70, 30, Dmfd_width, Dmfd_height); 	//하이햇
		DrumField[0].setBackground(new Color(0, 0, 50));
		Drumlb[0].setBounds(72, 15, Dmlb_width, Dmlb_height);	//하이햇
		
		DrumField[1].setBounds(35, 80, Dmfd_width, Dmfd_height);	//크래쉬 
		DrumField[1].setBackground(new Color(0,0,50));
		Drumlb[1].setBounds(37, 65, Dmlb_width, Dmlb_height);	//크래쉬
		
		DrumField[2].setBounds(120, 120, Dmfd_width, Dmfd_height);	//스내어
		DrumField[2].setBackground(new Color(0, 60, 112));
		Drumlb[2].setBounds(120, 105, Dmlb_width, Dmlb_height);	//스내어
		
		DrumField[3].setBounds(150, 80, Dmfd_width, Dmfd_height);	//스몰
		DrumField[3].setBackground(new Color(0, 60, 112));
		Drumlb[3].setBounds(150, 65, Dmlb_width, Dmlb_height);	//스몰
		
		DrumField[4].setBounds(190, 130, Dmfd_width, Dmfd_height);	//베이스
		DrumField[4].setBackground(Color.orange);
		Drumlb[4].setBounds(195, 115, Dmlb_width, Dmlb_height);	//베이스
		
		DrumField[5].setBounds(230, 80, Dmfd_width, Dmfd_height); // 라지
		DrumField[5].setBackground(new Color(0, 60, 112));
		Drumlb[5].setBounds(230, 65, Dmlb_width, Dmlb_height);	//라지
		
		DrumField[6].setBounds(260, 120, Dmfd_width, Dmfd_height); // 플로어
		DrumField[6].setBackground(new Color(0, 60, 112));
		Drumlb[6].setBounds(270, 105, Dmlb_width, Dmlb_height);	//플로어
		
		DrumField[7].setBounds(330, 65, Dmfd_width, Dmfd_height); // 라이드
		DrumField[7].setBackground(new Color(0,0,50));
		Drumlb[7].setBounds(332, 50, Dmlb_width, Dmlb_height);	//라이드
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JButton SettingButton = new JButton("확인");
		SettingButton.setPreferredSize(new Dimension(60,30));
		
		SettingButton.setFocusPainted(false);
		SettingButton.setContentAreaFilled(false);
		SettingButton.addActionListener(new SettingBtnPressedActionListener(this, m));
		SettingButton.setForeground(Color.DARK_GRAY);
		SettingButton.setFont(new Font("고딕", Font.BOLD, 12));
		panel.add(SettingButton, BorderLayout.EAST);

		for (int i = 0; i < SettingClass.Instance.KeyLength; i++) {
			SettingtapPanel2.add(Pianolb[i]);
			SettingtapPanel2.add(PianoField[i]);
		}

		for (int i = 0; i < SettingClass.Instance.DrumLength; i++) {
			SettingtapPanel1.add(Drumlb[i]);
			SettingtapPanel1.add(DrumField[i]);
		}

		frame.setResizable(false);
		frame.setVisible(true);
	}

	private class JavaKey_PressedActionListner extends KeyAdapter {
		JTextField field;

		JavaKey_PressedActionListner(JTextField KeyField) {
			this.field = KeyField;
		}

		public void keyReleased(KeyEvent e) {
			field.setText(e.getKeyText(e.getKeyCode()));
		}
	}
}
/*----------  ----------  ----------  ----------  텍스트 필드 초기화    ----------    ----------   ----------   ----------*/