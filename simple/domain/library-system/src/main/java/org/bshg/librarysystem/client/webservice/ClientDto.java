package org.bshg.librarysystem.client.webservice;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;
import org.bshg.librarysystem.reservation.webservice.ReservationDto;
import org.bshg.librarysystem.payment.webservice.PaymentDto;
import org.bshg.librarysystem.loan.webservice.LoanDto;
import org.bshg.librarysystem.transaction.webservice.TransactionDto;
import org.bshg.librarysystem.review.webservice.ReviewDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto extends UserDto {
private Long id;
private String firstName;
private String lastName;
private LocalDate dateOfBirth;
private List<LoanDto> loans;
private List<ReservationDto> reservations;
private List<ReviewDto> reviews;
private List<TransactionDto> transactions;
private List<PaymentDto> payments;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
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