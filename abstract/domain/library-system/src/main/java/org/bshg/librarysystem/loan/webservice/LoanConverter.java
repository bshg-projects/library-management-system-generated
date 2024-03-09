package org.bshg.librarysystem.loan.webservice;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.webservice.LoanDto;
import org.bshg.librarysystem.book.webservice.BookConverter;
import org.bshg.librarysystem.client.webservice.ClientConverter;
import org.bshg.librarysystem.employee.webservice.EmployeeConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class LoanConverter extends AbstractConverter<Loan, LoanDto> {
@Autowired private EmployeeConverter employeeConverter;
@Autowired private BookConverter bookConverter;
@Autowired private ClientConverter clientConverter;
private boolean book = true;
private boolean client = true;
private boolean employee = true;
@Override
protected void config() {
config(Loan.class, LoanDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.employeeConverter.setLoans(value);
this.clientConverter.setLoans(value);
}
@Override
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
@Override
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