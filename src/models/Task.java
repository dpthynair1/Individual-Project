package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Task {
	private int id = 0;
	private static int counter = 1;
	private String title;
	private LocalDate dueDate;
	private  boolean statusCompleted;
	private String project;

	
//	public Task() {
//		
//	}
	
	
	
	public Task(String title,LocalDate dueDate,String project) {
		this.id = counter++;
		this.title = title;
		this.dueDate = dueDate;
		this.project = project;
		this.statusCompleted = false;
	}

	public int getId() {
//		id = counter++;
		return id;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public String getProject() {
		return project;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public String isStatusCompleted() {
		String taskCompleted;
		
		if(statusCompleted ) {
			taskCompleted = "completed";
			
		}
		else {
			taskCompleted = "Not done";
		}
		
		
		
		
		return taskCompleted;
	}

	public void setProject(String project) {
		this.project = project;
	}



	public void setStatusCompleted(boolean statusCompleted) {
		this.statusCompleted = statusCompleted;
	}

	public String toString() {
		return this.getId() + " " + this.getTitle() + " " + this.getDueDate() + " " + this.getProject() 
		+ "\n";
	}

}


