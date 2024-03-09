package org.bshg.librarysystem.webservice.library.reservation;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.webservice.library.reservation.ReservationDto;
import org.bshg.librarysystem.webservice.content.book.BookConverter;
import org.bshg.librarysystem.webservice.user.client.ClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ReservationConverter {
@Autowired private BookConverter bookConverter;
@Autowired private ClientConverter clientConverter;
private boolean book = true;
private boolean client = true;
protected void convertersConfig(boolean value) {
this.clientConverter.setReservations(value);
}
public final ReservationDto toDto(Reservation item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Reservation toItem(ReservationDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Reservation> toItem(List<ReservationDto> dtos) {
if (dtos == null) return null;
List<Reservation> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<ReservationDto> toDto(List<Reservation> items) {
if (items == null) return null;
List<ReservationDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
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