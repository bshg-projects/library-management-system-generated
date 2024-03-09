package org.bshg.librarysystem.entity.core.storage;
import org.bshg.librarysystem.entity.core.content.Book;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="rack")
@SequenceGenerator(name = "rack_seq", sequenceName = "rack_seq", allocationSize = 1)
public class Rack {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rack_seq")
private Long id;
private String rackNumber;
@OneToMany(mappedBy = "rack")
private List<Book> books;
@ManyToOne(fetch = FetchType.LAZY)
private Shelf shelf;
public Rack() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getRackNumber() {
return rackNumber;
}
public void setRackNumber(String value) {
this.rackNumber = value;
}
public List<Book> getBooks() {
return books;
}
public void setBooks(List<Book> value) {
this.books = value;
}
public Shelf getShelf() {
return shelf;
}
public void setShelf(Shelf value) {
this.shelf = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Rack rack) {
return rack.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}