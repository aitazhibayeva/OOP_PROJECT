package Users;

import Instruments.*;
import Interfaces.*;

import java.io.Serializable;
import java.util.*;
/**
 * For decorating Student*/

public class StudentResearcher extends Researcher implements Researchable, Serializable {
	private static final long serialVersionUID = 5133030162836155384L;
	private Vector<ResearchPaper> researchPapers;
	private Vector<ResearchProject> researchProjects;
	
	public StudentResearcher(User u, Vector<ResearchPaper> researchPapers, Vector<ResearchProject> researchProjects) {
		super(u);
		this.researchPapers = researchPapers;
		this.researchProjects = researchProjects;
	}

	{
		researchPapers = new Vector<ResearchPaper>();
		researchProjects = new Vector<ResearchProject>();
	}
	
	/**
	 * Adds research paper*/

	public void addResearchPaper(ResearchPaper researchPaper) {
		getResearchPapers().add(researchPaper);
	}
	/**
	 * Adds research project*/
	public void addResearchProject(ResearchProject researchProject) {
		getResearchProjects().add(researchProject);
	}
	/**
	 * Calculates h-index*/

	public int getHindex() {
		int hIndex = 0;
		for(ResearchProject r : researchProjects) {
			int temp = r.getCitations().size();
			int cnt = 0;
			for(ResearchProject w : researchProjects) {
				if(w.getCitations().size()>=temp) cnt++;
				if(cnt>=temp)break;
			}
			if(cnt>=temp && temp>hIndex) hIndex = temp;
		}
		return hIndex;
	}

	public Vector<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}


	public Vector<ResearchProject> getResearchProjects() {
		return researchProjects;
	}
	
	public void setResearchPapers(Vector<ResearchPaper> v) {
		this.researchPapers = v;
	}
	
	public void setResearchProjects(Vector<ResearchProject> v) {
		this.researchProjects = v;
	}

}
