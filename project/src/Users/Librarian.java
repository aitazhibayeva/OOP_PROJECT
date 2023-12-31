package Users;

import java.io.Serializable; 
import java.util.*;

import Instruments.*;
/**Librarian takes order of Students, checking students for debt.*/

public class Librarian extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private Vector<Order> takers;
  
    public Librarian() {
    }

    public Librarian(User user, String id, Date hireDate, double salary, String insuranceNumber) {
        super(id, hireDate, salary, insuranceNumber);
        this.takers = new Vector<Order>();
    }
    
    {
		Database.getUsers().add(this);
    }
    
    public Vector<Order> getTakers() {
    	return takers;
    }
  
    public void setTakers(Vector<Order> takers) {
    	this.takers = takers;
    }
    
    /**
     * checks if the student owes books to the library
     * */
    public String checkForDebt(Student student) {	
    	for(Order order: takers) {
    		if(student.equals(order.getStudent())) {
    			return "You have taken book: " + order.getBook().getName() + ", Author: " + order.getBook().getAuthor();
    		}
    	}
    	return "You havn't debts";
    }
  
    public int hashCode() {
    	final int prime = 31;
    	int result = super.hashCode();
    	result = prime * result + Objects.hash(takers);
    	return result;
    }
  
    public boolean equals(Object obj) {
    	if (this == obj) return true;
    	if (!super.equals(obj)) return false;
    	if (getClass() != obj.getClass()) return false;
    	Librarian other = (Librarian) obj;
    	return Objects.equals(takers, other.takers);
    }
    
	public String toString() {
		return "Librarian [takers=" + takers + "]";
	}

    
}