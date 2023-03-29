package com.masai.UI;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.LogedUser;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.UserDTO;
import com.masai.DTO.UserDTOImpl;
import com.masai.Exceptions.SomethingWentWrongException;

public class UserUI {
	
	public static void showUserTable() {
		System.out.println();
		System.out.println( "   +------------------------------+"+"\n"
						  + "   | 1 -> "+ ConsoleColors.GREEN +"Update Profile Details "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   | 2 -> "+ ConsoleColors.GREEN +"Change Password  "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   | 3 -> "+ ConsoleColors.GREEN +"Add item to sell  "+ ConsoleColors.RESET +"         |"+"\n"
						  + "   | 4 -> "+ ConsoleColors.GREEN +"Update Details of product       "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   | 5 -> "+ ConsoleColors.GREEN +"Show Products to buy       "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   | 9 -> "+ ConsoleColors.GREEN +"Logout       "+ ConsoleColors.RESET +"            |"+"\n"
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
				updateUserInfo(sc);
				break;
			case 2:
				changePassword(sc);
				break;
			case 9:
				logout();
			}
			
			
		}while(choice != 0);
	}

	private static void logout() {
		// TODO Auto-generated method stub
		UserDAO U = new UserDAOImpl();
		
		U.recordLogout();
		System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + "    Logedout Successfully! " + ConsoleColors.RESET);
		MainUI.main(null);
		
	}

	private static void changePassword(Scanner sc) {
		// TODO Auto-generated method stub
		UserDAO U = new UserDAOImpl();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Old Password: "+ ConsoleColors.RESET +" ");
		String old = sc.next();
		
		if(old.equals(LogedUser.password)) {
			
			System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your new Password: "+ ConsoleColors.RESET +" ");
			String newPass = sc.next();
			
			try {
				U.changePassword(newPass);
				
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + "    Password Changed Successfully " + ConsoleColors.RESET);
			} catch (SomethingWentWrongException e) {
				// TODO Auto-generated catch block
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
				return;
			}
			
		}
		else {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + "    You have Entered Wrong Password" + ConsoleColors.RESET);
			return;
		}
		
		
	}

	private static void updateUserInfo(Scanner sc) {
		// TODO Auto-generated method stub
		UserDAO U = new UserDAOImpl();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your First name: "+ ConsoleColors.RESET +" ");
		String firstname = sc.next();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Last name: "+ ConsoleColors.RESET +" ");
		String lastname = sc.next();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Mobile No: "+ ConsoleColors.RESET +" ");
		String mobile = sc.next();
		sc.nextLine();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your country: "+ ConsoleColors.RESET +" ");
		String country = sc.nextLine();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Password: "+ ConsoleColors.RESET +" ");
		String password = sc.next();
		
		
		UserDTO user = new UserDTOImpl();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setMobile_no(mobile);
		user.setCountry(country);
		user.setPassword(password);
		
		try {
			
			U.updateProfile(user);
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
			return;
		}
		
	}
}
