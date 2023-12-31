package Users;

import Enums.*;
import Instruments.*;
import Interfaces.*;
import javafx.util.Pair;
import java.io.*;
import java.util.*;

/**
 * Manager can add/remove news, add courses for registration, and assign courses to teacher. Manager sends students’ requests to dean and also it can see employees’ requests. */
public class Manager extends Employee implements Viewable, Serializable {
	
	private static final long serialVersionUID = 1L;
	private ManagerType type;
	private Vector<Request> requests;
	private BufferedReader reader = null;
	
	public Manager() {
	}

	public Manager( String id, Date hireDate, double salary, String insuranceNumber, ManagerType type) {
		super(id, hireDate, salary, insuranceNumber);
		this.type = type;
		requests = new Vector<Request>();
		
	}
	
	{
		Database.getUsers().add(this);
	}
	
	/**
	 * returns Student id, name and mark from specific required course
	 * */
	public String viewMark(Course course) {
		for(Student student: Database.getStudents()) {
	    	for(HashMap.Entry<Pair<Course, Teacher>, Mark> marks : student.getTranscript().entrySet()) {
				if(marks.getKey().getKey().equals(course)) {
					System.out.println(student.getId()  + " " + student.getFullName() + " " + marks.getValue().getTotal());
					Database.getUserActions().add(new Action(this, new Date(), String.format("Manager: %s viewed mark of course: ", getUsername(), course.getName())));
					return student.getId()  + " " + student.getFullName() + " " + marks.getValue().getTotal();
				}
	    	}
		}
		return null;
	}
	
	/**
	 * to add news to news news feed
	 * */
	public String addNews(String title, String text) throws IOException {
		Database.getNews().add(new News(title, text));
		Database.getUserActions().add(new Action(this, new Date(), String.format("Manager: %s added news: ", getUsername())));
		return "added";
	}

	/**
	 * to remove news from news feed
	 * */
	public String removeNews(News news) {
		Database.getUserActions().add(new Action(this, new Date(), String.format("Manager: %s removed news: ", getUsername(), news.getTitle())));
		for(News n : Database.getNews()) {
			if(n.equals(news)) {
				Database.getNews().remove(n);
				return "deleted";
			}
		}
		return "not found";
	}

	/**
	 * to assign course to specific teacher
	 * */  
	public boolean assignCourseToTeacher(Course course, Teacher teacher) throws IOException {
		if(course.getSchool().equals(teacher.getSchool())){
			if(course.getTeachers().contains(teacher)) {
				return false;
			} else {
				return true;
			}
		} else {
			System.out.println("Schools are different.");
			return false;
		}
	}

	/**
	 * add courses for registration 
	 * */
	public String addCoursesForRegistration(Course newCourse) throws IOException {
		boolean found = false;
		for(Course c : Database.getCourses()) {
			if(c.equals(newCourse)) {
				found = true;
				break;
			}
		}
		if(!found) {
			Database.getCourses().add(newCourse);
			Database.getUserActions().add(new Action(this, new Date(), String.format("Manager %s added new course ($s) for registration", getFullName(), newCourse.getName())));
			return "added";
		}
		return "already exist";
  }

	
	/**
	   * allows to see teachers in alphabetical order
	   * */
	  public Vector<Teacher> viewTeachersAlphabetically() {
		  Vector<Teacher> v = Database.getTeachers();
		  Collections.sort(v);
		  return v;
	  }
	  
	  /**
	   * to send request from students to dean
	   * */
	  public boolean sendRequestToDean(Dean d, Request r) {
	    return d.signRequest(r);
	  }
	  
	  // getters and setters
	  public ManagerType getType() {
	    return type;
	  }

	  public void setType(ManagerType type) {
	    this.type = type;
	  }

	  public Vector<Request> getRequests() {
	    return requests;
	  }

	  public void setRequests(Vector<Request> requests) {
	    this.requests = requests;
	  }

	  public int hashCode() {
	    return Objects.hash(super.hashCode(), this.type, this.requests);
	  }

	  public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!super.equals(obj)) return false;
	    if (getClass() != obj.getClass()) return false;
	    Manager other = (Manager) obj;
	    return Objects.equals(requests, other.requests) && Objects.equals(type, other.type);
	  }

	public String toString() {
		return "Manager [type=" + type + ", requests=" + requests + ", reader=" + reader + "]";
	}
}