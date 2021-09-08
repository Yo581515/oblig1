package oppgave2Alt2;

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
		
		if (!erFul()) {
			Hamburger nyBurger = new Hamburger();
			
			//Hjelpet aa navigere antall burgere paa brettet, og om kapasitet nummer er riktig
//			System.out.println("hamburgerBrett.size()  = " + hamburgerBrett.size());
//			System.out.println("kAPASITET              = " + kAPASITET);
			
			nyBurger.setId(burgerNr);
			hamburgerBrett.add(nyBurger);
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " legger på hamburger (" + burgerNr + "). Brett: "
					+ hamburgerBrett);
			burgerNr++;
		}
	}

	public void fjernBurger() {
		if (!erTom()) {
			Hamburger hFjernet = hamburgerBrett.remove();
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " tar av hamburger: (" + hFjernet.getId()
					+ "). Brett " + hamburgerBrett);
		}
	}

	public synchronized boolean erTom() {
		return hamburgerBrett.isEmpty();
	}

	public synchronized boolean erFul() {
		return hamburgerBrett.size() >= kAPASITET;
	}

}
