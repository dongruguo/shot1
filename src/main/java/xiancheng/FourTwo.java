package xiancheng;

import java.util.HashSet;

public class FourTwo {
	private final HashSet<Person> person = new HashSet<>();
	
	public synchronized void addPerson(Person person) {
		this.person.add(person);
	}
	
	public synchronized boolean getPerson(Person person) {
		return this.person.contains(person);
	}
}
