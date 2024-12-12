package FileClass;

import java.awt.FileDialog;
import java.awt.event.*;
import java.io.*;

import VKI_src.MainFrame;
import VKI_src.SettingClass;

public class FileOpenHandler implements ActionListener {
	private MainFrame Main;

	public FileOpenHandler(MainFrame Main) {
		this.Main = Main;
	}

	public void actionPerformed(ActionEvent e) {
		FileDialog fileOpen = new FileDialog(Main.VKI_Frame, ".txt");
		fileOpen.setVisible(true);
		String fileName = fileOpen.getDirectory() + fileOpen.getFile();
		System.out.println(fileName);
		load(fileName);
	}

	void load(String fileName) {
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			String text;
			while ((text = bReader.readLine()) != null) 
			{
				if (SettingClass.Instance.PianoKey.contains(text) || SettingClass.Instance.DrumKey.contains(text)) 
				{
					SettingClass.Instance.SheetFile.add(text);
					Main.SheetText.setText(Main.SheetText.getText() + text + " ");
				}
				else
				{
					System.out.println("This is Invalid Filed.");
					break;
				}
			}
			bReader.close();
			Main.PianoSound[0].requestFocus();
			Main.DrumSound[0].requestFocus();
			
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
