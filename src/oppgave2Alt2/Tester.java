package oppgave2Alt2;

import java.util.LinkedList;
import java.util.Queue;

public class Tester {
	
	
	public static Queue<String> hamburgerBrett = new LinkedList<>();
	
	
	public static void main(String[] args) {
		String test1="1";
		String test2="2";
		
		hamburgerBrett.add(test1);
		hamburgerBrett.add(test2);
		
		System.out.println(hamburgerBrett.size());
		System.out.println(hamburgerBrett);
		
		System.out.println(hamburgerBrett.remove());
		System.out.println(hamburgerBrett.size());
		System.out.println(hamburgerBrett);
		
		System.out.println(hamburgerBrett.remove());
		System.out.println(hamburgerBrett.size());
		System.out.println(hamburgerBrett);
		
	}

}
