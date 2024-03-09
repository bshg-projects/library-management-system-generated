package org.bshg.librarysystem.webservice.converter.library;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.webservice.dto.library.LoanDto;
import org.bshg.librarysystem.webservice.converter.content.BookConverter;
import org.bshg.librarysystem.webservice.converter.user.ClientConverter;
import org.bshg.librarysystem.webservice.converter.user.admin.EmployeeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class LoanConverter {
public void init(boolean initialisation) {
this.book = initialisation;
this.client = initialisation;
this.employee = initialisation;
}
@Autowired private EmployeeConverter employeeConverter;
@Autowired private BookConverter bookConverter;
@Autowired private ClientConverter clientConverter;
private boolean book = true;
private boolean client = true;
private boolean employee = true;
protected void convertersConfig(boolean value) {
this.employeeConverter.setLoans(value);
this.clientConverter.setLoans(value);
}
public final LoanDto toDto(Loan item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Loan toItem(LoanDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Loan> toItem(List<LoanDto> dtos) {
if (dtos == null) return null;
List<Loan> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<LoanDto> toDto(List<Loan> items) {
if (items == null) return null;
List<LoanDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Loan convertToItem(LoanDto dto) {
var item = new Loan();
item.setId(dto.getId());
item.setName(dto.getName());
item.setBook(bookConverter.toItem(dto.getBook()));
item.setLoanDate(dto.getLoanDate());
item.setReturnDate(dto.getReturnDate());
item.setClient(clientConverter.toItem(dto.getClient()));
item.setEmployee(employeeConverter.toItem(dto.getEmployee()));
return item;
}
protected LoanDto convertToDto(Loan item) {
var dto = new LoanDto();
dto.setId(item.getId());
dto.setName(item.getName());
dto.setBook(book? bookConverter.toDto(item.getBook()): null);
dto.setLoanDate(item.getLoanDate());
dto.setReturnDate(item.getReturnDate());
dto.setClient(client? clientConverter.toDto(item.getClient()): null);
dto.setEmployee(employee? employeeConverter.toDto(item.getEmployee()): null);
return dto;
}
public void setBook(boolean value) {
this.book = value;
}
public void setClient(boolean value) {
this.client = value;
}
public void setEmployee(boolean value) {
this.employee = value;
}
public void setEmployeeConverter(EmployeeConverter value) {
this.employeeConverter = value;
}
public EmployeeConverter getEmployeeConverter() {
return employeeConverter;
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