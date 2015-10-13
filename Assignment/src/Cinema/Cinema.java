package Cinema;

import java.util.ArrayList;

import Cineplex.Movie;

public class Cinema {
	
	public String nameCinema = "";
	private ArrayList<Movie> listMovie = new ArrayList<Movie>();
	
	public Cinema(String nameCinema){
		this.nameCinema = nameCinema;
	}
	
	public void AddListOfMovie(Movie movie){
		if(movie == null){
			System.out.println("Sorry your movie is null");
			return ;
		}
		listMovie.add(movie);
	}
	
	public void RemoveListOfMovie(Movie movie){
		for(int i = 0 ; i < listMovie.size() ; i++){
			if(listMovie.get(i).equals(movie)){
				listMovie.remove(i);
				break;
			}
		}
	}
	
	
}
