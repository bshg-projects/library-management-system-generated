package org.bshg.librarysystem.webservice.dto.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookGenreDto extends AuditBaseDto {
    public BookGenreDto() {
        super();
    }

    private BookDto book;
    private GenreDto genre;

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto value) {
        this.book = value;
    }

    public GenreDto getGenre() {
        return genre;
    }

    public void setGenre(GenreDto value) {
        this.genre = value;
    }
}