package com.masai.UI;

import com.masai.Custom.ConsoleColors;

public class AdminUI {
	
	public static void adminMenu(){
		System.out.println();
		System.out.println( "   +--------------------------+"+"\n"
						  + "   | 1. -> "+ ConsoleColors.GREEN +"Admin Login "+ ConsoleColors.RESET +"       |"+"\n"
						  + "   | 2. -> "+ ConsoleColors.GREEN +"User Login  "+ ConsoleColors.RESET +"       |"+"\n"
						  + "   | 0. -> "+ ConsoleColors.GREEN +"Exit        "+ ConsoleColors.RESET +"       |"+"\n"
						  + "   +--------------------------+");
	}
	
	
}
