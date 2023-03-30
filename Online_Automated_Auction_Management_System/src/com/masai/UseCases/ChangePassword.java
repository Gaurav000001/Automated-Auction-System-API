package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.LogedUser;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.Exceptions.SomethingWentWrongException;

public class ChangePassword {

	public static void main(Scanner sc) {
		// TODO Auto-generated method stub
		UserDAO U = new UserDAOImpl();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Old Password: "+ ConsoleColors.RESET +" ");
		String old = sc.next();
		
		if(old.equals(LogedUser.password)) {
			
			System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your new Password: "+ ConsoleColors.RESET +" ");
			String newPass = sc.next();
			
			try {
				U.changePassword(newPass);
				
				System.out.println("   "+ConsoleColors.GREEN_BACKGROUND_BRIGHT + " Password Changed Successfully " + ConsoleColors.RESET);
			} catch (SomethingWentWrongException e) {
				// TODO Auto-generated catch block
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
				return;
			}
			
		}
		else {
			System.out.println("   "+ConsoleColors.RED_BACKGROUND_BRIGHT + " You have Entered Wrong Password" + ConsoleColors.RESET);
			return;
		}
	}

}
