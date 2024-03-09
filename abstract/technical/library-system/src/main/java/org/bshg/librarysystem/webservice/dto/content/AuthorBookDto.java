package org.bshg.librarysystem.webservice.dto.content;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.entity.enums.BookAuthorRoleEnum;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorBookDto extends AuditBaseDto {
public AuthorBookDto() {
super();
}
private float contribution;
private BookAuthorRoleEnum role;
private AuthorDto author;
private BookDto book;
public float getContribution() {
return contribution;
}
public void setContribution(float value) {
this.contribution = value;
}
public BookAuthorRoleEnum getRole() {
return role;
}
public void setRole(BookAuthorRoleEnum value) {
this.role = value;
}
public AuthorDto getAuthor() {
return author;
}
public void setAuthor(AuthorDto value) {
this.author = value;
}
public BookDto getBook() {
return book;
}
public void setBook(BookDto value) {
this.book = value;
}
}