package Users;

import java.io.Serializable;
import java.util.*;

import Instruments.*;
/**
 * TechSupportWorker handles technical requests from employees and students.
 * */

public class TechSupport extends Employee implements Serializable  {

	private static final long serialVersionUID = 1L;
	private Vector<Request> requests;
	
	public TechSupport() {
	}

	public TechSupport( String id, Date hireDate, double salary, String insuranceNumber) {
		super(id, hireDate, salary, insuranceNumber);
		this.requests = new Vector<Request>();
	}
	
	{
		Database.getUsers().add(this);
	}
	
	public Vector<Request> getRequests() {
		return requests;
	}

	public void setRequests(Vector<Request> requests) {
		this.requests = requests;
	}
	

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(requests);
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (getClass() != obj.getClass()) return false;
		TechSupport other = (TechSupport) obj;
		return Objects.equals(requests, other.requests);
	}
	
	public String toString() {
		return "TechSupportWorker [requests=" + requests + "]";
	}

	
}