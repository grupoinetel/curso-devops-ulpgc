package com.inerza.ulpgc.bookReview.services;

import java.util.List;

import com.inerza.ulpgc.bookReview.entities.Review;

public interface IReviewService {

    List<Review> getReviewsList(int page, int size, String sortDir, String sort);

    void updateReview(Review post);

    Review createReview(Review post);

    Review getReviewById(Long id);

}
