package Users;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import Instruments.*;
/**
 * The most important class is a Resercher who has a reserch project and paper
 */
public class Researcher implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected final User Researcher;
	public Researcher(User u) {
		this.Researcher = u;
	}
	
	public boolean login(String password) {
		return Researcher.login(password);
	}
	public boolean logout() {
		return Researcher.logout();
	}
	public Vector<News> viewNews() {
		return Researcher.viewNews();
	}
	public String getUsername() {
		return Researcher.getUsername();
	}
	public void setUsername(String username) {
		Researcher.setUsername(username);
	}
	public String getPassword() {
		return Researcher.getPassword();
	}
	public void setPassword(String password) {
		Researcher.setPassword(password);
	}
	public String getName() {
		return Researcher.getName();
	}
	public void setName(String name) {
		Researcher.setName(name);
	}
	public String getSurname() {
		return Researcher.getSurname();
	}
	public void setSurname(String surname) {
		Researcher.setSurname(surname);
	}
	public Date getDateOfBirth() {
		return Researcher.getDateOfBirth();
	}
	public void setDateOfBirth(Date dateOfBirth) {
		Researcher.setDateOfBirth(dateOfBirth);
	}
	public boolean getLogged() {
		return Researcher.getLogged();
	}
	
	public String toString() {
		return Researcher.toString();
	}
}