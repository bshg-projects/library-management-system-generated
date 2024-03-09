package org.bshg.librarysystem.webservice.dto.library;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDto {
private Long id;
private String name;
private List<AddressDto> addresses;
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
public List<AddressDto> getAddresses() {
return addresses;
}
public void setAddresses(List<AddressDto> value) {
this.addresses = value;
}
}