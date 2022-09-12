
public class WilliamAberhartStudent extends Youth {
	private int homeRoom;
	private String homeRoomTeacher;

	public WilliamAberhartStudent(int birthYear, int birthMonth, int birthDay, String firstName, String lastName, Gender gender,
			int grade, int homeRoom, String homeRoomTeacher) {
		super(birthYear, birthMonth, birthDay, firstName, lastName, gender, grade, "William Aberhart High School");
		this.homeRoom = homeRoom;
		this.homeRoomTeacher = homeRoomTeacher;
	}
	public int getHomeRoom() {
		return homeRoom;
	}
	public String getHomeRoomTeacher() {
		return homeRoomTeacher;
	}
}
