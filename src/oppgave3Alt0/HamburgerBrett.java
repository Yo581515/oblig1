package oppgave3Alt0;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class HamburgerBrett {
	private BlockingQueue<Hamburger> hamburgerBrett;

	public HamburgerBrett(int kAPASITET) {
		this.hamburgerBrett = new LinkedBlockingQueue<>(kAPASITET);
	}

	private int burgerNumer = 0;

	public void leggTil() {
		try {
			
			hamburgerBrett.put(new Hamburger(++burgerNumer));

		} catch (Exception e) {
			System.out.println("leggtilException");
		}
	}// metode

	public void fjernBurger() {
		try {
			System.out.println(Thread.currentThread().getName() + " tar av hamburger: "
					+ hamburgerBrett.take());
		} catch (Exception e) {
			System.out.println("fjernException");
		}

	}// metode

}
