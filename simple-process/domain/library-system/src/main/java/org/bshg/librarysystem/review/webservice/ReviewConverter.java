package org.bshg.librarysystem.review.webservice;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.review.webservice.ReviewDto;
import org.bshg.librarysystem.book.webservice.BookConverter;
import org.bshg.librarysystem.client.webservice.ClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ReviewConverter {
public void init(boolean initialisation) {
this.book = initialisation;
this.client = initialisation;
}
@Autowired private BookConverter bookConverter;
@Autowired private ClientConverter clientConverter;
private boolean book = true;
private boolean client = true;
protected void convertersConfig(boolean value) {
this.clientConverter.setReviews(value);
}
public final ReviewDto toDto(Review item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Review toItem(ReviewDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Review> toItem(List<ReviewDto> dtos) {
if (dtos == null) return null;
List<Review> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<ReviewDto> toDto(List<Review> items) {
if (items == null) return null;
List<ReviewDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Review convertToItem(ReviewDto dto) {
var item = new Review();
item.setId(dto.getId());
item.setName(dto.getName());
item.setBook(bookConverter.toItem(dto.getBook()));
item.setRating(dto.getRating());
item.setComment(dto.getComment());
item.setReviewDate(dto.getReviewDate());
item.setClient(clientConverter.toItem(dto.getClient()));
return item;
}
protected ReviewDto convertToDto(Review item) {
var dto = new ReviewDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setBook(book? bookConverter.toDto(item.getBook()): null);
dto.setRating(item.getRating());
dto.setComment(item.getComment());
dto.setReviewDate(item.getReviewDate());
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
return dto;
}
public void setBook(boolean value) {
this.book = value;
}
public void setClient(boolean value) {
this.client = value;
}
public void setBookConverter(BookConverter value) {
this.bookConverter = value;
}
public BookConverter getBookConverter() {
return bookConverter;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
}