package VKI_src_Listener;

import java.awt.Font;
import java.awt.event.*;

import VKI_src.SettingClass;

public class KeyReleasedActionListener extends KeyAdapter
{
	public void keyReleased(KeyEvent e)
	{
		String cmd = e.getKeyText(e.getKeyCode());
		
		for(int i=0;i<SettingClass.Instance.KeyLength;i++)
		{
			if(SettingClass.Instance.PianoKey.get(i).equals(cmd))
			{
				SettingClass.Instance.PianoSound[i].setFont(new Font(SettingClass.Instance.Font,Font.BOLD,18));
				break;
			}
		}
		
		for (int i = 0; i < SettingClass.Instance.DrumLength; i++) 
		{
			if (SettingClass.Instance.DrumKey.get(i).equals(cmd)) 
			{
				SettingClass.Instance.DrumSound[i].setFont(new Font(SettingClass.Instance.Font, Font.BOLD, 30));
				break;
			}
		}
			
	}
}
