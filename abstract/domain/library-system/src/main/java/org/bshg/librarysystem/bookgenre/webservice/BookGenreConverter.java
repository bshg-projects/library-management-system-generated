package org.bshg.librarysystem.bookgenre.webservice;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.webservice.BookGenreDto;
import org.bshg.librarysystem.book.webservice.BookConverter;
import org.bshg.librarysystem.genre.webservice.GenreConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BookGenreConverter extends AbstractConverter<BookGenre, BookGenreDto> {
@Autowired private BookConverter bookConverter;
@Autowired private GenreConverter genreConverter;
private boolean book = true;
private boolean genre = true;
@Override
protected void config() {
config(BookGenre.class, BookGenreDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.bookConverter.setBookGenre(value);
this.genreConverter.setBookGenre(value);
}
@Override
protected BookGenre convertToItem(BookGenreDto dto) {
var item = new BookGenre();
item.setId(dto.getId());
item.setBook(bookConverter.toItem(dto.getBook()));
item.setGenre(genreConverter.toItem(dto.getGenre()));
return item;
}
@Override
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