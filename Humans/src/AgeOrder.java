import java.util.Comparator;

public class AgeOrder implements Comparator<Human>{

	@Override
	public int compare(Human human1, Human human2) {
		int comparison = 0;
		if(human1.getBirthYear() < human2.getBirthYear()) {
			comparison = +1;
		}
		else if(human1.getBirthYear() > human2.getBirthYear()) {
			comparison = -1;
		}
		else if(human1.getBirthMonth() > human2.getBirthMonth()) {
			comparison = +1;
		}
		else if(human1.getBirthMonth() < human2.getBirthMonth()) {
			comparison = -1;
		}
		else if(human1.getBirthDay() > human2.getBirthDay()) {
			comparison = +1;
		}
		else if(human1.getBirthDay() < human2.getBirthDay()) {
			comparison = -1;
		}		
		return comparison;
	}
	

}
