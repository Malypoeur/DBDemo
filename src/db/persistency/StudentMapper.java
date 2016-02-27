package db.persistency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.connection.Database;

public class StudentMapper extends Mapper {
	// Singleton:
	private static StudentMapper uniqueInstance;

	/**
	 * Private constructor for singleton
	 */
	private StudentMapper() {
	}

	/**
	 * Sets up the unique instance of the Singleton
	 * 
	 * @return The unique instance
	 */
	public static StudentMapper getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new StudentMapper();
		}
		return uniqueInstance;
	}

	/**
	 * Gets a student from the database by the student name
	 * 
	 * @param studentName
	 *            The name of the student
	 * @return The desired student
	 */
	public StudentPersistent getStudent(String studentName) {
		String select = "SELECT ID, NAME, GENDER FROM STUDENT WHERE NAME = ?";
		try {
			PreparedStatement pstmt = Database.getInstance().getConnection().prepareStatement(select);
			pstmt.setString(1, studentName);
			List<StudentPersistent> students = this.queryStudent(pstmt);
			if (students.size() != 1) {
				return students.get(students.size() - 1);
			} else {
				return students.get(0);
			}

		} catch (SQLException e) {
			return null;
		}
	}

	private List<StudentPersistent> queryStudent(PreparedStatement pstmt) {
		List<StudentPersistent> students = new ArrayList<StudentPersistent>();
		try {
			ResultSet rset = pstmt.executeQuery(); // Execute the statement
			while (rset.next()) { // Load the result set
				StudentPersistent ps = null;
				int id = rset.getInt(1);
				String studentName = rset.getString(2);
				String gender = rset.getString(3);
				ps = new StudentPersistent(studentName, gender, id);
				students.add(ps);
			}
			rset.close(); // close the result set
			pstmt.close(); // close the statement
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

}
