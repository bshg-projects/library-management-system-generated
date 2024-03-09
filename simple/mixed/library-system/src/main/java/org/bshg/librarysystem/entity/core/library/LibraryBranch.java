package org.bshg.librarysystem.entity.core.library;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="librarybranch")
@SequenceGenerator(name = "librarybranch_seq", sequenceName = "librarybranch_seq", allocationSize = 1)
public class LibraryBranch {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "librarybranch_seq")
private Long id;
private String name;
@OneToOne()
private Address address;
public LibraryBranch() {
}
public LibraryBranch(Long id, String label) {
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
public Address getAddress() {
return address;
}
public void setAddress(Address value) {
this.address = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof LibraryBranch libraryBranch) {
return libraryBranch.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}