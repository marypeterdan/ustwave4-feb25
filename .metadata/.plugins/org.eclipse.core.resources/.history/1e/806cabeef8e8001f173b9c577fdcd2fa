package com.stackroute.movieapp.service;

import java.util.List;

import com.stackroute.movieapp.entity.Movie;
import com.stackroute.movieapp.exceptions.MovieIdNotFoundException;

public interface MovieService {
	
	
	Movie addMovie(Movie movie);
	
	List<Movie> getAllMovies();
	
	Movie updateMovie(Movie movie) throws MovieIdNotFoundException;
	
	boolean deleteMovie(int id) throws MovieIdNotFoundException;

}
