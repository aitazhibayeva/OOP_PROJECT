package Users;
import java.io.Serializable;

import java.util.*;

import Enums.RequestType;
import Instruments.*;
import Interfaces.*;

/**All employees can view students, can send messages within each other, also they can make request to Managers or TechSupportWorkers.*/

public abstract class Employee extends User implements Requestable, WriteableComment, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
    private Date hireDate;
    private double salary;
    private String insuranceNumber;
    private LinkedHashMap <Employee, Message> email;
    
    public Employee() {
    }
    
    public Employee(String id, Date hireDate, double salary, String insuranceNumber) {
        this.id = id;
        this.hireDate = hireDate;
        this.salary = salary;
        this.insuranceNumber = insuranceNumber;
        this.email = new LinkedHashMap<Employee, Message>();
    }
    
    /**
     * Views all the students of university*/
    public Vector<Student> viewStudent() {
    	return Database.getStudents();
    }
    
    /**
     * To send message to another employee*/
  	public void sendMessage(Message message, Employee employee) {
  		employee.getEmail().put(this, message);
  	}
  	
  	/**
  	 * To make request to Manager or TechSupportWorker
  	 * */
    public String makeRequest(Request request, Employee employee) {
    	if(employee instanceof TechSupport) { 
    		if(request.getDescription().length() > 10 && request.getTitle().equals(RequestType.SIMPLE_REQUEST)) {
    			TechSupport t = (TechSupport)employee;
    			t.getRequests().add(request);
    			Database.getUserActions().add(new Action(this, new Date(), String.format("Employee: %s made request to Tech support worker %s", getFullName(), t.getFullName())));
    			return "Your request has been sended";
    		} 
    		else {
        		return "Your request is rejected";	
        	}
    	}
    	 
    	else if(employee instanceof Manager) {
    		Manager m = (Manager)employee;
    		m.getRequests().add(request);
    		Database.getUserActions().add(new Action(this, new Date(), String.format("Employee: %s made request to manager %s", getFullName(), getFullName())));
    		return "Your request has been sended to manager";
    	}
    	return "";
    }
    
    /**
     * To write a comment under the news
     * */
  	public void writeComment(String comment, News n) {
  		n.getComments().add(comment);
  	}
  	
  	/**
  	 * View all student in requested order alphabetically or by gpa
  	 * */
  	public Vector<Student> viewStudentBy(int viewBy) {
  		Vector<Student> v = Database.getStudents();
  		if(viewBy == 1){ 
  			Collections.sort(v);
  		}
  		if(viewBy == 2) { 
  			Collections.sort(v, new GpaComparator());
  		}
  		return v;
  	}

  	public int hashCode() {
  		return Objects.hash(email, hireDate, id, insuranceNumber, salary);
  	}

  	public boolean equals(Object obj) {
  		if (this == obj) return true;
  		if (obj == null) return false;
  		if (getClass() != obj.getClass()) return false;
  		Employee other = (Employee) obj;
  		return Objects.equals(email, other.email) && Objects.equals(hireDate, other.hireDate)
  				&& Objects.equals(id, other.id) && Objects.equals(insuranceNumber, other.insuranceNumber)
  				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
  	}  
  	
    public String getId() {
    	return id;
    }

    public void setId(String id) {
    	this.id = id;
    }

    public Date getHireDate() {
    	return hireDate;
    }

    public void setHireDate(Date hireDate) {
    	this.hireDate = hireDate;
    }

    public double getSalary() {
    	return salary;
    }

    public void setSalary(double salary) {
    	this.salary = salary;
    }

    public String getInsuranceNumber() {
    	return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
    	this.insuranceNumber = insuranceNumber;
    }

    public  LinkedHashMap <Employee, Message> getEmail() {
    	return email;
    }

    public void setEmail(LinkedHashMap <Employee, Message> email) {
    	this.email = email;
    }

	public String toString() {
		return "Employee [id=" + id + ", hireDate=" + hireDate + ", salary=" + salary + ", insuranceNumber="
				+ insuranceNumber + ", email=" + email + "]";
	}
    
}