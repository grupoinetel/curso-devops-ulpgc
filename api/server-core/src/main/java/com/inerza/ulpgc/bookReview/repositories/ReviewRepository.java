package com.inerza.ulpgc.bookReview.spring.repositories;

import com.inerza.ulpgc.bookReview.spring.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ReviewRepository extends JpaRepository<Review, Long>, PagingAndSortingRepository<Review, Long> {
}
