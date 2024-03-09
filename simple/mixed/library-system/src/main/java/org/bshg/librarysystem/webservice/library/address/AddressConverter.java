package org.bshg.librarysystem.webservice.library.address;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.webservice.library.address.AddressDto;
import org.bshg.librarysystem.webservice.library.country.CountryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class AddressConverter {
@Autowired private CountryConverter countryConverter;
private boolean country = true;
protected void convertersConfig(boolean value) {
this.countryConverter.setAddresses(value);
}
public final AddressDto toDto(Address item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Address toItem(AddressDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Address> toItem(List<AddressDto> dtos) {
if (dtos == null) return null;
List<Address> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<AddressDto> toDto(List<Address> items) {
if (items == null) return null;
List<AddressDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Address convertToItem(AddressDto dto) {
var item = new Address();
item.setId(dto.getId());
item.setStreet(dto.getStreet());
item.setCity(dto.getCity());
item.setState(dto.getState());
item.setZipCode(dto.getZipCode());
item.setCountry(countryConverter.toItem(dto.getCountry()));
return item;
}
protected AddressDto convertToDto(Address item) {
var dto = new AddressDto();
dto.setId(item.getId());
dto.setStreet(item.getStreet());
dto.setCity(item.getCity());
dto.setState(item.getState());
dto.setZipCode(item.getZipCode());
dto.setCountry(country? countryConverter.toDto(item.getCountry()): null);
return dto;
}
public void setCountry(boolean value) {
this.country = value;
}
public void setCountryConverter(CountryConverter value) {
this.countryConverter = value;
}
public CountryConverter getCountryConverter() {
return countryConverter;
}
}