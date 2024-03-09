package org.bshg.librarysystem.webservice.dto.content;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.webservice.dto.storage.RackDto;
import org.bshg.librarysystem.webservice.dto.user.admin.EmployeeDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {
private Long id;
private String title;
private LocalDate publicationDate;
private String isbn;
private int pageCount;
private String description;
private List<AuthorBookDto> authorBook;
private List<BookGenreDto> bookGenre;
private EmployeeDto employee;
private PublisherDto publisher;
private RackDto rack;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
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
public String getIsbn() {
return isbn;
}
public void setIsbn(String value) {
this.isbn = value;
}
public int getPageCount() {
return pageCount;
}
public void setPageCount(int value) {
this.pageCount = value;
}
public String getDescription() {
return description;
}
public void setDescription(String value) {
this.description = value;
}
public List<AuthorBookDto> getAuthorBook() {
return authorBook;
}
public void setAuthorBook(List<AuthorBookDto> value) {
this.authorBook = value;
}
public List<BookGenreDto> getBookGenre() {
return bookGenre;
}
public void setBookGenre(List<BookGenreDto> value) {
this.bookGenre = value;
}
public EmployeeDto getEmployee() {
return employee;
}
public void setEmployee(EmployeeDto value) {
this.employee = value;
}
public PublisherDto getPublisher() {
return publisher;
}
public void setPublisher(PublisherDto value) {
this.publisher = value;
}
public RackDto getRack() {
return rack;
}
public void setRack(RackDto value) {
this.rack = value;
}
}