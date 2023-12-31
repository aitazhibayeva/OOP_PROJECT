package Instruments;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

import Users.*;
import Enums.*;

public class School implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
    private Vector<Manager> managers;
    private Dean dean;
    private Faculty faculty;
    
    public School(String name, Dean d, Faculty faculty) {
		this.name = name;
		this.dean = d;
		this.managers = new Vector<Manager>();
		this.faculty = faculty;
	}
    
    {
    	Database.getSchools().add(this);
    }
    
    public Faculty getFaculty() {
    	return faculty;
    }
    
    public void setFaculty(Faculty faculty) {
    	this.faculty = faculty;
    }
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Vector<Manager> getManagers() {
		return managers;
	}
	
	public void setManagers(Vector<Manager> managers) {
		this.managers = managers;
	}
	
	public Dean getDean() {
		return dean;
	}
	
	public void setDean(Dean d) {
		this.dean = d;
	}

	public int hashCode() {
		return Objects.hash(dean, managers, name);
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		School other = (School) obj;
		return Objects.equals(dean, other.dean) && Objects.equals(managers, other.managers)
				&& Objects.equals(name, other.name);
	}

	public String toString() {
		return "School [name=" + name + ", managers=" + managers + ", dean=" + dean
				+ ", faculty=" + faculty + "]";
	}
}