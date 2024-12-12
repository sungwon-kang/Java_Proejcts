package ThreadClass;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicThread extends Thread
{
	private URL path;
	
	public MusicThread(URL path)
	{
		this.path=path;
	}
	
	public void run()
	{
		try
		{
			//File Clap=new File(path);

			Clip clip = AudioSystem.getClip();

			clip.open(AudioSystem.getAudioInputStream(path));

			clip.start();

			Thread.sleep(clip.getMicrosecondLength()/1000);
			//Thread.sleep(1000);

		}

		catch(Exception e1)
		{
			System.out.println("Don't find Music File");
		}
	}
}
