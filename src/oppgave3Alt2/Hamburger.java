package oppgave3Alt2;

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
