package com.stackroute.movieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieapp.entity.Movie;
import com.stackroute.movieapp.exceptions.MovieIdNotFoundException;
import com.stackroute.movieapp.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	
	@Autowired
	MovieService mservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addmovie(@RequestBody Movie movie)
	{
		
	Movie resultobj=mservice.addMovie(movie);
	return new ResponseEntity(resultobj, HttpStatus.CREATED);	
		
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<?> getall()
	{
		
	List<Movie> movies=		mservice.getAllMovies();
	return new ResponseEntity(movies, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatemovie(@RequestBody Movie movieobj)  
	{
		
		try
		{
		Movie updatedmovie=	mservice.updateMovie(movieobj);
	return new ResponseEntity<Movie>(updatedmovie,HttpStatus.OK);
		}
		catch(MovieIdNotFoundException excep)
		{
			return new ResponseEntity("Id Not found",HttpStatus.NOT_FOUND);
			
		}
	}
	
	
	@DeleteMapping("/delete/{movieid}")
	public ResponseEntity<?> deletemovie(@PathVariable("movieid") int movieid)
	{
		
		try
		{
		boolean result=	mservice.deleteMovie(movieid);
	return new ResponseEntity("Deleted Successfully " ,HttpStatus.OK);
		}
		catch(MovieIdNotFoundException excep)
		{
			return new ResponseEntity("Id Not found",HttpStatus.NOT_FOUND);
			
		}
		
		
	}
	
	

}
