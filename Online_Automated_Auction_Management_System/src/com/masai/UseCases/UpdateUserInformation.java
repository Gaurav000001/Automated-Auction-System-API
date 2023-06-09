package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.LogedUser;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.DTO.UserDTO;
import com.masai.DTO.UserDTOImpl;
import com.masai.Exceptions.SomethingWentWrongException;
import com.masai.UI.AccountActivityUI;
import com.masai.UI.UserUI;

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
		
		System.out.println();
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Password to Confirm it's you: "+ ConsoleColors.RESET +" ");
		String password = sc.next();
		
		if(password.equals(LogedUser.password) == false) {
			System.out.println("   "+ ConsoleColors.RED_BACKGROUND_BRIGHT +" Wrong Password Entered "+ ConsoleColors.RESET +" ");
			AccountActivityUI.accountActivityMain(sc);
			return;
		}
		
		
		UserDTO user = new UserDTOImpl();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setMobile_no(mobile);
		user.setCountry(country);
		
		
		try {
			
			if(U.updateProfile(user))
				System.out.print("\n   "+ ConsoleColors.GREEN_BACKGROUND_BRIGHT +" Profile Details Updated Successfully! 😁 "+ ConsoleColors.RESET +" ");
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
			return;
		}
	}

}
