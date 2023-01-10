package com.inerza.ulpgc.bookReview.core.persistence;

import com.inerza.ulpgc.bookReview.model.entities.Review;
import com.inerza.ulpgc.bookReview.core.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviewsList(int page, int size, String sortDir, String sort) {

        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

        Page<Review> reviews = reviewRepository.findAll(pageReq);
        return reviews.getContent();
    }

    @Override
    public void updateReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.getReferenceById(id);
    }
}
