import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class HangMan {
	public static void main(String[] args) {
		HangMan h = new HangMan();
		int lengthOfList = h.SetNumber();
		
		ArrayList<String> items = new ArrayList<String>();
		String output="";
			JFileChooser fileExplorer = new JFileChooser();
			fileExplorer.showOpenDialog(null);
			
		//	try {
				
				//for (int i = 0; i < lengthOfList; i++) {
					
					//items.add(word);
			//	}
				//JOptionPane.showMessageDialog(null, output, "TO DO", 3);

			//} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			//}
			
		}
		
		

	public int SetNumber() {
		int length = 0;
		while (length == 0) {
			String listLength = JOptionPane.showInputDialog("Yo my guy, how many words would you like to be on the list?");
			try {
				length = Integer.parseInt(listLength);
			} catch (NumberFormatException e) {
				length = 0;
			}
		}
		System.out.println(length);
		return length;
	}

}
