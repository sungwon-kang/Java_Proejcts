package VKI_src;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SettingClass 
{
	public static SettingClass Instance;
	
	private SettingClass(){} //외부에서 생성자를 막기 위함
	
	public static synchronized SettingClass getInstance() // 쓰레드에서 동기화문제를 대처하기 위함
	{
        if(Instance == null){
        	Instance = new SettingClass();
        }
        return Instance;
    }

	public int KeyLength = 25;
	public int DrumLength = 8;
	public String Font = "궁서";

	public HashMap<String, String> PianoMap = new HashMap<String,String>();
	public HashMap<String, String> DrumMap = new HashMap<String,String>();
	
	public ArrayList<String> SheetFile = new ArrayList<String>();
	
	public ArrayList<String> PianoKey = new ArrayList<String>() 
	{ 	{
		add("Z"); add("S"); add("X");add("D"); add("C"); add("V"); 
		add("G"); add("B");add("H");add("N");add("J"); add("M"); 
		
		add("Q"); add("2");add("W");add("3");add("E");add("R"); add("5"); add("T");
		add("6"); add("Y");add("7");add("U");add("I");
		} 
	};
	
	public ArrayList<String> DrumKey = new ArrayList<String>() 
	{ {add("F1"); add("F2"); add("F3"); add("F4");add("F5");add("F6");add("F7");add("F8");} };
	
	public String PianoPath = "/PianoSound/";
	public String DrumPath = "/DrumSound/";
	
	public JButton[] PianoSound = new JButton[this.KeyLength];
	public JButton[] DrumSound = new JButton[this.DrumLength];
	
	public String[] Gye = new String[] 
			{
					"도","도(#)","레","레(#)","미","파","파(#)",
					"솔","솔(#)","라","라(#)","시",
					"도(H)","도(H#)","레(H)","레(H#)","미(H)",
					"파(H)","파(H#)","솔(H)","솔(H#)","라(H)",
					"라(H#)","시(H)","도(VH)"
			};
	public String[] Drum = new String[] {"HIHAT","CRASH","SNARE","SMALL","BASS","LARGE","FLOOR","RIDE"};
	
	public ImageIcon Set_Image(int Width, int Height, String FileName)
	{
        
		ImageIcon ImageSave = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource(FileName+".png")));
		Image Img = ImageSave.getImage();
		Image dImg = Img.getScaledInstance(Width,Height ,Image.SCALE_SMOOTH);
		ImageIcon ResizeImage = new ImageIcon(dImg);
	
		return ResizeImage;
	}
}


