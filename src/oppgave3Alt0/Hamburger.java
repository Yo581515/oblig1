package oppgave3Alt0;

import java.util.concurrent.atomic.AtomicInteger;

public class Hamburger {

//	public static AtomicInteger tall = new AtomicInteger(0);
	private int id;
//	public static int number = 0;

	public Hamburger() {
//		this.id = tall.incrementAndGet();
//		this.id = ++number;
	}

	public Hamburger(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "";

	}

}
