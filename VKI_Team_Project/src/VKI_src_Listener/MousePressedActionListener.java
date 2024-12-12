package VKI_src_Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.JButton;

import ThreadClass.MusicThread;
import VKI_src.SettingClass;
import VKI_src.MainFrame;

public class MousePressedActionListener implements ActionListener 
{
	public MusicThread Music;
	
	public void actionPerformed(ActionEvent e) {
		
		String cmd;
		URL Sound=null;
		cmd = ((JButton)e.getSource()).getText();

		if (SettingClass.Instance.PianoMap.containsKey(cmd)) {
			Sound = getClass().getResource(SettingClass.Instance.PianoMap.get(cmd));
		}

		if (SettingClass.Instance.DrumMap.containsKey(cmd)) {
			Sound = getClass().getResource(SettingClass.Instance.DrumMap.get(cmd));
		}
		
		Music = new MusicThread(Sound);
		Music.start();
	}
}
