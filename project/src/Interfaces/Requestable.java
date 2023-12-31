package Interfaces;

import Instruments.Request;
import Users.Employee;

public interface Requestable{
	String makeRequest(Request request, Employee employee);
}