import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBStructureSTUDENT
{
	CourseDBStructure cds, testS;

	@Before
	public void setUp() throws Exception
	{
		cds = new CourseDBStructure(20);
		testS = new CourseDBStructure("Testing", 20);
	}

	@After
	public void tearDown() throws Exception
	{
		cds = null;
		testS = null;
	}


	@Test
	public void testGet() {
		assertEquals(20, cds.hashTable.length);
		CourseDBElement cde = new CourseDBElement("CMSC140", 30504, 4, "SC120", "Mary Jones");
		cds.add(cde);
		LinkedList<CourseDBElement> list = cds.hashTable[cde.hashCode()%cds.getTableSize()];
		assertEquals(30504, list.get(0).getCRN());

		cds = new CourseDBStructure("Testing",20);
		assertEquals(20, cds.hashTable.length);
		cds.add(cde);
		list = cds.hashTable[cde.hashCode()%20];
		assertEquals(30504, list.get(0).getCRN());
	}

	@Test
	public void testGetTableSize() {
		assertEquals(20, cds.getTableSize());
		assertEquals(20, testS.getTableSize());
	}

}
