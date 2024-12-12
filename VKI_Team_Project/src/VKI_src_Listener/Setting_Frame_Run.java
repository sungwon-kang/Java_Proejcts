package VKI_src_Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import VKI_src.MainFrame;

public class Setting_Frame_Run implements ActionListener 
{
	MainFrame m;
	public Setting_Frame_Run(MainFrame m)
	{
		this.m=m;
	}
	public void actionPerformed(ActionEvent e) 
	{
		new VKI_src.javasettinggui(m);
	}
}