package com.theater.bioskop777.repository;

import com.theater.bioskop777.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,String> {
}
