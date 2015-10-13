package Cineplex;

import java.util.Scanner;

public class Cineplex {
	
	public static void main(String args[]){
		
		
	}
		
	public static void ChooseCineplexForUser(){
		Scanner scan = new Scanner(System.in);
		int choiceCineplex =  0;
		//we are using 3 cineplex from Singapore 
		//Cathay Cineplex
		//Filmgarde
		//Century Cineplex
		System.out.println("\n Please Choose the cineplex:");
		System.out.println("1)Cathay Cineplex");
		System.out.println("2)Filmgarde");
		System.out.println("3)Century Cineplex");
		choiceCineplex = scan.nextInt();
		switch(choiceCineplex){
		case 1:
			System.out.println("Welcome to the Cathay Cineplex");
			break;
		case 2:
			System.out.println("Welcome to Filmgarde Cineplex");
			break;
		case 3:
			System.out.println("Welcome to Century Cineplex");
			break;
		default:try{
			throw new ChoiceException("Please choose another cineplex");
		}catch(ChoiceException e){
			ChooseCineplexForUser();
		}
		}
	}
	
}
