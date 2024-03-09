package org.bshg.librarysystem.entity.core.content;
import org.bshg.librarysystem.entity.enums.BookAuthorRoleEnum;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
/**
* This Class is for Association between 'Book' and 'Author'
*/
@Entity
@Table(name="authorbook")
@SequenceGenerator(name = "authorbook_seq", sequenceName = "authorbook_seq", allocationSize = 1)
public class AuthorBook {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorbook_seq")
private Long id;
private float contribution;
@Enumerated(EnumType.STRING)
private BookAuthorRoleEnum role;
@ManyToOne(fetch = FetchType.LAZY)
private Author author;
@ManyToOne(fetch = FetchType.LAZY)
private Book book;
public AuthorBook() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
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
public Author getAuthor() {
return author;
}
public void setAuthor(Author value) {
this.author = value;
}
public Book getBook() {
return book;
}
public void setBook(Book value) {
this.book = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof AuthorBook authorBook) {
return authorBook.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}