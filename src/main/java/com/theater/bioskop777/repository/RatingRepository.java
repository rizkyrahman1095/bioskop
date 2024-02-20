package com.theater.bioskop777.repository;

import com.theater.bioskop777.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,String> {
}
