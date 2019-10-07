package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import ui.UI;



public class TaskList {
	
    Scanner scan = new Scanner(System.in);
	ArrayList<Task> allTasks = new ArrayList<Task>();
	Task task = new Task();
	Project project = new Project();
	UI ui = new UI();
	

	public ArrayList<Task> getTask() {
		return allTasks;
	}

	public void setTask(ArrayList<Task> tasks) {
		this.allTasks = tasks;
	}
	
	
	public void createTask() {
//		Random random = new Random();
//		int id =  random.nextInt(6) + 0;
//		task.setId(id);
		task.setId(1);
		System.out.println("Enter your task ");
		String title = scan.nextLine();
		task.setTitle(title);
		System.out.println(task.getTitle());
		
		System.out.println("Enter completion date");
		String dateString = scan.next();
		DateFormat  formatter = new SimpleDateFormat("YYYY-MM-dd");
		try {
			Date date = formatter.parse(dateString);
			task.setDueDate(date);
			System.out.println(task.getDueDate());
		} catch (ParseException e) {
			System.out.println("Error in DateFormat");
		}
		
		
		System.out.println("Enter your project");
		String  projectTitle = scan.next();
		project.setProjectTitle(projectTitle);
		task.setProject(project);
		System.out.println(task.getProject().getProjectTitle());
		
		task.setStatusCompleted(false);
		
		allTasks.add(task);
		
	
		}
	
	public void printTasks() {
		ui.printTaskList(allTasks);
		
	}
	
//	public void printTasks() {
//		ui.printTask(task);
//	}
	  
	
	 
	
	
	
}
