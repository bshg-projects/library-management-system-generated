package org.bshg.librarysystem.genre;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.magazine.Magazine;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="genre")
@SequenceGenerator(name = "genre_seq", sequenceName = "genre_seq", allocationSize = 1)
public class Genre {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
private Long id;
private String name;
@OneToMany(mappedBy = "genre")
private List<Magazine> magazines;
@OneToMany(mappedBy = "genre")
private List<BookGenre> bookGenre;
public Genre() {
}
public Genre(Long id, String label) {
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
public List<Magazine> getMagazines() {
return magazines;
}
public void setMagazines(List<Magazine> value) {
this.magazines = value;
}
public List<BookGenre> getBookGenre() {
return bookGenre;
}
public void setBookGenre(List<BookGenre> value) {
this.bookGenre = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Genre genre) {
return genre.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}