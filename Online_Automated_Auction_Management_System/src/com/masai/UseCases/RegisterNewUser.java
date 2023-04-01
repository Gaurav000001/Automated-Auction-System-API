package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.UserDTO;
import com.masai.DTO.UserDTOImpl;
import com.masai.Exceptions.SomethingWentWrongException;
import com.masai.UI.MainUI;

public class RegisterNewUser {
	public static void main(Scanner sc) {
		UserDAO U = new UserDAOImpl();
		
		System.out.print("\n   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter username: "+ ConsoleColors.RESET +" ");
		String username = sc.next();
		
		try {
			//checking is username already taken or not
			
			if(U.isUsernameExists(username) == true) {
				System.out.print(ConsoleColors.GREEN +"Username already taken try Again (Y/N): " + ConsoleColors.RESET);
				String choice = sc.next();
				
				if(choice.equalsIgnoreCase("y")) {
					RegisterNewUser.main(sc);
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
				MainUI.userLogin(sc);
			}
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " "+ ConsoleColors.RESET);
		}
	}
}
