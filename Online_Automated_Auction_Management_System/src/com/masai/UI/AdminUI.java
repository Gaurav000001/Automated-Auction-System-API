package com.masai.UI;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;
import com.masai.Exceptions.NoRecordFoundException;

public class AdminUI {
	
	public static void showAdminTable(){
		System.out.println();
		System.out.println( "   +-----------------------------------------+"+"\n"
						  + "   | 1. -> "+ ConsoleColors.GREEN +"Show all users  "+ ConsoleColors.RESET +"           	    |"+"\n"
						  + "   | 2. -> "+ ConsoleColors.GREEN +"Products related activity  "+ ConsoleColors.RESET +"       |"+"\n"
						  + "   | 3. -> "+ ConsoleColors.GREEN +"Transaction related activity "+ ConsoleColors.RESET +"     |"+"\n"
						  + "   | 9. -> "+ ConsoleColors.GREEN +"Logout        "+ ConsoleColors.RESET +"                    |"+"\n"
						  + "   | 0. -> "+ ConsoleColors.GREEN +"Exit        "+ ConsoleColors.RESET +"                      |"+"\n"
						  + "   +-----------------------------------------+");
	}
	
	
	private static void productActivityChart(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	
	private static void transactionActivityChart(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void adminMain(Scanner sc) {
		int choice;
		
		do {
			showAdminTable();
			
			System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Choice: "+ ConsoleColors.RESET +" ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				showAllUsers();
				break;
			case 2:
				productActivityChart(sc);
				break;
			case 3:
				transactionActivityChart(sc);
				break;
			case 9:
				MainUI.logout();
				break;
			case 0:
				MainUI.exit();
				System.out.print("   "+ ConsoleColors.GREEN_BACKGROUND_BRIGHT +" Thank You for using our services "+ ConsoleColors.RESET +" ");
				System.exit(choice);
			}
			
			
		}while(choice != 0);
	}


	private static void showAllUsers() {
		// TODO Auto-generated method stub
		AdminDAO D = new AdminDAOImpl();
		
		try {
			D.showAllUsers();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " "+ ConsoleColors.RESET);
		}
		
	}





	
	
}
