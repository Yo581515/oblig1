package oppgave3Alt0;

import java.util.Random;

public class Servitor extends Thread {

	private HamburgerBrett brett;
	private String navn;
	Random rand = new Random();

	public Servitor(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn+ " (Servit?r)" ;
	}

	@Override
	public void run() {
		setName(navn);

		while (true) {
			int r = rand.nextInt(3) + 1;

			try {
				Thread.sleep(r * 1000);
			} catch (InterruptedException e) {
			}
			brett.fjernBurger();
		}
	}
}
