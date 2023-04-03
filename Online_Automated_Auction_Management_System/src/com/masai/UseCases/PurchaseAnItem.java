package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Custom.ConsoleColors;
import com.masai.DAO.ProductDAO;
import com.masai.DAO.ProductDAOImpl;
import com.masai.Exceptions.NoRecordFoundException;
import com.masai.Exceptions.SomethingWentWrongException;

public class PurchaseAnItem {
	public static void main(Scanner sc) {
		ProductDAO pro = new ProductDAOImpl();
		
		System.out.print("   "+ConsoleColors.BLACK_BACKGROUND_BRIGHT+" Enter ProductID: "+ConsoleColors.RESET+" ");
		int proId = sc.nextInt();
		
		try {
			int product_price = pro.checkProductExistance(proId);
			
			if(product_price != 0) {
				
				System.out.print("   "+ConsoleColors.BLACK_BACKGROUND_BRIGHT+" Enter bid Amount above "+ product_price +": "+ConsoleColors.RESET+" ");
				
				int price = sc.nextInt();
				if(price < product_price) {
					System.out.print("   " +ConsoleColors.RED_BACKGROUND_BRIGHT+" Invalid bid price " +ConsoleColors.RESET);
				}
				else {
					try {
						pro.purchaseAnItem(proId, price);
						
						System.out.print("   " +ConsoleColors.GREEN_BACKGROUND_BRIGHT+" Order Placed Successfully! " +ConsoleColors.RESET);
					} catch (SomethingWentWrongException e) {
						// TODO Auto-generated catch block
						System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
					}
				}
				
			}
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + " " + e.getMessage() + " " + ConsoleColors.RESET);
		}
	}
}
