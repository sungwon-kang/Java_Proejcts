package VKI_src_Listener;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import ThreadClass.MusicThread;
import VKI_src.SettingClass;
import VKI_src.MainFrame;

public class KeyPressedActionListener extends KeyAdapter {

	MusicThread Music;

	public void keyPressed(KeyEvent e) {

		String cmd;
		URL Sound=null;

		cmd = e.getKeyText(e.getKeyCode());

		try {
			for (int i = 0; i < SettingClass.Instance.KeyLength; i++) 
			{
				if (SettingClass.Instance.PianoKey.get(i).equals(cmd))
						{
					SettingClass.Instance.PianoSound[i].setFont(new Font(SettingClass.Instance.Font, Font.BOLD, 30));
					break;
				}

			}
			for (int i = 0; i < SettingClass.Instance.DrumLength; i++) {
				if (SettingClass.Instance.DrumKey.get(i).equals(cmd))
					{
					SettingClass.Instance.DrumSound[i].setFont(new Font(SettingClass.Instance.Font, Font.BOLD, 35));
					break;
				}
			}

			if (SettingClass.Instance.PianoMap.containsKey(cmd)) {
				//MainFrame.SheetText.setText(MainFrame.SheetText.getText() + cmd);
				Sound = getClass().getResource(SettingClass.Instance.PianoMap.get(cmd));
			}

			if (SettingClass.Instance.DrumMap.containsKey(cmd)) {
				MainFrame.SheetText.setText(MainFrame.SheetText.getText() + cmd +" ");
				SettingClass.Instance.SheetFile.add(cmd);
				Sound = getClass().getResource(SettingClass.Instance.DrumMap.get(cmd));
			}
		} catch (NullPointerException e1) {
			e1.printStackTrace();
			System.out.println("Key Preesed Error");
		}

		Music = new MusicThread(Sound);
		Music.start();
	}

}
