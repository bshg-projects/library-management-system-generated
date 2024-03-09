package org.bshg.librarysystem.bookgenre;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.genre.Genre;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Book' and 'Genre'
* It extends AuditEntity to inherit auditing features.
*/
@Entity
@Table(name="bookgenre")
@SequenceGenerator(name = "bookgenre_seq", sequenceName = "bookgenre_seq", allocationSize = 1)
public class BookGenre extends AuditEntity {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookgenre_seq")
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Book book;
@ManyToOne(fetch = FetchType.LAZY)
private Genre genre;
public BookGenre() {
super();
}
@Override
public Long getId() {
return id;
}
@Override
public void setId(Long id) {
this.id = id;
}
public Book getBook() {
return book;
}
public void setBook(Book value) {
this.book = value;
}
public Genre getGenre() {
return genre;
}
public void setGenre(Genre value) {
this.genre = value;
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