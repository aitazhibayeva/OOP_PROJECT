package Menu;
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import Users.*;
import Instruments.*;
/**
 * Tester to check our University System
 */
public class Tester {
	public static void main(String[] args) throws Exception {
		
		Database.loadAttributes();

		InputStreamReader myStream = new InputStreamReader(System.in);        
		BufferedReader reader = new BufferedReader(myStream);		
				
		System.out.println("""
				1. Login
				0. Exit""");
		
		while(true) {
			String input = reader.readLine();
			if(input.equals("1")) {
				System.out.println("""
					Choose your role:
					1. Teacher
					2. Student
					3. Manager
					4. Librarian
					5. Tech support 
					6. Dean
					7. Parent 
					8. Admin
					0. Cancel""");
				input = reader.readLine();
				if(input.equals("0")) {
					break;
				}
				User user = findUser(input, reader);

				//////////////////////////////////////
			} else if(input.equals("0")) {
				System.out.println("Have a nice day!");
				break;
			}

		}
	}
	/**
	 * To find User
	 * @param input
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public static User findUser(String input, BufferedReader reader) throws IOException {
		System.out.print("Enter your username: ");
		String username = reader.readLine();
		System.out.print("Enter your password: ");
		String password = reader.readLine();
		for(User u : Database.getUsers()) {
			if(u.getUsername().equals(username)) {
				if(u.login(password)) {
					return u;
				}
				else {
					System.out.println("Password is incorrect."); 
					return null;
				}
			}
		}
		System.out.println("User not found.");
		return null;
	}
	
	public static boolean checkLogin(User u, String username, String password) {
		if(u.getUsername().equals(username)) {
			if(u.login(password)) {
				return true;
			}
			else {
				System.out.println("Password is incorrect.");
			}
		}
		return false;
	}
	/**
	 * To send Message
	 * @param e
	 * @param reader
	 * @throws IOException
	 */
	public static void sendMessage(Employee e, BufferedReader reader) throws IOException {
		System.out.print("Enter text of the message: ");
		String text = reader.readLine();
		Message m = new Message(new Date(), text);
		for(Employee ee : Database.getEmployees()) {
			System.out.println(String.format(("Id: %s, name: %s"), ee.getId(), ee.getFullName()));
		}
		System.out.print("\nEnter employee id you want to message to: ");
		String id = reader.readLine();
		Employee employee = Database.getEmployeeById(id);
		if(employee != null) {
			e.sendMessage(m, employee);
			System.out.println("Message sent.");
		} 
		else {
			System.out.println("Employee not found.");
		}
	}
	
	/**
	 * To View Student
	 * @param employee
	 * @param reader
	 * @throws IOException
	 */
	public static void viewStudent(Employee employee, BufferedReader reader) throws IOException {
		for(Student s : Database.getStudents()) {
			System.out.println(String.format("Id: %s, %s, year of study: %s, school: %s ", s.getId(), s.getFullName(), s.getYearOfStudy(), s.getSchool().getName()));
		}
		while(true) {
			System.out.println("1. Sort alphabetically.\n2. Sort by gpa.\n3. Back");
			String option = reader.readLine();
			if(option.equals("3")) {
				break;
			} else if(option.equals("1") || option.equals("2")) {
				for(Student s : employee.viewStudentBy(Integer.parseInt(option))) {
					System.out.println(String.format("Id: %s, %s, year of study: %s, school: %s ", s.getId(), s.getFullName(), s.getYearOfStudy(), s.getSchool().getName()));
				}
			}
		}
	}
	/**
	 * Read message 
	 * @param employee
	 * @param reader
	 */
	public static void readMessages(Employee employee, BufferedReader reader) {
		if(employee.getEmail().size() == 0) {
			System.out.println("You don't have messages.");
		} else {
			for(Employee e : employee.getEmail().keySet()) {
				Message m = employee.getEmail().get(e);
				System.out.println("Message from: " + e.getFullName() + ", text: " + m.getText() + ", date: " + m.getDate());
			}
		}
	}
}