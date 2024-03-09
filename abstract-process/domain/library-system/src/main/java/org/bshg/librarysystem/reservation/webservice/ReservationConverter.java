package org.bshg.librarysystem.reservation.webservice;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.webservice.ReservationDto;
import org.bshg.librarysystem.book.webservice.BookConverter;
import org.bshg.librarysystem.client.webservice.ClientConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ReservationConverter extends AbstractConverter<Reservation, ReservationDto> {
@Autowired private BookConverter bookConverter;
@Autowired private ClientConverter clientConverter;
private boolean book = true;
private boolean client = true;
@Override
protected void convertersConfig(boolean value) {
this.clientConverter.setReservations(value);
}
@Override
protected Reservation convertToItem(ReservationDto dto) {
var item = new Reservation();
item.setId(dto.getId());
item.setName(dto.getName());
item.setBook(bookConverter.toItem(dto.getBook()));
item.setReservationDate(dto.getReservationDate());
item.setStatus(dto.getStatus());
item.setClient(clientConverter.toItem(dto.getClient()));
return item;
}
@Override
protected ReservationDto convertToDto(Reservation item) {
var dto = new ReservationDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setBook(book? bookConverter.toDto(item.getBook()): null);
dto.setReservationDate(item.getReservationDate());
dto.setStatus(item.getStatus());
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
return dto;
}
public void setBook(boolean value) {
this.book = value;
}
public void setClient(boolean value) {
this.client = value;
}
public void setBookConverter(BookConverter value) {
this.bookConverter = value;
}
public BookConverter getBookConverter() {
return bookConverter;
}
public void setClientConverter(ClientConverter value) {
this.clientConverter = value;
}
public ClientConverter getClientConverter() {
return clientConverter;
}
}