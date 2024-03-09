package org.bshg.librarysystem.librarybranch.webservice;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.address.webservice.AddressDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibraryBranchDto extends AuditBaseDto {
public LibraryBranchDto() {
super();
}
private String name;
private AddressDto address;
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
public AddressDto getAddress() {
return address;
}
public void setAddress(AddressDto value) {
this.address = value;
}
}