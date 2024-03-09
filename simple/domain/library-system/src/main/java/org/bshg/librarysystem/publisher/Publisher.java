package org.bshg.librarysystem.publisher;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.magazine.Magazine;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="publisher")
@SequenceGenerator(name = "publisher_seq", sequenceName = "publisher_seq", allocationSize = 1)
public class Publisher {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_seq")
private Long id;
private String name;
@OneToMany(mappedBy = "publisher")
private List<Book> books;
@OneToMany(mappedBy = "publisher")
private List<Magazine> magazines;
@OneToOne()
private Address address;
public Publisher() {
}
public Publisher(Long id, String label) {
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
public List<Book> getBooks() {
return books;
}
public void setBooks(List<Book> value) {
this.books = value;
}
public List<Magazine> getMagazines() {
return magazines;
}
public void setMagazines(List<Magazine> value) {
this.magazines = value;
}
public Address getAddress() {
return address;
}
public void setAddress(Address value) {
this.address = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Publisher publisher) {
return publisher.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}