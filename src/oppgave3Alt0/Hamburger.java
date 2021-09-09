package oppgave3Alt0;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hamburger other = (Hamburger) obj;
		return id == other.id;
	}
	
	

}
