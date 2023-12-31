package Instruments;

import java.io.Serializable; 
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

/**
 * This is a Student Journal
 */
public class Journal implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private HashMap <Course, Vector <Mark> > marks;
    
    {
      marks = new HashMap<Course, Vector<Mark> >();
    }
    
    
    public Journal() {}
    
    
    public HashMap <Course, Vector <Mark> > getMarks() {
    	return marks;
    }
    public void setJournal(HashMap <Course, Vector <Mark> > marks) {
    	this.marks = marks;
    }
  
  
  /**
   * Sum of all marks
   * @param course
   * @return
   */
    public double getTotal(Course course) {
      double total = 0;
      for(Course c : marks.keySet()) {
        if(c.getName().equals(course.getName()) == false) continue;
        for(Mark m : marks.get(c)) {
          total+=m.getGrade();
        }
      }
      System.out.println(total);
      return total;
    }
    
    
    public void clear() {
      marks = new HashMap<Course, Vector<Mark> >();
    }

	public int hashCode() {
		return Objects.hash(marks);
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Journal other = (Journal) obj;
		return Objects.equals(marks, other.marks);
	}

	public String toString() {
		return "Journal [marks=" + marks + "]";
	}
    
}

