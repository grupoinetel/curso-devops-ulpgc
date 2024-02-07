package com.inerza.ulpgc.bookReview.controllers;

import com.inerza.ulpgc.bookReview.core.persistence.IReviewService;
import com.inerza.ulpgc.bookReview.model.dto.ReviewDTO;
import com.inerza.ulpgc.bookReview.model.entities.Review;
import com.inerza.ulpgc.bookReview.model.mappers.ReviewMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Tag(description = "Book reviews.", name = "Review Resource")
@RestController
@RequestMapping("reviews")
public class ReviewRestController {
    
    @Autowired
    private IReviewService reviewService;

    @Operation(summary = "Get reviews", description = "Provides all available book reviews with pagination.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.response-codes.ok.desc}"),
            @ApiResponse(responseCode = "400", description = "${api.response-codes.badRequest.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }),
            @ApiResponse(responseCode = "404", description = "${api.response-codes.notFound.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }) })
    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<ReviewDTO> getReviews(
            @Parameter(name = "page", description = "Página")
            @RequestParam() Integer page,
            @Parameter(name = "size", description = "Elementos por página")
            @RequestParam() Integer size,
            @Parameter(name = "sortDir", description = "ASC o DSC")
            @RequestParam() String sortDir,
            @Parameter(name = "sort", description = "Ordenar por campo Ex. 'id' ")
            @RequestParam() String sort) {

        List<Review> reviews = reviewService.getReviewList(page, size, sortDir, sort);
        return reviews.stream()
          .map(x -> ReviewMapper.INSTANCE.convertToDto(x))
          .collect(Collectors.toList());
    }

    @Operation(summary = "Create a review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.response-codes.ok.desc}"),
            @ApiResponse(responseCode = "400", description = "${api.response-codes.badRequest.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }),
            @ApiResponse(responseCode = "404", description = "${api.response-codes.notFound.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }) })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ReviewDTO createReview(@RequestBody ReviewDTO reviewDto) throws ParseException {
        Review review = ReviewMapper.INSTANCE.convertToEntity(reviewDto);
        Review reviewCreated = reviewService.createReview(review);
        return ReviewMapper.INSTANCE.convertToDto(reviewCreated);
    }

    @Operation(summary = "Get a review by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.response-codes.ok.desc}"),
            @ApiResponse(responseCode = "400", description = "${api.response-codes.badRequest.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }),
            @ApiResponse(responseCode = "404", description = "${api.response-codes.notFound.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }) })
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ReviewDTO getReview(@PathVariable("id") Long id) {
        return ReviewMapper.INSTANCE.convertToDto(reviewService.getReviewById(id));
    }

    @Operation(summary = "Update a review")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.response-codes.ok.desc}"),
            @ApiResponse(responseCode = "400", description = "${api.response-codes.badRequest.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }),
            @ApiResponse(responseCode = "404", description = "${api.response-codes.notFound.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }) })
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@PathVariable("id") Long id, @RequestBody ReviewDTO reviewDto) throws ParseException {
        if(!Objects.equals(id, reviewDto.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }

        Review review = ReviewMapper.INSTANCE.convertToEntity(reviewDto);
        reviewService.updateReview(review);
    }

    @Operation(summary = "Delete a review by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.response-codes.ok.desc}"),
            @ApiResponse(responseCode = "400", description = "${api.response-codes.badRequest.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }),
            @ApiResponse(responseCode = "404", description = "${api.response-codes.notFound.desc}",
                    content = { @Content(examples = { @ExampleObject(value = "") }) }) })
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview(@PathVariable("id") Long id) throws ParseException {
        reviewService.deleteReview(id);
    }
}
