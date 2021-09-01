package oppgave2Alt3;

import java.util.Random;

public class Servitor extends Thread {

//husker ikke
	private String navn;
	private HamburgerBrett brett;

	public Servitor() {
	}

	public Servitor(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	@Override
	public void run() {	
		//utenfor while
		setName(navn+ " (Servitør)");
		while(true){
			int r = (int) Math.floor(Math.random() * 3000) + 3000; // mellom 3 og 6 sec //du burde ha random inne i while-løkken
			// så du får nye tall hver gang
			
			try {
				Thread.sleep(r);
				brett.FjernEtBruger();
				
			}catch(Exception e){
			}
		}
		

	}
}
