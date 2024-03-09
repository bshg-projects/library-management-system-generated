package org.bshg.librarysystem.entity.core.content;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="magazine")
@SequenceGenerator(name = "magazine_seq", sequenceName = "magazine_seq", allocationSize = 1)
public class Magazine {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "magazine_seq")
private Long id;
private String title;
private LocalDate publicationDate;
@ManyToOne(fetch = FetchType.LAZY)
private Genre genre;
@ManyToOne(fetch = FetchType.LAZY)
private Publisher publisher;
public Magazine() {
super();
}
public Magazine(Long id, String label) {
// constructor to get optimized fields
this.id = id;
this.title = label;
}
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
public Genre getGenre() {
return genre;
}
public void setGenre(Genre value) {
this.genre = value;
}
public Publisher getPublisher() {
return publisher;
}
public void setPublisher(Publisher value) {
this.publisher = value;
}
@Override
public boolean equals(Object object) {
return super.equals(object);
}
@Override
public int hashCode() {
return super.hashCode();
}
}