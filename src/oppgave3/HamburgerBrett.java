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

	public void leggTil() {
		if (erFul()) {
			try {
				lock.lock();
//				Anne (kokk) klar med hamburger, men brett fullt. Venter!
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " klar med hamburger, men brett fullt. Venter!");
				notify.wait();
			} catch (InterruptedException e) {
			} finally {
				lock.unlock();
			}
		} else {
			try {
				lock.lock();
				Hamburger nyBurger = new Hamburger();
				// Hjelpet aa navigere antall burgere paa brettet, og om kapasitet nummer er
				// riktig
//						System.out.println("hamburgerBrett.size()  = " + hamburgerBrett.size());
//						System.out.println("kAPASITET              = " + kAPASITET);
				nyBurger.setId(burgerNr);
				hamburgerBrett.add(nyBurger);
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " legger paa hamburger (" + burgerNr + "). Brett: " + hamburgerBrett);
				burgerNr++;
				notify.notifyAll();
			} finally {
				lock.unlock();
			}

		} // else
	}// metode

	public void fjernBurger() {
		if (erTom()) {
			try {
				lock.lock();

				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " onsker aa ta hamburger, men brett tomt. Venter!");
				notify.wait();

			} catch (Exception e) {
			} finally {
				lock.unlock();
			}
		} else {
			try {
				lock.lock();
				Hamburger hFjernet = hamburgerBrett.remove();
				String threadName = Thread.currentThread().getName();
				System.out
						.println(threadName + " tar av hamburger: (" + hFjernet.getId() + "). Brett " + hamburgerBrett);
			} finally {
				lock.unlock();
			}
		} // else
	}// metode

	private synchronized boolean erTom() {
		return hamburgerBrett.isEmpty();
	}

	private synchronized boolean erFul() {
		return hamburgerBrett.size() >= kAPASITET;
	}

}
