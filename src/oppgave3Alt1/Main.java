package oppgave3Alt1;

public class Main {

	public static void main(String[] args) {
		final String[] kokker = { "Anne", "Erik", "Knut" };
		final String[] servitorer = { "Mia", "Per" };
		final int KAPASITET = 4;
		skrivUtHeader(kokker, servitorer, KAPASITET);

		HamburgerBrett brett = new HamburgerBrett(KAPASITET);

		for (String navn : kokker) {
			new Kokk(brett, navn).start();
		}
		for (String navn : servitorer) {
			new Servitor(brett, navn).start();
		}

	}
	

//	I denne simuleringen har vi
//	3 kokker [Anne, Erik, Knut]
//	2 servitører [Mia, Per]
//	Kapasiteten til brettet er 4 hamburgere.
//	Vi starter ...

	private static void skrivUtHeader(String[] kokker, String[] servitorer, int kAPASITET) {
		System.out.println("oppgave3Alt1");
		System.out.println("I denne simuleringen har vi");
		System.out.print(kokker.length + " kokker");
		skrivUtTabell(kokker);
		System.out.print(servitorer.length + " servitorer");
		skrivUtTabell(servitorer);
		System.out.println("Kapasiteten til brettet er " + kAPASITET + " hamburgere.");
		System.out.println("Vi starter ...");
		System.out.println();
	}

	public static  void skrivUtTabell(String[] tab) {
		System.out.print("[");
		for (int i = 0; i < tab.length; i++) {
			if (i < tab.length - 1) {
				System.out.print(tab[i] + ", ");
			} else {
				System.out.println(tab[i] + "]");
			}
		}
	}

}
