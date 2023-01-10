package com.inerza.ulpgc.bookReview.services;

import com.github.javafaker.Faker;
import com.inerza.ulpgc.bookReview.entities.Book;
import com.inerza.ulpgc.bookReview.entities.Review;
import junit.framework.TestCase;

import java.util.Date;
import java.util.Locale;

public class ReviewServiceTest extends TestCase {

    private Faker faker;

    public ReviewServiceTest() {
        faker = new Faker(Locale.getDefault());
    }

    public void testCreateReview() {
        Review r = new Review();
        r.setAuthor(faker.funnyName().name());
        r.setDescription(faker.shakespeare().romeoAndJulietQuote());
        r.setBook(new Book(1L));
        r.setCreated(new Date());

        ReviewService rs = new ReviewService();
        rs.createReview(r);
    }
}