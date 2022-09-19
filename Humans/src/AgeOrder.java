import java.util.Comparator;
//<<<<<<< HEAD
/*public class AgeOrder implements Comparator<Human>{

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
	
//=======
*/
public class AgeOrder implements Comparator<Human>{

	@Override
	public int compare(Human human1, Human human2) {
		int comparison = 0;
		if(human1.getBirthYear() < human2.getBirthYear()) {
			comparison = -1;
		}
		else if(human1.getBirthYear() > human2.getBirthYear()) {
			comparison = 1;
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
	

//>>>>>>> branch 'master' of https://github.com/owenp500/CS30-repo
}
