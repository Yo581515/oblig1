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

	public void leggTil() {
		synchronized (this) {
			if (!erFul()) {
				Hamburger nyBurger = new Hamburger();

				// Hjelpet aa navigere antall burgere paa brettet, og om kapasitet nummer er
				// riktig
//				System.out.println("hamburgerBrett.size()  = " + hamburgerBrett.size());
//				System.out.println("kAPASITET              = " + kAPASITET);

				nyBurger.setId(burgerNr);
				hamburgerBrett.add(nyBurger);
				System.out.println(Thread.currentThread().getName() + " legger paa hamburger (" + burgerNr
						+ "). Brett: " + hamburgerBrett);
				burgerNr++;
			} else {
				try {
					this.wait();
				} catch (InterruptedException e) {
				}
				this.notifyAll();
			}

		}

	}

	public void fjernBurger() {
		synchronized (this) {

			if (erTom()) {
				try {
					System.out.println(
							Thread.currentThread().getName() + " onsker aa ta hamburger, men brett tomt. Venter!");
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

	}

	public boolean erTom() {
		return hamburgerBrett.size() == 0;
	}

	public boolean erFul() {
		return hamburgerBrett.size() >= kAPASITET;
	}



}
