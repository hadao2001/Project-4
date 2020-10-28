import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * This class implements a hash table with buckets, creating an array
 * of linked lists of CourseDBElements. Each CDE has a hash code that
 * is generated from the crn. It adds CDEs to the data structure. If a
 * linked list doesn't exist, it creates one and adds it to the hash
 * table. If a linked list already exists for a given bucket, the CDE 
 * is added to the existing linked list. 
 * @author Ha T Dao
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	protected LinkedList<CourseDBElement>[] hashTable;
	protected int tableSize;
	int size;

	
	/** This constructor takes in an int that is the estimated size of
	 *  the hash table. 
	 * @param size the chosen size of the hash table
	 */
	@SuppressWarnings("unchecked") 
	public CourseDBStructure(int size) {
		tableSize = size;
		hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[size];
	}
	
	/**
	 * This constructor is for testing purposes and has two args per the instructions. 
	 * It takes an int for the size of the hash table and a string "Testing" 
	 * @param s the string "Testing" 
	 * @param size
	 */
	@SuppressWarnings("unchecked") 
	public CourseDBStructure(String s, int size) {
		tableSize = size;
		hashTable = (LinkedList<CourseDBElement>[]) new LinkedList[size];
	}


	/**
	 * Getter for the tableSize value.
	 */
	@Override
	public int getTableSize() {
		return tableSize;

	}

	/**
	 * This method adds an element to a bucket's LinkedList
	 * in the hashTable. If no linked list exists, one is 
	 * created.
	 */
	@Override
	public void add(CourseDBElement element) {
		int hash =element.hashCode()%getTableSize();

		if(hashTable[hash]!=null){
		hashTable[hash].add(element);}
		else
		{
			hashTable[hash]=new LinkedList<CourseDBElement>();
			hashTable[hash].add(element);
		}
	}

	/**
	 * This method retrieves a course based on its CRN.
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		for (int index = 0; index < tableSize; index++ ) {
			if (hashTable[index] != null) {
				for (CourseDBElement cde : hashTable[index]) {
					if (cde.getCRN() == crn) {
						return cde;
					}
				}
			}

		}

		throw new IOException("Course CRN " + crn + " is not in database");
	}
	
}
