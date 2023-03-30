package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.LogedUser;
import com.masai.DAO.UserDAO;
import com.masai.DAO.UserDAOImpl;
import com.masai.Exceptions.SomethingWentWrongException;

public class DeleteAccount {
	public static void main(Scanner sc) {
		UserDAO U = new UserDAOImpl();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Password: "+ ConsoleColors.RESET +" ");
		String old = sc.next();
		
		if(old.equals(LogedUser.password)) {
			
			try {
				
				U.deleteAccount();
				
				System.out.println("   "+ConsoleColors.GREEN_BACKGROUND_BRIGHT + " Account deleted Successfully " + ConsoleColors.RESET);
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
