package Instruments;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
import Enums.*;
import Users.*;

/**
 * This is a Course class, Student and Teachers can add course, Manager can controll 
 */
public class Course implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private String id;
	private String name;
    private Course prerequisite;
    private int numberOfCredits;
    private CourseType courseType;
    private School school;
    private Degree degree;
    private Vector<File> files;
    private Vector<Teacher> teachers;
    
    public Course(String name, Course prerequisite, int numberOfCredits, School school, CourseType courseType, Degree degree) {
		this.name = name;
		this.prerequisite = prerequisite;
		this.numberOfCredits = numberOfCredits;
		this.school = school;
		this.courseType = courseType;
		this.degree = degree;
		this.files = new Vector<File>();
		this.teachers = new Vector<Teacher>();
	}
     
//    {
//    	Database.getCourses().add(this);
//    }
        
    public Vector<Course> getCoursesOfTeacher(Teacher t) {
    	return Database.getTeachersCourse(t);
    }
	
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Course getPrerequisite() {
		return prerequisite;
	}
	
	public void setPrerequisite(Course prerequisite) {
		this.prerequisite = prerequisite;
	}
	
	public int getNumberOfCredits() {
		return numberOfCredits;
	}
	
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	public School getSchool() {
		return school;
	}
	
	public void setSchool(School school) {
		this.school = school;
	}
	
	public Degree getDegree() {
		return degree;
	}
	
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	public Vector<File> getFiles() {
		return files;
	}
	
	public void setFiles(Vector<File> files) {
		this.files = files;
	}
	
	public CourseType getType() {
		return courseType;
	}
	
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	
	public Vector<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Vector<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public File getCourseFile(String name) {
		for(File f : files) {
			if(f.getName() == name) {
				System.out.println(f);
			}
		}
		return null;
	}

	public int hashCode() {
		return Objects.hash(courseType, degree, files, name, numberOfCredits, prerequisite, school, teachers);
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Course other = (Course) obj;
		return Objects.equals(files, other.files) && Objects.equals(name, other.name)
				&& numberOfCredits == other.numberOfCredits && Objects.equals(prerequisite, other.prerequisite)
				&& Objects.equals(school, other.school) && degree == other.degree
				&& Objects.equals(teachers, other.teachers) && courseType == other.courseType;
	}

	public String toString() {
		return "Course [name=" + name + ", prerequisite=" + prerequisite + ", numberOfCredits=" + numberOfCredits
				+ ", courseType=" + courseType + ", school=" + school + ", degree=" + degree + ", files=" + files
				+ ", teachers=" + teachers + "]";
	}
}