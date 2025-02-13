package com.stackroute.movieapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movieapp.entity.Movie;
import com.stackroute.movieapp.entity.Review;
import com.stackroute.movieapp.exceptions.MovieIdNotFoundException;
import com.stackroute.movieapp.repo.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepo repo;

	@Override
	public Movie addMovie(Movie movie) {
		
		return repo.save(movie);
	}

	public Movie addReview(Review review,Movie movie)
	{
		
		Optional<Movie> movieobj=repo.findById(movie.getMovieid());
		
		if(movieobj.isPresent())
		{
			Movie actobj=movieobj.get();
			
			List<Review> reviews=actobj.getReviews();
			
			reviews.add(review);
			
			actobj.setReviews(reviews);
			
			return repo.save(actobj);
			
			
		}
		else
			return null;
		
		
	}
	
	@Override
	public List<Movie> getAllMovies() {
	 
		return repo.findAll();
	}

	@Override
	public Movie updateMovie(Movie movie) throws MovieIdNotFoundException {
		
	Optional<Movie> movieopt=repo.findById(movie.getMovieid());
	
	if(movieopt.isPresent())
		
 		return repo.save(movie);
	else
		
		throw new MovieIdNotFoundException("Id doesnt exist");
	
	}

	@Override
	public boolean deleteMovie(int movieid) throws MovieIdNotFoundException {
	
		Optional<Movie> movieopt=repo.findById(movieid);
		
		if(movieopt.isPresent())
		{
			repo.deleteById(movieid);
	 		return true;
		}
		else 
			
			throw new MovieIdNotFoundException("Id doesnt exist");
		
		
		
	}
  // obj==null 
}
