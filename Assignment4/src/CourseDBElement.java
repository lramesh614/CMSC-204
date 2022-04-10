/**
 * CourseDBElement - Class which makes elements that will go into hash table
 * 
 * @author Lokesh Sankar Ramesh
 *
 */
public class CourseDBElement implements Comparable
{
	private String ID, roomNumber, instructorName;
	private int CRN, credits;
	
	/**
	 * Constructor which takes in CRN
	 * @param CRN
	 */
	public CourseDBElement(int CRN)
	{
		this.CRN = CRN;
	}
	
	/**
	 * Constructor which takes in CRN, ID, credits, roomNumber, instructorName
	 * @param CRN
	 * @paran ID
	 * @param credits
	 * @param roomNumber
	 * @param instructorName
	 */
	public CourseDBElement(String ID, int CRN, int credits, String roomNumber, String instructorName)
	{
		this.ID = ID;
		this.CRN = CRN;
		this.credits = credits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}
	
	/*
	 * No-arg constructor
	 */
	public CourseDBElement()
	{
		this(null, 00000, 0, null,null);
	}
	
	
	//GETTERS
	/**
	 * Returns string representation of CRN
	 * @return crn as a string
	 */
	public String getHash() {
		return "" + CRN;
	}
	
	/**
	 * Returns course ID
	 * @return ID - course ID
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * returns CRN of the class
	 * 
	 * @return CRN
	 */
	public int getCRN() {
		return CRN;
	}
	
	/**
	 * Returns credits of the class
	 * 
	 * @return credits
	 */
	public int getCredits() {
		return credits;
	}
	
	/**
	 * returns room number of the class
	 * 
	 * @return roomNumber
	 */
	public String getRoomNum() {
		return roomNumber;
	}
	
	/**
	 * Returns name of the instructor
	 * 
	 * @return instructorName
	 */
	public String getinstructorName() {
		return instructorName;
	}
	
	
	//SETTERS
	/**
	 * Sets course ID
	 * 
	 * @param ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	
	/**
	 * Sets CRN of the class
	 * 
	 * @param CRN
	 */
	public void setCRN(int CRN) {
		this.CRN = CRN;
	}

	/**
	 * Sets credits of the class
	 * 
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * Sets room number of the class
	 * 
	 * @param roomNumber
	 */
	public void setRoomNum(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Sets name of instructor
	 * 
	 * @param instructorName
	 */
	public void setinstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	public int compareTo(CourseDBElement element) {
		return hashCode() - element.hashCode();
	}
	
	
	/**
	 * String representation of all values of the CourseDBElement object
	 * 
	 * @return string with all values of the element
	 */
	@Override
	public String toString() {
		return "\nCourse:" + ID + " CRN:" + CRN + " Credits:" + credits + 
				" Instructor:" + instructorName + " Room:" + roomNumber;
	}
	
}