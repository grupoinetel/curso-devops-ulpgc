package com.inerza.ulpgc.bookReview.model.entities;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

/**
 * The type Book.
 */
@Entity
@Table(name = "book")
public class Book {
    private Long id;
    private String name;
    private String author;
    private Date published;
    private String isbn;
    private String cover;

    /**
     * Instantiates a new Book.
     */
    public Book(){
    }

    /**
     * Instantiates a new Book.
     *
     * @param id the id
     */
    public Book(Long id){
        setId(id);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    public Long getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    @Basic
    @Column(name = "name", nullable = false)
    public String getName() { return name; }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets author.
     *
     * @return the author
     */
    @Basic
    @Column(name = "author", nullable = false)
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets published.
     *
     * @return the published
     */
    @Basic
    @Column(name = "published", nullable = false)
    public Date getPublished() { return published; }

    /**
     * Sets published.
     *
     * @param published the published
     */
    public void setPublished(Date published) { this.published = published; }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    @Basic
    @Column(name = "cover")
    public String getIsbn() { return isbn; }

    /**
     * Sets isbn.
     *
     * @param isbn the isbn
     */
    public void setIsbn(String isbn) { this.isbn = isbn; }

    /**
     * Gets cover.
     *
     * @return the cover
     */
    @Basic
    @Column(name = "isbn")
    public String getCover() { return cover; }

    /**
     * Sets cover.
     *
     * @param cover the cover
     */
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
