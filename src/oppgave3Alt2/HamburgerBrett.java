package oppgave3Alt2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import oppgave2Alt1.Hamburger;

public class HamburgerBrett {

	private BlockingQueue<Hamburger> hamburgerBrett;
//	private int kAPASITET;
	private int burgerNr = 1;

	private Lock lock = new ReentrantLock(true);

	public HamburgerBrett(int kAPASITET) {
//		this.kAPASITET=kAPASITET;
		this.hamburgerBrett = new LinkedBlockingQueue<>(kAPASITET);
	}

	public void leggTil() {
		try {
			lock.lock();
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " vil leggeTil");
			if (!erFul()) {
				Hamburger nyBurger = new Hamburger();
				nyBurger.setId(burgerNr);
				hamburgerBrett.put(nyBurger);
//				Anne (kokk) legger på hamburger (1). Brett: [1]
				threadName = Thread.currentThread().getName();
				System.out.println(threadName + " legger paa hamburger (" + burgerNr + "). Brett: " + hamburgerBrett);
				burgerNr++;
			}
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}

	}// metode

	public void fjernBurger() {
		try {
			lock.lock();
			if (!erTom()) {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + " vil fjerne");

				Hamburger hFjernet = hamburgerBrett.take();
//				Mia (servitør) tar av hamburger (5). Brett: [6]				
				threadName = Thread.currentThread().getName();
				System.out.println(
						threadName + " tar av hamburger: " + "(" + hFjernet.getId() + "). Brett " + hamburgerBrett);
			}

		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}// metode

	private boolean erTom() {
		return hamburgerBrett.isEmpty();
	}

	private boolean erFul() {
		return hamburgerBrett.remainingCapacity() == 0;
	}

}
