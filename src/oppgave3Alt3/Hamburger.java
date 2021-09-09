package oppgave3Alt3;

public class Hamburger {

	private int id;

	public Hamburger() {
	}

	public Hamburger(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	@Override
	public String toString() {
		return id + "";
		
	}

}
