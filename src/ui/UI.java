package ui;

import java.util.ArrayList;

import models.Task;

public class UI {

	public void printHeader() {

		System.out.println("Task ID  Tasks                 Due Date     Project     Status");
		System.out.println("**************************************************************");
	}



	public void printTask(Task tasks) {
		String idString = String.valueOf(tasks.getId());
		String dueDate = String.valueOf(tasks.getDueDate());
		System.out.println(fixLength(idString,7)  + "  " +fixLength(tasks.getTitle(),20) +"  " + fixLength(dueDate,11)
				+"  " + fixLength(tasks.getProject(),10)+"  "+fixLength(tasks.isStatusCompleted(), 12) );
	}
	
	private String fixLength(String start, int length){
        if(start.length() >= length){
            return start.substring(0, length);
        }
        else {
            while (start.length() < length){
                start += " ";
            }
            return start;
        }
    }
	
	public void printTaskList(ArrayList<Task> allTasks) {
		for(Task task: allTasks) {
			if(task != null) {
				printTask(task);
			}
		}
	}


}
