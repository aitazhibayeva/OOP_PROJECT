package Interfaces;

import Instruments.ResearchPaper;
import Instruments.ResearchProject;

public interface Researchable {
	public void addResearchPaper(ResearchPaper researchPaper);
	public void addResearchProject(ResearchProject researchProject);
	public int getHindex();
}
