package ui;

import java.util.ArrayList;

import models.Task;

public class UI {

	public void printHeader() {

		System.out.println("TaskId   Title           DueDate                    Project");
	}

//	public void toString(Task tasks) {
//		
//		System.out.println(tasks.getId()\tä+ tasks.getTitle()+ tasks.getDueDate()+tasks.getProject());
//	}

	public void printTask(Task tasks) {
		String idString = String.valueOf(tasks.getId());
		String dueDate = String.valueOf(tasks.getDueDate());
		System.out.println(fixLength(idString,9)  + fixLength(tasks.getTitle(),15) + fixLength(dueDate,25)
				+"   " + fixLength(tasks.getProject().getProjectTitle(),10));
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

//	public String fixLength(int start, int length) {
//		String startString = String.valueOf(start);
//		return fixLength(startString, length);
//	}
}
