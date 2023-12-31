package Users;

import java.io.Serializable; 
import java.util.Date;
import java.util.Objects;

import Instruments.*;
import Enums.*;
/**Dean signs official documents.*/

public class Dean extends Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Faculty faculty;

	public Dean() {
    }
    
    public Dean(User user, String id, Date hireDate, double salary, String insuranceNumber, Faculty faculty) {
		super(id, hireDate, salary, insuranceNumber);
		this.setFaculty(faculty);
    }
    
    {
		Database.getUsers().add(this);
    }
    public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
    
    /**
     * Gets request from Manager and decides to sign or not
     * */
    public boolean signRequest(Request r) {
		Database.getUserActions().add(new Action(this, new Date(), String.format("Dean: %s signed request of date: %s", getUsername(), r.getDateOfRequest())));
        if(!r.getDescription().isEmpty()) return true;
        	return false;
    }
    
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(faculty);
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (getClass() != obj.getClass()) return false;
		Dean other = (Dean) obj;
		return faculty == other.faculty;
	}
	public String toString() {
		return "Dean [faculty=" + faculty + "]";
	}
    
}