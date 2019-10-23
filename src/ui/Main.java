package ui;

import java.io.IOException;
import java.util.Scanner;
import models.Task;
import models.TaskList;


public class Main {

	public static void main(String[] args) throws IOException{
		TaskList TL = new TaskList();

		UI ui = new UI();
		Scanner scan = new Scanner(System.in);
		String ans = null;
		int option;
		
		
		TL.readFromFile();
		TL.welcome();
		
		do {

			TL.option();

			System.out.println("Enter your option");
			option = scan.nextInt();

			switch (option) {
			case 1:
				System.out.println("Do you want to sort list by project or date ?");
				String sort = scan.next();
				if (sort != null && sort.equalsIgnoreCase("project")) {
					TL.sortByProject();
				} else {
					TL.sortByDate();
				}
				break;

			case 2:

				do {
					TL.readFromFile();

					TL.createTask();

					System.out.println("Enter another task ?(Y/N)");
					ans = scan.next();

				} while (ans.equalsIgnoreCase("y"));

				break;
			case 3:
				System.out.println("Do you want to update, mark as done, remove");
				String action = scan.next();
				action.trim();
				TL.printTasks();
				if (action.equalsIgnoreCase("update")) {
					TL.updateTask();
				} else {
					System.out.println("Enter the task title");
					String title = scan.next();
					TL.removeTask(title);
				}
				TL.printTasks();
				break;
			case 4:
				break;

			default:
				System.out.println("Invalid option!");
				break;

			}

		} while (option != 4);

		TL.writeToFile();

	}

}
