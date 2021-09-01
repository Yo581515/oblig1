package oppgave2;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {

	private Queue<Hamburger> hamburgerBrett = new LinkedList<>();
	private int kAPASITET;
	private int burgerNr;
	private Servitor sLock = new Servitor();
	private Kokk kLock = new Kokk();

	public HamburgerBrett(int kAPASITET) {
		this.kAPASITET = kAPASITET;
	}

	public void leggTilBruger(Hamburger h) {

		if (hamburgerBrett.size() < kAPASITET) {
			synchronized (sLock) {
				h.setId(burgerNr);
				hamburgerBrett.add(h);
				burgerNr++;
				System.out.println(
						Thread.currentThread().getName() + " is adding a burger to the tray . Tray " + hamburgerBrett);
				sLock.notify();
			}
//fiks alle print linjenn s� de ser bra ut
		} else {
			synchronized (kLock) {

				try {
					System.out.println("brettet er ful");
					kLock.wait();
				} catch (InterruptedException e) {
				} // Du bruker wait fordi brettet er fult
			}
			synchronized (sLock) {
				h.setId(burgerNr);
				hamburgerBrett.add(h);
				burgerNr++;// du har denne hvis if-setning ikke er sann
				// hvis brette er fult m� du f�rst vente ogs� pr�ve p� nytt n�r det er klart
				// legg til etter at wait() er notified(N�r en servit�r har hentet en burger av
				// brettet)
				System.out.println(
						Thread.currentThread().getName() + " is adding a burger to the tray . Tray " + hamburgerBrett);

				sLock.notify();
//du blander engelsk og norsk i print/ fikser det senere S 
// hyggelig , jeg heter Josef
			}
		}

	}

	public void FjernEtBruger() {
		Hamburger hFjernet = null;
		if (hamburgerBrett.isEmpty()) {

			synchronized (sLock) {
				try {
					System.out.println("brettet er tomt");
					sLock.wait();// Du venter i tilfelle brettet er tomt
				} catch (InterruptedException e) {
				}

			}
		}
		synchronized (kLock) {// sLocfyk for � notifye servit�r. kLock for � notifye Kokk
			hFjernet = hamburgerBrett.remove();
			kLock.notify();
			System.out.println(removeBurgerString());
		}
	}

	public String removeBurgerString() {
		return "" + Thread.currentThread().getName() + " tar en burger fra brettet: ";
	}

}
