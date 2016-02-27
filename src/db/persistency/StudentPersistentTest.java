package db.persistency;

import junit.framework.TestCase;

public class StudentPersistentTest extends TestCase {

	/*
	 * Test method for 'persistency.StudentPersistent.StudentPersistent(String, String, int)'
	 */
	public void testStudentPersistent() {
		StudentPersistent testStudent = new StudentPersistent("Navy","Male", 1);
		assertNotNull("Student object not created", testStudent);
	}

	/*
	 * Test method for 'persistency.StudentPersistent.getId()'
	 */
	public void testGetId() {
		StudentPersistent testStudent = new StudentPersistent("Navy","Male", 1);
		assertEquals("Object ID false",1 , testStudent.getId());
	}


}
