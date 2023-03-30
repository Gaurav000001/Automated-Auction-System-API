package com.masai.UI;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.UseCases.ChangePassword;
import com.masai.UseCases.DeleteAccount;
import com.masai.UseCases.UpdateUserInformation;

public class AccountActivityUI {
	public static void showAccountActivityTable() {
		System.out.println();
		System.out.println( "   +---------------------------------------+"+"\n"
						  + "   | 1 -> "+ ConsoleColors.GREEN +"Update Profile Details "+ ConsoleColors.RESET +"       	|"+"\n"
						  + "   | 2 -> "+ ConsoleColors.GREEN +"Change Password "+ ConsoleColors.RESET +"            	|"+"\n"
						  + "   | 3 -> "+ ConsoleColors.GREEN +"Delete Account "+ ConsoleColors.RESET +"         		|"+"\n"
						  + "   | 8 -> "+ ConsoleColors.GREEN +"GO BACK "+ ConsoleColors.RESET +"            			|"+"\n"
						  + "   | 9 -> "+ ConsoleColors.GREEN +"Logout "+ ConsoleColors.RESET +"            			|"+"\n"
						  + "   | 0 -> "+ ConsoleColors.GREEN +"Exit "+ ConsoleColors.RESET +"            				|"+"\n"
						  + "   +---------------------------------------+");
	}
	
	public static void accountActivityMain(Scanner sc) {
		int choice;
		
		do {
			showAccountActivityTable();
			
			System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Choice: "+ ConsoleColors.RESET +" ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				UpdateUserInformation.main(sc);
				break;
			case 2:
				ChangePassword.main(sc);
				break;
			case 3:
				DeleteAccount.main(sc);
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
			}
			
			
		}while(choice != 0);
	}
}
