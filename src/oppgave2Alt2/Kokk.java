package oppgave2Alt2;

import java.util.Random;

import javax.sql.rowset.spi.SyncFactory;

public class Kokk extends Thread {
	Random rand = new Random();
	private HamburgerBrett brett;
	private String navn;

	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	@Override
	public void run() {
		setName(navn + " (Kokk)");

		while (true) {
			int r = rand.nextInt(4) + 1;

			try {
				Thread.sleep(r * 1000);
			} catch (InterruptedException e) {
			}
			synchronized (brett) {
				if (brett.erFul()) {
					try {
						String threadName = Thread.currentThread().getName();
						System.out.println(threadName + " klar med hamburger, men brett fullt. Venter!");
						brett.wait();
					} catch (InterruptedException e) {
					}
				}
				brett.leggTil();
				brett.notifyAll();
			}
		}
	}

}