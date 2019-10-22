package models;

import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Task {
	private int id = 0;
	private static int counter = 1;
	private String title;
	private LocalDate dueDate;
	private String statusCompleted;
	private String project;
	

	public Task() {

	}

	public Task(String title, LocalDate dueDate, String project, String statusCompleted) {
		this.id = counter++;
		this.title = title;
		this.dueDate = dueDate;
		this.project = project;
		this.statusCompleted = statusCompleted;

	}

//	Property method

	public int getId() {
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

	public String getStatusCompleted() {

		return statusCompleted;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void setStatusCompleted(String statusCompleted) {

		this.statusCompleted = statusCompleted;
	}
	
//	To string 
    @Override
	public String toString() {
		return id + "\t" + title + "\t" + dueDate + "\t" + project + "\t" + getStatusCompleted() + "\t" + "\n";
	}

}
