package Users;

import Interfaces.*; 
import javafx.util.Pair;

import java.io.Serializable;
import java.util.*;

import Enums.*;
import Instruments.*;
/** 
 * Teacher view courses, which he teaches, add/delete course files, put students’ mark.*/

public class Teacher extends Employee implements Viewable, Comparable<Teacher>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private School school;
	private TeacherType teacherType;
    
    public Teacher() {
    }

    public Teacher(User user, String id, Date hireDate, double salary, String insuranceNumber, School school, TeacherType teacherType) {
    	super(id, hireDate, salary, insuranceNumber);
    	this.school = school;
      	this.setTeacherType(teacherType);
    }    
    
//    {
//		Database.getUsers().add(this);
//    }
    
    public School getSchool() {
    	return school;
    }

    public void setSchool(School school) {
    	this.school = school;
    }
    public TeacherType getTeacherType() {
		return teacherType;
	}

	public void setTeacherType(TeacherType teacherType) {
		this.teacherType = teacherType;
	}

    /**
     * Returns all the courses in university system 
     * */
	public Vector<Course> getCourses(){
		return Database.getCourses();
	}

    public String addFileToCouse(Course course, File file) {
    	if(course.getFiles().contains(file)) {
    		return "Course already have this file";
    	} 
    	course.getFiles().add(file);
    	return "File is added";
    }
    
    public String deleteFileFromCourse(Course course, File file){
    	if(course.getFiles().contains(file)) {
    		course.getFiles().remove(file);
    		return "deleted";
    	} else {
    		return " not have this file";
    	}
    }
    
    /**
     * Puts mark for specific course and student
     * */
    public void putMark(Course course, Student s, int type, double point) {
		HashMap<Course, Teacher> p = new HashMap<Course, Teacher>();
    	if(s.getTranscript().containsKey(p)) {
    		if(type == 1) {
    			s.getTranscript().get(p).setFirstAttestation(point);
    		} else if(type == 2) {
    			s.getTranscript().get(p).setSecondAttestation(point);
    		} else if(type == 3) {
    			s.getTranscript().get(p).setFinalScore(point);
    		}
    	}
    }

    /**
     * To view mark of specific course he teaches
     * */
	public String viewMark(Course c) {
		String answer = "";
//		Pair<Course, Teacher> p = new Pair<Course, Teacher>(c, this);
		for(Student s: Database.getStudents()) {
			for(HashMap.Entry<Pair<Course, Teacher>, Mark> t : s.getTranscript().entrySet()) {
				if(t.getKey().getKey().equals(c) && t.getKey().getValue().equals(this)) {
					Database.getUserActions().add(new Action(this, new Date(), String.format("Teacher: %s viewed mark of course: %s", getFullName(), c.getName())));
		    		answer += "Student: " + s.getFullName() + ", points: " + t.getValue().getTotal() + ", letter grade: " + t.getValue().getLetterGrade();
				}
		    }
	   }
	   return answer;
	}
	public int hashCode() {
		   final int prime = 31;
		   int result = super.hashCode();
		   result = prime * result + Objects.hash(school, teacherType);
		   return result;
	   }

	   public boolean equals(Object obj) {
		   if (this == obj) return true;
		   if (!super.equals(obj)) return false;
		   if (getClass() != obj.getClass()) return false;
		   Teacher other = (Teacher) obj;
		   return Objects.equals(school, other.school) && teacherType == other.teacherType;
	    } 

	   public int compareTo(Teacher t) {
   			int resultByName = this.getName().compareTo(t.getName());
   			if(resultByName != 0) return resultByName;
   			int resultBySurname = this.getSurname().compareTo(t.getSurname());
   			return resultBySurname;   
   		}

	public String toString() {
		return "Teacher [school=" + school + ", teacherType=" + teacherType + "]";
	}

	
	   
}