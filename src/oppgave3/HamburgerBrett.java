package oppgave3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import oppgave2Alt1.Hamburger;

public class HamburgerBrett {
	private Queue<Hamburger> hamburgerBrett = new LinkedList<>();
	private int kAPASITET;
	private int burgerNr = 1;

	private Lock lock = new ReentrantLock();
	private Condition notify = lock.newCondition();

	public HamburgerBrett(int kAPASITET) {
		this.kAPASITET = kAPASITET;
	}

	public synchronized void leggTil() {

		if (erFul()) {
			try {
//				Anne (kokk) klar med hamburger, men brett fullt. Venter!
				System.out.println(Thread.currentThread().getName() + " klar med hamburger, men brett fullt. Venter!");
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
			System.out.println(Thread.currentThread().getName() + " legger paa hamburger (" + burgerNr + "). Brett: "
					+ hamburgerBrett);
			burgerNr++;
			this.notifyAll();
		}

	}

	public synchronized void fjernBurger() {
		if (erTom()) {
			try {
				System.out
						.println(Thread.currentThread().getName() + " onsker aa ta hamburger, men brett tomt. Venter!");
				this.wait();
			} catch (InterruptedException e) {
			}
		} else {
			Hamburger hFjernet = hamburgerBrett.remove();
			System.out.println(Thread.currentThread().getName() + " tar av hamburger: (" + hFjernet.getId()
					+ "). Brett " + hamburgerBrett);
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
