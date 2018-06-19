import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class HangMan implements KeyListener {

	public static void main(String[] args) throws FileNotFoundException {
		new HangMan().start();
	}

	ArrayList<String> allWords = readFile("dictionary.txt");
	ArrayList<String> wordsUsed = new ArrayList<String>();
	ArrayList<String> lettersUsed = new ArrayList<String>();
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JLabel t = new JLabel();
	JLabel l = new JLabel();
	int lives = 30;
	int currentWord;

	public void start() {

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

		f.add(t);
		f.add(l);
		f.setSize(500, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addKeyListener(this);
		f.setVisible(true);
	}

	public String word(int x) {
		String word = "";
		boolean letterFound;
		for (char c : wordsUsed.get(x).toCharArray()) {
			letterFound = false;
			for (String s : lettersUsed)
				if (s.equals(c + ""))
					letterFound = true;

			if (letterFound)
				word = (word + c + " ");

			else
				word = word + "_ ";
		}
		System.out.println(word);

		return word;
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

	void detectKey(String x) {
		if (!lettersUsed.contains(x)) {
			lettersUsed.add(x);
			System.out.println(lettersUsed);
			t.setText(word(currentWord));
			if (!wordsUsed.get(currentWord).contains(x)) lives--;
			l.setText("YOU HAVE " + lives + " LIVES REMAINING");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		String keyUsed = e.getKeyChar() + "";
		detectKey(keyUsed);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}