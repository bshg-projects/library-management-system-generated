package org.bshg.librarysystem.webservice.user.client;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;
import org.bshg.librarysystem.webservice.library.reservation.ReservationDto;
import org.bshg.librarysystem.webservice.event.payment.PaymentDto;
import org.bshg.librarysystem.webservice.library.loan.LoanDto;
import org.bshg.librarysystem.webservice.event.transaction.TransactionDto;
import org.bshg.librarysystem.webservice.library.review.ReviewDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto extends UserDto {
public ClientDto() {
super();
}
private String firstName;
private String lastName;
private LocalDate dateOfBirth;
private List<LoanDto> loans;
private List<ReservationDto> reservations;
private List<ReviewDto> reviews;
private List<TransactionDto> transactions;
private List<PaymentDto> payments;
public String getFirstName() {
return firstName;
}
public void setFirstName(String value) {
this.firstName = value;
}
public String getLastName() {
return lastName;
}
public void setLastName(String value) {
this.lastName = value;
}
public LocalDate getDateOfBirth() {
return dateOfBirth;
}
public void setDateOfBirth(LocalDate value) {
this.dateOfBirth = value;
}
public List<LoanDto> getLoans() {
return loans;
}
public void setLoans(List<LoanDto> value) {
this.loans = value;
}
public List<ReservationDto> getReservations() {
return reservations;
}
public void setReservations(List<ReservationDto> value) {
this.reservations = value;
}
public List<ReviewDto> getReviews() {
return reviews;
}
public void setReviews(List<ReviewDto> value) {
this.reviews = value;
}
public List<TransactionDto> getTransactions() {
return transactions;
}
public void setTransactions(List<TransactionDto> value) {
this.transactions = value;
}
public List<PaymentDto> getPayments() {
return payments;
}
public void setPayments(List<PaymentDto> value) {
this.payments = value;
}
}