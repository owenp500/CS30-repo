import java.util.Comparator;
public class AgeOrder implements Comparator<Human>{

	public int compare(Human human1, Human human2) {
		int comparison;
		if(human1.getBirthYear() > human2.getBirthYear()) {
			comparison = -1;
		}
		else if(human1.getBirthYear() < human2.getBirthYear()) {
			comparison = 1;
		}
		else if(human1.getBirthMonth() > human2.getYear)
		return comparison;
	}
	
}
