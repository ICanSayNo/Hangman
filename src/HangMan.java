import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HangMan {
	public static void main(String[] args) throws FileNotFoundException {
		new HangMan().start();
	}

	ArrayList<String> wordsUsed = new ArrayList<String>();

	public void start() {
		ArrayList<String> allWords = readFile("dictionary.txt");
		System.out.println("test");

		int lengthOfList = getNumber();
		for (int i = 0; i < lengthOfList; i++) {
			Random rand = new Random();
			int wordPicked = rand.nextInt(allWords.size());
			wordsUsed.add(allWords.get(wordPicked));
			System.out.println(wordsUsed);
		}
		build();
	}

	public void build() {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JTextArea t = new JTextArea();
		JLabel l = new JLabel();
		f.add(t);
		f.add(l);
		f.setSize(500,200);
		f.show();

		for (int i = 0; i < wordsUsed.size(); i++) {
			int lives = 9;

			while (lives != 0) {

				l.setText("YOU HAVE " + lives + " LIVES REMAINING");
			}
		}
	}

	public int getNumber() {
		int length = 0;
		while (length == 0) {
			String listLength = JOptionPane
					.showInputDialog("Yo my guy, how many words would you like to be on the list?");
			try {
				length = Integer.parseInt(listLength);
			} catch (NumberFormatException e) {
				length = 0;
			}
		}
		System.out.println(length);
		return length;
	}

	public ArrayList<String> readFile(String file) {
		ArrayList<String> words = new ArrayList<String>();
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String output = "";

			while ((output = reader.readLine()) != null) {
				words.add(output);
			}

			fr.close();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return words;
	}

}