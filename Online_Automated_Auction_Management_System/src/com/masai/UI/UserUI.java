package com.masai.UI;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.LogedUser;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.UserDTO;
import com.masai.DTO.UserDTOImpl;
import com.masai.Exceptions.SomethingWentWrongException;
import com.masai.UseCases.UpdateUserInformation;

public class UserUI {
	
	public static void showUserTable() {
		System.out.println();
		System.out.println( "   +------------------------------+"+"\n"
						  + "   | 1 -> "+ ConsoleColors.GREEN +"Account Related Activity "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   | 2 -> "+ ConsoleColors.GREEN +"Product Related Activity  "+ ConsoleColors.RESET +"         |"+"\n"
						  + "   | 3 -> "+ ConsoleColors.GREEN +"Transaction Related Activity  "+ ConsoleColors.RESET +"         |"+"\n"
						  + "   | 9 -> "+ ConsoleColors.GREEN +"Logout       "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   | 0 -> "+ ConsoleColors.GREEN +"Exit       "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   +------------------------------+");
	}
	
	public static void userMain(Scanner sc) {
		int choice;
		
		do {
			showUserTable();
			
			System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Choice: "+ ConsoleColors.RESET +" ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				AccountActivityUI.accountActivityMain(sc);
				break;
			case 2:
				
				break;
			case 3:
				
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



	



	
}
