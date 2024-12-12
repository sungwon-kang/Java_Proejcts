package FileClass;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import VKI_src.*;

public class FileSaveHandler implements ActionListener 
{
	private MainFrame Main;
	public FileSaveHandler(MainFrame Main)
	{
		this.Main = Main;
	}
	public void actionPerformed(ActionEvent e) 
	{
		FileDialog fileSave = new FileDialog(Main.VKI_Frame, ".txt", FileDialog.SAVE);
		fileSave.setVisible(true);
		String fileName = fileSave.getDirectory() + fileSave.getFile();
		System.out.println(fileName);
		save(fileName);
	}
	
	void save(String fileName) {
		FileWriter fileWriter;
		BufferedWriter bWriter;
		try {
			fileWriter = new FileWriter(fileName);
			bWriter = new BufferedWriter(fileWriter);
			
			String[] temp = Main.SheetText.getText().split(" ");
			
			for (String txt : temp) 
				bWriter.write(txt+"\n");
			
			bWriter.close();
			Main.PianoSound[0].requestFocus();

			
		} catch (IOException i) {
			System.out.println("Save File Error");
			i.printStackTrace();
		}
	}
}
