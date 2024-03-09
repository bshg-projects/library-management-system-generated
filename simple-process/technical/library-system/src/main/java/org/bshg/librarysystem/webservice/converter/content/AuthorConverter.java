package org.bshg.librarysystem.webservice.converter.content;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.webservice.dto.content.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class AuthorConverter {
public void init(boolean initialisation) {
this.authorBook = initialisation;
}
@Autowired private AuthorBookConverter authorBookConverter;
private boolean authorBook = true;
protected void convertersConfig(boolean value) {
this.authorBookConverter.setAuthor(value);
}
public final AuthorDto toDto(Author item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Author toItem(AuthorDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Author> toItem(List<AuthorDto> dtos) {
if (dtos == null) return null;
List<Author> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<AuthorDto> toDto(List<Author> items) {
if (items == null) return null;
List<AuthorDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Author convertToItem(AuthorDto dto) {
var item = new Author();
item.setId(dto.getId());
item.setFirstName(dto.getFirstName());
item.setLastName(dto.getLastName());
item.setDateOfBirth(dto.getDateOfBirth());
item.setNationality(dto.getNationality());
item.setBiography(dto.getBiography());
item.setAuthorBook(authorBookConverter.toItem(dto.getAuthorBook()));
return item;
}
protected AuthorDto convertToDto(Author item) {
var dto = new AuthorDto();
dto.setId(item.getId());
dto.setFirstName(item.getFirstName());
dto.setLastName(item.getLastName());
dto.setDateOfBirth(item.getDateOfBirth());
dto.setNationality(item.getNationality());
dto.setBiography(item.getBiography());
dto.setAuthorBook(authorBook? authorBookConverter.toDto(item.getAuthorBook()): null);
return dto;
}
public void setAuthorBook(boolean value) {
this.authorBook = value;
}
public void setAuthorBookConverter(AuthorBookConverter value) {
this.authorBookConverter = value;
}
public AuthorBookConverter getAuthorBookConverter() {
return authorBookConverter;
}
}