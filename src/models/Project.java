package models;

import java.util.ArrayList;

public class Project {
	
	private String projectTitle;
	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	
	
	
}
