package oppgave3Alt1;

import java.util.Random;


public class Kokk extends Thread {
	Random rand = new Random();
	private HamburgerBrett brett;
	private String navn;

	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	@Override
	public void run() {
		setName(navn+" (Kokk)");

		while (true) {
			int r = rand.nextInt(4) + 1;

			try {
				Thread.sleep(r * 1000);
			} catch (InterruptedException e) {
			}

				brett.leggTil();


		}
	}

}