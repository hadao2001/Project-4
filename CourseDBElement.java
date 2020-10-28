import java.util.ArrayList;

/**
 *  This class implements Comparable and consists of the CourseID, CRN, number of credits, room number, and instructor name
 * @author Ha T Dao
 * CMSC 204
 */

public class CourseDBElement implements Comparable
{
	int CRN;
	int numCredits;
	String roomNum;
	String instructorName;
	String hashcod;
	String courseID;
	
	/**
	 * Getter for the course id
	 * @return id String of the course
	 */
	public String getId() {
		return courseID;
	}
	
	/**
	 * Getter for the course crn
	 * @return id int of the course
	 */
	public int getCRN() {
		return CRN;
	}
	
	/**
	 * Getter for the course credits
	 * @return credits for the course
	 */
	public int getCredits() {
		return numCredits;
	}
	
	/**
	 * Getter for the course room 
	 * @return room of the course
	 */
	public String getRoom() {
		return roomNum;
	}
	
	/**
	 * Getter for the course instructor
	 * @return instructor of the course
	 */
	public String getInstructor() {
		return instructorName;
	}


	/**
	 * Sets the id value
	 * @param id
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * Sets the crn value
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.CRN = crn;
	}
	
	/**
	 * Sets the credits value
	 * @param credits
	 */
	public void setCredits(int numCredits) {
		this.numCredits = numCredits;
	}


	/**
	 * Sets the room value
	 * @param room
	 */
	public void setRoom(String roomNum) {
		this.roomNum = roomNum;
	}

	
	/**
	 * Sets the instructor value
	 * @param instructor
	 */
	public void setInstructor(String instructorName) {
		this.instructorName = instructorName;
	}


	public CourseDBElement()
	{
		courseID = null;
		CRN = 0;
		numCredits = 0;
		roomNum = null;
		instructorName = null;
		this.hashcod=hashcode();
	}

	/**
	 * This is a constructor with all the attributes of an element
	 * @param id course code from the MC catalog
	 * @param crn unique reference number for each section of the course
	 * @param credits number of credits earned for the course
	 * @param room where the course is held (or REMOTE/Distance-Learning)
	 * @param instructor name of the instructor for the course
	 */
	
	public CourseDBElement(String courseID,int CRN,int credits,String roomNum,String instructor)
	{
		this.courseID = courseID;
		this.CRN = CRN;
		this.numCredits = credits;
		this.roomNum = roomNum;
		this.instructorName = instructor;
		this.hashcod=hashcode();
	}

	/**
	 *  ToString method to convert an element into a string for the display method
	 */	
	public String toString() {
		String courseString = "\nCourse:" + courseID + " CRN:" + CRN + " Credits:" + numCredits + " Instructor:" + instructorName + " Room:"+roomNum;
		return courseString;
	}
	
	/**
	 * This method casts the crn as a string and returns the hash code
	 */
	public String hashcode()
	{
		return ""+((""+CRN).hashCode());
	}

	/**
	 * Method that compares two elements based on the crn
	 * and returns a positive, negative, or 0 value for
	 * using Comparable
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		
		return this.CRN - element.CRN;
	}
	
	/**
	 * Equals method that compares two elements based on their
	 * String representation.
	 */
	@Override
	public boolean equals(Object element) {
		if (this.toString().equals(element.toString())){
			return true;
		} else return false;
	}

}//end class
