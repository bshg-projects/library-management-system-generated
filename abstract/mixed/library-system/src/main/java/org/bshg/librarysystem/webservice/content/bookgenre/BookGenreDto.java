package org.bshg.librarysystem.webservice.content.bookgenre;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.webservice.content.book.BookDto;
import org.bshg.librarysystem.webservice.content.genre.GenreDto;

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