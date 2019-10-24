
package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import ui.UI;

public class TaskList {

	Scanner scan = new Scanner(System.in);
	ArrayList<Task> allTasks = new ArrayList<Task>();
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

		String status = "NOT DONE";
		String title;

		System.out.println("Enter your task ");
		title = scan.next();
		
			
			

			
	
		for(Task task: allTasks) {
			if(task.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Task already exists");
			    title = scan.next();
			}
			
				
			}
			
		


		System.out.println("Enter a completion date:");
		String date = scan.next();
		LocalDate localDate = LocalDate.parse(date);

		System.out.println("Enter your project");
		String projectTitle = scan.next();

		Task task = new Task(title, localDate, projectTitle, status);
		
		
		
			
		allTasks.add(task);
		
		

		

	}

	public void writeToFile() throws IOException {

		FileOutputStream TaskFile = new FileOutputStream("TaskFile.txt");
		Iterator<Task> iterator = allTasks.iterator();
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(TaskFile, "utf-8"))) {
			writer.write(
					("Task ID\tTasks\tDue Date\tProject\tStatus\n-------------------------------------------------------\n"));
			while (iterator.hasNext()) {

				Task task = iterator.next();
				writer.write(task.toString());

			}
		} finally {
			TaskFile.close();
		}

	}

	public boolean readFromFile() throws FileNotFoundException, IOException {

		int lineNo = 0;
		
		File file = new File("TaskFile.txt");
	       if (!file.exists()) {
	           file.createNewFile();
	       }
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("TaskFile.txt"))) {
			
			

			String line;
			while ((line = br.readLine()) != null) {
				if (++lineNo > 2) {
					String[] taskInfo = line.split("\t");

					allTasks.add(new Task(taskInfo[1], LocalDate.parse(taskInfo[2]), taskInfo[3], taskInfo[4]));

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public Task findTask(String title){

		Task tmpTask = null;
		for (Task tsk : allTasks) {
			if (tsk.getTitle().equalsIgnoreCase(title)) {
				tmpTask = tsk;

				return tmpTask;
			}

		}
		return null;

	}

	public void removeTask(String title){
		
		Task tmpTask = findTask(title);

		allTasks.remove(tmpTask);

	}

//	Update tasks

	public void updateTask(){

		System.out.println("Enter your task");
		String title = scan.next();

		Task tmpTask = findTask(title);
		System.out.println(tmpTask);
		if (tmpTask != null) {

			System.out.println("What would you like to update in the task?");
			System.out.println("1. Update Task title");
			System.out.println("2. Update Due Date");
			System.out.println("3. Update Project");
			System.out.println("4. Update Status To COMPLETED");

			System.out.println("Enter your option(1,2,3,4)");
			int option = scan.nextInt();

			switch (option) {
			case 1:
				System.out.println("Change task");
				String taskTitle = scan.next();
				tmpTask.setTitle(taskTitle);
				break;
			case 2:
				System.out.println("Change date");
				String date = scan.next();
				LocalDate localDate = LocalDate.parse(date);
				tmpTask.setDueDate(localDate);
				break;

			case 3:
				System.out.println("Change Project");
				String projectTitle = scan.next();
				tmpTask.setProject(projectTitle);
				break;
			case 4:
				System.out.println("Is the task completed ?(Y/N)");
				String status = scan.next();
				if (status.equalsIgnoreCase("y")) {
					tmpTask.setStatusCompleted("Completed");
				}

				break;

			default:
				System.out.println("Invalid option!");
				break;

			}

		}
	}

//	Task not completed count

	public int sortTaskNotCompleted() {

		int taskNotCompleted = 0;

		for (Task tsk : allTasks) {

			if (tsk.getStatusCompleted().equalsIgnoreCase("Not done")) {
				taskNotCompleted++;

			}
		}

		return taskNotCompleted;

	}

//	Task completed count
	public int sortTaskCompleted() {

		int taskCompleted = 0;

		for (Task tsk : allTasks) {

			if (tsk.getStatusCompleted().equalsIgnoreCase("Done")) {
				taskCompleted++;

			}
		}
		return taskCompleted;

	}

	Comparator<Task> taskProject = new Comparator<Task>() {
		@Override
		public int compare(Task t1, Task t2) {
			return t1.getProject().compareTo(t2.getProject());
		}
	};

	Comparator<Task> taskDate = new Comparator<Task>() {
		@Override
		public int compare(Task t1, Task t2) {
			return t1.getDueDate().compareTo(t2.getDueDate());
		}
	};

//    Sort by Project
	public void sortByProject() {
		Collections.sort(allTasks, taskProject);

	}

//	Sort by dueDate
	public void sortByDate() {
		Collections.sort(allTasks, taskDate);
	}

//  welcome method
	public void welcome() {
		System.out.println("    Welcome to ToDoLy :)                      ");
		System.out.println("  ^^^^^^^^^^^^^^^^^^^^^^^                     ");
		System.out.println(
				"You have " + sortTaskNotCompleted() + " tasks todo and " + sortTaskCompleted() + " tasks are done!");

	}

//	List options to the user
	public void option() {
		System.out.println("Pick an option:\n" + "(1) Show Task List (by date or project)\n" + "(2) Add New Task\n"
				+ "(3) Edit Task (update, mark as done, remove)\n" + "(4) Save and Quit\n" + "");
	}

//	Print tasks to console
	public void printTasks() {
		ui.printTaskList(allTasks);

	}

// Main program
	public void programRun() throws FileNotFoundException, IOException {
		String ans = null;
		int option;
		
		
		readFromFile();
		welcome();
		
		do {

			option();

			System.out.println("Enter your option");
			option = scan.nextInt();

			switch (option) {
			case 1:
				System.out.println("Do you want to sort list by project or date ?");
				String sort = scan.next();
				if (sort != null && sort.equalsIgnoreCase("project")) {
					sortByProject();
				} else {
					sortByDate();
				}
				break;

			case 2:

				do {
					readFromFile();

					createTask();

					System.out.println("Enter another task ?(Y/N)");
					ans = scan.next();

				} while (ans.equalsIgnoreCase("y"));

				break;
			case 3:
				System.out.println("Do you want to update, mark as done, remove");
				String action = scan.next();
				action.trim();
				printTasks();
				if (action.equalsIgnoreCase("update")) {
					updateTask();
				} else {
					System.out.println("Enter the task title");
					String title = scan.next();
					removeTask(title);
				}
				printTasks();
				break;
			case 4:
				break;

			default:
				System.out.println("Invalid option!");
				break;

			}

		} while (option != 4);

		writeToFile();
	}
	
	
}
