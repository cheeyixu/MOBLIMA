package Staff;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Cinema;
import Cineplex.Cineplex;
import Cineplex.CineplexDatabase;
import Movie.Movie;

public class StaffApplication {
	
	private static Cineplex currentCineplex = null;
	private static Cinema currentCinema = null;
	private static Movie currentMovie = null;
	
	
	public static void main(String args[]){
		//declare all the object 
		Scanner scan = new Scanner(System.in);
		String username=null,password= null;
		Staff inputStaff= null;
		ArrayList getList = null;	
		boolean staffStatus = false;
		int choiceFunction = 0;
		DatabaseStaff dbStaff = new DatabaseStaff();
		
		//scan the staff username and password
		System.out.println("Username: ");
		username = scan.nextLine();
		System.out.println("Password: ");
		password = scan.nextLine();
		inputStaff = new Staff(username,password);
		//processing database
		System.out.println("Check Database");
		System.out.println("process.....\n");
		getList =  dbStaff.ReadFromDatabase("staff.dat");
		for(int i = 0 ; i < getList.size() ; i++){
			Staff printStaff = (Staff)getList.get(i);
			if(printStaff.EqualsStaff(inputStaff)){
				staffStatus = true;
				break;
			}
		}
		
		if(staffStatus){
			System.out.println("welcome Staff");
			ViewCinemaFromDatabase();
		}else{
			System.out.println("Sorry your username and password is not match with our database");
		}
	}
	
	private static void ViewCinemaFromDatabase(){
		CineplexDatabase cDatabase = new CineplexDatabase();
		ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
		cineplexList = cDatabase.ReadFromDatabase("CineplexDatabase.dat");
		for(int i = 0 ;i < cineplexList.size() ; i++){
			System.out.println("List of Cineplex");
			System.out.printf("%d) %s",i+1,cineplexList.get(i).getCineplexName());
		}
		System.out.println("Please choose one Cineplex to configure or type -1 to quit");
		Scanner scan = new Scanner(System.in);
		int choices = scan.nextInt();
		if(choices == -1){
			System.out.println("Quit from the configuring process");
			return ;
		}
		currentCineplex = cineplexList.get(choices);
		Configuring();
	}
	
	private static void Configuring(){
		//get the list of Cinema from the cineplex
		System.out.println("Configuring "+currentCineplex.getCineplexName()+"............");
		for(int i = 0 ; i < currentCineplex.getListCinema().size() ; i++){
			System.out.printf("%d) %s",i+1,currentCineplex.getListCinema().get(i).getNameCinema());
		}
		System.out.println("Please choose one cinema to configure\n");
		Scanner scan = new Scanner(System.in);
		currentCinema = currentCineplex.getListCinema().get(scan.nextInt());
		//get the movie to configure
		//give option to add movie or update the movie
		while(true){
			System.out.println("Choose the option here: ");
			System.out.println("1) Add Movie");
			System.out.println("2) Update the movie List");
			System.out.println("3) Quit");
			int OptionMovie = scan.nextInt();
		if(OptionMovie == 1){
			System.out.println("Please add name of the movie ");
			Movie movie = new Movie(scan.nextLine());
			currentCinema.AddListOfMovie(movie);
			System.out.println("Finish Adding movie into the cinema");
		}else if(OptionMovie == 2){
			System.out.println("List of Movie from \n"+currentCinema.getNameCinema());
			for(int i = 0 ; i < currentCinema.getArrayMovie().size() ; i++){
				System.out.printf("%d) %s",i+1,currentCinema.getArrayMovie().get(i).printDescription());
			}
			System.out.println("\nplease choose one movie to configure");
			Movie chooseMovie = currentCinema.getMovieWithIndex(scan.nextInt());
			//later need to add the Date attribute so it will detect current time and the time when you put the object
			System.out.println("What description you want to configure");
			System.out.println("1) title");
			System.out.println("2) duration");
			System.out.println("3) rating");
			System.out.println("4) Genre");
			
		}else{
			System.out.println("Sorry your option is not been here");
			return ;
		}
		
		}
		
	}
	
	
}
