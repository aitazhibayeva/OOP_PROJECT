package Users;
import java.io.Serializable; 
import java.util.Vector;

import Instruments.ResearchPaper;
import Instruments.ResearchProject;
import Interfaces.*;
/**For decorating Teacher*/

public class TeacherResearcher extends Researcher implements Researchable, Serializable {
	
	private static final long serialVersionUID = 1L;
	private Vector<ResearchPaper> researchPapers;
	private Vector<ResearchProject> researchProjects;
	
	public TeacherResearcher(User u, Vector<ResearchPaper> researchPapers, Vector<ResearchProject> researchProjects) {
		super(u);
		this.researchPapers = researchPapers;
		this.researchProjects = researchProjects;
	}

	{
		researchPapers = new Vector<ResearchPaper>();
		researchProjects = new Vector<ResearchProject>();
	}
	
	/**Adds research paper*/

	public void addResearchPaper(ResearchPaper researchPaper) {
		getResearchPapers().add(researchPaper);
	}
	/**Adds research project*/

	public void addResearchProject(ResearchProject researchProject) {
		getResearchProjects().add(researchProject);
	}
	/**Calculates h-index*/

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
}
