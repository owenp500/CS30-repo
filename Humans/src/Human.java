
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Human implements Comparator{
	public static final Comparator<Human> AGE_ORDER = (Comparator<Human>) new AgeOrder();
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	
	private String firstName;
	private String lastName;
	
	private Gender gender;
	
	
	public Human(int birthYear, int birthMonth, int birthDay, String firstName, String lastName, Gender gender) {
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.gender = gender;
		
	}
	int calculateCurrentAgeInYears() {
		LocalDate now = LocalDate.now();
		LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
		Period period = Period.between(birthDate , now);
		
		//LocalDate birthDay = new LocalDate(birthMonth, birthMonth, birthMonth);
		return period.getYears();
	}
	
	//Accessors
	public int getBirthYear() {
		return birthYear;
	}
	
	public int getBirthMonth() {
		return birthMonth;
	}
	public int getBirthDay() {
		return birthDay;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	//Mutators
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}
}
