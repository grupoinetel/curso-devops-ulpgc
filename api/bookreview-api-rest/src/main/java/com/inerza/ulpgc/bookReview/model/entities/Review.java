package com.inerza.ulpgc.bookReview.model.entities;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "review")
public class Review {
    private Long id;
    private String author;
    private Date created;
    private String description;
    private Book book;

    public Review(){
    }

    public Review(Long id){
        setId(id);
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "author", nullable = false)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "created", nullable = false)
    public Date getCreated() { return created; }

    public void setCreated(Date reviewDate) { this.created = reviewDate; }

    @Basic
    @Column(name = "description", nullable = false)
    public String getDescription() { return description; }

    public void setDescription(String reviewText) { this.description = reviewText; }

    @ManyToOne()
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    public Book getBook() { return book; }

    public void setBook(Book book) { this.book = book; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id.equals(review.id) && author.equals(review.author) && created.equals(review.created) && description.equals(review.description) && book.equals(review.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, created, description, book);
    }
}
