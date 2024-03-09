package org.bshg.librarysystem.webservice.converter.user;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.webservice.dto.user.ClientDto;
import org.bshg.librarysystem.mySecurity.ws.converter.UserConverter;
import org.bshg.librarysystem.webservice.converter.library.LoanConverter;
import org.bshg.librarysystem.webservice.converter.library.ReservationConverter;
import org.bshg.librarysystem.webservice.converter.library.ReviewConverter;
import org.bshg.librarysystem.webservice.converter.event.TransactionConverter;
import org.bshg.librarysystem.webservice.converter.event.PaymentConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ClientConverter extends AbstractConverter<Client, ClientDto> {
@Autowired private UserConverter userConverter;
@Autowired private ReservationConverter reservationConverter;
@Autowired private PaymentConverter paymentConverter;
@Autowired private LoanConverter loanConverter;
@Autowired private TransactionConverter transactionConverter;
@Autowired private ReviewConverter reviewConverter;
private boolean loans = true;
private boolean reservations = true;
private boolean reviews = true;
private boolean transactions = true;
private boolean payments = true;
@Override
protected void config() {
config(Client.class, ClientDto.class);
}
@Override
protected void convertersConfig(boolean value) {
this.reservationConverter.setClient(value);
this.paymentConverter.setClient(value);
this.loanConverter.setClient(value);
this.transactionConverter.setClient(value);
this.reviewConverter.setClient(value);
}
@Override
protected Client convertToItem(ClientDto dto) {
var item = new Client();
userConverter.convertToChildItem(dto, item);
item.setFirstName(dto.getFirstName());
item.setLastName(dto.getLastName());
item.setDateOfBirth(dto.getDateOfBirth());
item.setLoans(loanConverter.toItem(dto.getLoans()));
item.setReservations(reservationConverter.toItem(dto.getReservations()));
item.setReviews(reviewConverter.toItem(dto.getReviews()));
item.setTransactions(transactionConverter.toItem(dto.getTransactions()));
item.setPayments(paymentConverter.toItem(dto.getPayments()));
return item;
}
@Override
protected ClientDto convertToDto(Client item) {
var dto = new ClientDto();
userConverter.convertToChildDto(item, dto);
dto.setFirstName(item.getFirstName());
dto.setLastName(item.getLastName());
dto.setDateOfBirth(item.getDateOfBirth());
dto.setLoans(loans? loanConverter.toDto(item.getLoans()): null);
dto.setReservations(reservations? reservationConverter.toDto(item.getReservations()): null);
dto.setReviews(reviews? reviewConverter.toDto(item.getReviews()): null);
dto.setTransactions(transactions? transactionConverter.toDto(item.getTransactions()): null);
dto.setPayments(payments? paymentConverter.toDto(item.getPayments()): null);
return dto;
}
public void setLoans(boolean value) {
this.loans = value;
}
public void setReservations(boolean value) {
this.reservations = value;
}
public void setReviews(boolean value) {
this.reviews = value;
}
public void setTransactions(boolean value) {
this.transactions = value;
}
public void setPayments(boolean value) {
this.payments = value;
}
public void setReservationConverter(ReservationConverter value) {
this.reservationConverter = value;
}
public ReservationConverter getReservationConverter() {
return reservationConverter;
}
public void setPaymentConverter(PaymentConverter value) {
this.paymentConverter = value;
}
public PaymentConverter getPaymentConverter() {
return paymentConverter;
}
public void setLoanConverter(LoanConverter value) {
this.loanConverter = value;
}
public LoanConverter getLoanConverter() {
return loanConverter;
}
public void setTransactionConverter(TransactionConverter value) {
this.transactionConverter = value;
}
public TransactionConverter getTransactionConverter() {
return transactionConverter;
}
public void setReviewConverter(ReviewConverter value) {
this.reviewConverter = value;
}
public ReviewConverter getReviewConverter() {
return reviewConverter;
}
}