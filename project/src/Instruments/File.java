package Instruments;

import java.io.Serializable; 
import java.util.Objects;

public class File implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
    private String content;
    
    public File(String name, String content) {
		this.name = name;
		this.content = content;
	}
   
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int hashCode() {
		return Objects.hash(content, name);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		File other = (File) obj;
		return Objects.equals(content, other.content) && Objects.equals(name, other.name);
	}

	public String toString() {
		return "File [name=" + name + ", content=" + content + "]";
	}
}