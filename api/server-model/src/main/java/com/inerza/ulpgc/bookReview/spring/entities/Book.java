package com.inerza.ulpgc.bookReview.entities;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
    private Long id;
    private String name;
    private String author;
    private Date published;
    private String isbn;
    private String cover;

    public Book(){
    }

    public Book(Long id){
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
    @Column(name = "name", nullable = false)
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Basic
    @Column(name = "author", nullable = false)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "published", nullable = false)
    public Date getPublished() { return published; }

    public void setPublished(Date published) { this.published = published; }

    @Basic
    @Column(name = "cover")
    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    @Basic
    @Column(name = "isbn")
    public String getCover() { return cover; }

    public void setCover(String cover) { this.cover = cover; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id)
                && name.equals(book.name)
                && author.equals(book.author)
                && published.equals(book.published)
                && Objects.equals(isbn, book.isbn)
                && Objects.equals(cover, book.cover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, published, isbn, cover);
    }
}
