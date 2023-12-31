package Instruments;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
	
    private static final long serialVersionUID = 1L;
	private String name;
    private String author;
    private int yearOfPublication;
    private static int numberOfBooks;
    
    public Book(String name, String author, int yearOfPublication) {
    	this.name = name;
    	this.author = author;
    	this.yearOfPublication = yearOfPublication;
    }
    
    {
    	Database.getBooks().add(this);
    	setNumberOfBooks(getNumberOfBooks() + 1);
    } 
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	
	public static int getNumberOfBooks() {
		return numberOfBooks;
	}

	public static void setNumberOfBooks(int numberOfBooks) {
		Book.numberOfBooks = numberOfBooks;
	}
	public int hashCode() {
		return Objects.hash(author, name, yearOfPublication);
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(name, other.name) 
				&& yearOfPublication == other.yearOfPublication;
	}

	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", yearOfPublication=" + yearOfPublication + "]";
	}

}