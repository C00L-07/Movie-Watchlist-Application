package com.example.shivagod.watchlist.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.shivagod.watchlist.entity.Movie;
import com.example.shivagod.watchlist.service.DatabaseService;

@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/WatchlistItemForm")
	public ModelAndView showWatchlistForm(@RequestParam(required = false) Integer id) {
		// TODO Auto-generated method stub
		String viewName = "WatchlistItemForm";
		
		Map<String, Object> model = new HashMap<>();
		
		if(id == null) {
			model.put("movie", new Movie());
		}else {
			model.put("movie", databaseService.getMoviebyid(id));
		}
//		Movie dummymovie = new Movie();
//		dummymovie.setTitle("dummy");
//		dummymovie.setRating(0);
//		dummymovie.setPriority("LOW");
//		dummymovie.setComment("John Doe");
//		model.put("watchlistItem",dummymovie);
		
		
		return new ModelAndView(viewName,model);
	}
	
	@PostMapping(path = "/WatchlistItemForm")
	public ModelAndView submitWatchlistForm(@Valid Movie movie , BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("WatchlistItemForm");
		}
		// TODO Auto-generated method stub
		Integer id = movie.getId();
		if(id == null) {
		   databaseService.create(movie);
		}else {
			databaseService.update(movie,id);
		}
		
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		// TODO Auto-generated method stub
		String viewName = "watchlist";
		Map<String, Object> model = new HashMap<>();
		List<Movie> movieList = databaseService.getallMovies();
		model.put("watchlistrows", movieList);
		model.put("noofmovies",movieList.size());
		return new ModelAndView(viewName,model);
		
	}
}
