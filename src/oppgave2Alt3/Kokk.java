package oppgave2Alt3;

public class Kokk extends Thread {

	private String navn;
	private HamburgerBrett brett;

	public Kokk() {
	}

	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	@Override
	public void run() {
		
		setName(navn+ " (Kokk)");

		while (true) {
			try {
				int r = (int) Math.floor(Math.random() * 1000) + 1000; // mellom 3 og 6 sec //du burde ha random inne i
																		// while-løkken
				// så du får nye tall hver gang
				Hamburger burger = new Hamburger();
				Thread.sleep(r);
				brett.leggTilBruger(burger);

			} catch (Exception e) {
				
			}

		}

	}

}
