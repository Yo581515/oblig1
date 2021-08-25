package oppgave1;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane.*;

public class Main {

	public static void main(String[] args) {

		String tekst = "Hallo verden!";
		MinThread t = new MinThread(tekst);

		t.start();

		while (!(tekst.equals("quit"))) {
			tekst = JOptionPane.showInputDialog("skriv her");
			t.setTekst(tekst);
		}

	}

}
