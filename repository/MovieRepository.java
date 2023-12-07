package com.example.shivagod.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shivagod.watchlist.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
