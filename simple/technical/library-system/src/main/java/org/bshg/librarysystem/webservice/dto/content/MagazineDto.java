package org.bshg.librarysystem.webservice.dto.content;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MagazineDto {
    private Long id;
    private String title;
    private LocalDate publicationDate;
    private GenreDto genre;
    private PublisherDto publisher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate value) {
        this.publicationDate = value;
    }

    public GenreDto getGenre() {
        return genre;
    }

    public void setGenre(GenreDto value) {
        this.genre = value;
    }

    public PublisherDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDto value) {
        this.publisher = value;
    }
}