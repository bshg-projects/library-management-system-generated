package org.bshg.librarysystem.webservice.dto.content;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookGenreDto {
private Long id;
private BookDto book;
private GenreDto genre;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
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