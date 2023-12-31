package Users;

import Interfaces.*; 

import javafx.util.Pair;
import java.io.Serializable;
import java.util.*;

import Enums.*;
import Instruments.*;
/**Student one of the main roles, can do all the staff with his courses, view news, rate teachers and etc.*/

public class Student extends User implements WriteableComment, Requestable, Viewable, Comparable<Student>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
    private School school;
    private int yearOfStudy;
    private HashMap<Pair<Course, Teacher>, Mark> transcript;
    private boolean grant;
    private double scholarship;
    private Degree degree;
    private Vector<Organization> organizations;
    
    public Student() {
    }

    public Student(String id, School school, int yearOfStudy, boolean grant,  double scholarship, Degree degree) {
    	this.id = id;
    	this.school = school;
    	this.yearOfStudy = yearOfStudy;
    	this.grant = grant;
    	this.scholarship = scholarship;
    	this.degree = degree;
    	this.transcript = new HashMap<Pair<Course, Teacher>, Mark>();  
    	this.organizations = new Vector<Organization>();
    } 
    
//	{
//		Database.getUsers().add(this);
//	}
    
    public String getId() {
    	return id;
    }
  
    public void setId(String id) {
    	this.id = id;
    }

    public School getSchool() {
    	return school;
    }

    public void setSchool(School school) {
    	this.school = school;
    }

    public int getYearOfStudy() {
    	return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
    	this.yearOfStudy = yearOfStudy;
    }

    public boolean getGrant() {
    	return grant;
    }

    public void setGrant(Boolean grant) {
    	this.grant = grant;
    }

    public double getScholarship() {
    	return scholarship;
    }

    public void setScholarship(double scholarship) {
    	this.scholarship = scholarship;
    }

    public Degree getDegree() {
    	return degree;
    }

    public void setDegree(Degree degree) {
    	this.degree = degree;
    }    

    public Vector<Organization> getOrganizations() {
    	return organizations;
    }

    public void setOrganizations(Vector<Organization> organizations) {
    	this.organizations = organizations;
    }
    
    public HashMap<Pair<Course, Teacher>, Mark> getTranscript() {
    	return transcript;
    }

    public void setTranscript(HashMap<Pair<Course, Teacher>, Mark> transcript) {
    	this.transcript = transcript;
    }

    
    /**
     * Allows to register for specific course
     * */
    public void registerForCourse(Course course, Teacher t, Manager m){
    	this.makeRequest(new Request(this.getId(), RequestType.COURSE_REGISTRATION, course.getId() + " " + t.getId()), m);
    	Database.getUserActions().add(new Action(this, new Date(), String.format("Student: %s sended request for registration %s:", getFullName(), course.getName())));
    }
    

    /**
     * Makes request to TechSupport or Manager*/ 
    public String makeRequest(Request request, Employee employee) {
    	if(employee instanceof TechSupport) {
    		if(request.getDescription().length() > 10 && request.getTitle().equals(RequestType.SIMPLE_REQUEST)) {
    			TechSupport t = (TechSupport)employee;
    			t.getRequests().add(request);
    			Database.getUserActions().add(new Action(this, new Date(),  getUsername()));
    			return "request sended";
        } else {
        	return "request is rejected";	
        }
      }
      else if(employee instanceof Manager) {
    	  Database.getUserActions().add(new Action(this, new Date(),  getUsername()));
    	  ((Manager) employee).getRequests().add(request);
    	  return "sended";
      }
    		return "sended to manager/tech";
   }
    /**
     * To write comment under the news
     * */
    public void writeComment(String comment, News n) {
		Database.getUserActions().add(new Action(this, new Date(), String.format("Student: %s writed comment to news %s", getUsername(), n.getTitle())));
    	n.getComments().add(comment);
    }
    /**
     * To view his own transcript
     * */
    public void viewTranscript() {
		Database.getUserActions().add(new Action(this, new Date(), getUsername()));
    	for(HashMap.Entry<Pair<Course, Teacher>, Mark> marks : transcript.entrySet()) {
    		System.out.println("Student: " + marks.getKey().getKey().getName() + ", mark: " + marks.getValue().getTotal() + " points, " + "letter: " + marks.getValue().getLetterGrade() + ", teacher: " + marks.getKey().getValue());
        }
    }
    
    public int hashCode() {
    	final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + Objects.hash(grant, id, organizations, scholarship, school, degree, transcript, yearOfStudy);
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return Objects.equals(grant, other.grant) && Objects.equals(id, other.id)
            && Objects.equals(organizations, other.organizations)
            && Double.doubleToLongBits(scholarship) == Double.doubleToLongBits(other.scholarship)
            && Objects.equals(school, other.school) && degree == other.degree
            && Objects.equals(transcript, other.transcript) && yearOfStudy == other.yearOfStudy;
      }
    /**
     * To view mark of specified course
     * */
    public String viewMark(Course c) {
    	for(HashMap.Entry<Pair<Course, Teacher>, Mark> t : transcript.entrySet()) {
    		if(t.getKey().getKey().equals(c)) {
    			Database.getUserActions().add(new Action(this, new Date(), String.format("Student: %s viewed mark of course: %s", getFullName(), c.getName())));
    			return c.getName() + ": " + t.getValue();
    		}
        }
    	return null;
    }
    
    public int compareTo(Student s) {
    	int resultByName = this.getName().compareTo(s.getName());
    	if(resultByName != 0) return resultByName;
    	int resultBySurname = this.getSurname().compareTo(s.getSurname());
    	return resultBySurname;
    } 
    public double getGpa() {
    	double total = 0;
    	int cnt = 0;
    	for(HashMap.Entry<Pair<Course, Teacher>, Mark> x : transcript.entrySet()) {
    		total += x.getValue().getGpa();
    		cnt++;
    	}
    	return total/cnt;
    }

	public String toString() {
		return "Student [id=" + id + ", school=" + school + ", yearOfStudy=" + yearOfStudy + ", transcript="
				+ transcript + ", grant=" + grant + ", scholarship=" + scholarship + ", degree=" + degree
				+ ", organizations=" + organizations + "]";
	}
    
	
}