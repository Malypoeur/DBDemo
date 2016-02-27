package db.persistency;

import db.application.Student;

public class StudentPersistent extends Student {
	
	private int id;
	
	public StudentPersistent(String name, String gender, int id){
		super(name, gender);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
}
