package com.example.shivagod.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {

	String apiurl = "http://www.omdbapi.com/?apikey=40e53782&t=";
	
	public String getMovieRating(String title) {
		// TODO Auto-generated method stub
		try {
			//if Movie Present in the imdb then fetch that movie
			
			RestTemplate template = new RestTemplate();
			//Api + url
			
			ResponseEntity<ObjectNode> response = template.getForEntity(apiurl + title, ObjectNode.class);
			
			ObjectNode jsonObjectNode = response.getBody();
			System.out.println(jsonObjectNode.path("imdbRating").asText());
			return jsonObjectNode.path("imdbRating").asText();
		}catch(Exception e){
			System.out.println("Either Movie name is Not Available or api is Down" + e.getMessage());
			return null;
		}
	}
}
