package org.bshg.librarysystem.webservice.dto.library;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto extends AuditBaseDto {
public AddressDto() {
super();
}
private String street;
private String city;
private String state;
private String zipCode;
private CountryDto country;
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
public CountryDto getCountry() {
return country;
}
public void setCountry(CountryDto value) {
this.country = value;
}
}