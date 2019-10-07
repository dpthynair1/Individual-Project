package models;

import java.util.ArrayList;
import java.util.Date;

public class Task {
	private int id;
	private String title;
	private Date dueDate;
	private  boolean statusCompleted;
	private Project project;
//	private String projectTitle;
	
	public Task() {
		
	}
	
	
	
	public Task(int id,String title,Date dueDate,Project project) {
		this.id = id;
		this.title = title;
		this.dueDate = dueDate;
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public Project getProject() {
		return project;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

//	public void setprojectTitle(String title) {
//		this.projectTitle = title;
//	}
	public boolean isStatusCompleted() {
		return statusCompleted;
	}

	public void setProject(Project project) {
		this.project = project;
	}



	public void setStatusCompleted(boolean statusCompleted) {
		this.statusCompleted = statusCompleted;
	}

	public String toString() {
		return this.getId() + " " + this.getTitle() + " " + this.getDueDate() + " " + this.getProject();
	}

}


