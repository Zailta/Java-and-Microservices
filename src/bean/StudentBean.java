package bean;

public class StudentBean {

	/*
	 * create a user Bean, it should return firstname, lastname , class, and grade
	 * while assessing the grade it should get the appropriate grade value.
	 */ 
	
	private int studentId;
	private String firstName;
	private String lastName;
	private int marksObtained;
	private String gradeObtained;
	private String gradeValue;
	public StudentBean(int studentId, String firstName, String lastName, int marksObtained, String gradeObtained,
			String gradeValue) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.marksObtained = marksObtained;
		this.gradeObtained = gradeObtained;
		this.gradeValue = gradeValue;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public String getGradeObtained() {
		return gradeObtained;
	}
	public void setGradeObtained(String gradeObtained) {
		this.gradeObtained = gradeObtained;
	}
	public String getGradeValue() {
		return gradeValue;
	}
	public void setGradeValue(String gradeValue) {
		this.gradeValue = gradeValue;
	}
	
}
