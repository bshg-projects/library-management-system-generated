package org.bshg.librarysystem.address;
import org.bshg.librarysystem.country.Country;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
@Entity
@Table(name="address")
@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
private Long id;
private String street;
private String city;
private String state;
private String zipCode;
@ManyToOne(fetch = FetchType.LAZY)
private Country country;
public Address() {
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getStreet() {
return street;
}
public void setStreet(String value) {
this.street = value;
}
public String getCity() {
return city;
}
public void setCity(String value) {
this.city = value;
}
public String getState() {
return state;
}
public void setState(String value) {
this.state = value;
}
public String getZipCode() {
return zipCode;
}
public void setZipCode(String value) {
this.zipCode = value;
}
public Country getCountry() {
return country;
}
public void setCountry(Country value) {
this.country = value;
}
@Override
public boolean equals(Object object) {
if (object instanceof Address address) {
return address.getId().equals(this.getId());
}
return false;
}
@Override
public int hashCode() {return (id == null) ? 0 : id.hashCode();}
}