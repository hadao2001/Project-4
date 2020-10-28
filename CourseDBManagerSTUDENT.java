import static org.junit.Assert.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManagerSTUDENT
{
	private CourseDBManagerInterface manager = new CourseDBManager();

	@Before
	public void setUp() throws Exception
	{
		manager = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception
	{
		manager = null;
	}

	@Test
	public void testAdd()
	{
		try {
			manager.add("CMSC140",30504,4,"SC120","Mary Jones");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testShowAll()
	{
		manager.add("CMSC140",30504,4,"SC120","Mary Jones");
		manager.add("CMSC110",30503,4,"SC350","Paul Smith");
		manager.add("CMSC203",30559,4,"SC450","Peter John");
		ArrayList<String> list = manager.showAll();

		assertEquals(list.get(0),"\nCourse:CMSC140 CRN:30865 Credits:4 Instructor:Mary Jones Room:SC120");
		assertEquals(list.get(1),"\nCourse:CMSC110 CRN:30456 Credits:4 Instructor:Paul Smith Room:SC350");
		assertEquals(list.get(2),"\nCourse:CMSC203 CRN:30223 Credits:4 Instructor:Peter John Room:SC450");
	}

	@Test
	public void testReadFile()
	{
		try {
			File inputFile = new File("NewCourse.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC140 30504 4 SC120 Mary Jones");
			inFile.print("CMSC110 30503 4 SC350 Paul Smith");

			inFile.close();
			manager.readFile(inputFile);
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}



}
