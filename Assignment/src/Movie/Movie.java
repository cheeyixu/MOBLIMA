package Movie;

import java.util.Date;

public class Movie {
	private String title = "";
	private int duration = 0;
	private double rating = 0;
	private String genre = "";
	private Date time = new Date();
	
	
	public Movie(String title, int duration , double rating , String genre ,Date time){
		this.title = title;
		this.duration = duration;
		this.rating = rating;
		this.genre = genre;
		this.time = time;
	}
	
	//just for quick test i make the simple constructor 
	public Movie(String title){
		this.title = title;
	}
	
	
	//getter and setter for title
	public void SetTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	//getter and setter for duration
	
	public void setDuration(int duration){
		this.duration = duration;
	}
	
	public int getDuration(){
		return duration;
	}
	
	//getter and setter for rating 
	
	public void setRating(double rating){
		this.rating= rating;
	}
	
	public double getRating(){
		return rating;
	}
	
	
	//getter and setter for genre
	
	public void setGenre(String genre){
		this.genre = genre;
	}
	
	public String getGenre(){
		return genre;
	}
	
	//getter and setter for date
	
	public void setTime(Date time){
		this.time = time;
	}
	
	
	public Date getDate(){
		return time;
	}
	
	

	public String printDescription(){
		String movieDescription = "Name Movie: "+this.title+"\n"
								   +"Duration: "+this.duration+ "\n"
								   +"Rating: "+this.rating+"\n"
								   +"Genre: "+this.genre+"\n"
								   +"Date: "+this.time.getTime()+"\n";
		return movieDescription;
	}
	
}
