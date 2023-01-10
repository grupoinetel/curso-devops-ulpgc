package com.inerza.ulpgc.bookReview.controllers;

import com.inerza.ulpgc.bookReview.core.persistence.IReviewService;
import com.inerza.ulpgc.bookReview.model.dto.ReviewDTO;
import com.inerza.ulpgc.bookReview.model.entities.Review;
import com.inerza.ulpgc.bookReview.model.mappers.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class ReviewRestController {
    
    @Autowired
    private IReviewService reviewService;

    @GetMapping(path="/", produces = "application/json")
    @ResponseBody
    public List<ReviewDTO> getReviews(
            @PathVariable("page") int page,
            @PathVariable("size") int size, 
            @PathVariable("sortDir") String sortDir, 
            @PathVariable("sort") String sort) {

        List<Review> reviews = reviewService.getReviewsList(page, size, sortDir, sort);
        return reviews.stream()
          .map(x -> ReviewMapper.INSTANCE.convertToDto(x))
          .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ReviewDTO createReview(@RequestBody ReviewDTO reviewDto) throws ParseException {
        Review review = ReviewMapper.INSTANCE.convertToEntity(reviewDto);
        Review reviewCreated = reviewService.createReview(review);
        return ReviewMapper.INSTANCE.convertToDto(reviewCreated);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ReviewDTO getReview(@PathVariable("id") Long id) {
        return ReviewMapper.INSTANCE.convertToDto(reviewService.getReviewById(id));
    }

    // Updating the review.
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@PathVariable("id") Long id, @RequestBody ReviewDTO reviewDto) throws ParseException {
        if(!Objects.equals(id, reviewDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }

        Review review = ReviewMapper.INSTANCE.convertToEntity(reviewDto);
        reviewService.updateReview(review);
    }
}
