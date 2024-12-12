package VKI_src;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import ThreadClass.*;
import VKI_src_Listener.*;
import FileClass.*;

public class MainFrame {

	public JFrame VKI_Frame;

	public static JTextField SheetText;
	public JTabbedPane InstructmentTap;
	public JButton[] PianoSound = new JButton[SettingClass.Instance.KeyLength];
	public JButton[] DrumSound = new JButton[SettingClass.Instance.DrumLength];
	
	public JPanel Piano_BackGround = new JPanel();
	
	private JList list;
	private JButton PlayBtn;
	private JButton ClearBtn;
	private JScrollPane TempoScroll;

	JMenu mnNewMenu_1 = new JMenu("����");
	JMenuItem Keyboard = new JMenuItem("Ű");
	private ImageIcon imageicon1= SettingClass.Instance.Set_Image(30, 30, "play");
	private ImageIcon imageicon2=SettingClass.Instance.Set_Image(30, 30, "stop");

	private String[] Tempo = new String[] { "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SettingClass.getInstance();
					
					MainFrame window = new MainFrame();
					window.VKI_Frame.setVisible(true);
					window.PianoSound[0].requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {

		for (int i = 0; i < SettingClass.Instance.KeyLength; i++)
			SettingClass.Instance.PianoMap.put(SettingClass.Instance.PianoKey.get(i),
					SettingClass.Instance.PianoPath + SettingClass.Instance.Gye[i] + ".wav");
		for (int i = 0; i < SettingClass.Instance.DrumLength; i++)
			SettingClass.Instance.DrumMap.put(SettingClass.Instance.DrumKey.get(i),
					SettingClass.Instance.DrumPath + SettingClass.Instance.Drum[i] + ".wav");
		
		initialize();

	}

	private void initialize() 
	{
		VKI_Frame = new JFrame();
		VKI_Frame.getContentPane().setBackground(Color.WHITE);
		VKI_Frame.setTitle("Keyboard_Instrument");
		VKI_Frame.setBackground(SystemColor.desktop);
		VKI_Frame.setBounds(100, 100, 800, 500);
		VKI_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VKI_Frame.getContentPane().setLayout(new BorderLayout(0, 0));
		VKI_Frame.setResizable(false);
		VKI_Frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PianoSound[0].requestFocus();
			}
		});

		JMenuBar menuBar = new JMenuBar();
		VKI_Frame.getContentPane().add(menuBar, BorderLayout.NORTH);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("ImageSoruce/titleicon.png");
		VKI_Frame.setIconImage(img);
		
		JMenu mnNewMenu = new JMenu("���ϰ���");
		JMenuItem MenuSave = new JMenuItem("�����ϱ�");
		MenuSave.addActionListener(new FileSaveHandler(this));
		mnNewMenu.add(MenuSave);

		JMenuItem MenuLoad = new JMenuItem("�ҷ�����");
		MenuLoad.addActionListener(new FileOpenHandler(this));
		mnNewMenu.add(MenuLoad);


		menuBar.add(mnNewMenu);
		mnNewMenu.add(MenuSave);
		mnNewMenu.add(MenuLoad);
		mnNewMenu_1.add(Keyboard);

		menuBar.add(mnNewMenu_1);
		Keyboard.addActionListener(new VKI_src_Listener.Setting_Frame_Run(this));
		
		JPanel panel_2 = new JPanel();
		menuBar.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JButton helpbtn = new JButton(SettingClass.Instance.Set_Image(60, 35, "Help"));
		panel_2.add(helpbtn, BorderLayout.EAST);
		//helpbtn.setBorderPainted(false);
		helpbtn.setPreferredSize(new Dimension(42, 35));
		helpbtn.setFocusPainted(false);
		helpbtn.setContentAreaFilled(false);
		helpbtn.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(VKI_Frame,
						"1. ���� : �ǾƳ�� �巳�� ���� Ű�� �Է��Ͽ� ����Ű ���� ( ó�� ���� ��, �⺻ �����Ǿ� ����.)\r\n"
								+ "2. ���� ��ư :  �Ǳ� ���� �� �ԷµǴ� Ű ����\r\n" + "3. ��� ���� : ��� ������ ����\r\n"
								+ "4. ��� ��ư : �巳�� ������ ���� �ݺ����\r\n" + "5. ���� : �����ߴ� �巳 ���� ���� ���� / �ҷ����� \r\n"
								+ "6. ���� : ����Ű�� �̿��Ͽ� �ǾƳ� / �巳 ���� ����, ���� ����");
				
				PianoSound[0].requestFocus();
			}
			
			
		});


		Panel panel = new Panel();
		VKI_Frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		SheetText = new JTextField();
		SheetText.setColumns(52);
		panel.add(SheetText, BorderLayout.CENTER);
		SheetText.setEditable(false);

		ClearBtn = new JButton(SettingClass.Instance.Set_Image(25, 25, "Clear2"));
		ClearBtn.setBackground(new Color(235, 235, 235));
		ClearBtn.setPreferredSize(new Dimension(40, 35));
		ClearBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SheetText.setText(null);
				SettingClass.Instance.SheetFile.clear();
				DrumSound[0].requestFocus();
			}
		});
		panel.add(ClearBtn, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));

		PlayBtn = new JButton(imageicon1);
		PlayBtn.addActionListener(new PlayButtonActionListner());
		PlayBtn.setFocusPainted(false);
		PlayBtn.setContentAreaFilled(false);
		PlayBtn.setPreferredSize(new Dimension(60, 35));
		panel_1.add(PlayBtn, BorderLayout.WEST);

		list = new JList(Tempo);
		list.setSelectedIndex(4);
		
		TempoScroll = new JScrollPane(list);
		TempoScroll.setVerticalScrollBarPolicy(TempoScroll.VERTICAL_SCROLLBAR_AS_NEEDED);
		TempoScroll.setHorizontalScrollBarPolicy(TempoScroll.HORIZONTAL_SCROLLBAR_NEVER);
		TempoScroll.setPreferredSize(new Dimension(50, 30));

		panel_1.add(TempoScroll, BorderLayout.EAST);


		InstructmentTap = new JTabbedPane(JTabbedPane.TOP);
		InstructmentTap.setBackground(Color.WHITE);

		VKI_Frame.getContentPane().add(InstructmentTap, BorderLayout.CENTER);

		InstructmentTap.addTab("�ǾƳ�", (Icon) null, Piano_BackGround, null);
		Piano_BackGround.setLayout(null);

		JPanel Drum_BackGround = new JPanel();
		InstructmentTap.addTab("�巳", null, Drum_BackGround, null);

		for (int i = 0; i < SettingClass.Instance.KeyLength; i++) {
			PianoSound[i] = new JButton(SettingClass.Instance.PianoKey.get(i));
			PianoSound[i].setFont(new Font(SettingClass.Instance.Font, Font.BOLD, 18));
			PianoSound[i].setForeground(Color.WHITE);

			PianoSound[i].addKeyListener(new KeyPressedActionListener());
			PianoSound[i].addKeyListener(new KeyReleasedActionListener());
			PianoSound[i].addActionListener(new MousePressedActionListener());

			PianoSound[i].setContentAreaFilled(false);
			PianoSound[i].setBorderPainted(false);
			PianoSound[i].setFocusPainted(false);
		}

		for (int i = 0; i < SettingClass.Instance.DrumLength; i++) {
			DrumSound[i] = new JButton(SettingClass.Instance.DrumKey.get(i));
			DrumSound[i].setFont(new Font(SettingClass.Instance.Font, Font.BOLD, 30));
			DrumSound[i].setForeground(Color.WHITE);

			DrumSound[i].addKeyListener(new KeyPressedActionListener());
			DrumSound[i].addActionListener(new MousePressedActionListener());
			DrumSound[i].addKeyListener(new KeyReleasedActionListener());

			DrumSound[i].setContentAreaFilled(false);
			DrumSound[i].setBorderPainted(false);
			DrumSound[i].setFocusPainted(false);
		}

		// ���� ��ġ
		// �߰� ��
		PianoSound[0].setBounds(-10, 260, 60, 70);// ��
		PianoSound[1].setBounds(16, 86, 60, 70);// ��(S#ARP)
		PianoSound[1].setForeground(Color.black);

		PianoSound[2].setBounds(45, 260, 60, 70);// ��
		PianoSound[3].setBounds(70, 86, 60, 70);// ��(S#ARP)
		PianoSound[3].setForeground(Color.black);

		PianoSound[4].setBounds(95, 260, 60, 70);// ��

		PianoSound[5].setBounds(150, 260, 60, 70);// ��
		PianoSound[6].setBounds(175, 86, 60, 70);// ��(S#ARP)
		PianoSound[6].setForeground(Color.black);

		PianoSound[7].setBounds(205, 260, 60, 70);// ��
		PianoSound[8].setBounds(230, 86, 60, 70);// ��(S#ARP)
		PianoSound[8].setForeground(Color.black);

		PianoSound[9].setBounds(255, 260, 60, 70);// ��
		PianoSound[10].setBounds(285, 86, 60, 70);// ��(S#ARP)
		PianoSound[10].setForeground(Color.black);

		PianoSound[11].setBounds(310, 260, 60, 70);// ��

		// ���� ��
		PianoSound[12].setBounds(360, 260, 60, 70);// ��
		PianoSound[13].setBounds(390, 86, 60, 70);// ��(S#ARP)
		PianoSound[13].setForeground(Color.black);

		PianoSound[14].setBounds(415, 260, 60, 70);// ��
		PianoSound[15].setBounds(445, 86, 60, 70);// ��(S#ARP)
		PianoSound[15].setForeground(Color.black);

		PianoSound[16].setBounds(465, 260, 60, 70);// ��

		PianoSound[17].setBounds(520, 260, 60, 70);// ��
		PianoSound[18].setBounds(548, 86, 60, 70);// ��(S#ARP)
		PianoSound[18].setForeground(Color.black);

		PianoSound[19].setBounds(575, 260, 60, 70);// ��
		PianoSound[20].setBounds(600, 86, 60, 70);// ��(S#ARP)
		PianoSound[20].setForeground(Color.black);

		PianoSound[21].setBounds(630, 260, 60, 70);// ��
		PianoSound[22].setBounds(655, 86, 60, 70);// ��(S#ARP)
		PianoSound[22].setForeground(Color.black);

		PianoSound[23].setBounds(680, 260, 60, 70);// ��

		PianoSound[24].setBounds(730, 260, 60, 70);// ��

		DrumSound[0].setBounds(61, 245, 100, 70); //HIHAT
		
		DrumSound[1].setBounds(109, 68, 100, 70); //CRASH

		DrumSound[2].setBounds(226, 220, 80, 36); //SNARE
		
		DrumSound[3].setBounds(300, 115, 80, 36); //SMALL
		
		DrumSound[4].setBounds(370, 230, 115, 75); // BASS
		
		DrumSound[5].setBounds(448, 105, 80, 36); // LARGE
		
		DrumSound[6].setBounds(567, 227, 80, 70); // FLOOR
		
		DrumSound[7].setBounds(614, 70, 100, 70); // RIDE

		SettingClass.Instance.PianoSound = this.PianoSound.clone();
		SettingClass.Instance.DrumSound = this.DrumSound.clone();

		for (int i = 0; i < SettingClass.Instance.KeyLength; i++)
			Piano_BackGround.add(PianoSound[i]);

		for (int i = 0; i < SettingClass.Instance.DrumLength; i++)
			Drum_BackGround.add(DrumSound[i]);
		Drum_BackGround.setLayout(null);
		
		JLabel DrumBackGround = new JLabel(SettingClass.Instance.Set_Image(800, 380, "Drum"));
		DrumBackGround.setBounds(0, 0, 789, 370);
		Drum_BackGround.add(DrumBackGround);
		
		JLabel PianoBackGround = new JLabel(SettingClass.Instance.Set_Image(800, 500, "Piano"));
		PianoBackGround.setBounds(0, 0, 789, 394);
		Piano_BackGround.add(PianoBackGround);

	}
	
	public void Update_Button_Text()
	{
		for (int i = 0; i < SettingClass.Instance.KeyLength; i++) 
			PianoSound[i].setText(SettingClass.Instance.PianoKey.get(i));

		for (int i = 0; i < SettingClass.Instance.DrumLength; i++) 
			DrumSound[i].setText(SettingClass.Instance.DrumKey.get(i));
	}

	public class PlayButtonActionListner implements ActionListener {

		private PlayMidiClass Music;
		int Tempo;

		public boolean flag = true;

		public void actionPerformed(ActionEvent e) {

			if (SettingClass.Instance.SheetFile.size() > 0) {

				if (flag) {
					PlayBtn.setIcon(imageicon2);
					ClearBtn.setVisible(false);

					this.Music = new PlayMidiClass(SettingClass.Instance.SheetFile,
							Integer.parseInt(list.getSelectedValue().toString()), this);
					this.Music.start();
					
					
				} else {
					ClearBtn.setVisible(true);
					PlayBtn.setIcon(imageicon1);
				}
				this.flag = !flag;
			} else {
				System.out.println("Sheet_Length_0");
				JOptionPane.showMessageDialog(VKI_Frame, "������ �ҷ����ų� Ű����� ���ָ� ���ּ���!"); // ��� â
				flag = true;
			}
			PianoSound[0].requestFocus();
			

		}
	}
}
