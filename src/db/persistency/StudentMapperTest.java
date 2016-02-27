package db.persistency;

import junit.framework.TestCase;

public class StudentMapperTest extends TestCase {

	/*
	 * Test method for 'persistency.StudentMapper.getInstance()'
	 */
	public void testGetInstance() {
		assertNotNull("Instance not created",StudentMapper.getInstance());
	}

	/*
	 * Test method for 'persistency.StudentMapper.getStudent(String)'
	 */
	public void testGetStudent() {
		assertEquals("Student name not returned correctly", "Navy",
				StudentMapper.getInstance().getStudent("Navy").getName());
	}

}
