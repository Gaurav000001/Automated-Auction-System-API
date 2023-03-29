package com.masai.UI;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.LogedUser;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.UserDTO;
import com.masai.DTO.UserDTOImpl;
import com.masai.Exceptions.SomethingWentWrongException;

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
			registerUser(sc);
			break;
		case 0:
			
			System.out.println("\n   "+ ConsoleColors.PURPLE_BACKGROUND_BRIGHT +" Happy to have you! Come back soon!! "+ ConsoleColors.RESET +"");
			System.exit(choice);
			
		}
	}


	static void adminLogin(Scanner sc) {
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
		}
		else {
			System.out.println("\n   "+ ConsoleColors.RED_BACKGROUND_BRIGHT +" Wrong Username OR Password! Please try again "+ ConsoleColors.RESET +"");
			MainUI.main(null);
		}
	}
	
	
	static void userLogin(Scanner sc) {
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
	
	static void registerUser(Scanner sc){
		UserDAO U = new UserDAOImpl();
		
		System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter username: "+ ConsoleColors.RESET +" ");
		String username = sc.next();
		
		try {
			//checking is username already taken or not
			
			if(U.isUsernameExists(username) == true) {
				System.out.print(ConsoleColors.GREEN +"Username already taken try Again (Y/N): " + ConsoleColors.RESET);
				String choice = sc.next();
				
				if(choice.equalsIgnoreCase("y")) {
					registerUser(sc);
					return;
				}
				else {
					main(null);
				}
			}
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " "+ ConsoleColors.RESET);
		}
		
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
		user.setUsername(username);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setMobile_no(mobile);
		user.setCountry(country);
		user.setPassword(password);
		
		try {
			
			if(U.registerUser(user)) {
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT +" Registered Successfully! 😁" + ConsoleColors.RESET);
				userLogin(sc);
			}
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " "+ ConsoleColors.RESET);
		}
	}

}
