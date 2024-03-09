package org.bshg.librarysystem.webservice.content.bookgenre;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.webservice.content.bookgenre.BookGenreDto;
import org.bshg.librarysystem.webservice.content.book.BookConverter;
import org.bshg.librarysystem.webservice.content.genre.GenreConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class BookGenreConverter {
public void init(boolean initialisation) {
this.book = initialisation;
this.genre = initialisation;
}
@Autowired private BookConverter bookConverter;
@Autowired private GenreConverter genreConverter;
private boolean book = true;
private boolean genre = true;
protected void convertersConfig(boolean value) {
this.bookConverter.setBookGenre(value);
this.genreConverter.setBookGenre(value);
}
public final BookGenreDto toDto(BookGenre item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final BookGenre toItem(BookGenreDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<BookGenre> toItem(List<BookGenreDto> dtos) {
if (dtos == null) return null;
List<BookGenre> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<BookGenreDto> toDto(List<BookGenre> items) {
if (items == null) return null;
List<BookGenreDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected BookGenre convertToItem(BookGenreDto dto) {
var item = new BookGenre();
item.setId(dto.getId());
item.setBook(bookConverter.toItem(dto.getBook()));
item.setGenre(genreConverter.toItem(dto.getGenre()));
return item;
}
protected BookGenreDto convertToDto(BookGenre item) {
var dto = new BookGenreDto();
dto.setId(item.getId());
dto.setBook(book? bookConverter.toDto(item.getBook()): null);
dto.setGenre(genre? genreConverter.toDto(item.getGenre()): null);
return dto;
}
public void setBook(boolean value) {
this.book = value;
}
public void setGenre(boolean value) {
this.genre = value;
}
public void setBookConverter(BookConverter value) {
this.bookConverter = value;
}
public BookConverter getBookConverter() {
return bookConverter;
}
public void setGenreConverter(GenreConverter value) {
this.genreConverter = value;
}
public GenreConverter getGenreConverter() {
return genreConverter;
}
}