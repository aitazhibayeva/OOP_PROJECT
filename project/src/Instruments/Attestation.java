package Instruments;

import java.io.Serializable;


/**
 */
public class Attestation implements Serializable 
{

	private static final long serialVersionUID = 1L;
	private Course course;
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    

    
    public Attestation(Course course, double firstAttestation) {
      this.course = course;
      this.firstAttestation = firstAttestation;
      secondAttestation = 0;
      finalExam = 0;
    }

    
    public String toString() {
      return course.getName() + ": " + "first att: " + this.getFirstAttestation() + ", second att: " + this.getSecondAttestation() + ", final: " + this.getFinalExam();
    }
    

  public double getFirstAttestation() {
    return firstAttestation;
  }


  public void setFirstAttestation(double firstAttestation) {
    this.firstAttestation = firstAttestation;
  }


  	public double getSecondAttestation() {
	  return secondAttestation;
  	}


  	public void setSecondAttestation(double secondAttestation) {
	  this.secondAttestation = secondAttestation;
  	}


  	public double getFinalExam() {
	  return finalExam;
  	}


  	public void setFinalExam(double finalExam) {
	  this.finalExam = finalExam;
    }


  	public Course getCourse() {
	    return course;
	}
	
	
	public void setCourse(Course course) {
	   this.course = course;
	}
	  
	
}
	
