package Instruments;

import Enums.*; 
import Users.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class Lesson implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private Format format;
    private LessonType type;
    private Vector <Student> participants;
    private Teacher teacher;
    
    public Lesson(Format format, LessonType type, Vector<Student> participants, Teacher teacher) {
		this.format = format;
		this.type = type;
		this.participants = participants;
		this.teacher = teacher;
	}
    
	public Format getFormat() {
		return format;
	}
	
	public void setFormat(Format format) {
		this.format = format;
	}
	
	public LessonType getType() {
		return type;
	}
	
	public void setType(LessonType type) {
		this.type = type;
	}
	
	public Vector<Student> getParticipants() {
		return participants;
	}
	
	public void setParticipants(Vector<Student> participants) {
		this.participants = participants;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public int hashCode() {
		return Objects.hash(format, participants, teacher, type);
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Lesson other = (Lesson) obj;
		return format == other.format && Objects.equals(participants, other.participants) && 
				Objects.equals(teacher, other.teacher) && type == other.type;
	}

	public String toString() {
		return "Lesson [format=" + format + ", type=" + type + ", participants=" + participants + ", teacher=" + teacher + "]";
	}
}