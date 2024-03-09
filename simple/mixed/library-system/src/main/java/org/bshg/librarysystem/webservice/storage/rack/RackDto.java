package org.bshg.librarysystem.webservice.storage.rack;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.webservice.content.book.BookDto;
import org.bshg.librarysystem.webservice.storage.shelf.ShelfDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RackDto {
private Long id;
private String rackNumber;
private List<BookDto> books;
private ShelfDto shelf;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getRackNumber() {
return rackNumber;
}
public void setRackNumber(String value) {
this.rackNumber = value;
}
public List<BookDto> getBooks() {
return books;
}
public void setBooks(List<BookDto> value) {
this.books = value;
}
public ShelfDto getShelf() {
return shelf;
}
public void setShelf(ShelfDto value) {
this.shelf = value;
}
}