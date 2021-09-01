package oppgave2;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {

	private Queue<Hamburger> hamburgerBrett = new LinkedList<>();
	private int kAPASITET;
	private int burgerNr = 1;
	private Servitor sLock = new Servitor();
	private Kokk kLock = new Kokk();

	public HamburgerBrett(int kAPASITET) {
		this.kAPASITET = kAPASITET;
	}

	
	
	
	
//	// Anne (kokk) legger på hamburger ◖1◗. Brett: [◖1◗]
//	public void leggTilBruger(Hamburger h) {
//
//		if (hamburgerBrett.size() < kAPASITET) {
//			synchronized (sLock) {
//				h.setId(burgerNr);
//				hamburgerBrett.add(h);
//				System.out.println(Thread.currentThread().getName() + " legger på hamburger <" + burgerNr + ">. Brett: "
//						+ hamburgerBrett);
//				
//				burgerNr++;
//
//				sLock.notify();
//			}
//
////fiks alle print linjenn så de ser bra ut
//		} else {
//			synchronized (kLock) {
//
//				try {
//					System.out.println("brettet er ful");
//					kLock.wait();
//				} catch (InterruptedException e) {
//				} // Du bruker wait fordi brettet er fult
//			}
//			synchronized (sLock) {
//				h.setId(burgerNr);
//				hamburgerBrett.add(h);
//				burgerNr++;// du har denne hvis if-setning ikke er sann
//				// hvis brette er fult må du først vente også prøve på nytt når det er klart
//				// legg til etter at wait() er notified(Når en servitør har hentet en burger av
//				// brettet)
//				System.out.println(Thread.currentThread().getName() + " legger på hamburger <" + burgerNr + ">. Brett: "
//						+ hamburgerBrett);
//
//				sLock.notify();
////du blander engelsk og norsk i print/ fikser det senere S
//// hyggelig , jeg heter Josef
//			}
//		}
//
//	}
//
//	public void FjernEtBruger() {
//		Hamburger hFjernet = null;
//		if (hamburgerBrett.isEmpty()) {
//
//			synchronized (sLock) {
//				try {
//					System.out.println("brettet er tomt");
//					sLock.wait();// Du venter i tilfelle brettet er tomt
//				} catch (InterruptedException e) {
//				}
//
//			}
//		}
//		synchronized (kLock) {// sLocfyk for å notifye servitør. kLock for å notifye Kokk
//			hFjernet = hamburgerBrett.remove();
//			kLock.notify();
//			System.out.println(removeBurgerString());
//		}
//	}
//
//	public String removeBurgerString() {
//		return "" + Thread.currentThread().getName() + " tar en burger fra brettet: ";
//	}

}
