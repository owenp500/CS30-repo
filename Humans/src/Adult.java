
public class Adult extends Human {
	private String placeOfWork;
	private String occupation;
	
	public Adult(int birthYear, int birthMonth, int birthDay, String firstName, String lastName, Gender gender, 
			String placeOfWork, String occupation ) {
		super(birthYear, birthMonth, birthDay, firstName, lastName, gender);
		this.placeOfWork = placeOfWork;
		this.occupation = occupation;		
	}
	public String getPlaceOfWork() {
		return placeOfWork;
	}
	public String getOccupation() {
		return occupation;
	}
}
