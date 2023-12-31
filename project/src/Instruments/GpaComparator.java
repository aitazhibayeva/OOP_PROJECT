package Instruments;

import java.util.Comparator;

import Users.Student;

public class GpaComparator implements Comparator<Student>{
	public int compare(Student s1, Student s2) {
		if(s1.getGpa() > s2.getGpa()) return 1;
		if(s1.getGpa() < s2.getGpa()) return -1;
		return 0;
	}
}
