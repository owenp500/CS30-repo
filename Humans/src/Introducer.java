import java.util.Random;
public class Introducer {
	public String createPublicIntroduction(Human human) {
		String introduction = String.format("I am pleased to introduce %s %s.", human.getFirstName(), human.getLastName());
		String pronoun = "They";
		switch(human.getGender()) {
		case MALE:
			pronoun = "He";
			break;
		case FEMALE:
			pronoun = "She";
			break;
		case GENDER_FLUID:
			Random x = new Random();
			if(x.nextBoolean()) {
				pronoun = "He";
			}
			else {
				pronoun = "She";
				
			}
			break;
		default:
			pronoun = "They";
			break;
		}
			
		if(human instanceof Adult) {
			Adult adult = (Adult) human;
			introduction = String.format("%s %s works at %s and their occupation is %s.", introduction, pronoun, adult.getPlaceOfWork(), adult.getOccupation() );
		}	
		else if(human instanceof Youth) {
			Youth youth = (Youth) human;
			introduction = String.format("%s %s goes to %s and is in grade %d.", introduction, pronoun, youth.getSchoolName(), youth.getSchoolGrade());
			
			if(youth instanceof WilliamAberhartStudent) {
				WilliamAberhartStudent abeStudent = (WilliamAberhartStudent) human;
				try {
					abeStudent.getHomeRoomTeacher();
					introduction = String.format("%s %s belongs to %s's homeroom, which is in room %d.",introduction, pronoun, abeStudent.getHomeRoomTeacher(), abeStudent.getHomeRoom());
				}
				catch(NullPointerException e) {
			
				}
				
			}
		}
		return introduction;
	}
}
//introduction = String.format("I am pleased to introduce %s %s.", human.getFirstName(), human.getLastName());