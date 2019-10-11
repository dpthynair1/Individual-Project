package models;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import ui.UI;

public class TaskList {

	Scanner scan = new Scanner(System.in);
	ArrayList<Task> allTasks = new ArrayList<Task>();

	//	Project project = new Project();
	UI ui = new UI();

	public ArrayList<Task> getTask() {
		return allTasks;
	}

	public void setTask(ArrayList<Task> tasks) {
		this.allTasks = tasks;
	}

	public void addTask(Task task) {
		getTask().add(task);
	}

	public void createTask() throws IOException {
		

		System.out.println("Enter your task ");
		String title = scan.next();


		System.out.println("Enter completion date:");
		String date = scan.next();
		LocalDate localDate = LocalDate.parse(date);


		System.out.println("Enter your project");
		String projectTitle = scan.next();

		Task task = new Task(title,localDate,projectTitle);
		allTasks.add(task);
		
		
		FileOutputStream TaskFile = new FileOutputStream("TaskFile.txt");
        Iterator <Task> iterator = allTasks.iterator();
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(TaskFile, "utf-8"))){
            writer.write(("Task ID  Tasks                 Due Date     Project     Status\n-------------------------------------------------------\n"));
            while (iterator.hasNext()){
                task = iterator.next();
                writer.write(task.toString());
            }
        }
        finally {
            TaskFile.close();
        }
        
	}
	
	
	public Task findTask(int id){
		Task tmpTask = null;
		for(Task tsk: allTasks) {
			if(tsk.getId()== id) {
				tmpTask = tsk;
				
				return tmpTask;	
			}
			
		}
		return null;
		
		
	}
	public void removeTask(int id) {
		
		Task tmpTask = this.findTask(id);
		allTasks.remove(tmpTask);
					
	}
	public void updateStatus(int id) {
		Task tmpTask = this.findTask(id);
		if(tmpTask != null) {
			tmpTask.setStatusCompleted(true);
		}
	}
	
	
	
	public void printTasks() {
		ui.printTaskList(allTasks);

	}

}
