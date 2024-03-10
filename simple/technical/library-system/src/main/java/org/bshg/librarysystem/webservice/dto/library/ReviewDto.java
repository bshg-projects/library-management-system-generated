package org.bshg.librarysystem.webservice.dto.library;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.webservice.dto.content.BookDto;
import org.bshg.librarysystem.webservice.dto.user.ClientDto;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewDto {
    private Long id;
    private String name;
    private BookDto book;
    private int rating;
    private String comment;
    private LocalDate reviewDate;
    private ClientDto client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto value) {
        this.book = value;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int value) {
        this.rating = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate value) {
        this.reviewDate = value;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto value) {
        this.client = value;
    }
}