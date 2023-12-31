package Users;
import java.util.*;
import Instruments.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**Admin is responsible for technical part of university system.*/

public class Admin extends User implements Serializable  {

	private static final long serialVersionUID = 1L;
	private static Vector<Action> logFiles;

	public Admin() {}
	
	public static Vector<Action> getLogFiles() {
		return logFiles;
	}

	public static void setLogFiles(Vector<Action> logFiles) {
		Admin.logFiles = logFiles;
	}
	
	
	{
		Database.getUsers().add(this);
	}
	
	/**
	 * To add user to university system
	 * */
    public void addUser(User u) {
		Database.getUserActions().add(new Action(this, new Date(), String.format("Admin: %s added user: %s", getFullName(), u.getFullName())));
    }

	/**
	 * To remove user from university system
	 * */
    public String removeUser(User u) {
    	if(Database.getUsers().contains(u)) {
    		Database.getUsers().remove(u);
    		Database.getUserActions().add(new Action(this, new Date(), String.format("Admin: %s removed user: %s", getFullName(), u.getUsername())));
    		return "User removed";
    	} else {
    		return "User not found";
    	}
    }
    
    /**
     * To update user's information
     * */
    public void updateUser(User u, int type, String toChange) throws Exception {
    	if(type == 1) {              
    		u.setUsername(toChange);
    	}
    	else if(type == 2) {         
    		u.setName(toChange);
    	}
    	else if(type == 3) {         
    		u.setSurname(toChange);
    	}
    	else if(type == 4) {       
    		u.setPassword(toChange);
    	}
    	else if(type == 5) {       
    		u.setDateOfBirth(new SimpleDateFormat("yyyy/MM/dd").parse(toChange));
    	}
		Database.getUserActions().add(new Action(this, new Date(), String.format("User: %s updated user: %s", getFullName(), u.getFullName())));
    }
    /**
     * Allows to see all user actions
     * */
    public Vector<Action> seeUsersActions() {
    	return Database.getUserActions();
    }
    
    public Vector<Action> seeUserActions(User u) {
    	Vector<Action> v = new Vector<Action>();
    	for(Action a : Database.getUserActions()) {
    		if(a.getUser().equals(u)) {
    			v.add(a);
    		}
    	}
    	return v;
    }

}