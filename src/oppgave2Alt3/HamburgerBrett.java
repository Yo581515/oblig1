package oppgave2Alt3;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {

	private Queue<Hamburger> hamburgerBrett = new LinkedList<>();
	private int kAPASITET;
	private int burgerNr = 1;
	private Servitor servitor = new Servitor();
	private Kokk kokk = new Kokk();

	public HamburgerBrett(int kAPASITET) {
		this.kAPASITET = kAPASITET;
	}

//	public void leggTilBruger(Hamburger burger) {
//		// TODO Auto-generated method stub
//		
//	}

//	public void FjernEtBruger() {
//		// TODO Auto-generated method stub
//		
//	}

	// Anne (kokk) legger paa hamburger (1). Brett: [(1)]
	// fiks alle print linjenn saade ser bra ut
	public void leggTilBruger(Hamburger h) {

		if (hamburgerBrett.size() < kAPASITET) {
			synchronized (servitor) {
				h.setId(burgerNr);
				hamburgerBrett.add(h);
				System.out.println(Thread.currentThread().getName() + " legger paa hamburger (" + burgerNr
						+ "). Brett: " + hamburgerBrett);
				burgerNr++;
				servitor.notify();
			}

		} else {
			synchronized (kokk) {
				try {
					kokk.wait();
				} catch (InterruptedException e) {
				} // Du bruker wait fordi brettet er fult
			}
			synchronized (servitor) {
				h.setId(burgerNr);
				hamburgerBrett.add(h);
				// du har denne hvis if-setning ikke er sann
				// hvis brette er fult maa du fÃ¸rst vente ogsaa prÃ¸ve paa nytt naar det er
				// klart
				// legg til etter at wait() er notified(Naar en servitor har hentet en burger
				// av
				// brettet)
				System.out.println(Thread.currentThread().getName() + " legger paa hamburger (" + burgerNr
						+ "). Brett: " + hamburgerBrett);
				burgerNr++;

				servitor.notify();
				// du blander engelsk og norsk i print/ fikser det senere S
				// hyggelig , jeg heter Josef
			}
		}

	}

	// Per (servitør) ønsker å ta hamburger, men brett tomt. Venter!
	public void FjernEtBruger() {
		Hamburger hFjernet = null;
		if (hamburgerBrett.isEmpty()) {

			synchronized (servitor) {
				try {
					System.out.println(
							Thread.currentThread().getName() + " ønsker å ta hamburger, men brett tomt. Venter!");
					servitor.wait();// Du venter i tilfelle brettet er tomt
				} catch (InterruptedException e) {
				}

			}
		}
		synchronized (kokk) {// sLocfyk for aa notifye servitor. kLock for aa notifye Kokk
			hFjernet = hamburgerBrett.remove();
			kokk.notify();
			System.out.println(Thread.currentThread().getName() + " tar av hamburger: (" + hFjernet.getId()
					+ "). Brett " + hamburgerBrett);
		}
	}

}
