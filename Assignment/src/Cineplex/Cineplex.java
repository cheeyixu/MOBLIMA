package Cineplex;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Cinema;
import Movie.Movie;

public class Cineplex {
	
	private String nameCineplex="";
	private int sizeCinema = 0;
	private ArrayList<Cinema> listCinema = new ArrayList<Cinema>();
	private Cinema currentCinema;
	private Cineplex currentCineplex =new Cineplex();
	private Movie currentMovie ;
	private Cineplex cathay,filmgarde,century;
	
	
	public void StartCineplex(){
		
		//automatically configure 3 Cineplex
		cathay = new Cineplex();
		cathay.nameCineplex = "Cathay Cineplex";
		filmgarde = new Cineplex();
		filmgarde.nameCineplex = "Filmgarde";
		century = new Cineplex();
		century.nameCineplex = "Century Cineplex";
		
	}
		
	public void ChooseCineplexForUser(){
		Scanner scan = new Scanner(System.in);
		int choiceCineplex =  0;
		//we are using 3 cineplex from Singapore 
		//Cathay Cineplex
		//Filmgarde
		//Century Cineplex
		System.out.println("\nPlease Choose the cineplex:");
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
	
	public void ConfigureCineplexForStaff(){
		Scanner scan = new Scanner(System.in);
		int choiceCineplex =  0;
		//we are using 3 cineplex from Singapore 
		//Cathay Cineplex
		//Filmgarde
		//Century Cineplex
		
		System.out.println("\n Please Choose the cineplex to configure:");
		System.out.println("1)Cathay Cineplex");
		System.out.println("2)Filmgarde");
		System.out.println("3)Century Cineplex");
		choiceCineplex = scan.nextInt();
		switch(choiceCineplex){
		case 1:
			System.out.println("Start Configuring Cathay Cineplex");
			if(cathay != null) currentCineplex = cathay;
			break;
		case 2:
			System.out.println("Start Configuring Filmgarde");
			if(filmgarde != null) currentCineplex = filmgarde;
			break;
		case 3:
			System.out.println("Start Configuring Century Cineplex");
			if(century != null) currentCineplex = century;
			
			break;
		default:try{
			throw new ChoiceException("Please choose another cineplex");
		}catch(ChoiceException e){
			ChooseCineplexForUser();
		}
		}
	}
	
	public void ConfiguringCinema(){
		System.out.println("Configuring cinema from "+this.nameCineplex);
		for(int i = 1; i <= currentCineplex.listCinema.size() ; i++){
			System.out.printf("%d) %s \n",i,listCinema.get(i-1).nameCinema);
		}
		System.out.println("please choose one Cinema to configure\n");
		Scanner scan = new Scanner(System.in);
		int indexCinema = scan.nextInt();
		ConfiguringMovie(indexCinema-1);
		
	}
	
	public void ConfiguringMovie(int pos){
		currentCinema = listCinema.get(pos);
		System.out.println("Configuring movie from "+currentCinema.nameCinema);
		for(int i = 0 ; i < currentCinema.getArrayMovie().size() ; i++){
			System.out.printf("%d) %s",i+1,currentCinema.getArrayMovie().get(i).nameMovie);
		}
		System.out.println("Please choose one Movie to configure");
		Scanner scan = new Scanner(System.in);
		int choiceMovie = scan.nextInt();
	}
	
	
	public void addCinema(Cinema cinema){
		listCinema.add(cinema);
	}
	
	public void RemoveCinema(Cinema cinema){
		for(int i = 0 ; i < listCinema.size() ; i++){
			if(listCinema.get(i).equals(cinema)) {
				listCinema.remove(i);
				break;
			}
		}
	}
	
}
