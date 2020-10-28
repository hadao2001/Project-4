import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class implements the CourseDBManagerInterface. 
 * It allows the user to read the courses from a file or 
 * to enter the data by hand, and uses an Alert to print out the database elements. 
 * The input is read from a file or read from the textfiles 
 * and is added to the data structure through the add method.  
 * The add method uses the CDS add method. 
 * *The CourseDBManager is also referred to as a CDM.
 * @author Ha T Dao
 * CMSC204
 *
 */

public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure cds = new CourseDBStructure(20);
	CourseDBElement cde = new CourseDBElement();

	/**
	 * The CDS add method is used to add elements to the data structure.
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor)
	{
		CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(cde);
	}


	/**
	 * This allows input to be read from the file or from the textfields
	 */
	@SuppressWarnings("unused")
	@Override
	public void readFile(File file) throws FileNotFoundException {
		String id = "";
		String stringCrn = "";
		String strCredits = "";
		String instructor = "";
		String room = "";
		int crn = 0;
		int credits = 0;

		Scanner readInput = new Scanner(file);
		while (readInput.hasNext()) {
			if (readInput.hasNext()) {
				id = readInput.next();
			}

			if (readInput.hasNext()) {
				stringCrn = readInput.next();
			}
			crn = Integer.parseInt(stringCrn);

			if (readInput.hasNext()) {
				strCredits = readInput.next();
			}
			credits = Integer.parseInt(strCredits);

			if (readInput.hasNext()) {
				room = readInput.next();
			}
			if (readInput.hasNext()) {
				instructor = readInput.nextLine();
			}
			add(id, crn, credits, room, instructor);
		}
		readInput.close();
	}

	/**
	 * This method prints out all the elements in the bucketed
	 * linked lists.
	 */
	@Override
	public ArrayList<String> showAll() {

		ArrayList<String> bucketList = new ArrayList<String>();
	
		for (int i = 0; i < cds.hashTable.length; i++) {
			if (cds.hashTable[i]!=null) {
				LinkedList<CourseDBElement> list = cds.hashTable[i]; 
				for (CourseDBElement str: list){
					bucketList.add(str.toString());
				}
			}
		}
		return bucketList;
	}

	/**
	 * Gets the crn within the CDS.
	 */
	@Override
	public CourseDBElement get(int crn)
	{
		try {
			return cds.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}

