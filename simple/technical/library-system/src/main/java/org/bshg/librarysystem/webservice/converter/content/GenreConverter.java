package org.bshg.librarysystem.webservice.converter.content;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.webservice.dto.content.GenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class GenreConverter {
@Autowired private BookGenreConverter bookGenreConverter;
@Autowired private MagazineConverter magazineConverter;
private boolean magazines = true;
private boolean bookGenre = true;
protected void convertersConfig(boolean value) {
this.bookGenreConverter.setGenre(value);
this.magazineConverter.setGenre(value);
}
public final GenreDto toDto(Genre item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Genre toItem(GenreDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Genre> toItem(List<GenreDto> dtos) {
if (dtos == null) return null;
List<Genre> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<GenreDto> toDto(List<Genre> items) {
if (items == null) return null;
List<GenreDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Genre convertToItem(GenreDto dto) {
var item = new Genre();
item.setId(dto.getId());
item.setName(dto.getName());
item.setMagazines(magazineConverter.toItem(dto.getMagazines()));
item.setBookGenre(bookGenreConverter.toItem(dto.getBookGenre()));
return item;
}
protected GenreDto convertToDto(Genre item) {
var dto = new GenreDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setMagazines(magazines? magazineConverter.toDto(item.getMagazines()): null);
dto.setBookGenre(bookGenre? bookGenreConverter.toDto(item.getBookGenre()): null);
return dto;
}
public void setMagazines(boolean value) {
this.magazines = value;
}
public void setBookGenre(boolean value) {
this.bookGenre = value;
}
public void setBookGenreConverter(BookGenreConverter value) {
this.bookGenreConverter = value;
}
public BookGenreConverter getBookGenreConverter() {
return bookGenreConverter;
}
public void setMagazineConverter(MagazineConverter value) {
this.magazineConverter = value;
}
public MagazineConverter getMagazineConverter() {
return magazineConverter;
}
}