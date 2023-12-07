package com.example.shivagod.watchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shivagod.watchlist.entity.Movie;
import com.example.shivagod.watchlist.repository.MovieRepository;



@Service
public class DatabaseService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	RatingService ratingService;
	
	public void create(Movie movie) {
		// TODO Auto-generated method stub
		String rating = ratingService.getMovieRating(movie.getTitle());
		if(rating!=null) {
			movie.setRating(Float.parseFloat(rating));
		}
		
		movieRepository.save(movie);
	}

	
	public List<Movie> getallMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}
	
	public Movie getMoviebyid(Integer id) {
		// TODO Auto-generated method stub
		return movieRepository.findById(id).get();
	}


	public void update(Movie movie, Integer id) {
		// TODO Auto-generated method stub
		Movie tobeupdated = getMoviebyid(id);
		
		tobeupdated.setTitle(movie.getTitle());
		tobeupdated.setComment(movie.getComment());
		tobeupdated.setPriority(movie.getPriority());
		tobeupdated.setRating(movie.getRating());
		
		movieRepository.save(tobeupdated);
	}
	


	




}
