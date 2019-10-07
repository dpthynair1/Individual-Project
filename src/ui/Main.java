package ui;

import models.Project;
import models.Task;
import models.TaskList;

public class Main {

	public static void main(String[] args) {
		TaskList TL = new TaskList();
		Task task = new Task();
		UI ui = new UI();
		
		TL.createTask();
		ui.printHeader();
		TL.printTasks();
		
//		System.out.println(task.getTitle());
		
		
		
	   
	   

	}

}
