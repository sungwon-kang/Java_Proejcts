package ThreadClass;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import VKI_src.MainFrame.PlayButtonActionListner;
import VKI_src.SettingClass;

public class PlayMidiClass extends Thread {
	private PlayButtonActionListner e;
	ArrayList<String> sheet;
	private int Tempo;

	public PlayMidiClass(ArrayList<String> sheet, int Tempo, PlayButtonActionListner e) 
	{
		this.e = e;
		this.Tempo = Tempo;
		this.sheet = sheet;
	}

	public void run() 
	{
		int i = 0;
		
		StickSound();
		
		while (!e.flag) 
		{
			if (sheet.size() <= i)
				i = 0;

			String cmd = sheet.get(i).toString();
			String path = null;

			if (SettingClass.Instance.PianoMap.containsKey(cmd))
				path = SettingClass.Instance.PianoMap.get(cmd);

			else
				path = SettingClass.Instance.DrumMap.get(cmd);

			try {

				File Clap = new File(path);

				Clip clip = AudioSystem.getClip();

				clip.open(AudioSystem.getAudioInputStream(Clap));

				clip.start();

				Thread.sleep(Tempo);

			}

			catch (Exception e1) 
			{
				System.out.println("Sheet File Error");
				break;
			}
			i++;
		}

	}
	
	private void StickSound()
	{
		for (int i = 0; i < 4; i++) 
		{
			try {
				File Clap = new File(SettingClass.Instance.DrumPath+"STICK.wav");

				Clip clip = AudioSystem.getClip();

				clip.open(AudioSystem.getAudioInputStream(Clap));

				clip.start();

				Thread.sleep(500);
			} catch (Exception e1) {
				System.out.println("Sheet File Error");
				break;
			}
		}
	}
}
