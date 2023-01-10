package com.inerza.ulpgc.bookReview.model.dto;

import com.inerza.ulpgc.bookReview.model.entities.Book;

import java.util.Date;

public class ReviewDTO {

    private Long id;
    private String author;
    private Date created;
    private String description;
    private Book book;

    public ReviewDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
