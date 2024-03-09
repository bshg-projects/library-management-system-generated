package org.bshg.librarysystem.review.webservice;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.book.webservice.BookDto;
import org.bshg.librarysystem.client.webservice.ClientDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewDto extends AuditBaseDto {
public ReviewDto() {
super();
}
private String name;
private BookDto book;
private int rating;
private String comment;
private LocalDate reviewDate;
private ClientDto client;
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
public BookDto getBook() {
return book;
}
public void setBook(BookDto value) {
this.book = value;
}
public int getRating() {
return rating;
}
public void setRating(int value) {
this.rating = value;
}
public String getComment() {
return comment;
}
public void setComment(String value) {
this.comment = value;
}
public LocalDate getReviewDate() {
return reviewDate;
}
public void setReviewDate(LocalDate value) {
this.reviewDate = value;
}
public ClientDto getClient() {
return client;
}
public void setClient(ClientDto value) {
this.client = value;
}
}