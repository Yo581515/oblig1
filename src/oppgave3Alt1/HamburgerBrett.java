package oppgave3Alt1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import oppgave2Alt1.Hamburger;

public class HamburgerBrett {
	private BlockingQueue<Hamburger> hamburgerBrett ;
	private int burgerNr = 1;
	
	private Lock lock = new ReentrantLock(true);

	public HamburgerBrett(int kAPASITET) {
		this.hamburgerBrett = new LinkedBlockingQueue<>(kAPASITET);
	}

	public void leggTil() {
		try {
			lock.lock();
			System.out.println("jeg skal leggeTil");
			Hamburger nyBurger = new Hamburger();
			nyBurger.setId(burgerNr);
			hamburgerBrett.add(nyBurger);
//			Anne (kokk) legger på hamburger (1). Brett: [1]
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " legger paa hamburger (" + burgerNr + "). Brett: " + hamburgerBrett);
			burgerNr++;
			

		} catch (Exception e) {
			System.out.println("leggtilException");
		} 
		finally {
			lock.unlock();
		}

	}// metode

	public void fjernBurger() {
		try {
			lock.lock();
			System.out.println("jeg skal fjerne");

			Hamburger hFjernet = hamburgerBrett.remove();
//			Mia (servitør) tar av hamburger (5). Brett: [6]				
			String threadName = Thread.currentThread().getName();
			System.out.println(
					threadName + " tar av hamburger: " + "(" + hFjernet.getId() + "). Brett " + hamburgerBrett);
		} catch (Exception e) {
			System.out.println("fjernException");
		} 
		finally {
			lock.unlock();
		}

	}// metode


}
