package VKI_src_Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import VKI_src.MainFrame;
import VKI_src.SettingClass;
import VKI_src.javasettinggui;

public class SettingBtnPressedActionListener implements ActionListener 
{
	private boolean Piano = false;
	private boolean Drum = false;
	private boolean PianoDrum = false;
	private javasettinggui SettingGUI;
	private MainFrame m;
	public SettingBtnPressedActionListener(javasettinggui SettingGUI,MainFrame m) 
	{
		this.m=m;
		this.SettingGUI = SettingGUI;
	}

	private boolean check() {
		for (int i = 0; i < SettingClass.Instance.DrumLength; i++) 
		{
			String check_key = SettingGUI.DrumField[i].getText();

			for (int j = 0; j < SettingClass.Instance.KeyLength; j++) 
			{
				String check_key2 = SettingGUI.PianoField[j].getText();
				if (check_key.equals(check_key2))
					return false;
				else
					continue;
			}
		}

		return true;
	}

	private boolean check(JTextField[] Field, ArrayList<String> Key, int Length) 
	{

		for (int i = 0; i < Length; i++) 
		{
			String check_Listkey = Key.get(i);
			String Check_keyField = Field[i].getText();

			for (int j = 0; j < Length; j++) 
			{
				String check_key2 = Field[j].getText();

				if ((check_Listkey.equals(check_key2) && i != j)||(Check_keyField.equals(check_key2)&&i!=j))
					return false;

				else
					continue;
			}
		}

		return true;
	}

	public void actionPerformed(ActionEvent e) 
	{
		Piano = check(SettingGUI.PianoField, SettingClass.Instance.PianoKey, SettingClass.Instance.KeyLength);
		Drum = check(SettingGUI.DrumField, SettingClass.Instance.DrumKey, SettingClass.Instance.DrumLength);
		PianoDrum = check();

		if (Piano && Drum && PianoDrum) 
		{

			SettingClass.Instance.PianoMap.clear();
			SettingClass.Instance.DrumMap.clear();
			SettingClass.Instance.PianoKey.clear();
			SettingClass.Instance.DrumKey.clear();

			for (int i = 0; i < SettingClass.Instance.KeyLength; i++) 
			{
				SettingClass.Instance.PianoKey.add(SettingGUI.PianoField[i].getText());
				SettingClass.Instance.PianoMap.put(SettingGUI.PianoField[i].getText(),
						SettingClass.Instance.PianoPath + SettingClass.Instance.Gye[i] + ".wav");
			}
				
			for (int i = 0; i < SettingClass.Instance.DrumLength; i++) 
			{ 
				SettingClass.Instance.DrumKey.add(SettingGUI.DrumField[i].getText());

				SettingClass.Instance.DrumMap.put(SettingGUI.DrumField[i].getText(),
						SettingClass.Instance.DrumPath + SettingClass.Instance.Drum[i] + ".wav");
			}
			
			m.Update_Button_Text();
			SettingGUI.frame.dispose();

		} 
		else 
		{
			JOptionPane.showMessageDialog(SettingGUI.frame, "잘못된 설정입니다.\n중복 키가 있으므로 다시 설정해주세요."); // 경고 창
		}
		
		
	}
}
