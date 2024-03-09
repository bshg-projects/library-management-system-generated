package org.bshg.librarysystem.entity.core.library;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="country")
@SequenceGenerator(name = "country_seq", sequenceName = "country_seq", allocationSize = 1)
public class Country {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
private Long id;
private String name;
@OneToMany(mappedBy = "country")
private List<Address> addresses;
public Country() {
super();
}
public Country(Long id, String label) {
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
public List<Address> getAddresses() {
return addresses;
}
public void setAddresses(List<Address> value) {
this.addresses = value;
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