package org.bshg.librarysystem.category;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="category")
@SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
private Long id;
private String name;
public Category() {
super();
}
public Category(Long id, String label) {
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
@Override
public boolean equals(Object object) {
return super.equals(object);
}
@Override
public int hashCode() {
return super.hashCode();
}
}