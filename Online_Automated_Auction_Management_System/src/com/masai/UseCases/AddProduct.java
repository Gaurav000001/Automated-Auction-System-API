package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.LogedUser;
import com.masai.DAO.ProductDAO;
import com.masai.DAO.ProductDAOImpl;
import com.masai.DTO.CategoryDTOImpl;
import com.masai.DTO.ProductDTO;
import com.masai.DTO.ProductDTOImpl;
import com.masai.Exceptions.SomethingWentWrongException;
import com.masai.UI.ProductActivityUI;

public class AddProduct {

	public static void main(Scanner sc) {
		// TODO Auto-generated method stub
		ProductDAO p = new ProductDAOImpl();
		
		System.out.println();
		p.displayCategories();
		System.out.println("   "+ ConsoleColors.RED + " Enter CategoryID from Above Table Only " + ConsoleColors.RESET + "\n");
		
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter categoryID: : "+ ConsoleColors.RESET +" ");
		int cat = sc.nextInt();
		sc.nextLine();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter Product Name: "+ ConsoleColors.RESET +" ");
		String name = sc.nextLine();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter Product price: "+ ConsoleColors.RESET +" ");
		int price = sc.nextInt();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter Product Quantity: "+ ConsoleColors.RESET +" ");
		int quantity = sc.nextInt();
		sc.nextLine();
		
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter Product Description: "+ ConsoleColors.RESET +" ");
		String desc = sc.nextLine();
		
		System.out.print("   "+ConsoleColors.BLACK_BACKGROUND_BRIGHT+" Enter Time Limit for Bidding in minutes: "+ConsoleColors.RESET+" ");
		int time = sc.nextInt();
		
		System.out.println();
		System.out.print("   "+ ConsoleColors.BLACK_BACKGROUND_BRIGHT +" Enter your Password to Confirm it's you: "+ ConsoleColors.RESET +" ");
		String password = sc.next();
		
		if(password.equals(LogedUser.password) == false) {
			System.out.println("   "+ ConsoleColors.RED_BACKGROUND_BRIGHT +" Wrong Password Entered "+ ConsoleColors.RESET +" ");
			ProductActivityUI.productActivityMain(sc);
			return;
		}
		
		
		ProductDTO pro = new ProductDTOImpl();
		
		pro.setCategory(new CategoryDTOImpl(cat, null));
		pro.setProduct_name(name);
		pro.setPrice(price);
		pro.setQuantity(quantity);
		pro.setDescription(desc);
		pro.setTime_span(time);
		
		try {
			p.addItemToSell(pro);
			
			System.out.println();
			System.out.println("   "+ConsoleColors.GREEN_BACKGROUND_BRIGHT + " Product Added Successfully! " + ConsoleColors.RESET);
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
			return;
		}
		
	}

}
