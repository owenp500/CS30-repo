import java.util.Comparator;

public class NameOrder implements Comparator<Human> {

	
	public int compare(Human human1, Human human2) {
		int comparison = human1.getLastName().compareTo(human2.getLastName());
		if(comparison == 0) {
			comparison = human1.getFirstName().compareTo(human2.getFirstName());
		}
		return comparison;
	}

}
