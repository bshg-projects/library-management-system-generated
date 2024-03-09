package org.bshg.librarysystem.webservice.dto.library;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDto extends AuditBaseDto {
public CountryDto() {
super();
}
private String name;
private List<AddressDto> addresses;
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