package Instruments;

import java.io.Serializable;

import java.util.*;
import java.util.Map.Entry;
/**
 * This is a transcript that gives an overall grade from the grades in the journal
 */
public class Transcript implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private HashMap<Course, Mark> marks;
    
    public Transcript(HashMap<Course, Mark> marks) {
		super();
		this.marks = marks;
	}
    

	public HashMap<Course, Mark> getMarks() {
		return marks;
	}
	public void setMarks(HashMap<Course, Mark> marks) {
		this.marks = marks;
	}

	
	public void getAllGpa() {
		for(Entry<Course, Mark> m: marks.entrySet()) {
			System.out.println(m.getKey().getName() + " " + GPAConverter(m.getValue().getGpa()));
		}
	}
	
	public Double getAverageGPA() {
		Double gpa = 0.0;
		for(Entry<Course, Mark> m: marks.entrySet()) {
			gpa += GPAConverter(m.getValue().getGpa());
		}
		return gpa;
	}
	
	public double GPAConverter(double mark) {
		if(mark > 95) return 4.00;
		if(mark > 90) return 3.67;
		if(mark > 85) return 3.33;
		if(mark > 80) return 3.0;
		if(mark > 75) return 2.67;
		if(mark > 70) return 2.33;
		if(mark > 65) return 2.0;
		if(mark > 60) return 1.67;
		if(mark > 55) return 1.33;
		if(mark > 50) return 1.00;
		return 0;
    }
	
    public void getTranscript() { 
    	for(Entry<Course, Mark> m: marks.entrySet()) {
			System.out.format(m.getKey().getName() , m.getKey().getNumberOfCredits() , m.getValue().getGpa());

    	}
    }
    
    
    
}
