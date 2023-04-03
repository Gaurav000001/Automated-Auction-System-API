package com.masai.UI;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;
import com.masai.Exceptions.SomethingWentWrongException;

public class AdminTransactionActivity {
	private static void AdminTransactionActivityTable() {
		System.out.println();
		System.out.println( "   +-----------------------------------------------------+"+"\n"
						  + "   | 1 -> "+ ConsoleColors.GREEN +"Display All Transactions "+ ConsoleColors.RESET +"                      |"+"\n"
						  + "   | 2 -> "+ ConsoleColors.GREEN +"Display All Transactions for Date range "+ ConsoleColors.RESET +"       |"+"\n"
						  + "   | 3 -> "+ ConsoleColors.GREEN +"Display Transaction by ID "+ ConsoleColors.RESET +"                     |"+"\n"
						  + "   | 8 -> "+ ConsoleColors.GREEN +"GO BACK "+ ConsoleColors.RESET +"            	  	                 |"+"\n"
						  + "   | 9 -> "+ ConsoleColors.GREEN +"Logout "+ ConsoleColors.RESET +"                                        |"+"\n"
						  + "   | 0 -> "+ ConsoleColors.GREEN +"Exit "+ ConsoleColors.RESET +"            		                 |"+"\n"
						  + "   +-----------------------------------------------------+");
	}
	
	public static void AdminTransactionActivityMain(Scanner sc) {
		int choice;
		
		do {
			AdminTransactionActivityTable();
			
			System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Choice: "+ ConsoleColors.RESET +" ");
			choice = sc.nextInt();
			System.out.println();
			
			switch(choice) {
			case 1:
				displayAllTransactions();
				break;
			case 2:
				displayAllTransactionInDateRange(sc);
				break;
			case 3:
				displayTransactionById(sc);
				break;
			case 8:
				AdminUI.adminMain(sc);
				break;
			case 9:
				MainUI.logout();
				break;
			case 0:
				MainUI.exit();
				System.out.print("   "+ ConsoleColors.GREEN_BACKGROUND_BRIGHT +" Thank You for using our services "+ ConsoleColors.RESET +" ");
				System.exit(choice);
				break;
			default:
				System.out.println("   "+ ConsoleColors.RED_BACKGROUND_BRIGHT+" Invalid Input!"+ ConsoleColors.RESET);
			}
			
			
		}while(choice != 0);
	}

	private static void displayAllTransactions() {
		// TODO Auto-generated method stub
		AdminDAO A = new AdminDAOImpl();
		
		try {
			A.displayAllTransactions();
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
		}
	}

	private static void displayAllTransactionInDateRange(Scanner sc) {
		// TODO Auto-generated method stub
		AdminDAO A = new AdminDAOImpl();
		
		System.out.print("   "+ConsoleColors.BLACK_BACKGROUND_BRIGHT+" Enter Start Date (yyyy-MM-dd): "+ConsoleColors.RESET+" ");
		LocalDate start = LocalDate.parse(sc.next());
		
		System.out.print("   "+ConsoleColors.BLACK_BACKGROUND_BRIGHT+" Enter End Date (yyyy-MM-dd): "+ConsoleColors.RESET+" ");
		LocalDate end = LocalDate.parse(sc.next());
		
		try {
			A.displayTransactionsInDateRange(start, end);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
		}
	}

	private static void displayTransactionById(Scanner sc) {
		// TODO Auto-generated method stub
		AdminDAO A = new AdminDAOImpl();
		
		System.out.print("   "+ConsoleColors.BLACK_BACKGROUND_BRIGHT+" Enter Transaction ID: "+ConsoleColors.RESET+" ");
		int id = sc.nextInt();
		
		try {
			A.displayTransactionById(id);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
		}
	}
	
}
