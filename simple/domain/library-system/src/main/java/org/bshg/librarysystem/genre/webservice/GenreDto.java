package org.bshg.librarysystem.genre.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.bookgenre.webservice.BookGenreDto;
import org.bshg.librarysystem.magazine.webservice.MagazineDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenreDto {
    private Long id;
    private String name;
    private List<MagazineDto> magazines;
    private List<BookGenreDto> bookGenre;

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

    public List<MagazineDto> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<MagazineDto> value) {
        this.magazines = value;
    }

    public List<BookGenreDto> getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(List<BookGenreDto> value) {
        this.bookGenre = value;
    }
}