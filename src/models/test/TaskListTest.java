package models.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import models.Task;
import models.TaskList;

class TaskListTest {

	Scanner scan = new Scanner(System.in);
	private TaskList list;
	private Task task;
	String title;
	String status = "NOT DONE";
	String date = "2019-11-11";
	LocalDate duedate = LocalDate.parse(date);
	
	public TaskListTest() {
		list = new TaskList();
		Task t = new Task("t2",duedate,"p1",status);
		list.addTask(t);
	}

	
	
	
	
    
	@Test
	void testCreateTask() throws IOException {

		int initialSize = list.getTask().size();
		list.createTask();


//		System.out.println("Enter your task ");
//		title = scan.next();
//
//		for(Task task: allTasks) {
//			if(task.getTitle().equalsIgnoreCase(title)) {
//				System.out.println("Task already exists");
//			    title = scan.next();
//			}
//			
//				
//			}
//
//		System.out.println("Enter a completion date:");
//		String date = scan.next();
//		LocalDate localDate = LocalDate.parse(date);
//
//		System.out.println("Enter your project");
//		String projectTitle = scan.next();
//
//		Task task = new Task(title, localDate, projectTitle, status);
//
//		list.getTask().add(task);
//	

		assertTrue(initialSize == list.getTask().size() - 1);
//		assertEquals(status.equalsIgnoreCase("Not done"), list.getTask);
	}

	@Test
	void testRemoveTask() {

		
	
		System.out.println(list.getTask().size());
		int initialSize = list.getTask().size();
		for(int i= 0;i< list.getTask().size(); i++){
			if(list.getTask().get(i).getTitle().equals("t2")) {
//				 Task tmpTask = list.getTask().get(i);
				 list.removeTask("t2");
			}else {
				System.out.println("not removed");
			}
		}

		
		

		assertTrue(initialSize == list.getTask().size()+1);
	}

}
