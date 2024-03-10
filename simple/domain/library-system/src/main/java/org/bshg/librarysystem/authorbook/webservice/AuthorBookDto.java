package org.bshg.librarysystem.authorbook.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.author.webservice.AuthorDto;
import org.bshg.librarysystem.book.webservice.BookDto;
import org.bshg.librarysystem.enums.BookAuthorRoleEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorBookDto {
    private Long id;
    private float contribution;
    private BookAuthorRoleEnum role;
    private AuthorDto author;
    private BookDto book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getContribution() {
        return contribution;
    }

    public void setContribution(float value) {
        this.contribution = value;
    }

    public BookAuthorRoleEnum getRole() {
        return role;
    }

    public void setRole(BookAuthorRoleEnum value) {
        this.role = value;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto value) {
        this.author = value;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto value) {
        this.book = value;
    }
}