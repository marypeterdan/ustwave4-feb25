package com.stackroute.movieapp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.movieapp.entity.Movie;


@Repository
public interface MovieRepo extends MongoRepository<Movie,Integer> {

}
