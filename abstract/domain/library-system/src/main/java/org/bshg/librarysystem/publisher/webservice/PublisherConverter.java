package org.bshg.librarysystem.publisher.webservice;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.webservice.PublisherDto;
import org.bshg.librarysystem.book.webservice.BookConverter;
import org.bshg.librarysystem.magazine.webservice.MagazineConverter;
import org.bshg.librarysystem.address.webservice.AddressConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class PublisherConverter extends AbstractConverter<Publisher, PublisherDto> {
@Autowired private AddressConverter addressConverter;
@Autowired private BookConverter bookConverter;
@Autowired private MagazineConverter magazineConverter;
private boolean books = true;
private boolean magazines = true;
private boolean address = true;
@Override
protected void config() {
config(Publisher.class, PublisherDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.bookConverter.setPublisher(value);
this.magazineConverter.setPublisher(value);
}
@Override
protected Publisher convertToItem(PublisherDto dto) {
var item = new Publisher();
item.setId(dto.getId());
item.setName(dto.getName());
item.setBooks(bookConverter.toItem(dto.getBooks()));
item.setMagazines(magazineConverter.toItem(dto.getMagazines()));
item.setAddress(addressConverter.toItem(dto.getAddress()));
return item;
}
@Override
protected PublisherDto convertToDto(Publisher item) {
var dto = new PublisherDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setBooks(books? bookConverter.toDto(item.getBooks()): null);
dto.setMagazines(magazines? magazineConverter.toDto(item.getMagazines()): null);
dto.setAddress(address? addressConverter.toDto(item.getAddress()): null);
return dto;
}
public void setBooks(boolean value) {
this.books = value;
}
public void setMagazines(boolean value) {
this.magazines = value;
}
public void setAddress(boolean value) {
this.address = value;
}
public void setAddressConverter(AddressConverter value) {
this.addressConverter = value;
}
public AddressConverter getAddressConverter() {
return addressConverter;
}
public void setBookConverter(BookConverter value) {
this.bookConverter = value;
}
public BookConverter getBookConverter() {
return bookConverter;
}
public void setMagazineConverter(MagazineConverter value) {
this.magazineConverter = value;
}
public MagazineConverter getMagazineConverter() {
return magazineConverter;
}
}