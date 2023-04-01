package com.masai.UI;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.AdminDAO;
import com.masai.DAO.AdminDAOImpl;
import com.masai.DAO.ProductDAO;
import com.masai.DAO.ProductDAOImpl;
import com.masai.Exceptions.NoRecordFoundException;

public class AdminProductActivityUI {
	private static void displayAdminProductActivityTable() {
		System.out.println();
		System.out.println( "   +-------------------------------------------------+"+"\n"
						  + "   | 1 -> "+ ConsoleColors.GREEN +"Display All Items to be sold "+ ConsoleColors.RESET +"              |"+"\n"
						  + "   | 2 -> "+ ConsoleColors.GREEN +"Display All Items already sold "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   | 3 -> "+ ConsoleColors.GREEN +"Display Items by category "+ ConsoleColors.RESET +"                 |"+"\n"
						  + "   | 8 -> "+ ConsoleColors.GREEN +"GO BACK "+ ConsoleColors.RESET +"            	  	             |"+"\n"
						  + "   | 9 -> "+ ConsoleColors.GREEN +"Logout "+ ConsoleColors.RESET +"                                    |"+"\n"
						  + "   | 0 -> "+ ConsoleColors.GREEN +"Exit "+ ConsoleColors.RESET +"            		             |"+"\n"
						  + "   +-------------------------------------------------+");
	}
	
	public static void adminProductActivityMain(Scanner sc) {
		int choice;
		
		do {
			displayAdminProductActivityTable();
			
			System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Choice: "+ ConsoleColors.RESET +" ");
			choice = sc.nextInt();
			System.out.println();
			
			switch(choice) {
			case 1:
				displayAllItemsToBeSold();
				break;
			case 2:
				displayAllItemsAlreadySold();
				break;
			case 3:
				displayItemsByCategory(sc);
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

	private static void displayItemsByCategory(Scanner sc) {
		// TODO Auto-generated method stub
		ProductDAO p = new ProductDAOImpl();
		AdminDAO A = new AdminDAOImpl();
		
		System.out.println();
		p.displayCategories();
		System.out.println("   "+ ConsoleColors.RED + " Enter CategoryID from Above Table Only " + ConsoleColors.RESET + "\n");
		
		System.out.println();
		System.out.print("   "+ConsoleColors.BLACK_BACKGROUND_BRIGHT+" Enter CategoryID: "+ConsoleColors.RESET+" ");
		int catId = sc.nextInt();
		
		try {
			A.displayAllProductsByCategory(catId);
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
		}
	}

	private static void displayAllItemsAlreadySold() {
		// TODO Auto-generated method stub
		AdminDAO A = new AdminDAOImpl();
		
		try {
			A.displayAllProductsAlreadySold();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
		}
	}

	private static void displayAllItemsToBeSold() {
		// TODO Auto-generated method stub
		AdminDAO A = new AdminDAOImpl();
		
		try {
			A.displayAllProductsToBeSold();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
		}
	}
	
}
