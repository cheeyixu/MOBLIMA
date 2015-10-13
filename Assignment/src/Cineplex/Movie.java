package Cineplex;

import java.util.Date;

public class Movie {
	private String nameMovie;
	private float price;
	private String typeOfMovie;
	private String ClassOfCinema;
	private String[] dateOfMovie = new String[100];
	private int dateCount;
	
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
