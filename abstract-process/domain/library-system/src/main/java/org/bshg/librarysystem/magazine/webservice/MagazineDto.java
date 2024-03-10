package org.bshg.librarysystem.magazine.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.genre.webservice.GenreDto;
import org.bshg.librarysystem.publisher.webservice.PublisherDto;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MagazineDto extends AuditBaseDto {
    public MagazineDto() {
        super();
    }

    private String title;
    private LocalDate publicationDate;
    private GenreDto genre;
    private PublisherDto publisher;

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