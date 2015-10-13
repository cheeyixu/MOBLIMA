package Cineplex;

import java.util.Date;

public class Movie {
	public String nameMovie = "";
	public float Price = 0;
	public String typeOfMovie = "";
	public String ClassOfCinema = "";
	public String[] dateOfMovie = new String[100];
	private int dateCount = 0;
	
	public Movie(String namemovie, float price,String typeofMovie,String classCinema,String dateMovie ){
		this.nameMovie = namemovie;
		this.Price = price;
		this.typeOfMovie = typeofMovie;
		this.ClassOfCinema = classCinema;
		this.dateOfMovie[dateCount] = dateMovie;
		
	}
	
	public void SetDateCount(int number){
		dateCount = number;
	}
	public int getDateCount(){
		return dateCount;
	}
	
}
