package org.bshg.librarysystem.review;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="review")
@SequenceGenerator(name = "review_seq", sequenceName = "review_seq", allocationSize = 1)
public class Review {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
private Long id;
private String name;
@OneToOne()
private Book book;
private int rating;
@Lob
private String comment;
private LocalDate reviewDate;
@ManyToOne(fetch = FetchType.LAZY)
private Client client;
public Review() {
}
public Review(Long id, String label) {
// constructor to get optimized fields
this.id = id;
this.name = label;
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
public Book getBook() {
return book;
}
public void setBook(Book value) {
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
public Client getClient() {
return client;
}
public void setClient(Client value) {
this.client = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Review review) {
return review.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}