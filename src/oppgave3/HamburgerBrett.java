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

	private Lock lock = new ReentrantLock(true);
	private Condition notify = lock.newCondition();

	public HamburgerBrett(int kAPASITET) {
		this.kAPASITET = kAPASITET;
	}

	public void leggTil() {

		try {
			lock.lock();
			if (erFul()) {
//				Anne (kokk) klar med hamburger, men brett fullt. Venter!
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " klar med hamburger, men brett fullt. Venter!");
				notify.wait();
			} else {
				Hamburger nyBurger = new Hamburger();
				// Hjelpet aa navigere antall burgere paa brettet, og om kapasitet nummer er
				// riktig
//					System.out.println("hamburgerBrett.size()  = " + hamburgerBrett.size());
//					System.out.println("kAPASITET              = " + kAPASITET);
				nyBurger.setId(burgerNr);
				hamburgerBrett.add(nyBurger);
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " legger paa hamburger (" + burgerNr + "). Brett: " + hamburgerBrett);
				burgerNr++;
				notify.signalAll();
			} // else
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}// metode

	public void fjernBurger() {
		try {
			lock.lock();
			if (erTom()) {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " onsker aa ta hamburger, men brett tomt. Venter!");
				notify.wait();

			} else {
				Hamburger hFjernet = hamburgerBrett.remove();
				String threadName = Thread.currentThread().getName();
				System.out.println(
						threadName + " tar av hamburger: " + "(" + hFjernet.getId() + "). Brett " + hamburgerBrett);
				notify.signalAll();
			} // else
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}

	}// metode

	private boolean erTom() {
		return hamburgerBrett.isEmpty();
	}

	private boolean erFul() {
		return hamburgerBrett.size() >= kAPASITET;
	}

}
