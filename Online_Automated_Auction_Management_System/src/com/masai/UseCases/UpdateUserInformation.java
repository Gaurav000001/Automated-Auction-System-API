package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.UserDTO;
import com.masai.DTO.UserDTOImpl;
import com.masai.Exceptions.SomethingWentWrongException;

public class UpdateUserInformation {

	public static void main(Scanner sc) {
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
