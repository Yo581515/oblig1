package oppgave1;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane.*;

public class Main {

	private static String tekst = "Hallo verden!";

	public static void main(String[] args) {

		MinThread t = new MinThread(tekst);

//		while (!(tekst.equals("quit"))) {
//			tekst = JOptionPane.showInputDialog("skriv her");
//			t.setTekst(tekst);
//		}

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!(tekst.equals("quit"))) {
					tekst = JOptionPane.showInputDialog("skriv quit aa slutte");
					t.setTekst(tekst);
				}
			}
		});
		
		t.start();
		t2.start();

	}

}
