package ui;

import java.io.IOException;
import java.util.Scanner;

import models.Project;
import models.Task;
import models.TaskList;

public class Main {

	public static void main(String[] args) throws IOException {
		TaskList TL = new TaskList();
		
		UI ui = new UI();
		Scanner scan = new Scanner(System.in);
		String ans = null;
		
		do {
			//Task task = new Task();
			TL.createTask();
//			TL.addTask(task);
			
			// Prompt the user to create another task 
			System.out.println("Enter another task ?(Y/N)");
			ans = scan.next();
			
		}
		while(ans.equalsIgnoreCase("y"));
		
		
		
		
		ui.printHeader();
//		TL.printTasks();
		
		System.out.println(TL.findTask(1));
		
		
		//TL.removeTask(1);
//		TL.printTasks();
		
//		TL.updateStatus(1);
//		TL.printTasks();
	}

}
