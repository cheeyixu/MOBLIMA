package Cineplex;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Cinema;
import Interface.Database;
import Movie.Movie;

public class CineplexDatabase implements Database{
	private Cinema currentCinema;
	private Cineplex currentCineplex =new Cineplex("");
	private Movie currentMovie ;
	private static Cineplex cathay;
	private static Cineplex filmgarde;
	private static Cineplex century;
	
	public static void main(String args[]){
		StartCineplex();
	}
	
	private static void StartCineplex(){
		//Change code in here to configure the database 
		//automatically configure 3 Cineplex
		ArrayList<Cineplex> listCineplex = new ArrayList<Cineplex>();
		cathay = new Cineplex("Cathay Cineplex");
		filmgarde = new Cineplex("Filmgarde");
		century = new Cineplex("Century Cineplex");
		listCineplex.add(cathay);
		//add three cinema to the cathay cineplex
		Cinema CathayFirst = new Cinema("AMK Hub");
		Cinema CathaySecond = new Cinema("JEM");
		Cinema CathayThird = new Cinema("West Mall");
		listCineplex.get(0).addCinema(CathayFirst);
		listCineplex.get(0).addCinema(CathaySecond);
		listCineplex.get(0).addCinema(CathayThird);
		//add movies to the AMK hub cinema
		
		listCineplex.add(filmgarde);
		//later add three more cinema from FilmGarde
		listCineplex.add(century);
		//later add three more cinema from Century Cineplex
		
		//insert all the information inside the Cineplex Data
		CineplexDatabase cDatabase =  new CineplexDatabase();
		System.out.println("size: "+listCineplex.size());
		cDatabase.WriteToDatabase("CineplexDatabase.dat", listCineplex);
		
	}
	
	@Override
	public void WriteToDatabase(String filename, ArrayList list) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try{
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			ObjectOutputStream os = new ObjectOutputStream(bos);
			os.writeObject(list);
			os.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ArrayList<Cineplex> ReadFromDatabase(String filename) {
		ArrayList returnedList = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try{
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			returnedList = (ArrayList)ois.readObject();
			ois.close();
		}catch(IOException e){
			
		} catch (ClassNotFoundException e) {
			
		}
		return returnedList;
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
		
		}
		}
	}
	/*
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
	
	private void ConfiguringMovie(int pos){
		currentCinema = listCinema.get(pos);
		System.out.println("Configuring movie from "+currentCinema.nameCinema);
		for(int i = 0 ; i < currentCinema.getArrayMovie().size() ; i++){
			System.out.printf("%d) %s",i+1,currentCinema.getArrayMovie().get(i).nameMovie);
		}
		System.out.println("Please choose one Movie to configure");
		Scanner scan = new Scanner(System.in);
		int choiceMovie = scan.nextInt();
		currentMovie = currentCinema.getArrayMovie().get(choiceMovie);
	}
	*/


}
