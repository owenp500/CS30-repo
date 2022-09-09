
public class Youth extends Human {
	int schoolGrade;
	String schoolName;

	public Youth(int birthYear, int birthMonth, int birthDay, String firstName, String lastName, Gender gender,
			int schoolGrade, String schoolName) {
		super(birthYear, birthMonth, birthDay, firstName, lastName, gender);
		this.schoolGrade = schoolGrade;
		this.schoolName = schoolName;
	}
	public int getSchoolGrade() {
		return schoolGrade;
	}
	public String getSchoolName() {
		return schoolName;
	}
}
