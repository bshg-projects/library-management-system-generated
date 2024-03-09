package org.bshg.librarysystem.webservice.content.publisher;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.webservice.library.address.AddressDto;
import org.bshg.librarysystem.webservice.content.book.BookDto;
import org.bshg.librarysystem.webservice.content.magazine.MagazineDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublisherDto extends AuditBaseDto {
public PublisherDto() {
super();
}
private String name;
private List<BookDto> books;
private List<MagazineDto> magazines;
private AddressDto address;
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
public List<BookDto> getBooks() {
return books;
}
public void setBooks(List<BookDto> value) {
this.books = value;
}
public List<MagazineDto> getMagazines() {
return magazines;
}
public void setMagazines(List<MagazineDto> value) {
this.magazines = value;
}
public AddressDto getAddress() {
return address;
}
public void setAddress(AddressDto value) {
this.address = value;
}
}