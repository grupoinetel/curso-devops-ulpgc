package com.inerza.ulpgc.bookReview.core.persistence;

import com.inerza.ulpgc.bookReview.model.entities.Review;

import java.util.List;

public interface IReviewService {

    List<Review> getReviewsList(int page, int size, String sortDir, String sort);

    void updateReview(Review post);

    Review createReview(Review post);

    Review getReviewById(Long id);

}
