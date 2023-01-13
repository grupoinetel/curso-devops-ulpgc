package com.inerza.ulpgc.bookReview.controllers;

import com.inerza.ulpgc.bookReview.core.persistence.IBookService;
import com.inerza.ulpgc.bookReview.model.dto.BookDTO;
import com.inerza.ulpgc.bookReview.model.dto.ReviewDTO;
import com.inerza.ulpgc.bookReview.model.entities.Book;
import com.inerza.ulpgc.bookReview.model.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("books")
public class BookRestController {
    
    @Autowired
    private IBookService bookService;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<BookDTO> getReviews(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String sortDir,
            @RequestParam() String sort) {

        List<Book> books = bookService.getBookList(page, size, sortDir, sort);
        return books.stream()
          .map(x -> BookMapper.INSTANCE.convertToDto(x))
          .collect(Collectors.toList());
    }
}
