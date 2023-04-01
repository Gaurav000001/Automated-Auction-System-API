package com.masai.UI;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.LogedUser;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.UserDTO;
import com.masai.DTO.UserDTOImpl;
import com.masai.Exceptions.SomethingWentWrongException;
import com.masai.UseCases.RegisterNewUser;

public class MainUI {
	
	public static int homeMenu(Scanner sc) {
		System.out.println();
		System.out.println( "   +------------------------------+"+"\n"
						  + "   | 1 -> "+ ConsoleColors.GREEN +"Admin Login "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   | 2 -> "+ ConsoleColors.GREEN +"User Login  "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   | 3 -> "+ ConsoleColors.GREEN +"Register User  "+ ConsoleColors.RESET +"         |"+"\n"
						  + "   | 0 -> "+ ConsoleColors.GREEN +"Exit        "+ ConsoleColors.RESET +"            |"+"\n"
						  + "   +------------------------------+");
		
		System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Choice: "+ ConsoleColors.RESET +" ");
		int choice = sc.nextInt();
		
		return choice;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int choice = homeMenu(sc);
		
		switch(choice) {
		
		case 1:
			adminLogin(sc);
			break;
			
		case 2:
			userLogin(sc);
			break;
			
		case 3:
			RegisterNewUser.main(sc);
			break;
		case 0:
			
			System.out.println("\n   "+ ConsoleColors.PURPLE_BACKGROUND_BRIGHT +" Happy to have you! Come back soon!! "+ ConsoleColors.RESET +"");
			System.exit(choice);
			break;
		default:
			System.out.println("   "+ ConsoleColors.RED_BACKGROUND_BRIGHT+" Invalid Input!"+ ConsoleColors.RESET);
			
		}
	}


	public static void adminLogin(Scanner sc) {
		// TODO Auto-generated method stub
		UserDAO U = new UserDAOImpl();
		
		System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your username: "+ ConsoleColors.RESET +" ");
		String username = sc.next();
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your password: "+ ConsoleColors.RESET +" ");
		String password = sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			System.out.println("\n   "+ ConsoleColors.GREEN_BACKGROUND_BRIGHT +" LogedIn Successfully! 😁"+ ConsoleColors.RESET +"");
			LogedUser.adminLoged = true;
			U.recordLogin();
			AdminUI.adminMain(sc);
		}
		else {
			System.out.println("\n   "+ ConsoleColors.RED_BACKGROUND_BRIGHT +" Wrong Username OR Password! Please try again "+ ConsoleColors.RESET +"");
			MainUI.main(null);
		}
	}
	
	
	public static void userLogin(Scanner sc) {
		UserDAO U = new UserDAOImpl();
		
		System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your username: "+ ConsoleColors.RESET +" ");
		String username = sc.next();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your password: "+ ConsoleColors.RESET +" ");
		String password = sc.next();
		
		try {
			if(U.userLogin(username, password)) {
				System.out.println("\n   "+ ConsoleColors.GREEN_BACKGROUND_BRIGHT +" LogedIN Successfully! 😁"+ ConsoleColors.RESET);
				U.recordLogin();
				UserUI.userMain(sc);
			}
			else {
				System.out.println("\n   "+ ConsoleColors.RED_BACKGROUND_BRIGHT +" Wrong Username OR Password! Please try again "+ ConsoleColors.RESET);
				MainUI.main(null);
			}
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
		}
	}
	
	
	
	public static void logout() {
		// TODO Auto-generated method stub
		UserDAO U = new UserDAOImpl();
		
		U.recordLogout();
		System.out.println("   " +ConsoleColors.GREEN_BACKGROUND_BRIGHT + " Logedout Successfully! " + ConsoleColors.RESET);
		MainUI.main(null);
		
	}
	
	
	public static void exit() {
		UserDAO U = new UserDAOImpl();
		
		U.recordLogout();
		System.out.println("   " +ConsoleColors.GREEN_BACKGROUND_BRIGHT + " Logedout Successfully! " + ConsoleColors.RESET);
		
	}

}
