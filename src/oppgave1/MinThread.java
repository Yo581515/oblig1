package oppgave1;

public class MinThread extends Thread {
	private String tekst;

	public MinThread(String tekst) {
		this.tekst = tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public void run() {
		while (!(tekst.equals("quit"))) {

			System.out.println(tekst);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}

		}

	}

}
