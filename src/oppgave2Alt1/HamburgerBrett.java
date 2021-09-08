package oppgave2Alt1;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {
	private Queue<Hamburger> hamburgerBrett = new LinkedList<>();
	private int kAPASITET;
	private int burgerNr = 1;

	public HamburgerBrett(int kAPASITET) {
		this.kAPASITET = kAPASITET;
	}

	public synchronized void leggTil() {

		if (erFul()) {
			try {
//				Anne (kokk) klar med hamburger, men brett fullt. Venter!
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " klar med hamburger, men brett fullt. Venter!");
				this.wait();
			} catch (InterruptedException e) {
			}
		} else {
			Hamburger nyBurger = new Hamburger();
			// Hjelpet aa navigere antall burgere paa brettet, og om kapasitet nummer er
			// riktig
//				System.out.println("hamburgerBrett.size()  = " + hamburgerBrett.size());
//				System.out.println("kAPASITET              = " + kAPASITET);
			nyBurger.setId(burgerNr);
			hamburgerBrett.add(nyBurger);
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " legger paa hamburger (" + burgerNr + "). Brett: " + hamburgerBrett);
			burgerNr++;
			this.notifyAll();
		}

	}

	public synchronized void fjernBurger() {
		if (erTom()) {
			try {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " onsker aa ta hamburger, men brett tomt. Venter!");
				this.wait();
			} catch (InterruptedException e) {
			}
		} else {
			String threadName = Thread.currentThread().getName();
			Hamburger hFjernet = hamburgerBrett.remove();
			System.out.println(threadName + " tar av hamburger: (" + hFjernet.getId() + "). Brett " + hamburgerBrett);
			this.notifyAll();
		}
	}

	private boolean erTom() {
		return hamburgerBrett.isEmpty();
	}

	private boolean erFul() {
		return hamburgerBrett.size() >= kAPASITET;
	}

}
