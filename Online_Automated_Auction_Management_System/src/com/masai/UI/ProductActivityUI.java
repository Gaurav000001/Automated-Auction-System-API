package com.masai.UI;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.ProductDAO;
import com.masai.DAO.ProductDAOImpl;
import com.masai.Exceptions.SomethingWentWrongException;
import com.masai.UseCases.AddProduct;
import com.masai.UseCases.UpdateProductDetails;

public class ProductActivityUI {
	static void showProductActivityTable() {
		System.out.println();
		System.out.println( "   +-------------------------------------------------+"+"\n"
						  + "   | 1 -> "+ ConsoleColors.GREEN +"Add a Product on sale "+ ConsoleColors.RESET +"                     |"+"\n"
						  + "   | 2 -> "+ ConsoleColors.GREEN +"Update Product Details "+ ConsoleColors.RESET +"                    |"+"\n"
						  + "   | 3 -> "+ ConsoleColors.GREEN +"Show Items available to buy "+ ConsoleColors.RESET +"               |"+"\n"
						  + "   | 4 -> "+ ConsoleColors.GREEN +"Purchar an Item "+ ConsoleColors.RESET +"            	             |"+"\n"
						  + "   | 5 -> "+ ConsoleColors.GREEN +"Return an Item "+ ConsoleColors.RESET +"            	             |"+"\n"
						  + "   | 8 -> "+ ConsoleColors.GREEN +"GO BACK "+ ConsoleColors.RESET +"            	  	             |"+"\n"
						  + "   | 9 -> "+ ConsoleColors.GREEN +"Logout "+ ConsoleColors.RESET +"                                    |"+"\n"
						  + "   | 0 -> "+ ConsoleColors.GREEN +"Exit "+ ConsoleColors.RESET +"            		             |"+"\n"
						  + "   +-------------------------------------------------+");
	}
	
	public static void productActivityMain(Scanner sc) {
		int choice;
		
		do {
			showProductActivityTable();
			
			System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Choice: "+ ConsoleColors.RESET +" ");
			choice = sc.nextInt();
			System.out.println();
			
			switch(choice) {
			case 1:
				AddProduct.main(sc);
				break;
			case 2:
				UpdateProductDetails.main(sc);
				break;
			case 3:
				DisplayItemsAvailableToBuy();
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 8:
				UserUI.userMain(sc);
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

	public static void DisplayItemsAvailableToBuy() {
		// TODO Auto-generated method stub
		ProductDAO pro = new ProductDAOImpl();
		
		try {
			pro.DisplayItemsAvailableToBuy();
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
		}
	}
	
}
